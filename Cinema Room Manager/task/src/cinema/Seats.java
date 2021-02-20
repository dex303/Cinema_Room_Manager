package cinema;

public class Seats {
    private final int ROWS = 7;
    private final int COLUMNS = 8;

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
