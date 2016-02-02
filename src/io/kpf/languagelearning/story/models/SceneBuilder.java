package io.kpf.languagelearning.story.models;

import io.kpf.languagelearning.utils.Parser;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Katie on 30/01/2016.
 */
public class SceneBuilder {
    protected Scene scene;
    protected Map<Integer, Character> characterMap = new HashMap<>();
    protected Map<Integer, Background> backgroundMap = new HashMap<>();
    protected Map<Integer, Item> itemMap = new HashMap<>();

    public SceneBuilder() {
        loadCharacters();
        loadBackgrounds();
        loadItems();
    }

    public void loadCharacters()
    {
        List<List<String>> charactersCSV = Parser.ParseCSV("data/characters.csv");
        for(List<String> line : charactersCSV)
        {
            characterMap.put(Integer.parseInt(line.get(0)), new Character(Integer.parseInt(line.get(0)), line.get(1),
                    new Image("file:data/images/characters/"+line.get(2)),
                    new Image("file:data/images/characters/"+line.get(3))));
        }
    }

    public void loadBackgrounds()
    {
        List<List<String>> scenesCSV = Parser.ParseCSV("data/backgrounds.csv");
        for(List<String> line : scenesCSV)
        {
            backgroundMap.put(Integer.parseInt(line.get(0)), new Background(Integer.parseInt(line.get(0)),
                    line.get(1), line.get(2)));
        }
    }

    public void loadItems()
    {
        List<List<String>> scenesCSV = Parser.ParseCSV("data/items.csv");
        for(List<String> line : scenesCSV)
        {
            itemMap.put(Integer.parseInt(line.get(0)), new Item(Integer.parseInt(line.get(0)),
                    line.get(1), new Image("file:data/images/items/"+line.get(2))));
        }
    }
    
    public Scene createNewScene(List<String> line) {
        Item item = itemMap.get(Integer.parseInt(line.get(2)));
        Background background = backgroundMap.get(Integer.parseInt(line.get(1)));
        Character character1 = characterMap.get(Integer.parseInt(line.get(3)));
        Character character2 = characterMap.get(Integer.parseInt(line.get(4)));
        
        Scene scene = new Scene(Integer.parseInt(line.get(0)), background, character1, character2, item, line.get(5));
        return scene;
    }
}
