package io.kpf.languagelearning.story.views;

import io.kpf.languagelearning.AssignmentTemplate;
import io.kpf.languagelearning.story.models.Animatable;
import io.kpf.languagelearning.story.models.Character;
import io.kpf.languagelearning.story.models.Item;
import io.kpf.languagelearning.utils.Parser;
import io.kpf.languagelearning.shared.View;
import io.kpf.languagelearning.shared.Word;
import io.kpf.languagelearning.story.models.Scene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.regex.Matcher;


/**
 * Created by Katie on 23/01/2016.
 */
public class StoryView extends View {

    public Pane textPane;
    public Character character1;
    public Character character2;
    public Item item;
    public ObjectView right;
    public ObjectView left;
    public ObjectView center;
    public AnimationTimer animationTimer;

    public StoryView()
    {
        textPane = new FlowPane();
        textPane.setPadding(new Insets(25, 25, 25, 25));
        textPane.setStyle("-fx-background-color: #ffffff;");
        
        left = new ObjectView();
        right = new ObjectView();
        center = new ObjectView();
        this.setBottom(textPane);
        
        this.setLeft(left);
        this.setRight(right);
        this.setCenter(center);

        right.setScaleX(-1);

        this.setStyle("-fx-background-color: #00000");
    }

    public void setCharacterRight(io.kpf.languagelearning.story.models.Character character)
    {
        character.setObjectView(right);
        character2 = character;
        right.setRegularImage(character.getImage());
        right.setOpenMouth(character.getOpenMouth());
        character2.setIdentifier("right");
        center.setImage(character.getImage());
    }

    public void setCharacterLeft(io.kpf.languagelearning.story.models.Character character)
    {
        character.setObjectView(left);
        character1 = character;
        left.setRegularImage(character.getImage());
        left.setOpenMouth(character.getOpenMouth());
        character1.setIdentifier("left");
        left.setImage(character.getImage());
    }

    public void setItem(Image image)
    {
        center.setImage(image);
    }

    public void setBackground(String imageUrl)
    {
        String image = imageUrl.trim();
        Image background = new Image("file:data/images/scenes/" + image);
        this.setStyle("-fx-background-image: url('"+background.impl_getUrl()+"')");
    }

    public String loadAnimations(String input) {
        Matcher actionMatcher = Parser.extractActionsFromDialogue(input);
        StringBuffer stringBuffer = new StringBuffer();
        while (actionMatcher.find())
        {
            ObjectView objectView;
            if(actionMatcher.group(2).equals(character1.getIdentifier()) && character1 instanceof Animatable) {
                objectView = character1.getObjectView();
            } else if(actionMatcher.group(2).equals(character2.getIdentifier()) && character2 instanceof Animatable) {
                objectView = character2.getObjectView();
            } else if(actionMatcher.group(2).equals(item.getIdentifier()) && item instanceof Animatable) {
                objectView = item.getObjectView();
            } else {
                objectView = new ObjectView();
            }

            switch (actionMatcher.group(1))
            {
                case "wiggle":
                    objectView.startWiggle();
                    break;

                case "fadein":
                    objectView.startFadeIn();
                    break;

                case "chat":
                    objectView.startChat();
                    break;

                case "fadeout":
                    objectView.startFadeOut();
                    break;

                case "invisible":
                    objectView.invisible();
                    break;

                case "visible":
                    objectView.visible();
                    break;

                case "slidein":
                    // todo
                    break;

                case "slideout":
                    // todo
                    break;
            }
            actionMatcher.appendReplacement(stringBuffer, "");
        }
        actionMatcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public void setUp(Scene scene) {

        // Setup visual elements from dialogue
        setCharacterLeft(scene.getCharacterLeft());
        setCharacterRight(scene.getCharacterRight());
        setBackground(scene.getBackground().getImageUrl());
        setItem(scene.getItem().getImage());

        // load any animations which must be played, returns a string clear of any animation tags
        String dialogueToSay = loadAnimations(scene.getText());

        // clear the current text
        textPane.getChildren().clear();

        // get all the words that need to have mouse overs
        List<Word> words = scene.getWords();
        // when replaced, the word is replaced with a semi colon, split the dialogue by this semi colon
        String[] strings = dialogueToSay.split(";");
        // Make the first text
        Text text = new Text(strings[0]);
        text.setFont(new Font(20));
        // Add this
        textPane.getChildren().add(text);

        // For each string add the word then add the next string
        for (int i = 1; i < strings.length; i++) {
            Text text2 = new Text(words.get(i-1).getPhrase());

            Tooltip tooltip = new Tooltip(words.get(i-1).getTranslation());
            Tooltip.install(text2, tooltip);
            text2.setFont(new Font(20));
            text2.setFill(Color.DARKGREEN);

            Text text3 = new Text(strings[i]);
            text3.setFont(new Font(20));

            textPane.getChildren().addAll(text2, text3);
        }
    }
}
