package com.example.tictactoeJavaFX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.scene.control.ListView;

public class ScoreBase {
        public int playerScore;
        private final ListView<String> scoreDisplay = new ListView<>();

        public ListView<String> getScoreDisplay() {
            return scoreDisplay;
        }

        public int getPlayerScore() {
            return playerScore;
        }

        public void setPlayerScore(int playerScore) {
            this.playerScore = playerScore;
        }

        public void saveRanking(){
            try {
                FileWriter scoreWriter = new FileWriter("src/main/java/com/example/tictactoeJavaFX/score.txt", true);
                if (getPlayerScore() > 0){
                    scoreWriter.write("Player" + ": " + getPlayerScore() + "\n");
                }
                scoreWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public void readRanking(){
            try {
                File scoreFile = new File("src/main/java/com/example/tictactoeJavaFX/score.txt");
                Scanner scoreReader = new Scanner(scoreFile);
                while (scoreReader.hasNextLine()) {
                    String data = scoreReader.nextLine();
                    scoreDisplay.getItems().add(0, data);
                }
                scoreReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
}


