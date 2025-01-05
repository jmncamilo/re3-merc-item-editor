package controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.ProcessExe;
import utilities.CenterWindow;
import utilities.CustomAlerts;
import utilities.Paths;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InitFrameControl implements Initializable {

    @FXML
    private ImageView bgTitle;

    @FXML
    private Button btnAbout;

    @FXML
    private Button btnOpenExe;

    @FXML
    private Button btnExit;

    private Stage initStage;

    private MainFrameControl mf;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init frame initializes successfully.");
    }

    public void setStage(Stage initStage) {
        this.initStage = initStage;
    }

    public void setMainFrameControl (MainFrameControl mf) {
        this.mf = mf;
    }

    @FXML
    void clickAbout(ActionEvent event) {
        try {
            Stage aboutStage = new Stage();
            Pane loadAboutScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Paths.ABOUT_FRAME)));
            Scene aboutScene = new Scene(loadAboutScene);
            aboutStage.setScene(aboutScene);
            aboutStage.setResizable(false);
            aboutStage.setTitle("About This Software"); // Frame title
            // Set icons
            aboutStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/icon256x.png"))));
            aboutStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/icon128x.png"))));
            aboutStage.show();
            CenterWindow.centeringWindow(aboutStage);
        } catch (IOException e) {
            System.out.println("Error loading frame about.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @FXML
    void clickOpen(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();
            fc.setTitle("Open Your RE3 Game"); // Title to the chooser selector
            // Filter
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("BIOHAZARD(R) 3 PC", "*.exe"));
            // Open dialog and get the file
            File re3Exe = fc.showOpenDialog(initStage);
            // Signature verification
            if (re3Exe != null && ProcessExe.searchExeSignature(re3Exe)) {
                // If is the correct file, call set method and allows to display frame with the editor
                MainFrameControl mf = this.mf;
                mf.setExe(re3Exe);
                System.out.println("File is set to MainFrameControl: " + re3Exe.getAbsolutePath());
                initStage.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickExit(ActionEvent event) {
        System.exit(0);
    }

}
