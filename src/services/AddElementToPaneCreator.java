package services;

import entities.Tile;
import enums.Actions;
import enums.ElementTypes;
import handlers.ActionOnClickHandler;
import interfaces.IElementPaneCreator;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;
import visualcontent.entities.VisualCaracteristics;

public class AddElementToPaneCreator implements IElementPaneCreator {
    private static ElementCreator elementService;
    private ComboBox comboBox;
    private Button button;
    private HBox hBox;
    private VBox vBox;
    private Tile tile;
    private StackPane text;
    private Label label;

    public AddElementToPaneCreator() {
        ActionOnClickHandler actionOnClickHandlerService = new ActionOnClickHandler();
        this.elementService = new ElementCreator(actionOnClickHandlerService);
    }
    // Combobox
    public void addElementToPane(ComboBox comboBox, Actions actionsName, VisualCaracteristics caracteristics, Pane pane) {
        this.comboBox = elementService.createCombo(comboBox, actionsName, caracteristics, pane);

    }
    // Button
    public void addElementToPane(String text, Actions actionsName, VisualCaracteristics caracteristics) {
        this.button = elementService.createButton(text, actionsName, caracteristics);

    }
    // TextLabel Horizontal
    public void addElementToPane(String label, VisualCaracteristics caracteristics_label, StringProperty text, VisualCaracteristics caracteristics_text) {
        this.hBox = elementService.createTextLabelH(label, caracteristics_label, text, caracteristics_text);

    }
    // TextLabel Vertical
    public void addElementToPane(String label, StringProperty text, boolean showLabel) {
        this.vBox = elementService.createTextLabelV(label, text, showLabel);
    }

    //  Label
    public void addElementToPane(String text, VisualCaracteristics caracteristics) {

        this.label = elementService.createLabel(text, caracteristics);

    }
    // Text
    public void addElementToPane(StringProperty text, VisualCaracteristics caracteristics, boolean isTitle) {
        this.text = elementService.createText(text, caracteristics, isTitle);

    }
    // Tile url will become string
    public static Tile addElementToPane(String url, int x, int y, int size) {
        Tile tile = elementService.createTile(url, x, y, size);

        return tile;
    }

    public ImageView addTileToPane(Pane firstChild, Tile tile) {

        String path = tile.getUrl();
        Image image = new Image(path, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(tile.getPosition().getSize() - 2);
        imageView.setFitHeight(tile.getPosition().getSize() - 2);
        imageView.setSmooth(true);
        imageView.setOpacity(0);
        Rectangle rectangle = new Rectangle(tile.getPosition().getSize() - 2, tile.getPosition().getSize()-2, Color.WHITE);
        rectangle.setStroke(Color.BLACK); // Couleur du contour
        rectangle.setStrokeWidth(1);
        StackPane stack = new StackPane(rectangle, imageView);
        firstChild.getChildren().add(stack);

        return imageView;
    }

    public void addContentToPane(Pane firstChild, AddElementToPaneCreator content, ElementTypes elementType) {
        switch (elementType) {
            case COMBO:
                ComboBox comboBox = content.getComboBox();
                showOnlyValueInComboBox(comboBox);
                firstChild.getChildren().add(comboBox);
                break;
            case TEXT_LABEL_H:
                firstChild.getChildren().add(content.gethBox());
                break;
            case TEXT:

                firstChild.getChildren().add(content.getText());
                break;
            case LABEL:
                firstChild.getChildren().add(content.getLabel());
                break;
            case TEXT_LABEL_V:
                firstChild.getChildren().add(content.getvBox());
                break;
            case BUTTON:
                firstChild.getChildren().add(content.getButton());
                break;

            default:
                System.out.println("not taken into account yet");
        }

    }

    public static void showOnlyValueInComboBox(ComboBox comboBox) {
        comboBox.setCellFactory(lv -> new ListCell<Pair<String, String>>() {
            @Override
            protected void updateItem(Pair<String, String> item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getValue());
            }
        });

        comboBox.setButtonCell(new ListCell<Pair<String, String>>() {
            @Override
            protected void updateItem(Pair<String, String> item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getValue());
            }
        });

    }
    public ComboBox getComboBox() {
        return comboBox;
    }

    public Button getButton() {
        return button;
    }

    public HBox gethBox() {
        return hBox;
    }

    public VBox getvBox() {
        return vBox;
    }

    public StackPane getText() {
        return text;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
