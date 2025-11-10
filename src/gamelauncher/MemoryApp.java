package gamelauncher;

import controllers.GameController;
import entities.Tiles;
import services.Scores;
import gamelauncher.prompts.ParametersApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.StageManager;
import services.AddElementToPaneCreator;
import services.ComboCreator;
import views.Board;
import views.FullGamePanel;

public class MemoryApp extends Application {
    private AddElementToPaneCreator elementCreatorService;
    private ComboCreator comboCreatorService;
    private Scores scores;
    private ParametersApp parameters;
    private int playerInList;

    private StageManager stageManager;
    public MemoryApp() {
        playerInList = 0;
        scores = new Scores(0, 0);

        parameters = new ParametersApp(scores);
        comboCreatorService = new ComboCreator();
        elementCreatorService = new AddElementToPaneCreator(scores);
        stageManager = new StageManager();


    }

    public MemoryApp(int playerInList, Scores scores) {
        this.playerInList = playerInList;
        this.scores = scores;

        stageManager = new StageManager();
    }


    @Override
    public void start(Stage stage) throws Exception {

        if(scores.getPlayers().isEmpty()) {
            this.parameters.initParametersPrompt();
        }

        Tiles tiles = new Tiles();

        FullGamePanel createFullPanel = new FullGamePanel(scores, tiles);
        stage.setScene(new Scene(createFullPanel.createContent(), 1200, 825));
        GameController gameController = new GameController(playerInList, scores, stageManager, tiles);

        gameController.initClicOnPicture();
        this.stageManager.setStage(stage);
        this.stageManager.getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

