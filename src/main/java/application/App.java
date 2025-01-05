package application;

import controllers.InitFrameControl;
import controllers.MainFrameControl;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilities.CenterWindow;
import utilities.MercSounds;
import utilities.Paths;

import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Frame when is located the editor (basically the main frame)
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.TEST_FRAME));
        Pane mainFramePane = loader.load();
        MainFrameControl mf = loader.getController(); // Gets the controller
        Scene scene = new Scene(mainFramePane); // Creates scene with the pane
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("RE3 - Mercenaries Item Editor"); // Frame title
        // Set icons to this frame
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/icon256x.png"))));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/icon128x.png"))));
        stage.show();
        CenterWindow.centeringWindow(stage); // Center frame

        // Init frame when users select .exe file
        Stage initStage = new Stage();
        FXMLLoader loaderInit = new FXMLLoader(Objects.requireNonNull(getClass().getResource(Paths.INIT_FRAME)));
        Pane loadInitFrame = loaderInit.load();
        Scene initScene = new Scene(loadInitFrame);
        initStage.setScene(initScene);
        initStage.initOwner(stage);
        initStage.initModality(Modality.APPLICATION_MODAL); // Sets frame like modal
        initStage.setResizable(false);
        initStage.initStyle(StageStyle.UNDECORATED); // Deletes title bar
        initStage.setTitle("Open Your Main RE3 EXE");
        // Set icons to this frame
        initStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/icon256x.png"))));
        initStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/icon128x.png"))));
        InitFrameControl initFrameControl = loaderInit.getController(); // Load controller to setting stage
        initFrameControl.setMainFrameControl(mf);
        CenterWindow.centeringModal(stage, initStage);
        initFrameControl.setStage(initStage); // Calling setter method for the stage
        initStage.setOnHidden(event -> { // Lambda to plays sound and background music
            MercSounds.playBackgroundMusic(); // Background
            MercSounds.playSelectSound(); // Sound additional
        });
        initStage.showAndWait(); // Shows frame like modal
    }

    public static void main(String[] args) {
        launch();
    }
}