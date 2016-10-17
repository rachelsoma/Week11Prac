import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

public class Movie {// implements Comparable<Movie> {

  static Scanner kb = new Scanner(System.in);
  private int movieID;
  private String movieTitle;
  private String director;
  private String writer;
  private double duration;
  private String genre;
  private String classification;
  private String releaseDate;
  private String rating;
  static Movie[] arrayMovies = null;

  /**
   * @param movieID - a unique numeric identifier for a movie
   * @param movieTitle - the title/name of the movie
   * @param director - the name of the director of the movie
   * @param writer - the name of the writer of the movie
   * @param duration - the duration of the movie in hours (eg an hour and a half hour / 90 minute
   *        movie would be 1.5hrs
   * @param genre - the categorisation of the movie (eg Drama, Action, Comedy, Adventure, Family,
   *        etc)
   * @param classification - cassification of the movie (eg G, PG, M, MA 15+, R)
   * @param date - when the movie was released.
   * @param rating a numeric value between 0-5 inclusive. May be NULL if movie has not been rated
   */
  public Movie(int movieID, String movieTitle, String director, String writer, double duration,
      String genre, String classification, String date, String rating) {
    super();
    this.setMovieID(movieID);
    this.setMovieTitle(movieTitle);
    this.setDirector(director);
    this.setWriter(writer);
    this.setDuration(duration);
    this.setGenre(genre);
    this.setClassification(classification);
    this.setReleaseDate(date);
    this.setRating(rating);
  }


  /**
   * @return the movieID
   */
  public int getMovieID() {
    return movieID;
  }

  /**
   * @param movieID the movieID to set
   */
  public void setMovieID(int movieID) {
    this.movieID = movieID;
  }

  /**
   * @return the movieTitle
   */
  public String getMovieTitle() {
    return movieTitle;
  }

