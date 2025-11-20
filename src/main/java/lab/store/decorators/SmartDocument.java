package lab.store.decorators;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartDocument implements Document {

    private final String gcsPath;

    public SmartDocument(String gcsPath) {
        this.gcsPath = gcsPath;
    }

    @Override
    public String parse() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(gcsPath));
            ByteString imgBytes = ByteString.copyFrom(data);

            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feature = Feature.newBuilder()
                    .setType(Feature.Type.DOCUMENT_TEXT_DETECTION)
                    .build();

            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                    .addFeatures(feature)
                    .setImage(img)
                    .build();

            try (ImageAnnotatorClient CLIENT = ImageAnnotatorClient.create()) {
                AnnotateImageResponse response = CLIENT.batchAnnotateImages(
                        java.util.List.of(request)
                ).getResponsesList().get(0);

                if (response.hasError()) {
                    throw new RuntimeException(response.getError().getMessage());
                }

                return response.getFullTextAnnotation().getText();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String getGcsPath() {
        return gcsPath;
    }
}
