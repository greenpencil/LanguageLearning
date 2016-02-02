package io.kpf.languagelearning.utils;

import java.io.*;

/**
 * Created by Katie on 27/01/2016.
 */
public class FileLoader {
    public static BufferedReader readFile(String fileName)
    {
        BufferedReader reader = null;
        File file = new File(fileName);
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return reader;
    }

    public static void loadConfig(String config)
    {
        BufferedReader reader = readFile(config);

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split("=");
                if(strings[1].equals("name"))
                {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
