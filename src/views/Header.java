package views;

import enums.Actions;
import enums.ElementTypes;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.HBox;
import services.AddElementToPaneCreator;
import visualcontent.entities.VisualCaracteristics;

public class Header {
    private AddElementToPaneCreator elementCreatorService;

    public Header(AddElementToPaneCreator elementCreatorService) {
        this.elementCreatorService = elementCreatorService;
    }

    public HBox createHeader() {

        HBox header = new HBox();

        header.setMaxSize(1200, 25);

        VisualCaracteristics quitButtonCaracteristiques = new VisualCaracteristics(150, 25);
        elementCreatorService.addElementToPane("Quitter", Actions.QUIT, quitButtonCaracteristiques);
        elementCreatorService.addContentToPane(header, elementCreatorService, ElementTypes.BUTTON);

        VisualCaracteristics saveButtonCaracteristiques = new VisualCaracteristics(150, 25);
        elementCreatorService.addElementToPane("Sauvegarder", Actions.SAVE, saveButtonCaracteristiques);
        elementCreatorService.addContentToPane(header, elementCreatorService, ElementTypes.BUTTON);

        VisualCaracteristics historyButtonCaracteristiques = new VisualCaracteristics(150, 25);
        elementCreatorService.addElementToPane("Historique", Actions.SAVE, historyButtonCaracteristiques);
        elementCreatorService.addContentToPane(header, elementCreatorService, ElementTypes.BUTTON);

        VisualCaracteristics titleCaracteristiques = new VisualCaracteristics(750, 25);
        elementCreatorService.addElementToPane(new SimpleStringProperty("Memory"), titleCaracteristiques, true);
        elementCreatorService.addContentToPane(header, elementCreatorService, ElementTypes.TEXT);


        return header;

    }
}
