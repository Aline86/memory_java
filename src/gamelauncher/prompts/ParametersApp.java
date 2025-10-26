package gamelauncher.prompts;

import services.Scores;
import entities.Player;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ParametersApp {

    private static Scores scores;
    public ParametersApp(Scores scores) {
        this.scores = scores;
    }

    public void initParametersPrompt() {
        try {
            TextField nbPlayers = new TextField();
            nbPlayers.setPromptText("Nombre de joueurs");

            VBox content = new VBox(10);
            content.getChildren().addAll(new Label("Nombre de joueurs :"), nbPlayers);

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Nombre de joueurs");
            alert.getDialogPane().setContent(content);

            ButtonType okButton = new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().addAll(okButton, cancelButton);

            alert.showAndWait().ifPresent(response -> {
                if (response == okButton) {
                    String textNB = nbPlayers.getText();
                    if (!textNB.trim().isEmpty()) {
                        List<TextField> playerNameFields = new ArrayList<>();
                        getPlayersName(textNB, playerNameFields, okButton, cancelButton);
                    }
                }
            });
        }
        catch(Exception e)  {
            initParametersPrompt();
        }


    }

    public  void getPlayersName(String textNB, List<TextField> playerNameFields, ButtonType okButton, ButtonType cancelButton) {
        try {
            int nbP = Integer.parseInt(textNB);

            VBox nameInputs = new VBox(10);

            for (int i = 0; i < nbP; i++) {
                TextField nameField = new TextField();
                nameField.setPromptText("Nom du joueur " + (i + 1));
                nameInputs.getChildren().addAll(new Label("Joueur " + (i + 1) + " :"), nameField);
                playerNameFields.add(nameField);
            }

            // Deuxième alerte : entrez les noms
            Alert nameAlert = new Alert(Alert.AlertType.NONE);
            nameAlert.setTitle("Noms des joueurs");
            nameAlert.getDialogPane().setContent(nameInputs);
            nameAlert.getButtonTypes().addAll(okButton, cancelButton);

            nameAlert.showAndWait().ifPresent(nameResponse -> {
                if (nameResponse == okButton) {
                    for (int i = 0; i < playerNameFields.size(); i++) {
                        String playerName = playerNameFields.get(i).getText();
                        System.out.println("Nom du joueur " + (i + 1) + " : " + playerName);

                        // Exemple : ajouter dans ton système de scores
                        scores.addPlayer(new Player(playerName, 0, "WHITE"));
                    }

                    scores.setPlayer(scores.getPlayers().get(0));
                }
            });

        } catch (NumberFormatException ex) {
            System.out.println("Erreur : ce n'est pas un nombre valide");
            initParametersPrompt();
        }
        scores.setPlayer(scores.getPlayers().get(0));
    }
}
