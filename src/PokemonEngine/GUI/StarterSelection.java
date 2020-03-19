package PokemonEngine.GUI;

import PokemonEngine.Move;
import PokemonEngine.PlayGame;
import PokemonEngine.PokeObjects.Bulbasaur;
import PokemonEngine.PokeObjects.Charmander;
import PokemonEngine.PokeObjects.Squirtle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class StarterSelection {

    @FXML
    ImageView charBall,   sqBall,   bulBall,
              charmander, squirtle, bulbasaur;



    public void mouseEnter(MouseEvent mouse){
        if(mouse.getSource().equals(charBall)){
            charmander.setVisible(true);
        }

        if(mouse.getSource().equals(sqBall)){
            squirtle.setVisible(true);
        }

        if(mouse.getSource().equals(bulBall)){
            bulbasaur.setVisible(true);
        }
    }

    public void mouseExit(MouseEvent mouse){
        if(mouse.getSource().equals(charBall)){
            charmander.setVisible(false);
        }

        if(mouse.getSource().equals(sqBall)){
            squirtle.setVisible(false);
        }

        if(mouse.getSource().equals(bulBall)){
            bulbasaur.setVisible(false);
        }
    }

    public void mouseClick(MouseEvent mouse)throws IOException {

        if(mouse.getSource().equals(charBall)){
            Charmander charmander = new Charmander(5);
            charmander.learnMove(Move.SCRATCH);
            charmander.learnMove(Move.GROWL);
            PlayGame.getMe().capturePokemon(charmander);

            Bulbasaur bulbasaur = new Bulbasaur(5);
            bulbasaur.learnMove(Move.TACKLE);
            bulbasaur.learnMove(Move.GROWL);
            PlayGame.getRival().capturePokemon(bulbasaur);
        }else if(mouse.getSource().equals(sqBall)){
            Squirtle squirtle = new Squirtle(5);
            squirtle.learnMove(Move.TACKLE);
            squirtle.learnMove(Move.TAIL_WHIP);
            PlayGame.getMe().capturePokemon(squirtle);

            Charmander charmander = new Charmander(5);
            charmander.learnMove(Move.SCRATCH);
            charmander.learnMove(Move.GROWL);
            PlayGame.getRival().capturePokemon(charmander);
        }else if(mouse.getSource().equals(bulBall)){
            Bulbasaur bulbasaur = new Bulbasaur(5);
            bulbasaur.learnMove(Move.TACKLE);
            bulbasaur.learnMove(Move.GROWL);
            PlayGame.getMe().capturePokemon(bulbasaur);

            Squirtle squirtle = new Squirtle(5);
            squirtle.learnMove(Move.TACKLE);
            squirtle.learnMove(Move.TAIL_WHIP);
            PlayGame.getRival().capturePokemon(squirtle);
        }

        Parent root = FXMLLoader.load(getClass().getResource("BattleScreen.fxml"));
        Scene scene = new Scene(root, 794, 550);
        PlayGame.getWindow().setScene(scene);

    }
}