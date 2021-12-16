package SetsAndMapsLab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String input = scan.nextLine();

        while (!input.equals("END")){
            String[] tokens = input.split(", ");

            String direction = tokens[0];
            String carNumber = tokens[1];

            switch (direction){

                case "IN":
                    parkingLot.add(carNumber);
                    break;
                case "OUT":
                    parkingLot.remove(carNumber);
                    break;
            }

            input = scan.nextLine();
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}
