package io.kpf.languagelearning.story.models;

import io.kpf.languagelearning.story.views.ObjectView;

/**
 * Created by Katie on 29/01/2016.
 */
public abstract class GameObject {
    ObjectView objectView;

    public GameObject() {
        objectView = new ObjectView();
    }

    public ObjectView getObjectView() {
        return objectView;
    }

    public void setObjectView(ObjectView objectView) {
        this.objectView = objectView;
    }
}
