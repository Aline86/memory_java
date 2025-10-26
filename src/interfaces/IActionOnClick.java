package interfaces;

import entities.Player;
import enums.Actions;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

public interface IActionOnClick {
    void quit(Button button);
    void save(Button button);
    void show_history(Button button);
    void trigger_combo(ComboBox<Pair<String, String>> comboBox);
    String get_selected_value(ComboBox<Pair<String, String>> comboBox);
    void executeComboAction(Player player, Actions comboAction, ComboBox<Pair<String, String>> comboBox, Pane pane);
}
