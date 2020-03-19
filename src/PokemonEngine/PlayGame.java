package PokemonEngine;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;



public class PlayGame extends Application{

    private static Stage window;
    public static Scene openingScene;
    private Scene starterSelectionScene;

    private MediaPlayer player;

    private static Player me = new Player();
    private static Player rival = new Player();


    public static Stage getWindow(){
        return window;
    }
    public static Player getMe(){
        return me;
    }
    public static Player getRival(){
        return rival;
    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Pokemon");

        HBox open = new HBox();
        ImageView background = new ImageView(new Image("PokemonEngine/GUI/titleScreen.png", true));
        open.getChildren().add(background);

        Parent root = FXMLLoader.load(getClass().getResource("GUI/StarterSelection.fxml"));
        starterSelectionScene = new Scene(root);

        openingScene = new Scene(open, 794, 550);
        openingScene.setOnMouseClicked(e -> window.setScene(starterSelectionScene));

        /**
         * credit to YouTuber FreddeGredde for his video The Pokemedley (A Pokémon Mashup)
         * https://www.youtube.com/watch?v=OG-L2wFrmm8
         * */
        Media backgroundMusic = new Media(new File("src/PokemonEngine/GUI/Pokemedley.wav").toURI().toString());
        player = new MediaPlayer(backgroundMusic);
        player.setAutoPlay(true);

        window.setScene(openingScene);
        window.setResizable(false);
        window.show();
    }
}
