package DefiningClassesLab.Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            CarConstructors car;

            if(tokens.length == 1){
                car = new CarConstructors(tokens[0]);
            }else{
                car = new CarConstructors(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            System.out.println(car.toString());
        }
    }
}
