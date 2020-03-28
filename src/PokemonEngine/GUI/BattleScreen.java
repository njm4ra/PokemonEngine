package PokemonEngine.GUI;

import PokemonEngine.Battle;
import PokemonEngine.Move;
import PokemonEngine.PlayGame;
import PokemonEngine.PokeObjects.*;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class BattleScreen{

    Image backgroundStd = new Image("PokemonEngine/GUI/Backgrounds/Battle_std.png", true);

    @FXML
    HBox battleOptions, moveOptions, attackNarration;

    @FXML
    VBox myStatusBar, opStatusBar;

    @FXML
    BorderPane mainLayout;

    @FXML
    ImageView background, mySprite, opponentSprite;

    @FXML
    Button move1, move2, move3, move4;

    @FXML
    ProgressBar myHp, opHp;

    @FXML
    Label myName, myLevel, myHealth,
          opName, opLevel, opHealth,
          moveStats, narration;

    private Move myMove, opMove;

    private int myNarrationDuration, opNarrationDuration,
                myAttackDuration,    opAttackDuration;

    private Timeline timeline;

    @FXML
    public void initialize(){

        this.background.setImage(backgroundStd);

        this.mySprite.setImage(PlayGame.getMe().currentPokemon().backSprite);

        this.opponentSprite.setImage(PlayGame.getRival().currentPokemon().frontSprite);

        this.myStatusBar.setBackground(new Background(new BackgroundFill
                                       (Color.rgb(255,254,235), CornerRadii.EMPTY, Insets.EMPTY)));

        this.opStatusBar.setBackground(new Background(new BackgroundFill
                                       (Color.rgb(255,254,235), CornerRadii.EMPTY, Insets.EMPTY)));

        this.myName.setText(PlayGame.getMe().currentPokemon().name);
        this.myLevel.setText("Lv. " + PlayGame.getMe().currentPokemon().level);
        this.myHealth.setText("HP: " + PlayGame.getMe().currentPokemon().health +
                              "/" + PlayGame.getMe().currentPokemon().hp);

        this.opName.setText(PlayGame.getRival().currentPokemon().name);
        this.opLevel.setText("Lv. " + PlayGame.getRival().currentPokemon().level);
        this.opHealth.setText("HP: " + PlayGame.getRival().currentPokemon().health +
                              "/" + PlayGame.getRival().currentPokemon().hp);

        this.setMoveButtons(PlayGame.getMe().currentPokemon());
    }

    public void handleFightButton(){
        this.battleOptions.setVisible(false);
        this.moveOptions.setVisible(true);
    }

    public void setMoveButtons(Pokemon myPokemon){

        if(myPokemon.moveset[0] != null) {
            move1.setText(myPokemon.moveset[0].name);
        }else{
            move1.setText("-");
        }
        if(myPokemon.moveset[1] != null) {
            move2.setText(myPokemon.moveset[1].name);
        }else{
            move2.setText("-");
        }
        if(myPokemon.moveset[2] != null) {
            move3.setText(myPokemon.moveset[2].name);
        }else{
            move3.setText("-");
        }
        if(myPokemon.moveset[3] != null) {
            move4.setText(myPokemon.moveset[3].name);
        }else{
            move4.setText("-");
        }
    }

    public void handleMoveButton(ActionEvent button){

        //links button pressed to the Move object its associated with
        if(button.getSource().equals(move1)){
            if(!move1.getText().equals("-")) {
                myMove = PlayGame.getMe().chooseMove(move1.getText());
            }else {
                myMove = null;
            }
        }else if(button.getSource().equals(move2)){
            if(!move2.getText().equals("-")) {
                myMove = PlayGame.getMe().chooseMove(move2.getText());
            }else {
                myMove = null;
            }
        }else if(button.getSource().equals(move3)){
            if(!move3.getText().equals("-")) {
                myMove = PlayGame.getMe().chooseMove(move3.getText());
            }else {
                myMove = null;
            }
        }else if(button.getSource().equals(move4)){
            if(!move4.getText().equals("-")) {
                myMove = PlayGame.getMe().chooseMove(move4.getText());
            }else {
                myMove = null;
            }
        }

        if(myMove != null){
            beginAttack();
        }
    }

    private void beginAttack(){
        opMove = PlayGame.getRival().computerMove();

        //this.opponentSprite.setImage(p.physicalAttackSprite);
        //have to reset x and y because of different gif formatting

        this.moveOptions.setVisible(false);
        this.attackNarration.setVisible(true);

        Pokemon first = Battle.hasFirstMove(PlayGame.getMe().currentPokemon(), PlayGame.getRival().currentPokemon());

        if(first.equals(PlayGame.getMe().currentPokemon())){

            PlayGame.getMe().currentPokemon().attack(myMove, PlayGame.getRival().currentPokemon());
            if(!PlayGame.getRival().currentPokemon().isFainted()) {
                PlayGame.getRival().currentPokemon().attack(opMove, PlayGame.getMe().currentPokemon());
            }

            myAttackDuration = 2;
            opAttackDuration = 6;
        }else{

            PlayGame.getRival().currentPokemon().attack(opMove, PlayGame.getMe().currentPokemon());
            if(!PlayGame.getMe().currentPokemon().isFainted()) {
                PlayGame.getMe().currentPokemon().attack(myMove, PlayGame.getRival().currentPokemon());
            }

            opAttackDuration = 2;
            myAttackDuration = 6;
        }

        KeyValue space = new KeyValue(this.narration.textProperty(), "");
        KeyFrame empty = new KeyFrame(Duration.seconds(0), space);

        KeyFrame myFrame = calculateMyFrame();

        KeyFrame empty2 = new KeyFrame(Duration.seconds(4), space);

        KeyFrame opFrame = calculateOpFrame();

        KeyFrame myAttack = new KeyFrame(Duration.seconds(myAttackDuration), e -> {
            if(!PlayGame.getMe().currentPokemon().isFainted()) {
                this.opHealth.setText("HP: " + PlayGame.getRival().currentPokemon().health +
                        "/" + PlayGame.getRival().currentPokemon().hp);
                animateProgressBar(this.opHp, (double) PlayGame.getRival().currentPokemon().health /
                        PlayGame.getRival().currentPokemon().hp);
            }
        });

        KeyFrame opAttack = new KeyFrame(Duration.seconds(opAttackDuration), e -> {
            if(!PlayGame.getRival().currentPokemon().isFainted()){
                this.myHealth.setText("HP: " + PlayGame.getMe().currentPokemon().health +
                        "/" + PlayGame.getMe().currentPokemon().hp);
                animateProgressBar(this.myHp, (double) PlayGame.getMe().currentPokemon().health /
                        PlayGame.getMe().currentPokemon().hp);
            }
        });

        KeyFrame reset = new KeyFrame(Duration.seconds(8), e -> {
            this.attackNarration.setVisible(false);
            this.battleOptions.setVisible(true);
            timeline.stop();

            boolean imFainted = PlayGame.getMe().currentPokemon().isFainted();
            boolean opFainted = PlayGame.getRival().currentPokemon().isFainted();
            //if(PlayGame.getMe().currentPokemon().isFainted() || PlayGame.getRival().currentPokemon.isFainted()){
            //not working for some reason
            if(imFainted || opFainted){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("EndCredits.fxml"));
                    Scene scene = new Scene(root, 794, 550);
                    PlayGame.getWindow().setScene(scene);
                }catch (IOException ex){
                    System.out.println("cant find");
                }
            }
        });

        timeline = new Timeline(empty, myAttack, myFrame, empty2, opAttack, opFrame, reset);

        timeline.setAutoReverse(false);
        timeline.setCycleCount(1);
        timeline.playFrom(Duration.seconds(0));
    }


    private KeyFrame calculateMyFrame(){
        Pokemon first = Battle.hasFirstMove(PlayGame.getMe().currentPokemon(), PlayGame.getRival().currentPokemon());

        if(first.equals(PlayGame.getMe().currentPokemon())){
            myNarrationDuration = 1;
            myAttackDuration = 2;
        }else{
            myAttackDuration = 5;
            myNarrationDuration = 6;
        }

        KeyValue narrateMyMove = new KeyValue(this.narration.textProperty(),
                                           PlayGame.getMe().currentPokemon().name + " Used " + myMove.name);
        KeyValue narrateMyDeath = new KeyValue(this.narration.textProperty(),
                                            PlayGame.getMe().currentPokemon().name + " Fainted!");

        if (!PlayGame.getMe().currentPokemon().isFainted()) {
            return new KeyFrame(Duration.seconds(myNarrationDuration), narrateMyMove);
        } else {
            return new KeyFrame(Duration.seconds(myNarrationDuration), narrateMyDeath);
        }
    }

    private KeyFrame calculateOpFrame(){
        Pokemon first = Battle.hasFirstMove(PlayGame.getMe().currentPokemon(), PlayGame.getRival().currentPokemon());
        if(first.equals(PlayGame.getMe().currentPokemon())){
            opNarrationDuration = 5;
            opAttackDuration = 6;
        }else{
            myAttackDuration = 5;
            myNarrationDuration = 6;
        }

        KeyValue narrateOpMove = new KeyValue(this.narration.textProperty(), "Foe " +
                                              PlayGame.getRival().currentPokemon().name + " Used " + opMove.name);
        KeyValue narrateOpDeath = new KeyValue(this.narration.textProperty(),"Foe " +
                                               PlayGame.getRival().currentPokemon().name + " Fainted!");

        if(!PlayGame.getRival().currentPokemon().isFainted()){
            return new KeyFrame(Duration.seconds(opNarrationDuration), narrateOpMove);
        }else{
            return new KeyFrame(Duration.seconds(opNarrationDuration), narrateOpDeath);
        }
    }

    private void animateProgressBar(ProgressBar bar, double progress){
        final Timeline animation = new Timeline();
        animation.setCycleCount(1);
        animation.setAutoReverse(false);

        final KeyValue interpolator = new KeyValue(bar.progressProperty(), progress, Interpolator.EASE_BOTH);

        final KeyFrame barAnimation = new KeyFrame(Duration.seconds(1.5), interpolator);
        animation.getKeyFrames().add(barAnimation);
        animation.playFrom(Duration.seconds(0));
    }

    public void mouseEnter(MouseEvent mouse){

        Move m1 = PlayGame.getMe().currentPokemon().moveset[0];
        Move m2 = PlayGame.getMe().currentPokemon().moveset[1];
        Move m3 = PlayGame.getMe().currentPokemon().moveset[2];
        Move m4 = PlayGame.getMe().currentPokemon().moveset[3];

        if(mouse.getSource().equals(move1) && m1 != null){
            this.moveStats.setText("PP: " + m1.pp + "\nType: " + m1.type.toString());
        }else

        if(mouse.getSource().equals(move2) && m2 != null){
            this.moveStats.setText("PP: " + m2.pp + "\nType: " + m2.type.toString());
        }else

        if(mouse.getSource().equals(move3) && m3 != null){
            this.moveStats.setText("PP: " + m3.pp + "\nType: " + m3.type.toString());
        }else

        if(mouse.getSource().equals(move4) && m4 != null){
            this.moveStats.setText("PP: " + m4.pp + "\nType: " + m4.type.toString());
        }

    }

    public void mouseExit(){
        this.moveStats.setText("");
    }
}