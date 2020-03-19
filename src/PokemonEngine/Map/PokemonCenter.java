package PokemonEngine.Map;

import PokemonEngine.Player;
import PokemonEngine.PokeObjects.Pokemon;
import PokemonEngine.Storage;

import java.util.ArrayList;

public class PokemonCenter {

    public Storage pc;

    public PokemonCenter(){
        this.pc = new Storage();
    }

    public void restore(Player player){
        for(Pokemon pokemon : player.party){
            pokemon.health = pokemon.hp;
        }
    }
}
