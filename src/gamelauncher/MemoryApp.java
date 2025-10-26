package gamelauncher;

import controllers.GameController;
import entities.FullBoard;
import entities.Player;
import entities.Tile;
import javafx.scene.image.ImageView;
import services.Scores;
import gamelauncher.prompts.ParametersApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.StageManager;
import services.AddElementToPaneCreator;
import services.ComboCreator;
import views.FullGamePanel;

import java.util.HashMap;

public class MemoryApp extends Application {
    private AddElementToPaneCreator elementCreatorService;
    private ComboCreator comboCreatorService;
    private Scores scores;
    private ParametersApp parameters;
    private int playerInList;
    private FullBoard board;
    private StageManager stageManager;
    public MemoryApp() {
        playerInList = 0;
        scores = new Scores(0, 0);
        board = new FullBoard();
        parameters = new ParametersApp(scores);
        comboCreatorService = new ComboCreator();
        elementCreatorService = new AddElementToPaneCreator();
        stageManager = new StageManager();


    }

    public MemoryApp(int playerInList, Scores scores) {
        this.playerInList = playerInList;
        this.scores = scores;
        board = new FullBoard();
        stageManager = new StageManager();
    }


    @Override
    public void start(Stage stage) throws Exception {

        if(scores.getPlayers().isEmpty()) {
            this.parameters.initParametersPrompt();
        }


        FullGamePanel createFullPanel = new FullGamePanel(scores, board);
        stage.setScene(new Scene(createFullPanel.createContent(), 1200, 825));
        GameController gameController = new GameController(playerInList, scores, stageManager, board);

        gameController.initClicOnPicture();
        this.stageManager.setStage(stage);
        this.stageManager.getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

