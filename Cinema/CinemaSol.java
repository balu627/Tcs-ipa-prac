import java.util.*;
public class CinemaSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Cinema> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int movieId = sc.nextInt();
            sc.nextLine();
            String director = sc.nextLine();
            int rating = sc.nextInt();
            int budget = sc.nextInt();
            arr.add(new Cinema(movieId,director,rating,budget));
        }
        sc.nextLine();
        String Sdirector = sc.nextLine();
        int Srating = sc.nextInt();
        int Sbudget = sc.nextInt();

        int res = findAvgBudgetByDirector(arr,Sdirector);
        if(res==0)
        {
            System.out.println("Sorry - The given director has not yet directed any movie");
        }
        else
        {
            System.out.println(res);
        }

        Cinema ans = getMovieByRatingBudget(arr,Srating,Sbudget);
        if(ans==null)
        {
            System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        }
        else
        {
            System.out.println(ans.getmovieId());
        }
    }
    public static int findAvgBudgetByDirector(Vector<Cinema> arr,String Sdirector)
    {
        int sum = 0;
        int count =0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getdirector().equals(Sdirector))
            {
                count++;
                sum+=arr.get(i).getbudget();
            }
        }
        if(count==0)
        {
            return 0;
        }
        int avg = sum/count;
        return avg;
    }

    public static Cinema getMovieByRatingBudget(Vector<Cinema> arr,int Srating,int Sbudget)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getbudget()== Sbudget && arr.get(i).getrating()== Srating)
            {
                if((arr.get(i).getbudget())%(arr.get(i).getrating())==0)
                {
                    return arr.get(i);
                }
            }
        }
        return null;
    }
}

class Cinema
{
    private int movieId;
    private String director;
    private int rating;
    private int budget;

    public Cinema(int movieId,String director,int rating,int budget)
    {
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

    public int getmovieId()
    {
        return movieId;
    }

    public String getdirector()
    {
        return director;
    }

    public int getrating()
    {
        return rating;
    }

    public int getbudget()
    {
        return budget;
    }
}