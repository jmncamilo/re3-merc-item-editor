package utilities;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.Objects;


public class CustomAlerts {

    private static final Image rejectFile = new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/RejectFile.png")));
    private static final Image validWrite = new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/ValidWrite.png")));
    private static final Image invalidWrite = new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/InvalidWrite.png")));

    public static void formatAlert(String title, String header, String content, Image image) {
        // Creates an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        // Get alert Stage and set the icon
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/icon256x.png"))));
        alertStage.getIcons().add(new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/icon128x.png"))));

        // Set image to alert
        ImageView imageView = new ImageView(image);
        alert.setGraphic(imageView);

        // Add custom button "OK"
        ButtonType btnOk = new ButtonType("OK");
        alert.getButtonTypes().setAll(btnOk);

        // Apply CSS style
        alert.getDialogPane().getStyleClass().add("custom-alert"); // Style class assignation
        Scene scene = alert.getDialogPane().getScene();
        scene.getStylesheets().add(Objects.requireNonNull(CustomAlerts.class.getResource("/css/styles.css")).toExternalForm());

        // show alert
        alert.showAndWait();
    }

    public static void setRejectFile() {
        formatAlert("Error", "Error!", "Invalid file. Please try again.", rejectFile);
    }

    public static void setValidWrite() {
        formatAlert("Success", "File Saved!", "The data has been successfully saved to the file.", validWrite);
    }

    public static void setInvalidWrite() {
        formatAlert("Error", "Something Went Wrong", "The file could not be modified. " +
                   "Please check if all required fields are completed.", invalidWrite);
    }

}
