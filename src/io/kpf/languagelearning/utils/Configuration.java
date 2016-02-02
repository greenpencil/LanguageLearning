package io.kpf.languagelearning.utils;

/**
 * Created by Katie on 28/01/2016.
 */
public class Configuration {

    private static Configuration ourInstance = new Configuration();

    public static Configuration getInstance() {
        return ourInstance;
    }

    private Configuration() {
    }
}
