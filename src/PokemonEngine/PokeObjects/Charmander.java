package PokemonEngine.PokeObjects;

import PokemonEngine.Type;
import javafx.scene.image.Image;

public class Charmander extends Pokemon{
    @Override
    public int BASE_HP() {
        return 39;
    }

    @Override
    public int BASE_ATTACK() {
        return 52;
    }

    @Override
    public int BASE_DEFENSE() {
        return 43;
    }

    @Override
    public int BASE_SPATTACK() {
        return 60;
    }

    @Override
    public int BASE_SPDEFENCE() {
        return 50;
    }

    @Override
    public int BASE_SPEED() {
        return 65;
    }

    @Override
    public int BASE_EXP_YIELD() {
        return 62;
    }

    @Override
    public Growth GROWTH_RATE() {
        return Growth.MEDIUM_SLOW;
    }

    public Charmander(int level) {
        this.name = "Charmander";
        this.type[0] = Type.FIRE;
        this.level = level;
        this.setBaseStats();
        this.frontSprite = new Image("PokemonEngine/GUI/Sprites/charmander_front.png", true);
        this.backSprite = new Image("PokemonEngine/GUI/Sprites/charmander_back.png", true);
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
