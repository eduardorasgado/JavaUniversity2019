package com.eduardocode.jasonviewer;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.model.Magazine;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.model.Serie;

import java.util.Date;

public class Main {

    public static void main(String[] args)
    {
        // Instantiate an object
        //Movie rambo = new Movie("Rambo");
        //System.out.println(rambo.getTitle());

        int exit = 0;
        do {
            printMenu();
            takeDecision();

        } while(exit != 0);
    }

    private static void printMenu() {
        System.out.println("[WELCOME TO JASON VIEWER]");
        System.out.println("");
        System.out.println("Selecciona la opcion a la que deseas accesar.");
        System.out.println("1. Movies");
        System.out.println("2. Series");
        System.out.println("3. Books");
        System.out.println("4. Magazines");
        System.out.println("5. Report");
        System.out.println("6. Report Today");
        System.out.println("0. Exit");
    }

    private static void takeDecision()
    {
        // Leer la respuesta del usuario
        int opcion = 4;

        switch (opcion) {
            case 0:
                System.out.println("Elegiste Salir");
                break;
            case 1:
                showMovies();
                break;
            case 2:
                showSeries();
                break;
            case 3:
                showBooks();
                break;
            case 4:
                showMagazines();
                break;
            case 5:
                makeReport();
                break;
            case 6:
                Date today = new Date();
                makeReport(today);
                break;
            default:
                System.out.println("Opcion inválida");
                break;
        }
    }

    private static void showMovies()
    {
        System.out.println("Elegiste movies");
        int exit = 1;
        do {
            System.out.println("::MOVIES::");
            // Creating a movie instance
            Movie cocoMovie = new Movie("Coco", "Animation",
                    "Lee Unkrich", 134, (short)2017);
            System.out.println(cocoMovie.getTitle());
            cocoMovie.setTitle("Rambo");
            cocoMovie.setGenre("Action");
            System.out.println(cocoMovie.getTitle());
            // calling toString method overloaded from Object->film->Movie
            System.out.println(cocoMovie);

            break;
        } while (exit == 1);
    }

    private static void showSeries()
    {
        System.out.println("Elegiste Series");
        int exit = 1;
        do {
            System.out.println("::SERIES::");

            Serie friends = new Serie("Friends", "Comedia", "Gabe Flores",
                    15000, 6);
            // using toSting override function
            System.out.println(friends);

            break;
        } while (exit == 1);
    }

    private static void showBooks()
    {
        System.out.println("Elegiste Books");
        int exit = 1;
        do {
            System.out.println("::BOOKS::");
            Date mydate = new Date();
            Book myBook = new Book("The Lean Startup", mydate,
                    "business", "Origins", "IRB34-45");
            System.out.println(myBook);

            break;
        } while (exit == 1);
    }

    private static void showMagazines()
    {
        System.out.println("Elegiste Magazines");
        int exit = 1;
        do {
            System.out.println("::MAGAZINES::");
            Date date = new Date();
            Magazine mag = new Magazine("Muy Interesante", date,
                    "Science", "Whaterver", (short) 789);
            System.out.println(mag);

            break;
        } while (exit == 1);
    }

    private static void makeReport()
    {

    }

    private static void makeReport(Date date)
    {

    }
}