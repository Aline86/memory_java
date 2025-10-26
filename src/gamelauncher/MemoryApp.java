package gamelauncher;

import controllers.GameController;
import services.Scores;
import gamelauncher.prompts.ParametersApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.StageManager;
import services.AddElementToPaneCreator;
import services.ComboCreator;

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
        System.out.println("scores " + scores);
        GameController gameController = new GameController(playerInList, scores, stageManager);
        stage.setScene(new Scene(gameController.createContent(), 1200, 825));
        this.stageManager.setStage(stage);
        this.stageManager.getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

