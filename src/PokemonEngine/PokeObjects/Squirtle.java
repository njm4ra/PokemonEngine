package PokemonEngine.PokeObjects;

import PokemonEngine.Type;
import javafx.scene.image.Image;

public class Squirtle extends Pokemon {
    @Override
    public int BASE_HP() {
        return 44;
    }

    @Override
    public int BASE_ATTACK() {
        return 48;
    }

    @Override
    public int BASE_DEFENSE() {
        return 65;
    }

    @Override
    public int BASE_SPATTACK() {
        return 50;
    }

    @Override
    public int BASE_SPDEFENCE() {
        return 64;
    }

    @Override
    public int BASE_SPEED() {
        return 43;
    }

    @Override
    public int BASE_EXP_YIELD() {
        return 63;
    }

    @Override
    public Growth GROWTH_RATE() {
        return Growth.MEDIUM_SLOW;
    }

    public Squirtle(int level) {
        this.name = "Squirtle";
        this.type[0] = Type.WATER;
        this.level = level;
        this.setBaseStats();
        this.frontSprite = new Image("PokemonEngine/GUI/Sprites/squirtle_front.png", true);
        this.backSprite = new Image("PokemonEngine/GUI/Sprites/squirtle_back.png", true);
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
