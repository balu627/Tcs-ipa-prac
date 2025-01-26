import java.util.*;
public class CollegeSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        College[] arr = new College[n];
        for(int i=0;i<arr.length;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int contactno = sc.nextInt();
            sc.nextLine();
            String address = sc.nextLine();
            int pincode = sc.nextInt();
            arr[i] = new College(id,name,contactno,address,pincode);
        }
        sc.nextLine();
        String Saddress = sc.nextLine();

        College max = findCollegeWithMaximumPincode(arr);
        if(max==null)
        {
            System.out.println("No college found with mentioned attribute");
        }
        else
        {
            System.out.println("id :"+max.getid());
            System.out.println("Name :"+max.getName());
            System.out.println("contactNo :"+max.getcontactNo());
            System.out.println("address :"+max.getaddress());
            System.out.println("pincode :"+max.getpincode());
        }


        College ans = searchCollegeByAddress(arr,Saddress);
        if(ans==null)
        {
            System.out.println("No college found with mentioned attribute");
        }
        else
        {
            System.out.println("id :"+ans.getid());
            System.out.println("Name :"+ans.getName());
            System.out.println("contactNo :"+ans.getcontactNo());
            System.out.println("address :"+ans.getaddress());
            System.out.println("pincode :"+ans.getpincode());
        }

    }
    public static College searchCollegeByAddress(College[] arr,String Saddress)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getaddress().equalsIgnoreCase(Saddress))
            {
                return arr[i];
            }
        }
        return null;
    }

    
    public static College findCollegeWithMaximumPincode(College[] arr)
    {
        College max = null;
        for(int i=0;i<arr.length;i++)
        {
            if(max==null || arr[i].getpincode()>max.getpincode())
            {
                max = arr[i];
            }
        }
        return max;
    }
}

class College
{
    private int id;
    private String name;
    private int contactno;
    private String address;
    private int pincode;

    public College(int id,String name,int contactno,String address,int pincode)
    {
        this.id = id;
        this.name = name;
        this.contactno = contactno;
        this.address = address;
        this.pincode = pincode;
    }

    public int getid()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getcontactNo()
    {
        return contactno;
    }

    public String getaddress()
    {
        return address;
    }

    public int getpincode()
    {
        return pincode;
    }
}