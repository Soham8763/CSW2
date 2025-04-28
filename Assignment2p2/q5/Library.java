package Assignment2p2.q5;

import java.util.*;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Book> books = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the name of the book");
            String name = sc.nextLine();
            System.out.println("Enter the author of the book");
            String author = sc.nextLine();
            System.out.println("Enter the quantity of the book");
            int quantity = sc.nextInt();
            books.put(i, new Book(i, name, author, quantity));
        }
        for (Map.Entry<Integer,Book> entry : books.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("Enter the name of the book you want to search");
        String bookName = sc.nextLine();
        for(Book book:books.values()){
            if(book.getName().equals(bookName)){
                System.out.println("Exists");
                break;
            }
        }
        System.out.println("Enter the book id to be removed");
        int bookId = sc.nextInt();
        Book removedBook = books.remove(bookId);
        if(removedBook != null){
            System.out.println("Book removed");
        }else{
            System.out.println("Book doesn't exists");
        }
        for(Map.Entry<Integer,Book> newBooks : books.entrySet()){
            System.out.println(newBooks.getValue());
        }
        sc.close();
    }
}