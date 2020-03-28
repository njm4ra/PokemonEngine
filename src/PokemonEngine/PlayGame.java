package PokemonEngine;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class PlayGame extends Application{

    private static Stage window;
    public static Scene openingScene;
    private Scene mapScreen;

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
        me.overworldFront = new Image("PokemonEngine/GUI/Sprites/me_front.png", true);
        me.frontWalk = new Image("PokemonEngine/GUI/Sprites/me_walking.png", true);

        me.overworldBack = new Image("PokemonEngine/GUI/Sprites/me_back.png", true);
        me.backWalk = new Image("PokemonEngine/GUI/Sprites/me_back_walking.png", true);
        launch(args);
    }
/*
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Pokemon Chriq");
        window.getIcons().add(new Image("PokemonEngine/GUI/Sprites/pokeball.png"));

        Parent root = FXMLLoader.load(getClass().getResource("GUI/Cities/Charlottesville.fxml"));

        Scene scene = new Scene(root, 794, 550);
        window.setScene(scene);
        window.show();
    }*/

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Pokemon Chriq");
        window.getIcons().add(new Image("PokemonEngine/GUI/Sprites/pokeball.png"));

        HBox open = new HBox();
        ImageView background = new ImageView(new Image("PokemonEngine/GUI/titleScreen.png", true));
        open.getChildren().add(background);

        //Parent root = FXMLLoader.load(getClass().getResource("GUI/StarterSelection.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/PokemonEngine/GUI/Cities/Charlottesville.fxml"));
        mapScreen = new Scene(root);

        openingScene = new Scene(open, 794, 550);
        openingScene.setOnMouseClicked(e -> window.setScene(mapScreen));

        /**
         * credit to YouTuber FreddeGredde for his video The Pokemedley (A Pokémon Mashup)
         * https://www.youtube.com/watch?v=OG-L2wFrmm8
         * */
        Media backgroundMusic = new Media(new File("src/PokemonEngine/GUI/Pokemedley.wav").toURI().toString());
        player = new MediaPlayer(backgroundMusic);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);

        window.setScene(openingScene);
        window.setResizable(false);
        window.show();
    }
}
