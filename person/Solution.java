import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Student[] st = new Student[2];
        faculty[] fa = new faculty[2];
        for(int i=0;i<st.length;i++)
        {
           String firstName = sc.nextLine();
           String lastName = sc.nextLine();
           int age = sc.nextInt();
           sc.nextLine();
           char gender = sc.nextLine().charAt(0);
           String rollNo = sc.nextLine();
           String course = sc.nextLine();
           int semester = sc.nextInt();
           double gpa = sc.nextDouble();
           sc.nextLine();
           st[i] = new Student(firstName,lastName,age,gender,rollNo,course,semester,gpa);
        }
        for(int i=0;i<fa.length;i++)
        {
            String firstName = sc.nextLine();
            String lastName = sc.nextLine();
            int age = sc.nextInt();
            sc.nextLine();
            char gender = sc.nextLine().charAt(0);
            String employeeId = sc.nextLine();
            String department = sc.nextLine();
            String designation = sc.nextLine();
            double salary = sc.nextDouble();
            sc.nextLine();
            fa[i] = new faculty(firstName,lastName,age,gender,employeeId,department,designation,salary);
        }

        for(int i=0;i<st.length;i++)
        {
            System.out.println(st[i].getfirstName()+" "+ st[i].getlastName()+" "+ st[i].getrollNo());
        }
    }
}

class person
{
    private String firstName;
    private String lastName;
    private int age;
    private char gender;

    public person(String firstName,String lastName,int age,char gender)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getfirstName()
    {
        return firstName;
    }

    public String getlastName()
    {
        return lastName;
    }

    public int getage()
    {
        return age;
    }

    public char getgender()
    {
        return gender;
    }
}

class Student extends person
{
    private String rollNo;
    private String course;
    private int semester;
    private double gpa;

    public Student(String firstName,String lastName, int age,char gender,String rollNo,String course,int semester,double gpa)
    {
        super(firstName,lastName,age,gender);
        this.rollNo = rollNo;
        this.course = course;
        this.semester = semester;
        this.gpa = gpa;
    }

    public String getrollNo()
    {
        return rollNo;
    }

    public String getcourse()
    {
        return course;
    }

    public int getsemester()
    {
        return semester;
    }

    public double getgpa()
    {
        return gpa;
    }
}

class faculty extends person
{
    private String employeeId;
    private String department;
    private String designation;
    private double salary;

    public faculty(String firstName,String lastName,int age,char gender,String employeeId,String department,String designation,double salary)
    {
        super(firstName,lastName,age,gender);
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public String getemployeeId()
    {
        return employeeId;
    }

    public String getdepartment()
    {
        return department;
    }

    public String getdesignation()
    {
        return designation;
    }

    public double getsalary()
    {
        return salary;
    }
}