import java.util.*;
public class Player2Sol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Player2> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int iccRank = sc.nextInt();
            int matchesPlayed = sc.nextInt();
            int runsScored = sc.nextInt();
            arr.add(new Player2(id,name,iccRank,matchesPlayed,runsScored));
        }
        int target = sc.nextInt();

        Vector<Player2> ans = findAverageOfRuns(arr,target);
        if(ans.size()==0)
        {
            System.out.println("None");
        }
        else
        {
            for(int i=0;i<ans.size();i++)
            {
                int avgrun = ans.get(i).getrunsScored()/ans.get(i).getmatchesPlayed();
                if(avgrun>=80 && avgrun<=100)
                {
                    System.out.println("Grade A");
                }
                else if(avgrun<=79 && avgrun>=50)
                {
                    System.out.println("Grade B");
                }
                else{
                    System.out.println("Grade C");
                }
            }
        }
    }
    public static Vector<Player2> findAverageOfRuns(Vector<Player2> arr,int target)
    {
        Vector<Player2> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getmatchesPlayed()>=target)
            {
                ans.add(arr.get(i));
            }
        }
        return ans;
    }
}
class Player2
{
    private int id;
    private String name;
    private int iccRank;
    private int matchesPlayed;
    private int runsScored;

    public Player2(int id,String name,int iccRank,int matchesPlayed,int runsScored)
    {
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public int getid()
    {
        return id;
    }

    public String getname()
    {
        return name;
    }

    public int geticcRank()
    {
        return iccRank;
    }

    public int getmatchesPlayed()
    {
        return matchesPlayed;
    }

    public int getrunsScored()
    {
        return runsScored;
    }
}