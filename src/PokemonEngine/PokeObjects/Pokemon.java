package PokemonEngine.PokeObjects;

import PokemonEngine.Move;
import PokemonEngine.Type;
import PokemonEngine.TypeMatch;
import javafx.scene.image.Image;

public abstract class Pokemon implements TypeMatch {

    public String name;
    public Type[] type = new Type[2];

    public Image frontSprite = null;
    public Image backSprite = null;
    public Image physicalAttackSprite = null;

    /*
    these represent "species strengths" or overall base stats used to calculate individual stats
    declared as abstract methods instead of constants for efficiency of implementation
     */
    public abstract int BASE_HP();
    public abstract int BASE_ATTACK();
    public abstract int BASE_DEFENSE();
    public abstract int BASE_SPATTACK();
    public abstract int BASE_SPDEFENCE();
    public abstract int BASE_SPEED();
    public abstract int BASE_EXP_YIELD();
    public abstract Growth GROWTH_RATE();

    //these values represent individual base stats of particular PokemonEngine.PokeObjects.Pokemon objects
    public int level;
    public int hp; //base HP
    public int attack;
    public int defence;
    public int spAttack;
    public int spDefence;
    public int speed;
    public int health;
    public int exp;
    public Move[] moveset = new Move[4];

    public int attackStage = 0; //stage of stat modifiers, int between -6 & 6
    public int defStage = 0;
    public int spAttackStage = 0;
    public int spDefStage = 0;
    public int speedStage = 0;



    public abstract <T> T evolve();

    /**
     * formulae for growth rates are inspired from https://www.math.miami.edu/~jam/azure/compendium/training.htm
     */
    public abstract void levelUp();

    public void setBaseStats(){
        hp = (2*this.BASE_HP()*level/100) + level + 10; //base HP
        attack = (2*BASE_ATTACK()*level/100) + 5;
        defence = (2*BASE_DEFENSE()*level/100) + 5;
        spAttack = (2*BASE_SPATTACK()*level/100) + 5;
        spDefence = (2*BASE_SPDEFENCE()*level/100) + 5;
        speed = (2*BASE_SPEED()*level/100) + 5;
        health = hp;

        if(this.GROWTH_RATE().equals(Growth.FAST)){
            exp = this.fastGrowth();
        }else if(this.GROWTH_RATE().equals(Growth.MEDIUM_FAST)){
            exp = this.medFastGrowth();
        }else if(this.GROWTH_RATE().equals(Growth.MEDIUM)){
            exp = this.mediumGrowth();
        }else if(this.GROWTH_RATE().equals(Growth.MEDIUM_SLOW)){
            exp = this.medSlowGrowth();
        }else if(this.GROWTH_RATE().equals(Growth.SLOW)){
            exp = this.slowGrowth();
        }
    }

