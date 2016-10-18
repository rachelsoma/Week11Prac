/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class MovieApp_18820821 {
  static Scanner kb = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    System.out.println("Running");
    /** Declare Vaiables */
    String fileNameMovies = "movieLibrary.txt";
    String fileNamePlaylists = "playlists.txt";
    int countMovies = 0;

    File inMovies = new File(fileNameMovies);
    File inPlaylists = new File(fileNamePlaylists);
    Movie.arrayMovies = Movie.readFile(inMovies, fileNameMovies);
    Playlist.arrayPlaylists = Playlist.readFile(inPlaylists, fileNamePlaylists);

    Menu.showMenu();

    System.out.println("Total: " + countMovies); // print total movies

    kb.close();
    System.out.println("Goodbye!");
  }

  static boolean fileExists(File inFile, String fileName) throws IOException {

    while (!inFile.exists()) { // validates that file exists

      System.out.println("File not found"); // alerts user to missing file
      System.out.println("Please enter a new file location:"); // prompts for new input
      fileName = kb.next();
      inFile = new File(fileName); // replace filename with user input
      kb.close();
    }
    return true;
  }

 
  
}
