import java.util.*;
public class PhoneSol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Phone> arr = new Vector<>();
        while(true)
        {
            if(sc.hasNextInt()){
                int phoneId = sc.nextInt();
                sc.nextLine();
                String os = sc.nextLine();
                String brand = sc.nextLine();
                int price = sc.nextInt();
                sc.nextLine();
                arr.add(new Phone(phoneId,os,brand,price));
            }
            else{
                break;
            }
        }
        String Sbrand = sc.nextLine();
        String Sos = sc.nextLine();

        int Sbrandres = findPriceForGivenBrand(arr,Sbrand);
        if(Sbrandres==0)
        {
            System.out.println("The given Brand is not available");
        }
        else{
            System.out.println(Sbrandres);
        }

        Phone SOsres = getPhoneIdBasedOnOs(arr,Sos);
        if(SOsres==null)
        {
            System.out.println("No phones are available with specified os and price range");
        }
        else{
            System.out.println(SOsres.getPhoneId());
        }

   }

   public static int findPriceForGivenBrand(Vector<Phone> arr,String Sbrand)
   {
        int sum = 0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getBrand().equalsIgnoreCase(Sbrand))
            {
                sum += arr.get(i).getPrice();
            }
        }
        return sum;
   }

   public static Phone getPhoneIdBasedOnOs(Vector<Phone> arr,String Sos)
   {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getOs().equalsIgnoreCase(Sos) && arr.get(i).getPrice()>=50000)
            {
                return arr.get(i);
            }
        }
        return null;
   }
}

class Phone
{
    private int phoneId;
    private String os;
    private String brand;
    private int price;

    public Phone(int phoneId,String os,String brand,int price)
    {
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price=  price;
    }

    public int getPhoneId()
    {
        return phoneId;
    }

    public String getOs()
    {
        return os;
    }

    public String getBrand()
    {
        return brand;
    }

    public int getPrice()
    {
        return price;
    }
}