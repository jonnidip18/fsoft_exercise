import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.time.Duration;

public class S3Sign {
    public static void main(String... args) {
        Region region = Region.AP_NORTHEAST_1;
        // Create an S3Presigner using the default region and credentials.
        // This is usually done at application startup, because creating a presigner can be expensive.
        S3Presigner presigner = S3Presigner.builder().region(region).build();

        // Create a GetObjectRequest to be pre-signed
        GetObjectRequest getObjectRequest =
                GetObjectRequest.builder()
                        .bucket("my-bucket")
                        .key("my-key")
                        .build();

        // Create a GetObjectPresignRequest to specify the signature duration
        GetObjectPresignRequest getObjectPresignRequest =
                GetObjectPresignRequest.builder()
                        .signatureDuration(Duration.ofMinutes(5))
                        .getObjectRequest(getObjectRequest)
                        .build();

        // Generate the presigned request
        PresignedGetObjectRequest presignedGetObjectRequest =
                presigner.presignGetObject(getObjectPresignRequest);

        // Log the presigned URL, for example.
        System.out.println("Presigned URL: " + presignedGetObjectRequest.url());
        System.out.println("Expiration: " + presignedGetObjectRequest.expiration());

        // It is recommended to close the S3Presigner when it is done being used, because some credential
        // providers (e.g. if your AWS profile is configured to assume an STS role) require system resources
        // that need to be freed. If you are using one S3Presigner per application (as recommended), this
        // usually is not needed.
        presigner.close();
    }
}