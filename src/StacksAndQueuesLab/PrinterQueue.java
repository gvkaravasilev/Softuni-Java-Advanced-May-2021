package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String filename = scan.nextLine();

        while (!filename.equals("print")){

            if(!filename.equals("cancel")){
                printerQueue.offer(filename);
            }else{
                if(printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled " + printerQueue.poll());
                }
            }

            filename = scan.nextLine();
        }
        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }
    }
}
