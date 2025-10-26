package interfaces;

import services.Scores;

public interface IGameFinisheListener {
    void onGameFinished(int nextPlayerIndex, Scores score);
}
