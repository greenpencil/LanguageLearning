package io.kpf.languagelearning.shared;

/**
 * Created by Katie on 27/01/2016.
 */
public abstract class Controller {
    protected View view;
    protected Game game;


    public View getView() {
        return view;
    }
}
