package io.kpf.languagelearning.story.models;

import io.kpf.languagelearning.story.views.ObjectView;
import javafx.scene.image.Image;

import java.util.List;

/**
 * Created by Katie on 23/01/2016.
 */
public class Character extends GameObject implements Animatable {
    protected int id;
    protected String name;
    protected Image image;
    protected Image openMouth;
    protected String identifier;

    public Character(int id, String name, Image image, Image openMouth) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.openMouth = openMouth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public Image getOpenMouth() {
        return openMouth;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}


