package views;

import entities.FullBoard;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import services.AddElementToPaneCreator;

public class FullGamePanel {
    RightPanel rightPanel;
    Header header;
    Board board;
    private AddElementToPaneCreator elementCreatorService;

    public FullGamePanel() {
        elementCreatorService = new AddElementToPaneCreator();
        this.rightPanel = new RightPanel(elementCreatorService);
        this.header = new Header(elementCreatorService);
        this.board = new Board(elementCreatorService);

    }
    public Parent createContent() {
        VBox pane = new VBox();

        // Header
        Pane header = this.header.createHeader();
        header.setPrefSize(1200, 25);
        header.setMaxSize(1200, 25);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().add(header);

        // Body
        HBox bodyContainer = new HBox();
        bodyContainer.setMaxWidth(1200);

        TilePane board = this.board.createBodyTilesBoard();
        board.setAlignment(Pos.BOTTOM_LEFT);
        bodyContainer.getChildren().add(board);

        VBox rightPanel = this.rightPanel.createRightPanel(pane);
        rightPanel.setPrefSize(400, 800);

        bodyContainer.getChildren().add(rightPanel);

        pane.getChildren().add(bodyContainer);


        return pane;
    }
}
