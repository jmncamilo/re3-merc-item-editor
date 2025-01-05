package controllers;


import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutFrameControl implements Initializable {

    @FXML
    private TextArea txtText;

    @FXML
    private ImageView lbLogoMystic;

    @FXML
    private Button btnBuyMe;

    @FXML
    private Button btnPaypal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Frame about is successfully open.");
    }

    @FXML
    void clickBuyMe(ActionEvent event) {
        try {
            URI uri = new URI("https://buymeacoffee.com/jmncamilo");
            // Checks if system supports open the default browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("System cannot open Buy Me A Coffee URL.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickPaypal(ActionEvent event) {
        try {
            URI uri = new URI("https://www.paypal.com/donate/?hosted_button_id=8DZU725MLQKRL");
            // Checks if system supports open the default browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("System cannot open PayPal URL.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
