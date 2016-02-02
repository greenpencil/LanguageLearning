package io.kpf.languagelearning.story.models;

import io.kpf.languagelearning.utils.Parser;
import io.kpf.languagelearning.shared.Word;
import javafx.scene.image.Image;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Katie on 23/01/2016.
 */
public class Scene {
    protected int id;
    protected Background background;
    protected Character characterLeft;
    protected Character characterRight;
    protected Item item;
    protected String text;
    protected ArrayList<Word> words;

    public Scene(int id, Background background, Character characterLeft, Character characterRight, Item item, String text) {
        this.id = id;
        this.background = background;
        this.characterLeft = characterLeft;
        this.characterRight = characterRight;
        this.item = item;
        this.text = text;
        words = new ArrayList<>();

        Matcher matcher = Parser.parseDialogue(this.text);
        this.words = Parser.extractWordsFromDialogue(matcher);
        this.text = Parser.replaceWordsInDialogue(matcher);
    }

    public int getId() {
        return id;
    }

    public Background getBackground() {
        return background;
    }

    public Character getCharacterLeft() {
        return characterLeft;
    }

    public Character getCharacterRight() {
        return characterRight;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public Item getItem()
    {
        return item;
    }
}
