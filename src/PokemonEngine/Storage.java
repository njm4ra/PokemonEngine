package PokemonEngine;

import PokemonEngine.PokeObjects.Pokemon;

import java.util.ArrayList;

public class Storage {
    public ArrayList<Pokemon> pokemonStorage;
    public ArrayList<Item> itemStorage;

    public Storage(){
        pokemonStorage = new ArrayList<>();
        itemStorage = new ArrayList<>();
    }

}
