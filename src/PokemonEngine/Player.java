package PokemonEngine;

import PokemonEngine.PokeObjects.Pokemon;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player {

    public String name;
    public Storage storage;
    public Pokemon[] party;

    public Image overworldFront;
    public Image frontWalk;

    public Image overworldBack;
    public Image backWalk;

    public Player(){
        this.party = new Pokemon[6];
    }

    public Player(Pokemon[] party){
        this.party = party;
    }

    public Pokemon currentPokemon(){
        if (this.party != null) {
            return this.party[0];
        }
        return null;
    }

    //adds new Pokemon object to your party
    public void capturePokemon(Pokemon p){
        for(int i = 0; i < 6; i++){
            if(this.party[i] == null){
                this.party[i] = p;
            }
        }
    }

    //sets the current pokemon object so that it can be used in battle
    public void choosePokemon(Pokemon p){
        for(int i = 0; i < party.length; i++){
            if (p.equals(party[i])) {
                //currentPokemon = party[i];
            }
        }
    }

    public boolean whitedOut(){
        for(Pokemon p : this.party){
            try {
                if (!(p.isFainted())) {
                    return false;
                }
            }catch(NullPointerException e){
                return true;
            }
        }
        return true;
    }

    public Move chooseMove(String moveName){

        for(Move m : currentPokemon().moveset){
            if(moveName.equals(m.getName())){
                return m;
            }
        }

        return null;
    }

    public Move computerMove(){
        return currentPokemon().moveset[0];
    }

    public void movePokemon(Pokemon pokemon){
        for(Pokemon p : this.storage.pokemonStorage){
            if(pokemon.equals(p)){
                //TODO implement
            }
        }
    }

    public void frontWalk(ImageView sprite){
        sprite.setImage(this.frontWalk);
    }

    public void backWalk(ImageView sprite){
        sprite.setImage(this.backWalk);
    }


    public String getName(){
        return this.name;
    }
}
