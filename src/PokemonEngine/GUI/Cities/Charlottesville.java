package PokemonEngine.GUI.Cities;

import PokemonEngine.Map.Building;
import PokemonEngine.PlayGame;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;


public class Charlottesville{



    @FXML
    AnchorPane mainPane;

    @FXML
    ScrollPane scroll;

    @FXML
    ImageView mySprite, background, rotunda;

    private double xPixels;
    private double yPixels;

    private Transition down;
    private Transition up;

    private Building theRotunda;

    public void initialize(){
        this.xPixels = this.background.getImage().getWidth();
        this.yPixels = this.background.getImage().getHeight();

        this.theRotunda = new Building();

        this.mySprite.setImage(PlayGame.getMe().overworldFront);
        scroll.setVvalue(0.5);

        this.down = new Transition() {
            {
                setCycleDuration(Duration.INDEFINITE);
            }
            @Override
            protected void interpolate(double v) {
                scroll.setVvalue(scroll.getVvalue() + 0.002);
            }
        };

        this.up = new Transition() {
            {
                setCycleDuration(Duration.INDEFINITE);
            }
            @Override
            protected void interpolate(double v) {
                scroll.setVvalue(scroll.getVvalue() - 0.002);
            }
        };
    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException {
        if(event.getCode() == KeyCode.S){
            PlayGame.getMe().frontWalk(this.mySprite);
            down.play();
        }
        if(event.getCode() == KeyCode.W){
            if(!isClose(mySprite, rotunda)) {
                PlayGame.getMe().backWalk(this.mySprite);
                up.play();
            }else{
                up.stop();
                mySprite.setImage(PlayGame.getMe().overworldBack);
            }
        }
        if(event.getCode() == KeyCode.A){

        }
        if(event.getCode() == KeyCode.D){

        }
        if(event.getCode() == KeyCode.ENTER){
            if(isClose(this.mySprite, this.rotunda)){
                this.theRotunda.enter();
            }
        }
    }

    @FXML
    private void handleKeyRelease(KeyEvent event){
        if(event.getCode() == KeyCode.S){
            down.stop();
            mySprite.setImage(PlayGame.getMe().overworldFront);
        }
        if(event.getCode() == KeyCode.W){
            up.stop();
            mySprite.setImage(PlayGame.getMe().overworldBack);
        }
        if(event.getCode() == KeyCode.A){

        }
        if(event.getCode() == KeyCode.D){

        }
    }

    private boolean isClose(ImageView mySprite, ImageView building){
        double buildingY = building.getLayoutY() + building.getFitHeight();
        double myY = mySprite.getLayoutY() + (scroll.getVvalue()*yPixels) + mySprite.getFitHeight();
        if(myY - buildingY <= 10){
            return true;
        }else {
            return false;
        }
    }
}
