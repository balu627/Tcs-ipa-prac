import java.util.*;
public class TeamSol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Team> arr =  new Vector<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int tId = sc.nextInt();
            sc.nextLine();
            String tName = sc.nextLine();
            String tCountry = sc.nextLine();
            int tRun = sc.nextInt();
            arr.add(new Team(tId,tName,tCountry,tRun));
        }
        int Srun = sc.nextInt();
        sc.nextLine();
        String SCountry = sc.nextLine();

        Team ans = findPlayer(arr,Srun,SCountry);
        if(ans==null)
        {
            System.out.println("No team is found from the given country and run");
        }
        else
        {
            System.out.println(ans.gettId());
            System.out.println(ans.gettName());
            System.out.println(ans.gettCountry());
            System.out.println(ans.gettRun());
        }
    }
    public static Team findPlayer(Vector<Team> arr,int Srun,String SCountry)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).gettCountry().equalsIgnoreCase(SCountry) && arr.get(i).gettRun() > Srun)
            {
                return arr.get(i);
            }
        }
        return null;
    }
}
class Team
{
    private int tId;
    private String tName;
    private String tCountry;
    private int tRun;

    public Team(int tId,String tName,String tCountry,int tRun)
    {
        this.tId = tId;
        this.tName = tName;
        this.tCountry=  tCountry;
        this.tRun = tRun;
    }

    public int gettId()
    {
        return tId;
    }

    public String gettName()
    {
        return tName;
    }

    public String gettCountry()
    {
        return tCountry;
    }

    public int gettRun()
    {
        return tRun;
    }
}