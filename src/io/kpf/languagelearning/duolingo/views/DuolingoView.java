package io.kpf.languagelearning.duolingo.views;

import io.kpf.languagelearning.shared.View;
import io.kpf.languagelearning.shared.Word;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Created by Katie on 24/01/2016.
 */
public class DuolingoView extends View {
    private Button startButton, option1, option2, option3, option4;
    private Text answer, scoreLabel, word;

    public DuolingoView() {
        startButton = new Button("start");
        option1 = new Button();
        option2 = new Button();
        option3 = new Button();
        option4 = new Button();
        word = new Text();
        scoreLabel = new Text();
        answer = new Text();
        this.setCenter(startButton);
    }

    public void start()
    {
        this.setStyle("-fx-background-color: #ffffff;");

        GridPane gridPane = new GridPane();

        gridPane.setPrefWidth(800);
        //gridPane.setAlignment(Pos.CENTER);
        scoreLabel.setText("Your Score: 0");
        scoreLabel.setFont(new Font(20));

        this.setTop(scoreLabel);
        this.setCenter(gridPane);

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        word.setFont(new Font(40));
        gridPane.add(word, 1, 1, 3, 2);

        option1.setFont(new Font(30));
        option2.setFont(new Font(30));
        option3.setFont(new Font(30));
        option4.setFont(new Font(30));

        gridPane.add(option1, 1, 3);
        gridPane.add(option2, 2, 3);
        gridPane.add(option3, 1, 4);
        gridPane.add(option4, 2, 4);

        gridPane.setHalignment(word, HPos.CENTER);
        gridPane.setHalignment(option1, HPos.CENTER);
        gridPane.setHalignment(option2, HPos.CENTER);
        gridPane.setHalignment(option3, HPos.CENTER);
        gridPane.setHalignment(option4, HPos.CENTER);

        answer.setFont(new Font(30));
        gridPane.add(answer, 1, 5, 2, 3);
        gridPane.setHalignment(answer, HPos.CENTER);
    }

    public void setButtonAndLabel(ArrayList<Word> words, Word target)
    {
        word.setText("Select the English for: " + target.getPhrase());
        option1.setText(words.get(0).getTranslation());
        option2.setText(words.get(1).getTranslation());

        option3.setText(words.get(2).getTranslation());
        option4.setText(words.get(3).getTranslation());
    }

    public void setScore(int score)
    {
        scoreLabel.setText("Your Score: " + score);
    }

    public void startButtonSetOnMouseClicked(EventHandler handler)
    {
        startButton.setOnMouseClicked(handler);
    }

    public void optionsSetOnMouseClicked(EventHandler handler)
    {
        option1.setOnMouseClicked(handler);
        option2.setOnMouseClicked(handler);
        option3.setOnMouseClicked(handler);
        option4.setOnMouseClicked(handler);
    }
    
    public void displayCorrectAnswer(String phrase, String translation)
    {
        answer.setText("Correct, translation for " + phrase + " is: " + translation);
        answer.setFill(Color.GREEN);
    }

    public void displayIncorrectAnswer(String phrase, String translation)
    {
        answer.setText("Wrong, correct translation for " + phrase + " is: " + translation);
        answer.setFill(Color.RED);
    }
}
