package io.kpf.languagelearning.shared;

/**
 * Created by Katie on 26/01/2016.
 */
public abstract class Game {
    protected Player player;

    public Game(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
