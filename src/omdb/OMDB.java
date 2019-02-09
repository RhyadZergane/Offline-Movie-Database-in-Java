package omdb;

import java.io.*;

public class OMDB 
{
   public static void main(String[] args) 
   {
     // Optional file paramter incase user wants to change file.
     File films = new File("films.txt");
     
     // Creates new instance of MovieDatabse
     MovieDatabase database = new MovieDatabase();
     
     System.out.println("Movies in an unsorted order:");
     System.out.println(database);
     System.out.println("Movies in chronological order:");
     System.out.println(database.sortByChronologicalOrder());
     System.out.println("The eigth most recent unrated film:");
     System.out.println(database.getEigthMostRecentUnratedFilm());
     System.out.println("The movie with the longest title:");
     System.out.println(database.getLongestTitle());
     System.out.println("The 3rd longest film-noir movie:");
     System.out.println(database.getThirdLongestFilmNoir());
   } 
}
