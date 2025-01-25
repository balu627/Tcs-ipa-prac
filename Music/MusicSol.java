import java.util.*;
public class MusicSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Music> arr = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            int playListNo = sc.nextInt();
            sc.nextLine();
            String type = sc.nextLine();
            int count = sc.nextInt();
            double duration = sc.nextDouble();
            arr.add(new Music(playListNo,type,count,duration));
        }
        int Scount = sc.nextInt();
        int Sduration = sc.nextInt();

        int avg = findAvgOfCount(arr,Scount);
        if(avg==0)
        {
            System.out.println("No playlist found");
        }
        else
        {
            System.out.println(avg);
        }

        ArrayList<Music> ans = sortTypeByDuration(arr,Sduration);
        if(ans==null)
        {
            System.out.println("No playlist found with mentioned attribute");
        }
        else{
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getType());
            }
        }

    }

    public static ArrayList<Music> sortTypeByDuration (ArrayList<Music> arr,int Sduration)
    {
        ArrayList<Music> ans = new ArrayList<>();
        for(int i=0;i<arr.size();i++)
        {
            if(((int)arr.get(i).getduration())>Sduration)
            {
                ans.add(arr.get(i));
            }
        }

        if(ans.size()==0)
        {
            return null;
        }

        for(int i=0;i<ans.size();i++)
        {
            for(int j=1;j<ans.size();j++)
            {
                if(ans.get(j-1).getduration()>ans.get(j).getduration())
                {
                    Music temp = ans.get(j);
                    ans.set(j,ans.get(j-1));
                    ans.set(j-1,temp);
                }
            }
        }
        return ans;
    }

    public static int findAvgOfCount(ArrayList<Music> arr,int Scount)
    {
        int count = 0;
        int sum = 0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getcount()>Scount)
            {
                count++;
                sum+=arr.get(i).getcount();
            }
        }
        if(count==0)
        {
            return 0;
        }
        int avg = sum/count;
        return avg;
    }
}

class Music
{
    private int playListNo;
    private String type;
    private int count;
    private double duration;

    public Music(int playListNo,String type,int count,double duration)
    {
        this.playListNo = playListNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }

    public int getplayListNo()
    {
        return playListNo;
    }

    public String getType()
    {
        return type;
    }

    public int getcount()
    {
        return count;
    }

    public double getduration()
    {
        return duration;
    }
}