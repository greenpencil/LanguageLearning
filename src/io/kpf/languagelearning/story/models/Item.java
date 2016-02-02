package io.kpf.languagelearning.story.models;

import javafx.scene.image.Image;

/**
 * Created by Katie on 27/01/2016.
 */
public class Item extends GameObject implements Animatable {
    protected int id;
    protected Image image;
    protected String name;
    protected String identifier;

    public Item(int id, String name, Image image) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Image getImage() {
        return image;
    }
}
