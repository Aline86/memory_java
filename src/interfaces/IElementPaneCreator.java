package interfaces;

import enums.Actions;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import visualcontent.entities.VisualCaracteristics;

public interface IElementPaneCreator {
    void addElementToPane(ComboBox comboBox, Actions actionsName, VisualCaracteristics caracteristics, Pane pane);
    // Button
    void addElementToPane(String text, Actions actionsName, VisualCaracteristics caracteristics);
    // TextLabel Horizontal
    void addElementToPane(String label, VisualCaracteristics caracteristics_label, StringProperty text, VisualCaracteristics caracteristics_text);
    void addElementToPane(String text, VisualCaracteristics caracteristics);
    // Text
    void addElementToPane(StringProperty text, VisualCaracteristics caracteristics, boolean isTitle);
}
