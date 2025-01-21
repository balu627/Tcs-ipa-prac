import java.util.*;
public class FootwearSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Footwear> arr = new Vector<>();
        for(int i=0;i<5;i++)
        {
            int footwearId = sc.nextInt();
            sc.nextLine();
            String footwearName = sc.nextLine();
            String footwearType = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            arr.add(new Footwear(footwearId,footwearName,footwearType,price));
        }
        String SfootwearType = sc.nextLine();
        String SfootwearName = sc.nextLine();

        int count = getCountByType(arr,SfootwearType);
        if(count!=0)
        {
            System.out.println(count);
        }
        else
        {
            System.out.println("Footwear not available");
        }

        Footwear res = getSecondHighestPriceByBrand(arr,SfootwearName);
        if(res==null)
        {
            System.out.println("Brand not available");
        }
        else{
            System.out.println(res.getfootwareId());
            System.out.println(res.getfootwearName());
            System.out.println(res.getprice());
        }
    }
    public static int getCountByType(Vector<Footwear> arr,String SfootwearType)
    {
        int count = 0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getfootwareType().equalsIgnoreCase(SfootwearType))
            {
                count++;
            }
        }
        return count;
    }

    public static Footwear getSecondHighestPriceByBrand(Vector<Footwear> arr, String SfootwearName)
    {
        Vector<Footwear> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getfootwearName().equals(SfootwearName))
            {
                ans.add(arr.get(i));
            }
        }
        if(ans.size()<=1 )
        {
            return null;
        }


        for(int i=0;i<ans.size();i++)
        {
            for(int j=1;j<ans.size()-i;j++)
            {
                if(ans.get(j-1).getprice()>ans.get(j).getprice())
                {
                    Footwear temp = ans.get(j);
                    ans.set(j,ans.get(j-1));
                    ans.set(j-1,temp);
                }
            }
        }

        return ans.get(ans.size()-2);
    }
}

class Footwear
{
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;

    public Footwear(int footwearId,String footwearName,String footwearType,int price)
    {
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }

    public int getfootwareId()
    {
        return footwearId;
    }

    public String getfootwearName()
    {
        return footwearName;
    }

    public String getfootwareType()
    {
        return footwearType;
    }

    public int getprice()
    {
        return price;
    }
}