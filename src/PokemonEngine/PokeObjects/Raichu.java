package PokemonEngine.PokeObjects;

import PokemonEngine.Type;

public class Raichu extends Pikachu{

    @Override
    public int BASE_HP() {
        return 60;
    }

    @Override
    public int BASE_ATTACK() {
        return 90;
    }

    @Override
    public int BASE_DEFENSE() {
        return 55;
    }

    @Override
    public int BASE_SPATTACK() {
        return 90;
    }

    @Override
    public int BASE_SPDEFENCE() {
        return 80;
    }

    @Override
    public int BASE_SPEED() {
        return 110;
    }

    @Override
    public int BASE_EXP_YIELD() {
        return 218;
    }


    public Raichu(int level){
        this.name = "Raichu";
        this.type[0] = Type.ELECTRIC;
        this.level = level;
        this.setBaseStats();
    }

    @Override
    public void levelUp() {
        if(this.exp >= this.medFastGrowth()){
            this.level++;
        }
    }
}
