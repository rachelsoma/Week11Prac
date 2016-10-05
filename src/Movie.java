import java.util.Date;

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
  private Date releaseDate;
  private String rating;
  
  /**
   * @param movieID
   * @param movieTitle
   * @param director
   * @param writer
   * @param duration
   * @param genre
   * @param classification
   * @param releaseDate
   * @param rating
   */
  public Movie(int movieID, String movieTitle, String director, String writer, double duration,
      String genre, String classification, Date releaseDate, String rating) {
    super();
    this.setMovieID(movieID);
    this.setMovieTitle(movieTitle);
    this.setDirector(director);
    this.setWriter(writer);
    this.setDuration(duration);
    this.setGenre(genre);
    this.setClassification(classification);
    this.setReleaseDate(releaseDate);
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
  public Date getReleaseDate() {
    return releaseDate;
  }

  /**
   * @param releaseDate the releaseDate to set
   */
  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
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