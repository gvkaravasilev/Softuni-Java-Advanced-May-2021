package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int decimal = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();

        if(decimal == 0){
            System.out.println(0);
        }else {
            while (decimal != 0) {
                binaryRepresentation.push(decimal % 2);
                decimal /= 2;
            }
        }
        while (!binaryRepresentation.isEmpty()){
            System.out.print(binaryRepresentation.pop());
        }
    }
}
