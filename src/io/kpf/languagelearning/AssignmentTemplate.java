package io.kpf.languagelearning;

import io.kpf.languagelearning.duolingo.controllers.DuolingoController;
import io.kpf.languagelearning.shared.Player;
import io.kpf.languagelearning.story.controllers.StoryController;
import io.kpf.languagelearning.utils.FileLoader;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class AssignmentTemplate extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Scene scene;
    TabPane root;
    Tab tab1, tab2;
    private Player player;

    public void start(Stage stage) throws Exception {
        stage.setTitle("Software Architectures - Katie Paxton-Fear");
        root = new TabPane();
        scene = new Scene(root, 800, 600);
        stage.setScene(scene);

        player = Player.getInstance();

        FileLoader.loadConfig("configuration.txt");

        tab1 = new Tab();
        tab1.setText("First Tab");
        tab1.setClosable(false);
        root.getTabs().add(tab1);

        StoryController storyController = new StoryController(player);
        tab1.setContent(storyController.getView());

        tab2 = new Tab();
        tab2.setText("Second Tab");
        tab2.setClosable(false);
        root.getTabs().add(tab2);

        DuolingoController duolingoController = new DuolingoController(player);
        tab2.setContent(duolingoController.getView());

        stage.show();
    }

    public Player getPlayer() {
        return player;
    }
}
