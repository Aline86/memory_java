package handlers;

import services.Scores;
import gamelauncher.MemoryApp;
import interfaces.IGameFinisheListener;
import manager.StageManager;

public class GameFinishedHandler implements IGameFinisheListener {
    private final StageManager stage;

    public GameFinishedHandler(StageManager stage) {
        this.stage = stage;
    }

    @Override
    public void onGameFinished(int nextPlayerIndex, Scores score) {

        try {
            MemoryApp memory = new MemoryApp(nextPlayerIndex + 1, score);
            memory.start(stage.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

