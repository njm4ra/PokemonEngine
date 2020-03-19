package PokemonEngine.Map;

public class City {
    public String name;
    public Route inbound;
    public Route outbound;
    public PokemonCenter pokemonCenter;

    public City(String name, Route in, Route out){
        this.name = name;
        this.inbound = in;
        this.outbound = out;
        this.pokemonCenter = new PokemonCenter();
    }
}
