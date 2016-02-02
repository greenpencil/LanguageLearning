package io.kpf.languagelearning.story.models;

import io.kpf.languagelearning.shared.Game;
import io.kpf.languagelearning.shared.Player;

import java.util.ArrayList;

/**
 * Created by Katie on 26/01/2016.
 */
public class StoryGame extends Game {

    protected ArrayList<Scene> scenes;

    public StoryGame(Player player) {
        super(player);

        scenes = new ArrayList<>();
    }

    public void addDialogue(Scene scene)
    {
        scenes.add(scene);
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public Scene getCurrentDialogue() {
        return scenes.get(player.getProgress());
    }
}
