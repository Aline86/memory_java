package gamelauncher;

import controllers.GameController;
import entities.FullBoard;
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

    private StageManager stageManager;
    public MemoryApp() {
        playerInList = 0;
        scores = new Scores(0, 0);
        parameters = new ParametersApp(scores);
        comboCreatorService = new ComboCreator();
        elementCreatorService = new AddElementToPaneCreator();
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
        System.out.println("scores " + scores);


        FullGamePanel createFullPanel = new FullGamePanel();
        stage.setScene(new Scene(createFullPanel.createContent(), 1200, 825));
        GameController gameController = new GameController(playerInList, scores, stageManager);

        gameController.initClicOnPicture();
        this.stageManager.setStage(stage);
        this.stageManager.getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

