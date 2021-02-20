package cinema;

public class Cinema {

    public static void main(String[] args) {
        Seats seats = new Seats();
        seats.view(-1, -1);
        seats.priceForSeat();
    }
}