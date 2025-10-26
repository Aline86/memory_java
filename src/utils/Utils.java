package utils;

import entities.Tile;
import enums.ElementTypes;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.util.Pair;
import services.AddElementToPaneCreator;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Utils {

    public static void fadeInWithDelay(Node node, double delaySeconds, double durationSeconds) {
        FadeTransition ft = new FadeTransition(Duration.seconds(durationSeconds), node);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setDelay(Duration.seconds(delaySeconds)); // wait before starting fade in
        ft.play();

    }
    public static Tile createTile(List<String> urls_avec_dupplicats, int count, int i, int j ) {
        return AddElementToPaneCreator.addElementToPane(urls_avec_dupplicats.get(count), i, j, 200);
    }

    public static List<String> getImageUrls() {
        List<String> imageUrls = new ArrayList<>();
        Path folder = Paths.get("src/images").toAbsolutePath();
        File[] files = folder.toFile().listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isImageFile(file)) {
                    String url = file.toURI().toString();
                    imageUrls.add(url);
                }
            }
        } else {
            System.out.println("Folder not found or empty: " + folder);
        }

        return imageUrls;
    }

    private static boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".gif");
    }

}
