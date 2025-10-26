package interfaces;

import javafx.scene.control.ComboBox;
import javafx.util.Pair;

public interface IComboCreator {
    ComboBox<Pair<String, String>> createComboBox();
    void addElementToComboBox(ComboBox<Pair<String, String>>  comboBox, String key, String value);
}
