import java.util.*;
public class Sim2Sol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Sim2> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String company = sc.nextLine();
            int balance = sc.nextInt();
            double rateperSecond = sc.nextDouble();
            sc.nextLine();
            String circle = sc.nextLine();
            arr.add(new Sim2(id,company,balance,rateperSecond,circle));
        }
        String Scircle = sc.nextLine();
        double SrateperSecond = sc.nextDouble();

        Vector<Sim2> ans = matchAndSort(arr,Scircle,SrateperSecond);
        if(ans.size()==0)
        {
            System.out.println("None");
        }
        else
        {
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getid());
            }
        }

    }
    public static Vector<Sim2> matchAndSort(Vector<Sim2> arr, String Scircle, double SrateperSecond)
    {
        Vector<Sim2> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getcircle().equals(Scircle) && SrateperSecond > arr.get(i).getrateperSecond())
            {
                ans.add(arr.get(i));
            }
        }

        if(ans.size()==0)
        {
            return ans;
        }

        for(int i=0;i<ans.size();i++)
        {
            for(int j=1;j<ans.size();j++)
            {
                if(ans.get(j).getbalance()>ans.get(j-1).getbalance())
                {
                    Sim2 temp = ans.get(j);
                    ans.set(j,ans.get(j-1));
                    ans.set(j-1,temp);
                }
            }
        }
        return ans;
    }
}

class Sim2
{
    private int id;
    private String company;
    private int balance;
    private double rateperSecond;
    private String circle;

    public Sim2(int id,String company,int balance,double rateperSecond,String circle)
    {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.rateperSecond = rateperSecond;
        this.circle = circle;
    }

    public int getid()
    {
        return id;
    }

    public String getcompany()
    {
        return company;
    }

    public int getbalance()
    {
        return balance;
    }

    public double getrateperSecond()
    {
        return rateperSecond;
    }

    public String getcircle()
    {
        return circle;
    }
}