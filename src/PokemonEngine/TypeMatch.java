package PokemonEngine;

import PokemonEngine.PokeObjects.Pokemon;

public interface TypeMatch {

    boolean isType(Type t);

    default boolean isStrongAgainst(Pokemon opponent){
        if(this.isType(Type.NORMAL)){
            return false;
        }
        if(this.isType(Type.WATER)){
            return opponent.isType(Type.FIRE) ||
                   opponent.isType(Type.ROCK) ||
                   opponent.isType(Type.GROUND);
        }
        if(this.isType(Type.FIRE)){
            return opponent.isType(Type.GRASS) ||
                   opponent.isType(Type.ICE) ||
                   opponent.isType(Type.BUG) ||
                   opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.GRASS)){
            return opponent.isType(Type.WATER) ||
                   opponent.isType(Type.ROCK) ||
                   opponent.isType(Type.GROUND);
        }
        if(this.isType(Type.ELECTRIC)){
            return opponent.isType(Type.WATER) ||
                   opponent.isType(Type.FLYING);
        }
        if(this.isType(Type.ROCK)){
            return opponent.isType(Type.FIRE) ||
                   opponent.isType(Type.ICE) ||
                   opponent.isType(Type.FLYING) ||
                   opponent.isType(Type.BUG);
        }
        if(this.isType(Type.PSYCHIC)){
            return opponent.isType(Type.POISON) ||
                   opponent.isType(Type.FIGHTING);
        }
        if(this.isType(Type.GHOST)){
            return opponent.isType(Type.PSYCHIC) ||
                   opponent.isType(Type.GHOST);
        }
        if(this.isType(Type.FLYING)){
            return opponent.isType(Type.GRASS) ||
                   opponent.isType(Type.FIGHTING) ||
                   opponent.isType(Type.BUG);
        }
        if(this.isType(Type.ICE)){
            return opponent.isType(Type.GRASS) ||
                   opponent.isType(Type.GROUND) ||
                   opponent.isType(Type.FLYING) ||
                   opponent.isType(Type.DRAGON);
        }
        if(this.isType(Type.FIGHTING)){
            return opponent.isType(Type.NORMAL) ||
                   opponent.isType(Type.ICE) ||
                   opponent.isType(Type.DARK) ||
                   opponent.isType(Type.ROCK) ||
                   opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.POISON)){
            return opponent.isType(Type.GRASS) ||
                   opponent.isType(Type.FAIRY);
        }
        if(this.isType(Type.GROUND)){
            return opponent.isType(Type.FIRE) ||
                   opponent.isType(Type.ELECTRIC) ||
                   opponent.isType(Type.POISON) ||
                   opponent.isType(Type.ROCK) ||
                   opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.BUG)){
            return opponent.isType(Type.GRASS) ||
                   opponent.isType(Type.PSYCHIC) ||
                   opponent.isType(Type.DARK);
        }
        if(this.isType(Type.DRAGON)){
            return opponent.isType(Type.DRAGON);
        }
        if(this.isType(Type.DARK)){
            return opponent.isType(Type.GHOST) ||
                   opponent.isType(Type.PSYCHIC);
        }
        if(this.isType(Type.STEEL)){
            return opponent.isType(Type.ICE) ||
                   opponent.isType(Type.ROCK) ||
                   opponent.isType(Type.FAIRY);
        }
        if(this.isType(Type.FAIRY)){
            return opponent.isType(Type.FIGHTING) ||
                   opponent.isType(Type.DARK) ||
                   opponent.isType(Type.DRAGON);
        }

        return false;
    }


    /**
     * these moves are offensively strong against certain Pokemon
     * @param opponent the pokemon you are comparing yourself to
     * @return true if your pokemon/move is strong/super effecting against opponent, false otherwise
     */

    default boolean isWeakAgainst(Pokemon opponent) {
        if(this.isType(Type.NORMAL)){
            return opponent.isType(Type.ROCK) ||
                    opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.WATER)){
            return opponent.isType(Type.WATER) ||
                    opponent.isType(Type.GRASS) ||
                    opponent.isType(Type.DRAGON);
        }
        if(this.isType(Type.FIRE)){
            return opponent.isType(Type.FIRE) ||
                    opponent.isType(Type.WATER) ||
                    opponent.isType(Type.ROCK) ||
                    opponent.isType(Type.DRAGON);
        }
        if(this.isType(Type.GRASS)){
            return opponent.isType(Type.FIRE) ||
                    opponent.isType(Type.GRASS) ||
                    opponent.isType(Type.POISON) ||
                    opponent.isType(Type.FLYING) ||
                    opponent.isType(Type.BUG) ||
                    opponent.isType(Type.DRAGON) ||
                    opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.ELECTRIC)){
            return opponent.isType(Type.ELECTRIC) ||
                    opponent.isType(Type.GRASS) ||
                    opponent.isType(Type.DRAGON);
        }
        if(this.isType(Type.ROCK)){
            return opponent.isType(Type.FIGHTING) ||
                    opponent.isType(Type.GROUND) ||
                    opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.PSYCHIC)){
            return opponent.isType(Type.PSYCHIC) ||
                    opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.GHOST)){
            return opponent.isType(Type.DARK);
        }
        if(this.isType(Type.FLYING)){
            return opponent.isType(Type.ELECTRIC) ||
                    opponent.isType(Type.ROCK) ||
                    opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.ICE)){
            return opponent.isType(Type.FIRE) ||
                    opponent.isType(Type.WATER) ||
                    opponent.isType(Type.ICE) ||
                    opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.FIGHTING)){
            return opponent.isType(Type.POISON) ||
                    opponent.isType(Type.FLYING) ||
                    opponent.isType(Type.PSYCHIC) ||
                    opponent.isType(Type.BUG) ||
                    opponent.isType(Type.FAIRY);
        }
        if(this.isType(Type.POISON)){
            return opponent.isType(Type.POISON) ||
                    opponent.isType(Type.GROUND) ||
                    opponent.isType(Type.ROCK) ||
                    opponent.isType(Type.GHOST);
        }
        if(this.isType(Type.GROUND)){
            return opponent.isType(Type.GRASS) ||
                    opponent.isType(Type.BUG);
        }
        if(this.isType(Type.BUG)){
            return opponent.isType(Type.FIRE) ||
                    opponent.isType(Type.FIGHTING) ||
                    opponent.isType(Type.POISON) ||
                    opponent.isType(Type.FLYING) ||
                    opponent.isType(Type.GHOST) ||
                    opponent.isType(Type.STEEL) ||
                    opponent.isType(Type.FAIRY);
        }
        if(this.isType(Type.DRAGON)){
            return opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.DARK)){
            return opponent.isType(Type.FIGHTING) ||
                    opponent.isType(Type.DARK) ||
                    opponent.isType(Type.FAIRY);
        }
        if(this.isType(Type.STEEL)){
            return opponent.isType(Type.FIRE) ||
                    opponent.isType(Type.WATER) ||
                    opponent.isType(Type.ELECTRIC) ||
                    opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.FAIRY)){
            return opponent.isType(Type.FIRE) ||
                    opponent.isType(Type.POISON) ||
                    opponent.isType(Type.STEEL);
        }

        return false;
    }

}
