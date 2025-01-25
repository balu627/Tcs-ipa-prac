import java.util.*;
public class TravelAgenciesSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<TravelAgencies> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int regno = sc.nextInt();
            sc.nextLine();
            String agencyName = sc.nextLine();
            String pakageType = sc.nextLine();
            int price = sc.nextInt();
            boolean flightFacility = sc.nextBoolean();
            arr.add(new TravelAgencies(regno,agencyName,pakageType,price,flightFacility));
        }
        int Sregno = sc.nextInt();
        sc.nextLine();
        String SpakageType = sc.nextLine();

        int highprice = findAgencyWithHighestPackagePrice(arr);
        System.out.println(highprice);

        TravelAgencies ans = agencyDetailsForGivenldAndType(arr,Sregno,SpakageType);
        if(ans==null)
        {
            System.out.println("None");
        }
        else
        {
            System.out.println(ans.getagencyName()+":"+ans.getprice());
        }

    }
    public static TravelAgencies agencyDetailsForGivenldAndType(Vector<TravelAgencies> arr,int Sregno,String SpakageType)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getregNo() == Sregno && arr.get(i).getpakageType().equalsIgnoreCase(SpakageType) && arr.get(i).getflightFacility())
            {
                return arr.get(i);
            }
        }
        return null;
    }

    public static int findAgencyWithHighestPackagePrice(Vector<TravelAgencies> arr)
    {
        int maxi = arr.get(0).getprice();
        for(int i=0;i<arr.size();i++)
        {
            if(maxi < arr.get(i).getprice())
            {
                maxi = arr.get(i).getprice();
            }
        }
        return maxi;
    }
}

class TravelAgencies
{
    private int regno;
    private String agencyName;
    private String pakageType;
    private int price;
    private boolean flightFacility;

    public TravelAgencies(int regno,String agencyName,String pakageType,int price,boolean flightFacility)
    {
        this.regno = regno;
        this.agencyName = agencyName;
        this.pakageType = pakageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getregNo()
    {
        return regno;
    }

    public String getagencyName()
    {
        return agencyName;
    }

    public String getpakageType()
    {
        return pakageType;
    }

    public int getprice()
    {
        return price;
    }

    public boolean getflightFacility()
    {
        return flightFacility;
    }
}