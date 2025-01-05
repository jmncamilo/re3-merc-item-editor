package utilities;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class FilterTxt {
    public static void applyFormat(TextField txt) {
        // Creates TextFormatter to filter numbers in the range 0 to 255
        TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
            // Gets old text + new text to verification
            String newText = change.getControlNewText();

            // Only allows numbers 3 digits in the range 0 to 255
            if (newText.matches("\\d{1,3}") && Integer.parseInt(newText) <= 255) {
                return change;  // If text is valid, allows the change
            }

            return null;  // Rejects change if is not valid
        });

        // Setting TextFormatter to field
        txt.setTextFormatter(textFormatter);
    }
}
