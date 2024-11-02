import java.util.*;
public class nd_Lowest_Salary{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] arr = new Employee[n];
        for(int i=0;i<n;i++)
        {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            char d = sc.next().charAt(0);
            double e = sc.nextDouble();
            arr[i] = new Employee(a,b,c,d,e);
        }
        sc.nextLine();
        int sage = sc.nextInt();
        if(arr.length>1)
        {
            Employee nd_high = getEmployeeWithSecondLowestSalary(arr);
            System.out.println(nd_high.getEmployeeId()+ "#" +nd_high.getEmployeeName());
        }
        else{
            System.out.println("Insufficent comparing employees in array");
        }

        int agecount = countEmployeesBasedOnAge(arr,sage);
        if(agecount!=0)
        {
            System.out.println(agecount);
        }
        else{
            System.out.println("No employee found for the given age");
        }
        
    }

    public static Employee getEmployeeWithSecondLowestSalary(Employee[] arr)
    {
        for(int i = 1;i<arr.length;i++)
        {
            for(int j = i;j<arr.length;j++)
            {
                if(arr[j].getSalary()>arr[j-1].getSalary())
                {
                    Employee temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr[1];
    }

    public static int countEmployeesBasedOnAge(Employee[] arr,int sage)
    {
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(sage==arr[i].getAge())
            {
                count++;
            }
        }
        return count;
    }
}

class Employee{
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;

    public Employee(int employeeId,String employeeName, int age,char gender,double salary)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }
    
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public char getGender()
    {
        return gender;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
}