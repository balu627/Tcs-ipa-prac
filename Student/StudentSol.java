import java.util.*;
public class StudentSol{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Student> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int rollno = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String subject = sc.nextLine();
            char grade = sc.next().charAt(0);
            sc.nextLine();
            String date = sc.nextLine();
            arr.add(new Student(rollno,name,subject,grade,date));
        }
        char Sgrade = sc.next().charAt(0);
        sc.nextLine();
        int smonth = sc.nextInt();

        Vector<Student> finalans = findStudentByGradeAndMonth(arr,Sgrade,smonth);
        if(finalans.size()>0)
        {
            for(int i=0;i<finalans.size();i++)
            {
                System.out.println(finalans.get(i).getname());
                System.out.println(finalans.get(i).getsubject());
            }
            System.out.println(finalans.size());
        }
        else{
            System.out.println("No student found");
        }
    }
    public static Vector<Student> findStudentByGradeAndMonth(Vector<Student> arr,char Sgrade,int smonth)
    {
        Vector<Student> ans = new Vector<>();
        int month = 0;
        for(int i=0;i<arr.size();i++)
        {
            String str = arr.get(i).getdate();
            int j = 0;
            while(j<str.length())
            {
                if(str.charAt(j)=='/')
                {
                    int sum = 0;
                    int k = j+1;
                    while(k<str.length() && str.charAt(k)!='/')
                    {
                        int num = str.charAt(k)-'0';
                        sum = sum*10 + num;
                        k++;
                    }
                    month = sum;
                    break;
                }
                j++;
            }
            if(arr.get(i).getgrade()==Sgrade && month == smonth)
            {
                ans.add(arr.get(i));
            }
        }

        if(ans.size()<0)
        {
            return null;
        }

        for(int i=0;i<ans.size();i++)
        {
            for(int j=1;j<ans.size()-i;j++)
            {
                if(ans.get(j-1).getrollNo()>ans.get(j).getrollNo())
                {
                    Student temp = ans.get(j);
                    ans.set(j,ans.get(j-1));
                    ans.set(j-1,temp);
                }
            }
        }
        return ans;
    }
}
class Student 
{
    private int rollno;
    private String name;
    private String subject;
    private char grade;
    private String date;

    public Student(int rollno,String name,String subject,char grade,String date)
    {
        this.rollno = rollno;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }

    public int getrollNo()
    {
        return rollno;
    }

    public String getname()
    {
        return name;
    }

    public String getsubject()
    {
        return subject;
    }

    public char getgrade()
    {
        return grade;
    }

    public String getdate()
    {
        return date;
    }
}