import java.util.*;
public class NewspaperSol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Newspaper> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int regNo = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int publicationYear = sc.nextInt();
            int price = sc.nextInt();
            arr.add(new Newspaper(regNo,name,publicationYear,price));
        }
        int Syear = sc.nextInt();
        sc.nextLine();
        String Sname = sc.nextLine();

        int totalprice = findTotalPriceByPublicationYear(arr,Syear);
        if(totalprice == 0)
        {
            System.out.println("No Newspaper found with the mentioned attribute");
        }
        else
        {
            System.out.println(totalprice);
        }

        Newspaper ans = searchNewspaperByName(arr,Sname);
        if(ans==null)
        {
            System.out.println("No Newspaper found with the given name.");
        }
        else
        {
            System.out.println("regno:"+ans.getregNo());
            System.out.println("name:"+ans.getName());
            System.out.println("publication year:"+ans.getpublicationYear());
            System.out.println("price:"+ans.getprice());

        }
    }

    public static Newspaper searchNewspaperByName(Vector<Newspaper> arr,String Sname)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getName().equals(Sname))
            {
                return arr.get(i);
            }
        }
        return  null;
    }

    public static int findTotalPriceByPublicationYear(Vector<Newspaper> arr,int Syear)
    {
        int sum =0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getpublicationYear()==Syear)
            {
                sum+=arr.get(i).getprice();
            }
        }
        return sum;
    }
}

class Newspaper
{
    private int regNo;
    private String name;
    private int publicationYear;
    private int price;

    public Newspaper(int regNo,String name,int publicationYear,int price)
    {
        this.regNo = regNo;
        this.name = name;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public int getregNo()
    {
        return regNo;
    }

    public String getName()
    {
        return name;
    }

    public int getpublicationYear()
    {
        return publicationYear;
    }

    public int getprice()
    {
        return price;
    }

} 