package org.example.advanced.book_collection;

import java.util.HashSet;
import java.util.Iterator;

public class BookCollection {
//    Create a HashSet of Book objects
    HashSet<Book> bookSet = new HashSet<>();

//    Add Book objects to the bookSet
    public void addBook(Book book) {
        bookSet.add(book);
    }

    public void removeBookByTitleUsingIterator(HashSet<Book> bookSet, String title) {
//        Using Iterator to safely remove while iterating
        Iterator<Book> iterator = bookSet.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove();
                System.out.println("Removed book: " + book );
                break;
            }
        }
    }

    public void removeBookByTitleUsingForEach(String title) {

        Book targetBook = null;
        for (Book book: bookSet) {
            if (book.getTitle().equals(title)) {
                targetBook = book;
            }
        }
        if (targetBook != null) {
            bookSet.remove(targetBook);
        } else {
            System.out.println("Book" + targetBook.getTitle() + "is not found");
        }
    }

    public void findBookByTitle(HashSet<Book> bookSet,String title) {
//        Using Iterator to safely remove while iterating
        Iterator<Book> iterator = bookSet.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                System.out.println("Book found: " + book );
                break;
            } else {
                System.out.println("Unfortunately, Book is not found");
                break;
            }
        }
    }

    public HashSet<Book> getBookSet() {
        return bookSet;
    }

    public static void main(String[] args) {

        BookCollection bookCollection1 = new BookCollection();

        bookCollection1.addBook(new Book("Complete Guide To Test Automation", "Arnon Axelrod"));
        bookCollection1.addBook(new Book("Testing Web APIs", "Mark Winteringham"));
        bookCollection1.addBook(new Book("Cracking The Coding Interview", "McDowel"));
        bookCollection1.addBook(new Book("Thinking in Java", "Bruce Eckel"));
        bookCollection1.addBook(new Book("Clean Code", "Robert Martin"));
        bookCollection1.addBook(new Book("Computer Networks", "Tanenbaum"));
        bookCollection1.addBook(new Book("Design Patterns", "Freeman"));

//        bookCollection1.getBookSet().forEach(book -> System.out.println(book));

        bookCollection1.removeBookByTitleUsingForEach("Design Patterns");
        bookCollection1.removeBookByTitleUsingIterator(bookCollection1.getBookSet(), "Thinking in Java");
        bookCollection1.getBookSet().forEach(book -> System.out.println(book));

        bookCollection1.findBookByTitle(bookCollection1.getBookSet(),"Book should not be found");
        bookCollection1.findBookByTitle(bookCollection1.getBookSet(),"Computer Networks");

    }
}
