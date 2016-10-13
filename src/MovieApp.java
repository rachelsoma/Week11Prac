/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

import java.util.Scanner;
import java.io.File;
// import java.io.FileNotFoundException;
import java.io.IOException;
// import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MovieApp {

  public static void main(String[] args) throws IOException {

    System.out.println("Running");
    // TODO Auto-generated method stub
    // define variables
    String fileName = "movieLibrary.txt";
    int countMovies = 0;

    Scanner kb = new Scanner(System.in);
    File inFile = new File(fileName);
    String str;
    String[] tokens;
    // int[] array;

    Movie[] arrayMovies = new Movie[50];

    fileExists(inFile, fileName);
    Scanner inputFile = new Scanner(inFile);

    String[] menuArray = {"Movies", "Playlists", "Save", "Exit"};
    int returnMenu = displayMenu(menuArray);


    switch (returnMenu) {
      case 1:
        String[] movieMenuArray =
            {"Display movies", "Sort Movies", "Rate Movie", "Change Movie Genre"};
        displayMenu(movieMenuArray);
    }
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
      if (tokens.length > 8) { // greater than 8 because array starts from 0 and max tokens should
                               // be 9
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



    System.out.println("Total: " + countMovies); // print total movies

    inputFile.close();
    kb.close();
  }



  static Scanner kb = new Scanner(System.in);


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

    Scanner kb = new Scanner(System.in);
    while (!inFile.exists()) { // validates that file exists

      System.out.println("File not found"); // alerts user to missing file
      System.out.println("Please enter a new file location:"); // prompts for new input
      fileName = kb.next();
      inFile = new File(fileName); // replace filename with user input
      kb.close();
    }

  }
}
