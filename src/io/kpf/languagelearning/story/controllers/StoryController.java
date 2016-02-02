package io.kpf.languagelearning.story.controllers;

import io.kpf.languagelearning.shared.Controller;
import io.kpf.languagelearning.utils.Parser;
import io.kpf.languagelearning.shared.Player;
import io.kpf.languagelearning.shared.Word;
import io.kpf.languagelearning.story.models.*;
import io.kpf.languagelearning.story.models.Character;
import io.kpf.languagelearning.story.views.StoryView;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.*;

/**
 * Created by Katie on 23/01/2016.
 */
public class StoryController extends Controller {
    StoryView storyView;
    StoryGame storyGame;
    SceneBuilder sceneBuilder;

    public StoryController(Player player) {
        game = new StoryGame(player);
        storyGame = ((StoryGame) game);
        sceneBuilder = new SceneBuilder();
        loadScenes();
        
        view = new StoryView();
        storyView = ((StoryView) view);


        storyView.setUp(storyGame.getCurrentDialogue());

        EventHandler<MouseEvent> tHandler = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                storyGame.getPlayer().progress();
                if(storyGame.getPlayer().getProgress() < storyGame.getScenes().size()) {

                    Scene currentScene = storyGame.getCurrentDialogue();
                    storyView.setUp(currentScene);
                    for (Word word : currentScene.getWords()) {
                        player.addWord(word);
                    }
                }
            }};

        storyView.setOnMouseClicked(tHandler);
    }
    
    public void loadScenes()
    {
        List<List<String>> dialogueCSV = Parser.ParseCSV("data/scenes.csv");
        for(List<String> line : dialogueCSV)
        {
            Scene scene = sceneBuilder.createNewScene(line);
            storyGame.addDialogue(scene);
        }
    }
}
