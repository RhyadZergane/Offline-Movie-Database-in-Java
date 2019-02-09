package omdb;
import java.util.*;

public class Movie implements Comparable<Movie> // Defines comparable interface
{
   private int year;
   private String title;
   private String ageRating;
   private String genre;
   private int averageRating;
   private int duration;
   private String[] movieCollection;
   private String movie;
   
   public Movie() // Movie constructor
   {
      year          = 0;
      title         = null;
      ageRating     = null;
      genre         = null;
      duration      = 0;
      averageRating = 0;
   }
   
   // Method used for testing toString and creating movies from test harness.
   public Movie(String title, int year , String ageRating,String genre, int duration, int averageRating)
   {
      this.year          = year;
      this.title         = title;
      this.ageRating     = ageRating;
      this.genre         = genre;
      this.duration      = duration;
      this.averageRating = averageRating;
   }
   
   // Gets file from  Movie database and splits it.
   public Movie(String movie)
   {
       this.movie           = movie;
       movieCollection      = movie.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
       title                = movieCollection[0];
       year                 = Integer.parseInt(movieCollection[1]);
       ageRating            = movieCollection[2];
       genre                = movieCollection[3];
       duration             = Integer.parseInt(movieCollection[4]);
       averageRating        = Integer.parseInt(movieCollection[5]);
// https://stackoverflow.com/questions/18893390/splitting-on-comma-outside-quotes
// The above regex command was found at stack overflow and allows strings to be 
// split by commas and double quotes.
   }
   
   @Override
   public String toString()
   {
       StringBuilder builder = new StringBuilder();
       builder.append(title + ", " + year + ", " + ageRating+ ", " + genre +
                      ", " + duration + ", " + averageRating + "\n");
      return builder.toString();
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public String getAgeRating()
   {
      return ageRating;
   }
   
   public String getGenre()
   {
      return genre;
   }
   
   public int getDuration()
   {
      return duration;
   }
   
   public int getAverageRating()
   {
      return averageRating;
   }
   
   @Override
   public int compareTo(Movie movie) // Compares movies for chronological order
   {
      return year - movie.year;
   }
   
   public static Comparator<Movie> titleLength = new Comparator<Movie>()
   {
      @Override
      public int compare(Movie film1, Movie film2)
      {
         return film2.getTitle().length()-film1.getTitle().length();
      }
   };
   
   public static Comparator<Movie> recentFilms = new Comparator<Movie>()
   {
      @Override
      public int compare(Movie recentFilms1, Movie recentFilms2)
      {
         return recentFilms2.getYear()-recentFilms1.getYear();
      }
   };
   
   public static Comparator<Movie> filmDuration = new Comparator<Movie>()
   {
      @Override
      public int compare(Movie duration1, Movie duration2)
      {
         return duration2.getDuration()-duration1.getDuration();  
      }
   };
   
    // Test harness for this class
   public static void main(String[] args)
   {
      //Test data entered for film
      List<Movie> film = new ArrayList<Movie>();
      
      film.add(new Movie("Your name", 2016, "PG-12","Romance/Fantasy/Drama", 152, 92));
      film.add(new Movie("Your name", 2010, "PG-12","Romance/Fantasy/Drama", 152, 92));
      film.add(new Movie("Your name", 2009, "PG-12","Romance/Fantasy/Drama", 152, 92));
      film.add(new Movie("Your name", 2022, "PG-12","Romance/Fantasy/Drama", 152, 92));
       
      Collections.sort(film);
      
      for(Movie movie:film)
      {
         System.out.println(movie);
      }
   } 
}
