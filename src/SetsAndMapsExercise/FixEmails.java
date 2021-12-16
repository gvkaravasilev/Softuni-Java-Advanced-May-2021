package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        LinkedHashMap<String, String> personAndEmail = new LinkedHashMap<>();

        while (!name.equals("stop")){
            String email = scan.nextLine();

            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                personAndEmail.put(name, email);
            }
            name = scan.nextLine();
        }
        for (Map.Entry<String, String> entry : personAndEmail.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(), entry.getValue());
        }
    }
}
