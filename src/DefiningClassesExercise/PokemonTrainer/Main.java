package DefiningClassesExercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        LinkedHashMap<String, List<Pokemon>> trainerMap = new LinkedHashMap<>();
        Pokemon pokemon = null;
        Trainer trainer = null;

        List<Pokemon> pokemonList = new ArrayList<>();
        while (!input.equals("Tournament")){

            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.put(trainerName, new ArrayList<>());
            trainerMap.get(trainerName).add(pokemon);

            trainer = new Trainer(trainerName, 0, 0);


            input = scan.nextLine();
        }

        String elementInput = scan.nextLine();

        while (!elementInput.equals("End")){

            for (Map.Entry<String, List<Pokemon>> entry : trainerMap.entrySet()) {
            }


            elementInput = scan.nextLine();
        }
    }
}
