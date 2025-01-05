package utilities;

import javafx.stage.Screen;
import javafx.stage.Stage;

public class CenterWindow {
    public static void centeringWindow(Stage stage) {
        stage.sizeToScene();

        // Get dimension of the screen
        javafx.geometry.Rectangle2D primScreenBounds = Screen.getPrimary().getBounds();

        // Calculate coordinates to center the screen
        double x = (primScreenBounds.getWidth() - stage.getWidth()) / 2; // (size of the screen - frame size) / 2
        double y = (primScreenBounds.getHeight() - stage.getHeight()) / 2; // Same formula

        // Setting screen location
        stage.setX(x);
        stage.setY(y);
    }

    public static void centeringModal (Stage stage, Stage initStage) {
        // Get dimensions of frame reference (stage)
        double mainStageX = stage.getX();
        double mainStageY = stage.getY();
        double mainStageWidth = stage.getWidth();
        double mainStageHeight = stage.getHeight();

        // Ensures size calculation is done after stage is shown
        initStage.showingProperty().addListener((obs, wasShowing, isNowShowing) -> {
            if (isNowShowing) {
                initStage.sizeToScene();

                // Get dimensions of frame to center
                double initStageWidth = initStage.getWidth();
                double initStageHeight = initStage.getHeight();

                // Calculates coordinates
                double centerX = mainStageX + (mainStageWidth - initStageWidth) / 2;
                double centerY = mainStageY + (mainStageHeight - initStageHeight) / 2;

                // Setting screen location
                initStage.setX(centerX);
                initStage.setY(centerY);
            }
        });

    }
}
