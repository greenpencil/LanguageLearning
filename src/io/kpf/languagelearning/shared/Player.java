package io.kpf.languagelearning.shared;

import java.util.ArrayList;

/**
 * Created by Katie on 25/01/2016.
 */
public class Player {
    private ArrayList<Word> wordList = new ArrayList<>();
    private int score;
    private int progress;
    private static Player instance;

    private Player() {
        progress = 0;
        score = 0;
    }

    public static Player getInstance(){
        if (instance == null)
        {
            instance = new Player();
        }
        return instance;
    }

    public void increaseScore()
    {
        score++;
    }

    public void progress()
    {
        progress++;
    }

    public ArrayList<Word> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<Word> wordList) {
        this.wordList = wordList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void addWord(Word word)
    {
        wordList.add(word);
    }
}
