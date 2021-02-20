package cinema;

import java.util.Scanner;

public class Seats {
    private final int ROWS;
    private final int COLUMNS;

    public Seats() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        ROWS = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        COLUMNS = scanner.nextInt();
    }

    public void income() {
        int frontTicketPrice;
        int backTicketPrice;
        int income;
        if (ROWS * COLUMNS <= 60) {
            frontTicketPrice = 10;
            income = frontTicketPrice * ROWS * COLUMNS;
        } else {
            frontTicketPrice = 10;
            backTicketPrice = 8;
            income = frontTicketPrice * (ROWS / 2) * COLUMNS + backTicketPrice * (ROWS - ROWS / 2) * COLUMNS;
            System.out.println(ROWS / 2);
            System.out.println(ROWS - ROWS / 2);
        }
        System.out.println("Total income:\n$" + income);
    }

    public void view() {
        System.out.print("Cinema:\n  ");
        for (int i = 1; i <= COLUMNS; i ++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int j = 0; j < ROWS; j++) {
            System.out.print(j + 1 + " ");
            for (int k = 0; k < COLUMNS; k++) {
                System.out.print("S ");
            }
            System.out.println();
        }
    }
}
