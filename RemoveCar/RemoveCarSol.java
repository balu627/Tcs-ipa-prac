import java.util.*;
public class RemoveCarSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Car[] arr = new Car[5];
        for(int i=0;i<arr.length;i++)
        {
            int carid = sc.nextInt();
            sc.nextLine();
            String carName = sc.nextLine();
            String fuelType = sc.nextLine();
            arr[i] = new Car(carid,carName,fuelType);
        }
        int Sid = sc.nextInt();

        Car[] ans = RemoveAndRearrange(arr,Sid);
        if(ans==null)
        {
            System.out.println("There are no car with given id");
        }
        else
        {
            for(int i=0;i<ans.length;i++)
            {
                System.out.println(ans[i].getcarid()+":"+ans[i].getcarName());
            }
        }
    }
    public static Car[] RemoveAndRearrange(Car[] arr,int Sid)
    {
        Car[] ans = new Car[0];
        boolean occured = false;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getcarid()!=Sid)
            {
                if(occured)
                {
                    arr[i].setcarid(arr[i].getcarid()-1);
                }
                ans = Arrays.copyOf(ans,ans.length+1);
                ans[ans.length-1] = arr[i];
            }
            else if(arr[i].getcarid()==Sid)
            {
                occured = true;
            }
        }
        return ans;
    }
}
class Car
{
    private int carid;
    private String carName;
    private String fuelType;

    public Car(int carid,String carName,String fuelType)
    {
        this.carid = carid;
        this.carName = carName;
        this.fuelType = fuelType;
    }

    public int getcarid()
    {
        return carid;
    }

    public void setcarid( int carid)
    {
        this.carid = carid;
    }

    public String getcarName()
    {
        return carName;
    }

    public String getfuelType()
    {
        return fuelType;
    }
}