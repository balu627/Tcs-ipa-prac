import java.util.*;
public class AutonomousCarSol{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<AutonomousCar> arr = new Vector<>();
        while(true)
        {
            if(sc.hasNextInt())
            {
                int carId = sc.nextInt();
                sc.nextLine();
                String brand = sc.nextLine();
                int nooftestcaseconducted = sc.nextInt();
                sc.nextLine();
                int nooftestcasepassed = sc.nextInt();
                sc.nextLine();
                String enviroment = sc.nextLine();
                arr.add(new AutonomousCar(carId,brand,nooftestcaseconducted,nooftestcasepassed,enviroment));
            }
            else{
                break;
            }
        }
        String Senviroment = sc.nextLine();
        String Sbrand = sc.nextLine();

        int findTCenv = findTestPassedByEnv(arr,Senviroment);
        if(findTCenv>0)
        {
            System.out.println(findTCenv);
        }
        else{
            System.out.println("There are no tests passed in this particular environment");
        }

        AutonomousCar result = updateCarGrade(arr,Sbrand);
        if(result==null)
        {
            System.out.println("No Car is available with the specified brand");
        }
        else{
            String grade = "";
            int percentage = (result.getNoOfTestcasePassed()*100)/result.getNoOFTestcaseConducted();
            if(percentage>=80)
            {
                grade += "A1";
            }
            else{
                grade +="B2";
            }
            System.out.println(result.getBrand()+"::"+grade);
        }

    }
    public static int findTestPassedByEnv(Vector<AutonomousCar> arr,String Senviroment)
    {
        int sum = 0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getenviroment().equalsIgnoreCase(Senviroment))
            {
                sum += arr.get(i).getNoOfTestcasePassed();
            }
        }
        return sum;
    }

    public static AutonomousCar updateCarGrade(Vector<AutonomousCar> arr,String Sbrand)
    {
        for(int i = 0;i<arr.size();i++)
        {
            if(arr.get(i).getBrand().equalsIgnoreCase(Sbrand))
            {
                return arr.get(i);
            }
        }
        return null;
    }
}

class AutonomousCar{
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestPassed;
    private String enviroment;

    public AutonomousCar(int carId,String brand,int noOfTestsConducted,int noOfTestPassed,String enviroment)
    {
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestPassed = noOfTestPassed;
        this.enviroment = enviroment;
    }

    public int getCarId()
    {
        return carId;
    }

    public String getBrand()
    {
        return brand;
    }

    public int getNoOFTestcaseConducted()
    {
        return noOfTestsConducted;
    }

    public int getNoOfTestcasePassed()
    {
        return noOfTestPassed;
    }

    public String getenviroment()
    {
        return enviroment;
    }
}