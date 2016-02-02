package io.kpf.languagelearning.story.models;

import io.kpf.languagelearning.utils.Parser;
import javafx.scene.image.Image;

import java.util.List;

/**
 * Created by Katie on 23/01/2016.
 */
public class Background {
    protected int id;
    protected String name;
    protected String imageUrl;

    public Background(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
