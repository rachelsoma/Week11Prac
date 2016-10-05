/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

import java.util.Scanner;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.PrintWriter;

public class MovieApp {

  public static void main(String[] args) throws IOException {
    
    System.out.println("Running");
    // TODO Auto-generated method stub
    //define variables
    String fileName = "movieLibrary.txt";
    int countMovies = 0;

    Scanner kb = new Scanner(System.in);
    File inFile = new File(fileName);
    String str;
    String[] tokens;

    fileExists(inFile, fileName);
    Scanner inputFile = new Scanner(inFile);
    //read file
    while (inputFile.hasNextLine()) {
      str = inputFile.nextLine();
      tokens = str.split(",");
      for (int i =0; i < tokens.length; i++){
        System.out.print(tokens[i] + " ");
      }
      countMovies++;
      System.out.println(" ");
    }

    System.out.println(countMovies);

    
    inputFile.close();
    kb.close();
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