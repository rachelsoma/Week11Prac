/**
 * Student ID: 18820821 
 * Name: Rachel Hardie 
 * Campus: Kingswood 
 * Tutor Name: Jordan Collier 
 * Class Day: Thursday 
 * Class Time: 0900
 */

import java.util.Scanner;
import java.io.File;
// import java.io.FileNotFoundException;
import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.Date;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;

public class MovieApp {
  static Scanner kb = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    System.out.println("Running");
    /** Declare Vaiables */
    
    int returnMenu;
    Movie[] arrayMovies = null;
    String fileName = "movieLibrary.txt";
    int countMovies = 0;

    Scanner kb = new Scanner(System.in);
    File inFile = new File(fileName);
    



    String[] mainMenuArray = {"Movies", "Playlists", "Save", "Exit Program"};
    returnMenu = displayMenu(mainMenuArray);

    readFile(inFile, countMovies, fileName);

    switch (returnMenu) {
      case 1:
        String[] movieMenuArray =
            {"Display movies", "Sort Movies", "Rate Movie", "Change Movie Genre"};
        displayMenu(movieMenuArray);
        switch (returnMenu){
          case 1: 
           System.out.println("****DISPLAY MOVIES****");
            printMovies(arrayMovies, countMovies);
        }
        
      case 2:
        String[] playlistMenuArray =
            {"Display Playlists", "Create Playlists", "Add movie to playlist", "Exit submenu"};
        displayMenu(playlistMenuArray);
        switch(returnMenu){
          case 1:
            
          case 2:
            
            
          case 3:
            
          case 4:
            displayMenu(mainMenuArray);
          break;
        }
        break;
      case 3:
        System.out.println("Saving...");
        
        break;
      case 4:
        System.out.println("Exiting program");
        break;

    }
    
    System.out.println("Total: " + countMovies); // print total movies

    
    kb.close();
    System.out.println("Goodbye!");
  }

  public static int displayMenu(String[] menuArray) {

    final int min = 1;
    final int max = menuArray.length;
    // int input;

    System.out.println("Enter your menu choice");
    for (int i = 0; i < menuArray.length; i++) {
      System.out.println((i + 1) + ". " + menuArray[i]);
    }
    return getMenuChoice(min, max);

  }

  public static int getMenuChoice(int min, int max) {

    int input;
    do {
      input = kb.nextInt();
      if (input < min || input > max) {
        System.out.println("menu choice out of range");
      }
    } while (input < min || input > max);
    return input;
  }

  static void fileExists(File inFile, String fileName) throws IOException {

    // Scanner kb = new Scanner(System.in);
    while (!inFile.exists()) { // validates that file exists

      System.out.println("File not found"); // alerts user to missing file
      System.out.println("Please enter a new file location:"); // prompts for new input
      fileName = kb.next();
      inFile = new File(fileName); // replace filename with user input
      kb.close();
    }
  }
  
  public static void readFile(File inFile, int countMovies, String fileName) throws IOException{
    fileExists(inFile, fileName);
    Scanner inputFile = new Scanner(inFile);
    String str;
    String[] tokens;
    // int[] array;

    Movie[] arrayMovies = new Movie[50];
 // Read each line, split, then print
    while (inputFile.hasNextLine() && countMovies < arrayMovies.length) {
      str = inputFile.nextLine();
      tokens = str.split(",");
      // for (int i =0; i < tokens.length; i++){ //loop through tokens
      // System.out.print(tokens[i] + " "); //print one token
      // }

      // parsing int/double inspiration from
      // http://stackoverflow.com/questions/8348591/splitting-string-and-put-it-on-int-array
      int inID = Integer.parseInt(tokens[0]);
      String inTitle = tokens[1];
      String inDirector = tokens[2];
      String inWriter = tokens[3];
      Double inDuration = Double.parseDouble(tokens[4]);
      String inGenre = tokens[5];
      String inClassification = tokens[6];
      String inDate = tokens[7];
      String inRating;
      if (tokens.length > 8) { /* greater than 8 because array starts from 0 and max 
      tokens should be 9 */
        inRating = tokens[8];
      } else {
        inRating = "";
      }
      // create movie object
      arrayMovies[countMovies] = new Movie(inID, inTitle, inDirector, inWriter, inDuration, inGenre,
          inClassification, inDate, inRating);
      countMovies++;// increment count
      // System.out.println(" ");
    }
    inputFile.close();
  }
  
  public static void printMovies(Movie[] arrayMovies, int countMovies){
    System.out.println("Calling printMovies");
    for (int i = 0; i < countMovies; i++){
    //print one object
      
        System.out.println(arrayMovies[i].getMovieTitle());
      
    }
  }
}
