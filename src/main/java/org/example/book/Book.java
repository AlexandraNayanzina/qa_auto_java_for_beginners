package org.example.book;

public class Book implements Displayable {
    private String title;
    private  String author;
    private  int year;

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;

    }

    public void setYear(int year){
        this.year = year;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYear(){
        return this.year;
    }

    @Override
    public void display(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println(" Book year: " + this.year);
    }

}
