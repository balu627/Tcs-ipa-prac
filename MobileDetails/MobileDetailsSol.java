import java.util.*;
public class MobileDetailsSol{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        MobileDetails[] arr = new MobileDetails[5];
        for(int i=0;i<arr.length;i++)
        {
            int mobileId = sc.nextInt();
            int price = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            boolean isFlagship = sc.nextBoolean();
            sc.nextLine();
            arr[i] = new MobileDetails(mobileId,price,brand,isFlagship);
        }
        String Sbrand = sc.nextLine();

        int sum = getTotalPrice(arr,Sbrand);
        if(sum==0)
        {
            System.out.println("There are no mobile with given brand");
        }
        else
        {
            System.out.println(sum);
        }

        MobileDetails[] ans = getSecondMin(arr);
        if(ans.length==0)
        {
            System.out.println("None");
        }
        else{
            for(int i=0;i<ans.length;i++)
            {
                System.out.println(ans[i].getbrand()+":"+ans[i].getprice());
            }
        }
    }

    public static MobileDetails[] getSecondMin(MobileDetails[] arr)
    {
        MobileDetails min = null;
        MobileDetails smin = null;
        for(int i=0;i<arr.length;i++)
        {
            if(min==null ||arr[i].getprice()<min.getprice())
            {
                smin = min;
                min = arr[i];
            }
            else if(smin==null || arr[i].getprice()<smin.getprice() && arr[i].getprice()>min.getprice())
            {
                smin = arr[i];
            }
        }

        MobileDetails[] ans = new MobileDetails[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getprice()==smin.getprice())
            {
                ans = Arrays.copyOf(ans,ans.length+1);
                ans[ans.length-1] = arr[i];
            }
        }
        return ans;
    }

    public static int getTotalPrice(MobileDetails[] arr,String Sbrand)
    {
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getbrand().equals(Sbrand))
            {
                sum+=arr[i].getprice();
            }
        }
        return sum;
    }
}

class MobileDetails
{
    int mobileId;
    int price;
    String brand;
    boolean isFlagship;

    public MobileDetails(int mobileId,int price,String brand ,boolean isFlagship)
    {
        this.mobileId = mobileId;
        this.price = price;
        this.brand = brand;
        this.isFlagship =isFlagship;
    }

    public int getmobileId()
    {
        return mobileId;
    }

    public int getprice()
    {
        return price;
    }

    public String getbrand()
    {
        return brand;
    }

    public boolean getisFlagship()
    {
        return isFlagship;
    }
}