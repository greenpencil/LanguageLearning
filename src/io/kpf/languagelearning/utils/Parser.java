package io.kpf.languagelearning.utils;

import io.kpf.languagelearning.shared.Word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Katie on 23/01/2016.
 */
public class Parser {
    public static List<List<String>> ParseCSV(String fileName)
    {
        BufferedReader reader = FileLoader.readFile(fileName);
        String line = "";
        String deliminator = ";";
        List<List<String>> returnList = new ArrayList<>();

        try {
            reader.readLine();
            while ((line = reader.readLine()) != null)
            {
                line =  line + " ";
                String[] vals = line.split(deliminator);
                List<String> value = new ArrayList<>(Arrays.asList(vals));
                returnList.add(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return returnList;
    }

    public static Matcher parseDialogue(String text)
    {
        Pattern pattern = Pattern.compile("\\[([^\\]]*)\\]\\(([^\\(]*)\\)");
        pattern.flags();
        Matcher matcher = pattern.matcher(text);
        return matcher;
    }

    public static ArrayList<Word> extractWordsFromDialogue(Matcher matcher)
    {
        ArrayList<Word> words = new ArrayList<>();
        while (matcher.find())
        {
            words.add(new Word(matcher.group(1), matcher.group(2)));
        }
        return words;
    }

    public static String replaceWordsInDialogue(Matcher matcher)
    {
        StringBuffer stringBuffer= new StringBuffer();
        matcher.reset();
        while (matcher.find())
        {
            matcher.appendReplacement(stringBuffer, ";");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static Matcher extractActionsFromDialogue(String text)
    {
        Pattern pattern = Pattern.compile("<([a-zA-Z]*):(left|middle|right)>");
        pattern.flags();
        Matcher matcher = pattern.matcher(text);
        return matcher;
    }

}
