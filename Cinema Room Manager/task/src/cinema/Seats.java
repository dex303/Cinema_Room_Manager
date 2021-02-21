package cinema;

import java.util.Scanner;

public class Seats {
    private final int ROWS;
    private final int COLUMNS;
    String[][] reservedSeats;
    private int soldTickets = 0;
    private int currentIncome = 0;

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
        System.out.println("Total income: $" + income);
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

        boolean isRowRight = seatRow < 0 || seatRow > ROWS;
        boolean isColRight = seatCol < 0 || seatCol > COLUMNS;
        if (isRowRight || isColRight) {
            System.out.println("Wrong input!");
            System.out.println();
            priceForSeat();
        } else if (reservedSeats[seatRow - 1][seatCol - 1].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            priceForSeat();
        } else {
            reservedSeats[seatRow - 1][seatCol - 1] = "B";
            soldTickets++;

            if (ROWS * COLUMNS <= 60) {
                ticketPrice = 10;
            } else if (seatRow <= ROWS / 2) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }

            currentIncome += ticketPrice;
            System.out.println("\nTicket price: $" + ticketPrice);
            System.out.println();
        }
    }

    public void stats() {
        System.out.println("Number of purchased tickets: " + soldTickets);
        double percentageOfSoldTickets = (double) soldTickets / (ROWS * COLUMNS) * 100;
        System.out.format("Percentage:% .2f%%\n", percentageOfSoldTickets);
        System.out.println("Current income: $" + currentIncome);
        income();
        System.out.println();
    }
}
