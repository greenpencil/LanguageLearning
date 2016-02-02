package io.kpf.languagelearning.shared;

/**
 * Created by Katie on 23/01/2016.
 */
public class Word {
    protected String phrase;
    protected String translation;

    public Word(String phrase, String translation) {
        this.phrase = phrase;
        this.translation = translation;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getTranslation() {
        return translation;
    }
}
