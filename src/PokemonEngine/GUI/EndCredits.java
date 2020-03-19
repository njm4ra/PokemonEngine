package PokemonEngine.GUI;

import PokemonEngine.PlayGame;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class EndCredits{
    @FXML
    BorderPane background;

    @FXML
    Label theEnd;

    @FXML
    Label credit;

    Timeline roll;

    public void initialize(){
        this.background.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.theEnd.setVisible(true);
        this.credit.setVisible(false);

        KeyValue removeEnd = new KeyValue(this.theEnd.visibleProperty(), false);
        KeyFrame space0 = new KeyFrame(Duration.seconds(4), removeEnd);

        KeyValue setCredit0 = new KeyValue(this.credit.textProperty(),
                "Base Stat, Move, and Type Matchup Data\n\nhttps://pokemondb.net");
        KeyValue viewCredit = new KeyValue(this.credit.visibleProperty(), true);
        KeyFrame credit0 = new KeyFrame(Duration.seconds(5), setCredit0, viewCredit);

        KeyValue empty = new KeyValue(this.credit.textProperty(), "");
        KeyFrame space1 = new KeyFrame(Duration.seconds(9), empty);

        KeyValue setCredit1 = new KeyValue(this.credit.textProperty(), "Music\n\n" +
                "YouTuber FreddeGredde:\nThe Pokemedley (A Pokémon Mashup)\n" +
                "https://www.youtube.com/watch?v=OG-L2wFrmm8");
        KeyFrame credit1 = new KeyFrame(Duration.seconds(10), setCredit1);

        KeyFrame space2 = new KeyFrame(Duration.seconds(14), empty);

        KeyValue setCredit2 = new KeyValue(this.credit.textProperty(),
                                        "Sprites\nhttp://www.pokestadium.com/tools/sprites");
        KeyFrame credit2 = new KeyFrame(Duration.seconds(15), setCredit2);

        KeyFrame space3 = new KeyFrame(Duration.seconds(19), empty);

        KeyValue setFin = new KeyValue(this.credit.textProperty(), "Thanks For Playing,\nChriq");
        KeyFrame fin = new KeyFrame(Duration.seconds(20), setFin);

        KeyFrame returnToOpen = new KeyFrame(Duration.seconds(25), e ->
                                             PlayGame.getWindow().setScene(PlayGame.openingScene));

        roll = new Timeline(space0, credit0, space1, credit1, space2, credit2, space3, fin, returnToOpen);
        roll.setAutoReverse(false);
        roll.setCycleCount(1);
        roll.playFrom(Duration.seconds(1));
    }
}