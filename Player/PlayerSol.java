import java.util.*;
public class PlayerSol{
    public static void main(String[]Args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Player> arr = new Vector<>();
        while(true)
        {
            if(sc.hasNextInt())
            {
                int id = sc.nextInt();
                sc.nextLine();
                String skill = sc.nextLine();
                String level = sc.nextLine();
                int points = sc.nextInt();
                sc.nextLine();
                arr.add(new Player(id,skill,level,points));
            }
            else{
                break;
            }
        }
        String Sskill = sc.nextLine();
        String Slevel = sc.nextLine();

        int Spoints = findPointsForGivenSkill(arr,Sskill);
        if(Spoints>0)
        {
            System.out.println(Spoints);
        }
        else{
            System.out.println("The given Skill is not available");
        }

        Player Rplayer = getPlayerBasedOnLevel(arr,Sskill,Slevel);
        if(Rplayer==null)
        {
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
        else{
            System.out.println(Rplayer.getPlayerId());
        }

    }
    public static int findPointsForGivenSkill(Vector<Player>arr,String Sskill)
    {
        int sum =0;
        for(int i =0;i<arr.size();i++)
        {
            if(arr.get(i).getSkill().equalsIgnoreCase(Sskill))
            {
                sum+=arr.get(i).getPoints();
            }
        }
        return sum;
    }

    public static Player getPlayerBasedOnLevel(Vector<Player>arr,String Sskill,String Slevel)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getSkill().equalsIgnoreCase(Sskill) && arr.get(i).getLevel().equalsIgnoreCase(Slevel) && arr.get(i).getPoints()>=20)
            {
                return arr.get(i);
            }
        }
        return null;
    }
}

class Player
{
    private int PlayerId;
    private String skill;
    private String level;
    private int points;

    public Player(int PlayerId,String skill,String level,int points)
    {
        this.PlayerId = PlayerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    public int getPlayerId()
    {
        return PlayerId;
    }


    public String getSkill()
    {
        return skill;
    }

    public String getLevel()
    {
        return level;
    }

    public int getPoints()
    {
        return points;
    }
}