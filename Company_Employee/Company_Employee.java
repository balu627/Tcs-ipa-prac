import java.util.*;
public class Company_Employee
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Comany Name:");
        String comp_name = sc.nextLine();
        System.out.println("Enter the Number of Employees");
        int emp_count = sc.nextInt();
        sc.nextLine(); 
        Vector<Employee> arr = new Vector<>();
        System.out.println("Enter the employee details:");
        for(int i=0;i<emp_count;i++)
        {
            System.out.println("Employee"+ (i+1) +":");
            System.out.println("Enter id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the emp  name");
            String name = (sc.nextLine());
            System.out.println("Enter the emp designation");
            String designation = (sc.nextLine());
            System.out.println("Enter the salary:");
            double salary = sc.nextDouble();
            arr.add(new Employee(id,name,designation,salary));
        }

       
        Company cmp = new Company(comp_name,arr,emp_count);
        int averagesalary = cmp.getAveragesalary(arr);
        System.out.println("Average Salary of cmp is :" + averagesalary);

        double maxsalary = cmp.getMaximumsalary(arr);
        System.out.println("Maximum Salary of cmp is :" + maxsalary);

        Vector<Employee> ans = cmp.getEmployeesByDesignation(arr);
        for(int i=0;i<ans.size();i++)
        {
            System.out.println("ID:" + ans.get(i).getId()+", Name" + ans.get(i).getName()+", Designation:"+ans.get(i).getDesignation()+", Salary:"+ans.get(i).getSalary());
        }

    }
}

class Company
{
    private String companyname;
    private Vector<Employee> arr;
    private int numEmployees;

    public Company(String companyname,Vector<Employee> arr,int numEmployees)
    {
        this.companyname = companyname;
        this.arr = arr;
        this.numEmployees = numEmployees;
    }

    public String getCompanyName()
    {
        return companyname;
    }

    public int getnumEmployees()
    {
        return numEmployees;
    }

    public Vector<Employee> getArr()
    {
        return arr;
    }

    public static int getAveragesalary(Vector<Employee>arr)
    {
        int sum = 0;
        for(int i=0;i<arr.size();i++)
        {
            sum += arr.get(i).getSalary();
        }
        int avg = (sum/arr.size());
        return avg;
    }

    public static double getMaximumsalary(Vector<Employee>arr)
    {
        for(int i=1;i<arr.size();i++)
        {
            for(int j = i;j<arr.size();j++)
            {
                if(arr.get(j-1).getSalary()>arr.get(j).getSalary())
                {
                    Employee temp = arr.get(j-1);
                    arr.set(j-1,arr.get(j)) ;
                    arr.set(j,temp);
                }
            }
        }
        return arr.get(arr.size() -1).getSalary();
    }

    public static Vector<Employee> getEmployeesByDesignation(Vector<Employee> arr)
    {
        System.out.println("Enter the designation to search:");
        Scanner sc = new Scanner(System.in);
        String sDesignation = sc.nextLine();
        Vector<Employee> ans = new Vector<Employee>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getDesignation().equalsIgnoreCase(sDesignation))
            {
                ans.add(arr.get(i));
            }
        }
        return ans;
    }    
}

class Employee
{
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id,String name,String designation,double salary)
    {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDesignation()
    {
        return designation;
    }

    public double getSalary()
    {
        return salary;
    }
}