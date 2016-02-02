package io.kpf.languagelearning.duolingo.controllers;

import io.kpf.languagelearning.shared.Controller;
import io.kpf.languagelearning.shared.Word;
import io.kpf.languagelearning.duolingo.models.DuolingoGame;
import io.kpf.languagelearning.duolingo.views.DuolingoView;
import io.kpf.languagelearning.shared.Player;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by Katie on 24/01/2016.
 */
public class DuolingoController extends Controller {

    DuolingoView duolingoView;
    DuolingoGame duolingoGame;

    public DuolingoController(Player player) {
        view = new DuolingoView();
        game = new DuolingoGame(player);

        duolingoView = ((DuolingoView) view);
        duolingoGame= ((DuolingoGame) game);

        setUpStartMenu();
        selectionHandler();
    }

    public void setUpStartMenu()
    {
        EventHandler<MouseEvent> tHandler = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                duolingoGame.generateChoices();
                duolingoView.setButtonAndLabel(duolingoGame.getChoices(), duolingoGame.getTarget());
                duolingoView.start();
            }};
        duolingoView.startButtonSetOnMouseClicked(tHandler);
    }

    public void selectionHandler()
    {
        EventHandler<MouseEvent> tHandler = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                Word target = duolingoGame.getTarget();
                if(((Button)arg0.getSource()).getText().equals(target.getTranslation()))
                {
                    duolingoView.displayCorrectAnswer(target.getPhrase(),target.getTranslation());
                    duolingoGame.getPlayer().increaseScore();
                    duolingoView.setScore(duolingoGame.getPlayer().getScore());
                } else {
                    duolingoView.displayIncorrectAnswer(target.getPhrase(), target.getTranslation());
                }
                duolingoGame.clearChoices();
                duolingoGame.generateChoices();

                duolingoView.setButtonAndLabel(duolingoGame.getChoices(), duolingoGame.getTarget());
            }};

        duolingoView.optionsSetOnMouseClicked(tHandler);
    }

}
