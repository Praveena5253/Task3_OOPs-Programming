package com.task3;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
	String bookId;
    String title;
    String author; 
    boolean isAvailable;
    
	public Book(String bookId, String title, String author, boolean isAvailable) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}  
	
}

class Library {
    ArrayList<Book> books = new ArrayList();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String bookId) {
        for (Book book : books) {
            if (book.bookId.equals(bookId)) 
                books.remove(book);
            else
            	System.out.println("No book exists with ID: " + bookId);
        }
    }

    public void displayBooks() {
        for (Book book : books) {
        	System.out.println("BookId: " + book.bookId);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Availability: " + book.isAvailable);
            System.out.println();
        }	
    	}   	
    }


public class LibraryManagementSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        System.out.println("Library Management System");
        System.out.println("-------------------------");
        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.println("\nEnter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
            	scanner.nextLine(); 
                System.out.println("Enter Book ID: ");
                String bookId = scanner.nextLine();
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                System.out.println("Enter author: ");
                String author = scanner.nextLine();
                System.out.println("Enter availability (true/false): ");
                boolean availability = scanner.nextBoolean();
                library.addBook(new Book(bookId, title, author, availability));
            } else if (choice == 2) {
            	scanner.nextLine(); 
                System.out.print("Enter Book ID: ");
                String bookId = scanner.next();
                library.removeBook(bookId);
            } else if (choice == 3) {
                library.displayBooks();
            } else if (choice == 4) {
                break;
            }
        }
	}

}
