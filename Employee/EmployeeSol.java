import java.util.*;
public class EmployeeSol
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        Vector<Employee> arr = new Vector<>();
        while(true)
        {
            if(sc.hasNextInt())
            {
                int id = sc.nextInt();
                sc.nextLine();
                String Name = sc.nextLine().toLowerCase();
                String branch = sc.nextLine().toLowerCase();
                double rating = sc.nextDouble();
                sc.nextLine();
                boolean transport = sc.nextBoolean();
                arr.add(new Employee(id,Name,branch,rating,transport));
            }
            else{
                break;
            }
        }
        sc.nextLine();
        String SIT = sc.nextLine().toLowerCase(); 
        
        int countcomptranspot = findCountOfEmployeesUsingCompTransport(arr,SIT);
        if(countcomptranspot>0)
        {
            System.out.println(countcomptranspot);
        }
        else{
            System.out.println("No such Employees");
        }
        
        Employee secondhighrating = findEmployeeWithSecondHighestRating(arr);
        if(secondhighrating==null)
        {
            System.out.println("All Employees using company transport");
        }
        else{
            System.out.println(secondhighrating.getEmployeeId());
            System.out.println(secondhighrating.getName());
        }
    }
    public static int findCountOfEmployeesUsingCompTransport(Vector<Employee> arr,String SIT)
    {
        int count =0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getTransport() && arr.get(i).getBranch().equalsIgnoreCase(SIT))
            {
                count++;
            }
        }
        return count;
    }

    public static Employee findEmployeeWithSecondHighestRating(Vector<Employee> arr)
    {
        Vector<Employee> sort = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getTransport()== false )
            {
                sort.add(arr.get(i));
            }
        }
        if(sort.size()<=1)
        {
            return null;
        }

        for(int i=1;i<sort.size();i++)
        {
            for(int j=i;j<sort.size();j++)
            {
                if(sort.get(j-1).getRating()>sort.get(j).getRating())
                {
                    Employee temp = sort.get(j-1);
                    sort.set(j-1,sort.get(j));
                    sort.set(j,temp);
                }
            }
        }
        return sort.get(sort.size()-2);
    }
}

class Employee
{
    private int employeeId;
    private String Name;
    private String branch;
    private double rating;
    private boolean transport;

    public Employee(int employeeId,String Name,String branch,double rating,boolean transport)
    {
        this.employeeId = employeeId;
        this.Name = Name;
        this.branch = branch;
        this.rating = rating;
        this.transport = transport;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public String getName()
    {
        return Name;
    }

    public String getBranch()
    {
        return branch;
    }

    public double getRating()
    {
        return rating;
    }

    public boolean getTransport()
    {
        return transport;
    }
}