    public void attack(Move myMove, Pokemon opponent) {
        /*
        these formulae are based on
        https://bulbapedia.bulbagarden.net/wiki/Damage
        */

        if (myMove.isStrongAgainst(opponent)) {
            if(myMove.category.equals("Physical")){
                int damage = 2 * ((((2*this.level/5)+2) * myMove.power *
                             (this.attack/opponent.defence) / 50) + 2);
                opponent.health = opponent.health - damage;
                myMove.target = opponent;
                myMove.damage = damage;
                myMove.executeMove();
            }else if(myMove.category.equals("Special")){
                int damage = 2 * ((((2*this.level/5)+2) * myMove.power *
                             (this.spAttack/opponent.spDefence) / 50) + 2);
                opponent.health = opponent.health - damage;
                myMove.target = opponent;
                myMove.damage = damage;
                myMove.executeMove();
            }else if(myMove.category.equals("Status")){
                myMove.target = opponent;
                myMove.executeMove();
            }
        }else if(myMove.isWeakAgainst(opponent)){
            if(myMove.category.equals("Physical")){
                int damage = (int) (0.5 * ((((2*this.level/5)+2) * myMove.power *
                             (this.attack/opponent.defence) / 50) + 2));
                opponent.health = opponent.health - damage;
                myMove.target = opponent;
                myMove.damage = damage;
                myMove.executeMove();
            }else if(myMove.category.equals("Special")){
                int damage = (int) (0.5 * ((((2*this.level/5)+2) * myMove.power *
                        (this.spAttack/opponent.spDefence) / 50) + 2));
                opponent.health = opponent.health - damage;
                myMove.target = opponent;
                myMove.damage = damage;
                myMove.executeMove();
            }else if(myMove.category.equals("Status")){
                myMove.target = opponent;
                myMove.executeMove();
            }
        }else if(myMove.isNotEffective(opponent)){
            if (myMove.category.equals("Physical") || myMove.category.equals("Special")) {
                System.out.println("It doesn't affect" + opponent.name);
            }else if(myMove.category.equals("Status")){
                myMove.target = opponent;
                myMove.executeMove();
            }
        }else{
            if(myMove.category.equals("Physical")){
                int damage = ((((2*this.level/5)+2) * myMove.power *
                             (this.attack/opponent.defence) / 50) + 2);
                opponent.health = opponent.health - damage;
                myMove.target = opponent;
                myMove.damage = damage;
                myMove.executeMove();
            }else if(myMove.category.equals("Special")){
                int damage = ((((2*this.level/5)+2) * myMove.power *
                             (this.spAttack/opponent.spDefence) / 50) + 2);
                opponent.health = opponent.health - damage;
                myMove.target = opponent;
                myMove.damage = damage;
                myMove.executeMove();
            }else if(myMove.category.equals("Status")){
                myMove.target = opponent;
                myMove.executeMove();
            }
        }

        if(opponent.health <= 0){
            opponent.health = 0;
        }
    }

    public boolean isFainted(){
        return this.health <= 0;
    }

    //helper method to get number of moves in moveset
    public int numMoves(){
        int count = 0;
        for(Move m : moveset){
            if(m != null){
                count++;
            }
        }
        return count;
    }

    public void learnMove(Move m) {
        if(this.numMoves() < 4){
            for(int i = 0; i < moveset.length; i++){
                if(moveset[i] == null){
                    moveset[i] = m;
                    m.pokemon = this;
                    break;
                }
            }
        }else{
            /**
             * TODO implement forget move
             */
        }
    }

    public void forgetMove(Move m){
        for(int i = 0; i < moveset.length; i++){
            if(m.equals(moveset[i])){
                moveset[i] = null;
            }
        }
    }

    //nullifies in-battle modifiers
    public void resetStats(){
        this.attackStage = 0;
        this.defStage = 0;
        this.spAttackStage = 0;
        this.spDefStage = 0;
        this.speedStage = 0;
    }

    /**
     * growth rates inspired from https://www.math.miami.edu/~jam/azure/compendium/training.htm
     */
    public int fastGrowth(){
        return (int) (0.8 * Math.pow(this.level, 3));
    }
    public int medFastGrowth(){
        return (int) (0.9 * ( Math.pow(this.level, 3)));
    }
    public int mediumGrowth(){
        return (int) (Math.pow(this.level, 3));
    }
    public int medSlowGrowth() {
        return (int) (1.125 * Math.pow(this.level, 3));
    }
    public int slowGrowth(){
        return (int) (1.25 * Math.pow(this.level, 3));
    }

    /**
     * formulae inspired by descriptions from https://www.dragonflycave.com/mechanics/stat-stages
     * @param stage int between -6 & 6 that describes a multiplies for raising/lowering stats
     * @return a multiplier for stats
     */
    public double statStage(int stage){
        if(stage < 0){
            return 2/((stage-2)*-1);
        }else if(stage > 0){
            return (stage+2)/2;
        }else{
            return 1;
        }
    }

    public boolean isType(Type t) {
        for (Type x : type) {
            if(x != null) {
                if (x.equals(t)) {
                    return true;
                }
            }else{
                return false;
            }
        }

        return false;
    }

    public int getHealth(){
        return this.health;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof Pokemon)){
            return false;
        }

        Pokemon p = (Pokemon) o;

        if((this.name.equals(p.name)) && (this.level == p.level) ){
            return true;
        }else{
            return false;
        }
    }
}

enum Growth{
    FAST,
    MEDIUM_FAST,
    MEDIUM,
    MEDIUM_SLOW,
    SLOW
}