package com.eduardocode.jasonviewer;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.model.Magazine;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.model.Serie;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	private static Scanner sc = null;
	private static int exit = 1;
	
    public static void main(String[] args)
    {
    	sc = new Scanner(System.in);
    	
        do {
            printMenu();
            takeDecision();

        } while(exit != 0);
    }

    private static void printMenu() {
        System.out.println("\n[WELCOME TO JASON VIEWER]");
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
    	
    	// parsing de string a entero
    	try {
    		exit = Integer.valueOf(sc.nextLine()); // lo que el usuario introduzca en la consola
    		
    		switch (exit) {
	            case 0:
	                System.out.println("Elegiste Salir");
	                exit = 0;
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
	                System.out.println("Opcion invalida");
	                break;
    		}
    	} catch (NumberFormatException e) {
    		System.out.println("[Selecciona una opci�n, tu opcion no es valida]");
		}
    }

    private static void showMovies()
    {
        System.out.println("Elegiste movies");
        do {
            System.out.println("::MOVIES::");
            // Creating a movie instance
            ArrayList<Movie> movies = Movie.createMovieList();
            
            for(int i = 0; i < movies.size(); i++) {
            	String viewed = movies.get(i).isViewed() ? "Si" : "No";
            	
            	System.out.println("============");
            	System.out.println((i+1)+". "+movies.get(i).getTitle());
            	System.out.println(movies.get(i).getGenre());
            	System.out.println("visto: "+viewed);
            }
            System.out.println("0. Regresar al menu anterior");
        	System.out.println("============");
            System.out.println("Tu opcion: ");
            
            try {
            	exit = Integer.valueOf(sc.nextLine());
            	if(exit != 0 && exit < 5) {
            		Movie movieSelected = movies.get(exit-1);
            		System.out.println("Viendo "+movieSelected+"...\n");
            		movieSelected.setViewed(true);
            		Date dateI = movieSelected.startToSee(new Date());
            		try {
            			Thread.sleep(2000);
            		} catch (Exception e) {
            			e.printStackTrace();
					}
            		movieSelected.stoptToSee(dateI, new Date());
            		
            		System.out.println("Viste la pelicula:"+ movieSelected);
            	} else if(exit > 5){
            		System.out.println("**tu opcion es invalida**");
            	}
            	else {
            		System.out.println("[Saliendo de menu movies]...");
            		break;
            	}
            } catch (NumberFormatException e) {
            	System.out.println("**Tu opcion es invalida**");
			}
        } while (true);
        exit = 1;
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
    
    private static boolean validatingScannerInput() {
    	return true;
    }
}