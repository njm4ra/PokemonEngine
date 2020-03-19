package PokemonEngine.PokeObjects;

import PokemonEngine.Type;
import javafx.scene.image.Image;

public class Pikachu extends Pokemon{

    @Override
    public int BASE_HP() {
        return 35;
    }

    @Override
    public int BASE_ATTACK() {
        return 55;
    }

    @Override
    public int BASE_DEFENSE() {
        return 40;
    }

    @Override
    public int BASE_SPATTACK() {
        return 50;
    }

    @Override
    public int BASE_SPDEFENCE() {
        return 50;
    }

    @Override
    public int BASE_SPEED() {
        return 90;
    }

    @Override
    public int BASE_EXP_YIELD() {
        return 112;
    }

    @Override
    public Growth GROWTH_RATE() {
        return Growth.MEDIUM_FAST;
    }

    public Pikachu(){

    }

    public Pikachu(int level) {
        this.name = "Pikachu";
        this.type[0] = Type.ELECTRIC;
        this.level = level;
        this.setBaseStats();
        this.frontSprite = new Image("PokemonEngine/GUI/Sprites/pikachu_front.png", true);
        this.backSprite = new Image("PokemonEngine/GUI/Sprites/pikachu_back.png", true);
        this.physicalAttackSprite = new Image("PokemonEngine/GUI/Sprites/pikachu_front_physical.png", true);
    }

    @Override
    public Raichu evolve() {

        Raichu r = new Raichu(this.level);
        /*
        this.hp = r.hp;
        this.attack = r.attack;
        this.defence = r.defence;
        this.spAttack = r.spAttack;
        this.spDefence = r.spDefence;
        this.speed = r.speed;
        this.exp = r.exp;
        */

        return r;
    }

    @Override
    public void levelUp() {
        if(this.exp >= this.medFastGrowth()){
            this.level++;
        }
    }
}
