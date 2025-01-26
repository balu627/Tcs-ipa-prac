import java.util.*;
public class SongSol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Song[] arr = new Song[5];
        for(int i=0;i<arr.length;i++)
        {
            int songid = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String artist = sc.nextLine();
            double duration = sc.nextDouble();
            arr[i] = new Song(songid,title,artist,duration);
        }
        sc.nextLine();
        String Sartist = sc.nextLine();
        String SSartist = sc.nextLine();

        double sum = findSongDurationForArtist(arr,Sartist);
        if(sum==0)
        {
            System.out.println("There are no songs with given artist");
        }
        else
        {
            System.out.println(sum);
        }

        Song[] ans = getSongsInAscendingOrder(arr,SSartist);
        if(ans.length==0)
        {
            System.out.println("There are no songs with given artist");
        }
        else
        {
            for(int i=0;i<ans.length;i++)
            {
                System.out.println(ans[i].getsongid());
                System.out.println(ans[i].gettitle());
            }
        }
    }

    public static Song[] getSongsInAscendingOrder(Song[] arr,String SSartist)
    {
        Song[] ans = new Song[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getartist().equalsIgnoreCase(SSartist))
            {
                ans = Arrays.copyOf(ans,ans.length+1);
                ans[ans.length-1] = arr[i];
            }
        }

        if(ans.length==0)
        {
            return ans;
        }

        for(int i=0;i<ans.length;i++)
        {
            for(int j=1;j<ans.length;j++)
            {
                if(ans[j-1].getduration()>ans[j].getduration())
                {
                    Song temp = ans[j];
                    ans[j] = ans[j-1];
                    ans[j-1] = temp;
                }
            }
        }
        return ans;
    }

    public static double findSongDurationForArtist(Song[] arr,String Sartist)
    {
        double sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getartist().equalsIgnoreCase(Sartist))
            {
                sum+=arr[i].getduration();
            }
        }
        return sum;
    }
}

class Song
{
    private int songid;
    private String title;
    private String artist;
    private double duration;

    public Song(int songid,String title,String artist,double duration)
    {
        this.songid = songid;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public int getsongid()
    {
        return songid;
    }

    public String gettitle()
    {
        return title;
    }

    public String getartist()
    {
        return artist;
    }

    public double getduration()
    {
        return duration;
    }
}