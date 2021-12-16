package DefiningClassesExercise.PokemonTrainer;


public class Trainer {
    private String name;
    private int badgesCount;
    private int pokemonCollection;

    public Trainer(String name, int badgesCount, int pokemonCollection){
        this.name = name;
        this.badgesCount = badgesCount;
        this.pokemonCollection = pokemonCollection;
    }

    public String getName() {
        return name;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount++;
    }

}
