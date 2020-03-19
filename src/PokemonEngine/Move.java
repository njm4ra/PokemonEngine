package PokemonEngine;

import PokemonEngine.PokeObjects.Pokemon;
import java.util.Random;

public enum Move implements TypeMatch {

    ABSORB("Absorb", Type.GRASS, "Special", 20, 100, 25){
        /**
         * recover half damage inflicted
         */
        @Override
        public void executeMove() {
            this.pokemon.health += 0.5 * damage;
        }
    },

    ACID("Acid", Type.POISON, "Special", 40, 100, 30){
        /**
         * has a 10% chance of lowering spDefence by 1 stage
         * chose 5 as arbitrary integer between 0-9 (10%)
         */
        @Override
        public void executeMove() {

            int ogSpDef = target.spDefence;

            Random rand = new Random();
            int digit = rand.nextInt(10);
            if(digit == 5){
                if(target.spDefStage > -NUM_STAGES){
                    target.spDefStage--;
                }
                target.spDefence = (int) (ogSpDef * target.statStage(this.pokemon.spDefStage));
                System.out.println(target.name + "'s Special Defense Fell!");
            }
        }
    },

    AERIAL_ACE("Aerial Ace", Type.FLYING, "Physical", 60, 101, 20) {
        @Override
        public void executeMove() {

        }
    },

    AGILITY("Agility", Type.PSYCHIC, 30){
        @Override
        public void executeMove() {

        }
        /**
         * TODO sharply boost speed
          */
    },

    GROWL("Growl", Type.NORMAL, 40){
        @Override
        public void executeMove(){
            int ogAttack = target.attack;

            if(target.attackStage > -NUM_STAGES){
                target.attackStage--;
            }
            target.attack = (int) (ogAttack * target.statStage(this.pokemon.attackStage));
            //System.out.println("\n" + target.name + "'s Attack Fell!");
        }
    },

    SCRATCH("Scratch", Type.NORMAL, "Physical", 40, 100, 35){
        @Override
        public void executeMove() {

        }
    },

    TACKLE("Tackle", Type.NORMAL, "Physical", 40, 95, 35) {
        @Override
        public void executeMove() {

        }
    },

    TAIL_WHIP("Tail Whip", Type.NORMAL, 30){
        @Override
        public void executeMove(){
            int ogDef = target.defence;

            if(target.defStage > -NUM_STAGES){
                target.defStage--;
            }
            target.defence = (int) (ogDef * target.statStage(this.pokemon.defStage));
            //System.out.println("\n" + target.name + "'s Attack Fell!");
        }
    };

    public String name;
    public String category;
    public int pp;
    public int power;
    public int accuracy;
    public Type type;
    public Pokemon pokemon; //the pokemon that uses the move
    public Pokemon target; //the pokemon being targeted by the attack
    public int damage; //damage done after an attack was inflicted
    public int NUM_STAGES = 6; //number of stages a stat may be lowered
/*
    //placeholder stats to store original values before stat changes from moves
    public final int ogHP = this.pokemon.hp;
    private final int ogAttack = this.pokemon.attack;
    private final int ogDefence = this.pokemon.defence;
    private final int ogSpAtk = this.pokemon.attack;
    private final int ogSpDef = this.pokemon.attack;
    private final int ogSpeed = this.pokemon.attack;
    */

    /**
     * attack move constructor
     * @param name
     * @param type
     * @param category
     * @param power
     * @param accuracy
     * @param pp
     */
    Move(String name, Type type, String category, int power, int accuracy, int pp){
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }

    /**
     * status move constructor
     * @param name
     * @param type
     * @param pp
     */
    Move(String name, Type type, int pp){
        this.name = name;
        this.type = type;
        this.category = "Status";
        this.pp = pp;
    }

    public abstract void executeMove();

    public boolean isNotEffective(Pokemon opponent) {
        if(this.isType(Type.NORMAL)){
            return opponent.isType(Type.GHOST);
        }
        if(this.isType(Type.WATER)){
            return false;
        }
        if(this.isType(Type.FIRE)){
            return false;
        }
        if(this.isType(Type.GRASS)){
            return false;
        }
        if(this.isType(Type.ELECTRIC)){
            return opponent.isType(Type.GROUND);
        }
        if(this.isType(Type.ROCK)){
            return false;
        }
        if(this.isType(Type.PSYCHIC)){
            return opponent.isType(Type.DARK);
        }
        if(this.isType(Type.GHOST)){
            return opponent.isType(Type.NORMAL);
        }
        if(this.isType(Type.FLYING)){
            return false;
        }
        if(this.isType(Type.ICE)){
            return false;
        }
        if(this.isType(Type.FIGHTING)){
            return opponent.isType(Type.GHOST);
        }
        if(this.isType(Type.POISON)){
            return opponent.isType(Type.STEEL);
        }
        if(this.isType(Type.GROUND)){
            return opponent.isType(Type.FLYING);
        }
        if(this.isType(Type.BUG)){
            return false;
        }
        if(this.isType(Type.DRAGON)){
            return opponent.isType(Type.FAIRY);
        }
        if(this.isType(Type.DARK)){
            return false;
        }
        if(this.isType(Type.STEEL)){
            return false;
        }
        if(this.isType(Type.FAIRY)){
            return false;
        }

        return false;
    }

    public boolean isType(Type t){
        if(this.getType().equals(t)){
            return true;
        }else{
            return false;
        }
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public int getPp() {
        return pp;
    }

    public int getPower() {
        return power;
    }

    public Type getType() {
        return type;
    }

    //Setters

    public void setPp(int pp) {
        this.pp = pp;
    }


}