  /**
   * @param movieTitle the movieTitle to set
   */
  public void setMovieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
  }

  /**
   * @return the director
   */
  public String getDirector() {
    return director;
  }

  /**
   * @param director the director to set
   */
  public void setDirector(String director) {
    this.director = director;
  }

  /**
   * @return the writer
   */
  public String getWriter() {
    return writer;
  }

  /**
   * @param writer the writer to set
   */
  public void setWriter(String writer) {
    this.writer = writer;
  }

  /**
   * @return the duration
   */
  public double getDuration() {
    return duration;
  }

  /**
   * @param duration the duration to set
   */
  public void setDuration(double duration) {
    this.duration = duration;
  }

  /**
   * @return the genre
   */
  public String getGenre() {
    return genre;
  }

  /**
   * @param genre the genre to set
   */
  public void setGenre(String genre) {
    this.genre = genre;
  }

  /**
   * @return the classification
   */
  public String getClassification() {
    return classification;
  }

  /**
   * @param classification the classification to set
   */
  public void setClassification(String classification) {
    this.classification = classification;
  }

  /**
   * @return the releaseDate
   */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
   * @param date the releaseDate to set
   */
  public void setReleaseDate(String date) {
    this.releaseDate = date;
  }

  /**
   * @return the rating
   */
  public String getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(String rating) {
    this.rating = rating;
  }

  public static Movie[] readFile(File inFile, String fileName) throws IOException {
    MovieApp.fileExists(inFile, fileName);
    Scanner inputFile = new Scanner(inFile);
    int countMovies = 0;
    String str;
    String[] tokens;
    // int[] array;

    Movie[] arrayMovies = new Movie[50];
    // Read each line, split, then print
    while (inputFile.hasNextLine() && countMovies < arrayMovies.length) {
      str = inputFile.nextLine();
      tokens = str.split(",");

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
      // greater than 8 because array starts from 0 and max tokens should be 9
      if (tokens.length > 8) {
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

    return arrayMovies;
  }

  public static void print(Movie[] arrayMovies) {
    System.out.println("Calling printMovies");
    for (int i = 0; i < arrayMovies.length && arrayMovies[i] != null; i++) {
      System.out.printf("%s, %s, %s, %s, %s \n", arrayMovies[i].getMovieTitle(),
          arrayMovies[i].getDuration(), arrayMovies[i].getGenre(),
          arrayMovies[i].getClassification(), arrayMovies[i].getRating());
    }
  }

  public static void sortName(Movie[] arr) {
    int startAt; // index of starting position
    int j; // loop control
    int minIndex; // index of smallest element
    Movie tempObj; // temp object for swapping
    for (startAt = 0; startAt < arr.length - 1; startAt++) {
      minIndex = startAt; // assume smallest is at the start of arr
      tempObj = arr[startAt];
      if (arr[startAt] != null) {
        // look through the rest of the array for value smaller than starting value
        for (j = startAt + 1; j < arr.length && arr[j] != null; j++) {
          // compare current element with tempObj
          if (arr[j].getMovieTitle().compareTo(tempObj.getMovieTitle()) < 0) {
            tempObj = arr[j]; // set temp to be the new smallest value
            minIndex = j; // record where that smallest value is located
          }
        }
        arr[minIndex] = arr[startAt]; // perform the swap
        arr[startAt] = tempObj; // complete the swap
      }
    }
    print(arr);
  }

  public static void sortGenre(Movie[] arr) {
    int minIndex; // index of smallest element
    Movie tempObj; // temp object for swapping
    for (int startAt = 0; startAt < arr.length - 1; startAt++) {
      minIndex = startAt; // assume smallest is at the start of arr
      tempObj = arr[startAt];
      if (arr[startAt] != null) {
        // look through the rest of the array for value smaller than starting value
        for (int j = startAt + 1; j < arr.length && arr[j] != null; j++) {
          // compare current element with tempObj
          if (arr[j].getGenre().compareTo(tempObj.getGenre()) < 0) {
            tempObj = arr[j]; // set temp to be the new smallest value
            minIndex = j; // record where that smallest value is located
          }
        }
        arr[minIndex] = arr[startAt]; // perform the swap
        arr[startAt] = tempObj; // complete the swap
      }
    }
    print(arr);
  }

  public static int search(Movie[] array, String lookingFor) {
    int i = 0;
    int foundAt = -1;
    boolean found = false;
    while (!found && i < array.length&&array[i]!=null) {
      if (array[i].getMovieTitle().contains(lookingFor)) {
        found = true;
        foundAt = i;
      }
      i++;
    }
    return foundAt;
  }


  public static void changeGenre() {
    // TODO Auto-generated method stub
    System.out.println("****Change movie genre****");
    // get user input for movie name and search
    System.out.println("Enter a title to search for: ");
    String lookingFor = kb.nextLine();
    int foundAt = Movie.search(arrayMovies, lookingFor);
    
    if (foundAt >=0) {
      System.out
          .println(arrayMovies[foundAt].getMovieTitle() + " " + arrayMovies[foundAt].getGenre());
      // choose genre
      int returnGenre = Menu.displayMenu(Menu.genreArray);
      arrayMovies[foundAt].setGenre(Menu.genreArray[returnGenre - 1]);
      System.out.println(
          arrayMovies[foundAt].getMovieTitle() + " " + arrayMovies[foundAt].getGenre());
    } else { System.out.println("No matches found");}
  }

  public static void rate() {
    // TODO Auto-generated method stub
    System.out.println("****Change movie rating****");
    // get user input for movie name and search
    System.out.println("Enter a title to search for: ");
    String lookingFor = kb.nextLine();
    int foundAt = Movie.search(arrayMovies, lookingFor);
    if(foundAt >=0){
    System.out
        .println(arrayMovies[foundAt].getMovieTitle() + " " + arrayMovies[foundAt].getRating());
    // choose rate movie
System.out.println("Enter your rating: ");
    String newRating = kb.nextLine();
    newRating = validateRating(newRating);
    arrayMovies[foundAt].setRating(newRating);
    System.out
        .println(arrayMovies[foundAt].getMovieTitle() + " rated as " + arrayMovies[foundAt].getRating());
    } else { System.out.println("No matches found");}
  }


  private static String validateRating(String inRating) {
    // TODO Auto-generated method stub
   
    double rating = Double.parseDouble(inRating);
    while (rating < 0 || rating > 5){
      System.out.println("Enter your rating: ");
      rating = kb.nextInt();
    }
    String newRating = Double.toString(rating);
    return newRating;
  }


  // *END OF CLASS Movie *//
}
