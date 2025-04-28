package Assignment2p1.q2;

public class Book {
    private int bookId;
    private String bookName;
    private double price;

    public Book(int bookId, String bookName, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Book Name: " + bookName + ", Price: Rs." + price;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass()!=obj.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return bookId == book.bookId && Double.compare(price, book.price) == 0 && bookName.equals(book.bookName);
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Book book1 = new Book(1, "A", 250.75);
        Book book2 = new Book(2, "B", 300.50);
        if (book1.getPrice() > book2.getPrice()) {
            System.out.println("Book A is more expensive than Book B.");
        } else if (book1.getPrice() < book2.getPrice()) {
            System.out.println("Book B is more expensive than Book A.");
        } else {
            System.out.println("Both books are of same price.");
        }
        System.out.println("\nDetails of Book One:");
        System.out.println(book1);
        System.out.println("\nDetails of Book Two:");
        System.out.println(book2);
    }
}