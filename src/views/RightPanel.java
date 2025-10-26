package views;

import enums.Actions;
import enums.ElementTypes;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.AddElementToPaneCreator;
import services.ComboCreator;

import services.Scores;
import visualcontent.entities.VisualCaracteristics;

public class RightPanel {
    private AddElementToPaneCreator elementCreatorService;

    private ComboCreator comboCreatorService;
    public RightPanel(AddElementToPaneCreator elementCreatorService) {
        this.elementCreatorService = elementCreatorService;

        this.comboCreatorService = new ComboCreator();
    }

    public VBox createRightPanel(Pane pane) {
        VBox rightPanelContainer = new VBox();
        rightPanelContainer.setMaxWidth(400);
        rightPanelContainer.setMaxHeight(500);
        rightPanelContainer.setPrefSize(400, 800);
        rightPanelContainer.setFillWidth(true);

        // Création des élément Label + texte
        VisualCaracteristics playerNameCaracteristiques = new VisualCaracteristics(400, 50);
        // A normaliser avec le bind au changement de joueur pas encore codé
        elementCreatorService.addElementToPane(new SimpleStringProperty(Scores.getPlayer().getName()), playerNameCaracteristiques, true);
        elementCreatorService.addContentToPane(rightPanelContainer, elementCreatorService, ElementTypes.TEXT);


        VisualCaracteristics tentativesCaracteristiques = new VisualCaracteristics(300, 50);
        VisualCaracteristics tentativesResultatCaracteristiques = new VisualCaracteristics(100, 50);

        elementCreatorService.addElementToPane("Nombre de tentatives", tentativesCaracteristiques, Scores.getTentatives(), tentativesResultatCaracteristiques);
        elementCreatorService.addContentToPane(rightPanelContainer, elementCreatorService, ElementTypes.TEXT_LABEL_H);

        VisualCaracteristics facesRetourneesCaracteristiques = new VisualCaracteristics(300, 50);
        VisualCaracteristics nbFacesRetourneesCaracteristiques = new VisualCaracteristics(100, 50);
        elementCreatorService.addElementToPane("Nombre de faces retournées", facesRetourneesCaracteristiques, Scores.getFaceRetournees(), nbFacesRetourneesCaracteristiques);
        elementCreatorService.addContentToPane(rightPanelContainer, elementCreatorService, ElementTypes.TEXT_LABEL_H);

        // Création de la combo
        VisualCaracteristics comboCaracteristiques = new VisualCaracteristics(400, 30);
        ComboBox comboboxColor = comboCreatorService.createComboBox();
        comboCreatorService.addElementToComboBox(comboboxColor, "WHITE", "Changer la couleur");
        comboCreatorService.addElementToComboBox(comboboxColor, "GOLD", "JAUNE");
        comboCreatorService.addElementToComboBox(comboboxColor, "LIGHTCORAL", "ROUGE");
        comboCreatorService.addElementToComboBox(comboboxColor, "LIME", "VERT");
        comboCreatorService.addElementToComboBox(comboboxColor, "LIGHTBLUE", "BLEU");
        comboboxColor.setValue("Changer la couleur");

        elementCreatorService.addElementToPane(comboboxColor, Actions.CHANGE_COLOR, comboCaracteristiques, pane);
        elementCreatorService.addContentToPane(rightPanelContainer, elementCreatorService, ElementTypes.COMBO);

        return rightPanelContainer;
    }
}
