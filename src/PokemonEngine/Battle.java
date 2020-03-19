package PokemonEngine;

import PokemonEngine.PokeObjects.Pokemon;

import java.util.Random;

public class Battle {

    /**
     * Single battle constructor
     * @param myPokemon the Pokemon the player will use in battle
     * @param opponent the opposing Pokemon
     */
    Battle(Pokemon myPokemon, Pokemon opponent){
        /*
        this.myHealth = myPokemon.hp;
        this.oppHealth = opponent.hp;

         */
    }

    /**
     * Double battle constructor
     * @param myPokemon the Pokemon the player will use in battle
     * @param myPokemon2 the Pokemon the player will use in battle
     * @param opponent the opposing Pokemon
     * @param opponent2 the second opposing Pokemon
     */
    Battle(Pokemon myPokemon, Pokemon myPokemon2, Pokemon opponent, Pokemon opponent2){
        /*
        this.myHealth = myPokemon.hp;
        this.myHealth2 = myPokemon2.hp;
        this.oppHealth = opponent.hp;
        this.oppHealth2 = opponent2.hp;

         */
    }

    /**
     * @param myPokemon
     * @param opponent
     * @return the pokemon that will get to attack first in a round within a battle
     */
    public static Pokemon hasFirstMove(Pokemon myPokemon, Pokemon opponent){
        if(myPokemon.speed > opponent.speed){
            return myPokemon;
        }else if(myPokemon.speed < opponent.speed){
            return opponent;
        }else{
            /*
              if two pokemon speeds are equal, a random integer between 0-9 is generated to randomly choose whether
              myPokemon goes first (if the integer is less than 5) or the opponent goes first (if the integer is
              greater than or equal to 5) in a round
             */
            Random rand = new Random();
            int digit = rand.nextInt(10);
            if(digit < 5){
                return myPokemon;
            }else{
                return opponent;
            }
        }
    }

        /**
         * TODO reset base stats and revive if lost
         **/
    }