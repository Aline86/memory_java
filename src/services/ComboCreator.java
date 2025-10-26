package services;

import interfaces.IComboCreator;
import javafx.scene.control.ComboBox;
import javafx.util.Pair;




public class ComboCreator implements IComboCreator {
    public ComboBox<Pair<String, String>> createComboBox() {
        ComboBox<Pair<String, String>> comboBox = new ComboBox<>();

        return comboBox;
    }

    public void addElementToComboBox(ComboBox<Pair<String, String>> comboBox, String key, String value) {
        if(!key.isEmpty() && !value.isEmpty()) {
            Pair<String, String> item = new Pair<String, String>(key, value);
            comboBox.getItems().add(item);
        }
    }
}
