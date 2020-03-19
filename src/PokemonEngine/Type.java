package PokemonEngine;

import PokemonEngine.PokeObjects.Pokemon;

public enum Type{
    NORMAL,
    WATER,
    FIRE,
    GRASS,
    ELECTRIC,
    ROCK,
    PSYCHIC,
    GHOST,
    FLYING,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    BUG,
    DRAGON,
    DARK,
    STEEL,
    FAIRY;

    @Override
    public String toString(){
        return this.name();
    }

}
