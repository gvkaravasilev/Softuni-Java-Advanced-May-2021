package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("search")){
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phoneBook.put(name, number);

            input = scan.nextLine();
        }
        String searchedName = scan.nextLine();

        while (!searchedName.equals("stop")){

            if(!phoneBook.containsKey(searchedName)){
                System.out.printf("Contact %s does not exist.%n",searchedName);
            }else{
                System.out.printf("%s -> %s%n",searchedName, phoneBook.get(searchedName));
            }

            searchedName = scan.nextLine();
        }
    }
}
