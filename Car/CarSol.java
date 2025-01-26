import java.util.*;
public class CarSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Car[] arr = new Car[4];
        for(int i=0;i<arr.length;i++)
        {
            String make = sc.nextLine();
            String model = sc.nextLine();
            int year = sc.nextInt();
            double price = sc.nextDouble();
            sc.nextLine();
            arr[i] = new Car(make,model,year,price);
        }
        String Smake = sc.nextLine();
        String Smodel = sc.nextLine();


        Car ans1 = findMostExpensiveCar(arr);
        if(ans1==null)
        {
            System.out.println("Sorry - No car is available");
        }
        else
        {
            System.out.println(ans1.getMake());
            System.out.println(ans1.getModel());
            System.out.println(ans1.getprice());
            System.out.println(ans1.getYear());
        }

        Car ans2 = getCarByMakeAndModel(arr,Smake,Smodel);
        if(ans2==null)
        {
            System.out.println("Sorry - No car is available");
        }
        else
        {
            System.out.println(ans2.getYear());
            System.out.println(ans2.getprice());
        }
    }
    public static Car getCarByMakeAndModel(Car[] arr,String Smake,String Smodel)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getMake().equalsIgnoreCase(Smake) && arr[i].getModel().equalsIgnoreCase(Smodel))
            {
                return arr[i];
            }
        }
        return null;
    }

    public static Car findMostExpensiveCar(Car[] arr)
    {
        Car max = null;
        for(int i=0;i<arr.length;i++)
        {
            if(max==null || arr[i].getprice()>max.getprice())
            {
                max = arr[i];
            }
        }
        return max;
    }
}

class Car
{
    String make;
    String model;
    int year;
    double price;

    public Car(String make,String model,int year,double price)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake()
    {
        return make;
    }
    
    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }

    public double getprice()
    {
        return price;
    }
}