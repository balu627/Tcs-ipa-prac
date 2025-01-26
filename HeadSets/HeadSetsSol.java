import java.util.*;
public class HeadSetsSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        HeadSets[] arr = new HeadSets[4];
        for(int i=0;i<arr.length;i++)
        {
            String headsetName = sc.nextLine();
            String brand = sc.nextLine();
            int price = sc.nextInt();
            boolean available = sc.nextBoolean();
            sc.nextLine();
            arr[i] = new HeadSets(headsetName,brand,price,available);
        }
        String Sbrand = sc.nextLine();

        int tot = findTotalPriceForGivenBrand(arr,Sbrand);
        if(tot==0)
        {
            System.out.println("No Headsets available with the given brand");
        }
        else
        {
            System.out.println(tot);
        }

        HeadSets ans = findAvailableHeadsetWithSecondMinPrice(arr);
        if(ans==null)
        {
            System.out.println("No Headsets available");
        }
        else{
            System.out.println(ans.getheadsetName());
            System.out.println(ans.getprice());
        }
    }

    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[]arr)
    {
        HeadSets min = null;
        HeadSets smin = null;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getavailable())
            {
                if(min==null|| arr[i].getprice()<min.getprice())
                {
                    smin = min;
                    min = arr[i];
                }
                else if(smin==null || (arr[i].getprice()<smin.getprice() && arr[i].getprice()>min.getprice()))
                {
                    smin = arr[i];
                }
            }
        }
        return smin;
    }

    public static int findTotalPriceForGivenBrand(HeadSets[] arr,String Sbrand)
    {
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getbrand().equalsIgnoreCase(Sbrand))
            {
                sum+=arr[i].getprice();
            }
        }
        return sum;
    }

}
class HeadSets
{
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSets(String headsetName,String brand,int price,boolean available)
    {
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public  String getheadsetName()
    {
        return headsetName;
    }

    public String getbrand()
    {
        return brand;
    }

    public int getprice()
    {
        return price;
    }

    public boolean getavailable()
    {
        return available;
    }
}