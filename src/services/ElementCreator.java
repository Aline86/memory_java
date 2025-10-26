package services;

import entities.Tile;
import entities.TilePosition;
import handlers.ActionOnClickHandler;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Pair;
import visualcontent.entities.VisualCaracteristics;
import enums.Actions;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

// Creation d'élément composés qui n'auront pas d'enfants / dernière étape de la chaîne de création
public class ElementCreator {
    private ActionOnClickHandler actionService;
    private Scores scores;

    public ElementCreator(ActionOnClickHandler actionService, Scores scores) {
        this.actionService = actionService;
        this.scores = scores;
    }

    public Button createButton(String text, Actions actionsName, VisualCaracteristics caracteristics) {
        Button button = new Button(text);
        button.setPrefWidth(caracteristics.getWidth());
        button.setPrefHeight(caracteristics.getHeight());
        button.setOnAction(event -> {
            this.actionService.executeAction(actionsName, button);
        });

        return button;
    }

    public HBox createTextLabelH(String label, VisualCaracteristics caracteristics_label, StringProperty text, VisualCaracteristics caracteristics_text) {
        HBox textLabel = new HBox();
        Pane texte = createText(text, caracteristics_text, false);
        Label libel = createLabel(label, caracteristics_label);

        textLabel.getChildren().addAll(libel, texte);

        return textLabel;
    }

    public VBox createTextLabelV(String label, StringProperty text, boolean showLabel) {
        VBox textLabel = new VBox();
        if(showLabel) {
            Label libel = new Label(label);
            textLabel.getChildren().addAll(libel);
        }

        Text texte = new Text();
        texte.textProperty().bind(text);
        textLabel.getChildren().addAll(texte);

        return textLabel;
    }

    public ComboBox<Pair<String, String>> createCombo(ComboBox<Pair<String, String>> comboBox, Actions actionsName, VisualCaracteristics caracteristics, Pane pane) {
        comboBox.setPrefWidth(caracteristics.getWidth());
        comboBox.setPrefHeight(caracteristics.getHeight());
        comboBox.setOnAction(event -> {
            this.actionService.executeComboAction(scores.getPlayer(), actionsName, comboBox, pane);

        });

        return comboBox;
    }
    // Color wil become string
    public Tile createTile(String url, int x, int y, int size) {
        TilePosition position = new TilePosition(x, y, size);
        return new Tile(url, position);
    }


    public StackPane createText(StringProperty text, VisualCaracteristics caracteristics_text, boolean isTitle) {
        StackPane pane = new StackPane();
        Text texte = new Text();
        texte.textProperty().bind(text);
        pane.setPrefSize(caracteristics_text.getWidth(), caracteristics_text.getHeight());
        pane.getChildren().add(texte);

        if(isTitle) {
            centerText(texte, pane);
            texte.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 16px; -fx-font-weight: bold;");
        }

        return pane;
    }

    public Label createLabel(String label, VisualCaracteristics caracteristics_label) {
        Label libel = new Label(label);
        libel.setPrefWidth(caracteristics_label.getWidth());
        libel.setPrefHeight(caracteristics_label.getHeight());

        return libel;
    }

    private void centerText(Text text, Pane pane) {
        text.layoutBoundsProperty().addListener((obs, old, bounds) -> {
            double centerX = (pane.getWidth() - bounds.getWidth()) / 2;
            text.setX(centerX); // Centrage horizontal
        });
        // Important : réagir aux changements de taille du pane
        pane.widthProperty().addListener((obs, old, newVal) -> {
            double centerX = (newVal.doubleValue() - text.getLayoutBounds().getWidth()) / 2;
            text.setX(centerX);
        });
    }

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }
}
