package PokemonEngine.PokeObjects;

import PokemonEngine.Type;
import javafx.scene.image.Image;

public class Bulbasaur extends Pokemon{

    @Override
    public int BASE_HP() {
        return 45;
    }

    @Override
    public int BASE_ATTACK() {
        return 49;
    }

    @Override
    public int BASE_DEFENSE() {
        return 49;
    }

    @Override
    public int BASE_SPATTACK() {
        return 65;
    }

    @Override
    public int BASE_SPDEFENCE() {
        return 65;
    }

    @Override
    public int BASE_SPEED() {
        return 45;
    }

    @Override
    public int BASE_EXP_YIELD() {
        return 64;
    }

    @Override
    public Growth GROWTH_RATE() {
        return Growth.MEDIUM_SLOW;
    }

    public Bulbasaur(int level) {
        this.name = "Bulbasaur";
        this.type[0] = Type.GRASS;
        this.level = level;
        this.setBaseStats();
        this.frontSprite = new Image("PokemonEngine/GUI/Sprites/bulbasaur_front.png", true);
        this.backSprite = new Image("PokemonEngine/GUI/Sprites/bulbasaur_back.png", true);
    }

    @Override
    public <T> T evolve() {
        return null;
    }

    @Override
    public void levelUp() {
        if(this.exp >= this.medSlowGrowth()){
            this.level++;
        }
    }
}
