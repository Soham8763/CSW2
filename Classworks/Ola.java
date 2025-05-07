package Classworks;

interface Cab {
    void bookCab(String src, String dest);
}

public class Ola {
    public static void main(String[] args) {
        Cab cab = (s, d) -> System.out.println("Ola cab is booked from " + s + " to " + d);
        cab.bookCab("Bangalore", "Mysore");
    }
}