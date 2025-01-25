import java.util.*;
public class Player3Sol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        Vector<Player> arr = new Vector<>();
        for(int i=0;i<n;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String country = sc.nextLine();
            int matchesplayed = sc.nextInt();
            int runsscored = sc.nextInt();
            arr.add(new Player(id,name,country,matchesplayed,runsscored));
        }
        sc.nextLine();
        String Scountry = sc.nextLine();
        int Sscore = sc.nextInt();

        Vector<Player> ans = findPlayerName(arr,Scountry,Sscore);
        if(ans.size()==0)
        {
            System.out.println("No player found");
        }
        else
        {

            //sorting with respective to dictonary order of names
            for(int i=0;i<ans.size()-1;i++)
            {
                for(int j=i+1;j<ans.size();j++)
                {
                    if(ans.get(i).getname().compareTo(ans.get(j).getname())>0)
                    {
                        Player temp = ans.get(i);
                        ans.set(i,ans.get(j));
                        ans.set(j,temp);
                    }
                }
            }
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getid()+":"+ans.get(i).getname());
            }
        }
    }

    public static Vector<Player> findPlayerName(Vector<Player> arr,String Scountry,int Sscore)
    {
        Vector<Player> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getcountry().equalsIgnoreCase(Scountry) && arr.get(i).getrunsscored()>Sscore)
            {
                ans.add(arr.get(i));

                // to increase the size of an array dynamicly we use this method

                // ans = Arrays.copyOf(ans,ans.length+1);
                // tobecopied = (should be copied from , size of new formation array);

                // ans[ans.length-1]=arr[i];
            }
        }
        return ans;
    }
}

class Player
{
    private int id;
    private String name;
    private String country;
    private int matchesplayed;
    private int runsscored;

    public Player(int id,String name,String country,int matchesplayed,int runsscored)
    {
        this.id = id;
        this.name = name;
        this.country = country;
        this.matchesplayed = matchesplayed;
        this.runsscored = runsscored;
    }

    public int getid()
    {
        return id;
    }

    public String getname()
    {
        return name;
    }

    public String getcountry()
    {
        return country;
    }

    public int getmatchesplayed()
    {
        return matchesplayed;
    }

    public int getrunsscored()
    {
        return runsscored;
    }
}

