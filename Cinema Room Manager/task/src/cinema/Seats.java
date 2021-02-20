package cinema;

import java.util.Scanner;

public class Seats {
    private final int ROWS;
    private final int COLUMNS;
    String[][] reservedSeats;

    public Seats() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        ROWS = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        COLUMNS = scanner.nextInt();
        reservedSeats = new String[ROWS][COLUMNS];
        for (int a = 0; a < reservedSeats.length; a++) {
            for (int b = 0; b < reservedSeats[0].length; b++) {
                reservedSeats[a][b] = "S";
            }
        }
        System.out.println();
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
        for (int i = 1; i <= COLUMNS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int j = 0; j < ROWS; j++) {
            System.out.print(j + 1 + " ");
            for (int k = 0; k < COLUMNS; k++) {
                System.out.print(reservedSeats[j][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void priceForSeat() {
        int seatRow;
        int seatCol;
        int ticketPrice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        seatRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatCol = scanner.nextInt();

        if (reservedSeats[seatRow - 1][seatCol - 1].equals("B")) {
            System.out.println("This seat is already reserved, please choose another one.");
            priceForSeat();
        } else {
            reservedSeats[seatRow - 1][seatCol - 1] = "B";

            if (ROWS * COLUMNS <= 60) {
                ticketPrice = 10;
            } else if (seatRow <= ROWS / 2) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }

            System.out.println("\nTicket price: $" + ticketPrice);
            System.out.println();
        }
    }
}
