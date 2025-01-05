package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.HashValues;
import models.ProcessExe;
import utilities.CustomAlerts;
import utilities.FilterTxt;
import utilities.MercSounds;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainFrameControl implements Initializable {

    @FXML
    private ImageView bgCarlos;

    @FXML
    private ImageView bgImg;

    @FXML
    private ImageView bgMikhail;

    @FXML
    private ImageView bgNicholai;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> cbDispColor;

    @FXML
    private ComboBox<String> cbItemId;

    @FXML
    private ComboBox<String> cbSlotSelector;

    @FXML
    private Label lblChange;

    @FXML
    private Label lblChar;

    @FXML
    private Label lblTitle1;

    @FXML
    private Label lblTitle2;

    @FXML
    private Label lblTitle3;

    @FXML
    private Label lblTitle4;

    @FXML
    private Pane mainFrame;

    @FXML
    private RadioButton rdCarlos;

    @FXML
    private RadioButton rdMikhail;

    @FXML
    private RadioButton rdNicholai;

    @FXML
    private Separator sepChange;

    @FXML
    private Separator sepSelect;

    @FXML
    private TextField txtQty;

    private File exe;
    private long initOffset;
    private long currentOffset;
    private byte itemId;
    private int qtyValue;
    private byte dispColor;

    private final HashValues hv = new HashValues(); // Instantiated HashValues
    private final LinkedHashMap<String, Byte> itemsId = hv.getItemsId(); // Creating hashmap and referencing it
    private final LinkedHashMap<String, Byte> colorDisp = hv.getColorDisp(); // Creating hashmap and referencing it

    // ═════ Initialize certain components ═════
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Radio bottom group
        ToggleGroup groupCharacters = new ToggleGroup();
        rdCarlos.setToggleGroup(groupCharacters);
        rdMikhail.setToggleGroup(groupCharacters);
        rdNicholai.setToggleGroup(groupCharacters);

        // Assign values to slot selector
        cbSlotSelector.getItems().addAll("Slot 1", "Slot 2", "Slot 3", "Slot 4", "Slot 5", "Slot 6");
        // Assign values to item selector
        cbItemId.getItems().addAll(itemsId.keySet());
        // Assign values to color selector
        cbDispColor.getItems().addAll(colorDisp.keySet());

        // Initializes variables to modify
        exe = null;
        initOffset = -1;
        currentOffset = -1;
        qtyValue = -1;
        itemId = 0;
        dispColor = -1;

        // Setting filter to quantity field
        FilterTxt.applyFormat(txtQty);
    }


    // ═════ Method that setting .exe ═════
    public void setExe (File exe) {
        this.exe = exe;
    }

    // ═════ Methods to handle events ═════
    @FXML
    void click(ActionEvent event) {

        // Validates variable before its treatment
        boolean exeNotNull = exe != null;
        boolean offsetNotNegative = currentOffset!= -1;
        boolean itemIdNotZero = itemId != 0;
        boolean qtyNotBlankOrNegative = (txtQty != null && !txtQty.getText().isBlank()) && (Integer.parseInt(txtQty.getText()) != -1);
        boolean dispColorNotNegative = dispColor != -1;

        if (exeNotNull && offsetNotNegative && itemIdNotZero && qtyNotBlankOrNegative && dispColorNotNegative) {

            try {
                // Processing qty to byte conversion
                byte qty = (byte) Integer.parseInt(txtQty.getText());
                // Creating a byte array with current data
                byte [] bytesValues = {itemId, qty, dispColor};
                // Write the exe file with current data
                ProcessExe.writeExe(exe, currentOffset, bytesValues);

                //  ----- DEBUG PURPOSES -----
                System.out.println("El valor del offset está en: " + currentOffset);
                System.out.println("El ID del item es: " + itemId);
                System.out.println("El valor del color mostrado es: " + dispColor);
                System.out.println("El estado del EXE es: " + this.exe);
                System.out.println("La cantidad del item es: " + qty);

            } catch (NumberFormatException e) {
                CustomAlerts.setInvalidWrite();
                System.out.println("There is an error processing data to write.");
                e.printStackTrace();
            }

        } else {
            CustomAlerts.setInvalidWrite();
            System.out.println("Error writing the file.");
        }

    }

    @FXML
    void selectCarlos(ActionEvent event) {
        // Set image when Carlos is selected
        Image imageCarlos = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bgCarlos.png")));
        bgImg.setImage(imageCarlos);
        // Set the initial offset to calculate items for Carlos
        initOffset = 0x12D264;
        // Update slot selection
        selectionSlot(event);
    }

    @FXML
    void selectMikhail(ActionEvent event) {
        // Set image when Mikhail is selected
        Image imageMikhail = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bgMikhail.png")));
        bgImg.setImage(imageMikhail);
        // Set the initial offset to calculate items for Mikhail
        initOffset = 0x12D29C;
        // Update slot selection
        selectionSlot(event);
    }

    @FXML
    void selectNicholai(ActionEvent event) {
        // Set image when Nicholai is selected
        Image imageNicholai = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bgNicholai.png")));
        bgImg.setImage(imageNicholai);
        // Set the initial offset to calculate items for Nicholai
        initOffset = 0x12D280;
        // Update slot selection
        selectionSlot(event);
    }

    @FXML
    void selectionColor(ActionEvent event) {
        // Assign current value of combobox to the variable
        String selectionColor = cbDispColor.getValue();
        // Checks if comboBox has a selected valid value
        if (selectionColor != null && colorDisp.containsKey(selectionColor)) {
            // Updates variable dispColor to write
            dispColor = colorDisp.get(selectionColor);
            System.out.println("Color changed."); // ----- DEBUG PURPOSES -----
        }
    }

    @FXML
    void selectionItem(ActionEvent event) {
        // Assign current value of combobox to the variable
        String selectionItem = cbItemId.getValue();
        // Checks if comboBox has a selected valid value
        if (selectionItem != null && itemsId.containsKey(selectionItem)) {
            // Updates variable itemId to write
            itemId = itemsId.get(selectionItem); // Assign the actual value of selected element in the ComboBox to the variable
            System.out.println("ID item changed."); // ----- DEBUG PURPOSES -----
        }
    }

    @FXML
    void selectionSlot(ActionEvent event) {
        // Creating LinkedHashMap local to map values
        LinkedHashMap<String, Long> slotOffset = new LinkedHashMap<String, Long>(); // Assign key and value type

        long counter = 0; // Initialize counter in 0
        for (int i = 0; i < 6; i++) {
            slotOffset.put("Slot " + (i+1), initOffset + counter); // Concatenates key word with iteration value and addition value counter to offset char reference
            counter += 4; // Add +4 to the count for calculate distance exactly between the different slots offsets
        }

        // Checks if ComboBox has a selected value
        String selectedSlot = cbSlotSelector.getValue();
        if (selectedSlot != null && slotOffset.containsKey(selectedSlot)) {
            // Updates currentOffset value to write
            currentOffset = slotOffset.get(selectedSlot); // Assign the actual value of selected element in the ComboBox to the variable
            System.out.println("Current offset is : " + currentOffset); // ----- DEBUG PURPOSES -----
        } else {
            System.out.println("No slot selected yet."); // ----- DEBUG PURPOSES -----
        }

        System.out.println("Current slot is : " + selectedSlot); // ----- DEBUG PURPOSES -----
    }


}
