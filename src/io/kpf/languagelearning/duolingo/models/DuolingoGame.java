package io.kpf.languagelearning.duolingo.models;

import io.kpf.languagelearning.shared.Game;
import io.kpf.languagelearning.shared.Player;
import io.kpf.languagelearning.shared.Word;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Katie on 26/01/2016.
 */
public class DuolingoGame extends Game {
    protected ArrayList<Word> choices;
    protected Word target;

    public DuolingoGame(Player player) {
        super(player);
        choices = new ArrayList<>();
    }

    public void generateChoices() {
        Random random = new Random();
        ArrayList<Word> allWords = player.getWordList();
        if(allWords.size() < 4)
        {
            System.out.println("Not enough words...");
        }
        else {
            for (int i = 0; i < 4; i++) {
                int choice = random.nextInt(allWords.size());
                Word word = allWords.get(choice);
                if (!choices.contains(word)) {
                    choices.add(word);
                } else {
                    i--;
                }
            }
        }
        target = choices.get(random.nextInt(4));
    }

    public ArrayList<Word> getChoices() {
        return choices;
    }

    public Word getTarget() {
        return target;
    }

    public void clearChoices()
    {
        choices.clear();
        target = null;
    }
}
