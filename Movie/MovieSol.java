import java.util.*;
public class MovieSol{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Movie> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            String movieName = sc.nextLine();
            String company = sc.nextLine();
            String genre = sc.nextLine();
            int budget = sc.nextInt();
            sc.nextLine();
            arr.add(new Movie(movieName,company,genre,budget));
        }
        String Sgenre = sc.nextLine();
        Vector<Movie> result = getMovieByGenre(arr,Sgenre);
        if(result.size()==0)
        {
            System.out.println("No movies found with that genre");
        }
        else{
            for(int i=0;i<result.size();i++)
            {
                if(result.get(i).getBudget()> 80000000)
                {
                    System.out.println("High Budget Movie");
                }
                else{
                    System.out.println("Low Budget Movie");
                }
            }
        }
    }

    public static Vector<Movie> getMovieByGenre(Vector<Movie> arr,String Sgenre)
    {
        Vector<Movie> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getGenre().equalsIgnoreCase(Sgenre))
            {
                ans.add(arr.get(i));
            }
        }
        return ans;
    }
}

class Movie
{
    private String movieName;
    private String company;
    private String genre;
    private int budget;

    public Movie(String movieName,String company,String genre,int budget)
    {
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    } 

    public String getMovieName()
    {
        return movieName;
    }

    public String getCompany()
    {
        return company;
    }

    public String getGenre()
    {
        return genre;
    }

    public int getBudget()
    {
        return budget;
    }
}