
/**
 * Student ID: 18820821
 * Name: Rachel Hardie
 * Campus: Kingswood
 * Tutor Name: Jordan Collier
 * Class Day: Thursday
 * Class Time: 0900
 */

public class Movie {
  
  private int movieID;
  private String movieTitle;
  private String director;
  private String writer;
  private double duration;
  private String genre;
  private String classification;
  private String releaseDate;
  private String rating;
  
  /**
   * @param movieID - a unique numeric identifier for a movie
   * @param movieTitle - the title/name of the movie
   * @param director - the name of the director of the movie
   * @param writer - the name of the writer of the movie
   * @param duration - the duration of the movie in hours (eg an hour and a half hour / 90 minute movie would be 1.5hrs
   * @param genre - the categorisation of the movie (eg Drama, Action, Comedy, Adventure, Family, etc)
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
}