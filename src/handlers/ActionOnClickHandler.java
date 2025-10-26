package handlers;

import entities.Player;
import enums.Actions;
import interfaces.IActionOnClick;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;


public class ActionOnClickHandler implements IActionOnClick {


    public void quit(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    public void save(Button button) {

    }
    public void show_history(Button button) {

    }
    public String get_selected_value(ComboBox<Pair<String, String>> comboBox) {
        Pair<String, String> selected = comboBox.getValue();

        if (selected != null) {
            System.out.println("selected " + selected.getKey());
            return  selected.getKey();

        } else {
            return "";
        }

    }

    public void trigger_combo(ComboBox<Pair<String, String>> comboBox) {

    }

    public void change_color(Player player, String value, Pane pane) {
        player.setBoardColor(value);
        pane.setStyle("-fx-background-color: " + value.toLowerCase() + ";");
    }
    public void show_tile(ImageView picture) {

        picture.setOpacity(1);

    }

    public void executeAction(Actions action, ImageView picture) {
        switch(action) {
            case TILE_CLICK:
                this.show_tile(picture);
                break;
            default:
                System.out.println("Error");
        }
    }
    public void executeAction(Actions action, Button button) {
        switch(action) {
            case QUIT:
                this.quit(button);
                break;
            case SAVE:
                this.save(button);
                break;
            case HISTORIQUE:
                this.show_history(button);
                break;
            default:
                System.out.println("Error");
        }
    }



    public void executeComboAction(Player player, Actions comboAction, ComboBox<Pair<String, String>> comboBox, Pane pane) {
        String value = this.get_selected_value(comboBox);
        switch(comboAction) {
            case CHANGE_COLOR:
                this.change_color(player, value, pane);
                break;
            default:
                System.out.println("Error");
        }
    }



}
