package PokemonEngine;

public enum Item {

    //Potions

    //Elixirs

    //Pokeballs

    POKEBALL("Pokeball", 200){
        @Override
        public void useItem() {

        }
    };


    String name;
    public int price;

    Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public abstract void useItem();
}
