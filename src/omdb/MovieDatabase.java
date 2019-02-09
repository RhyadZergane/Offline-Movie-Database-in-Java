package omdb;

import java.io.*;
import java.util.*;

public class MovieDatabase 
{
   private File films = null;
   private String line;
   private List<Movie> movieList = new ArrayList<>();
   private List<Movie> filmNoirList = new ArrayList<>();
   private List<Movie> unratedList = new ArrayList<>();
   
   // Database method that defaults to films.txt
   public MovieDatabase()
   { 
      
      films = new File("films.txt");
      
      try(BufferedReader reader = new BufferedReader(new FileReader(films)))
      { 
        while((line = reader.readLine()) != null)
        {
           Movie movie = new Movie(line);
           movieList.add(movie);
        }
        reader.close();    
      }
      catch(IOException e)
      {
         // used for debugging and returning errors
         System.out.println("There is an error reading in the file");
      }
   }
   
   public MovieDatabase(List<Movie> chronologicalOrder, File films)
   { 
      this.films = films;
      
      try(BufferedReader reader = new BufferedReader(new FileReader(films)))
      { 
        while((line = reader.readLine()) != null)
        {
           Movie movie = new Movie(line);
           movieList.add(movie);
        }
        reader.close();
        
        Collections.sort(movieList);
      }
      catch(IOException e)
      {
         System.out.println("There is an error reading in the file");
      }
   }
   
   // Method that allows user to overwrite default file.
   public MovieDatabase(File films)
   {
      this.films = films;
      
      try(BufferedReader reader = new BufferedReader(new FileReader(films)))
      { 
        while((line = reader.readLine()) != null)
        {
           Movie movie = new Movie(line);
           movieList.add(movie);           
        }
        reader.close();        
      }
      catch(IOException e)
      {
         System.out.println("There is an error reading in the file");
      }
   }
    
   public MovieDatabase sortByChronologicalOrder()
   {
      MovieDatabase database = new MovieDatabase(movieList, films);
      return database;
   }
    
   public Movie getLongestTitle()
   {
      // Sorts title by length.
      Collections.sort(movieList, Movie.titleLength);
       
      // Displays longest movie.
      return movieList.get(0);
   }
   
   public Movie getThirdLongestFilmNoir()
   {
      // loop that iterates through all movies.
      for(Movie genre: movieList)
      {
         if(genre.getGenre().contains("Film-Noir"))
         {
            filmNoirList.add(genre);
         }
      }
      
      Collections.sort(filmNoirList, Movie.filmDuration);
      return filmNoirList.get(2);
   }
   
   // Method for getting eigth most unrated film
   public Movie getEigthMostRecentUnratedFilm()
   {
      for(Movie rating: movieList)
      {
         if(rating.getAgeRating().contains("UNRATED"))
         {
            // Add each unrated movie to a new list
            unratedList.add(rating);
         }
      }
      // Sorts UnratedList by year.
      Collections.sort(unratedList, Movie.recentFilms);
      // Prints 8th movie from UnratedList
      return unratedList.get(7);
   }
   
   @Override
   public String toString()
   {
      // String builder
      StringBuilder md = new StringBuilder();
      
      // Lists each movie in movieList
      for(Movie movie: movieList)
      {
         // Appends movie to a string
         md.append(movie);
      }     
      // Returns the stringbuilder toString
      return md.toString();
   }
   
   // Test harnes for this class
   public static void main(String[] args)
   {
      MovieDatabase db = new MovieDatabase();
       
       System.out.print(db);
   }
}
