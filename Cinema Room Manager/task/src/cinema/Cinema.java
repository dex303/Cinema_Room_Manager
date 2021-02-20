package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Seats seats = new Seats();
        Scanner scanner = new Scanner(System.in);
        boolean again = true;

        while (again) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit");
            switch (scanner.nextInt()) {
                case 0:
                    again = false;
                    break;
                case 1:
                    seats.view();
                    break;
                case 2:
                    seats.priceForSeat();
                    break;
            }
        }
    }
}