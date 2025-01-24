import java.util.*;

public class StudentSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Student[] ans = new Student[4];
        for(int i=0;i<4;i++)
        {
            int rollno = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String branch = sc.nextLine();
            double score  = sc.nextDouble();
            sc.nextLine();
            boolean dayScholar = sc.nextBoolean();
            ans[i] = (new Student(rollno,name,branch,score,dayScholar));
        }
        int count = findCountOfDayscholarStudents(ans);
        if(count==0)
        {
            System.out.println ("There are no such dayscholar students");
        }
        else
        {
            System.out.println(count);  
        }

        Student ansf = findStudentwithSecondHighestScore(ans);
        if(ansf==null)
        {
            System.out.println("There are no student from non day scholar");
        }
        else{
            System.out.println(ansf.getrollNo()+"#"+ansf.getName()+"#"+ansf.getScore());
        }
    }
    public static int findCountOfDayscholarStudents(Student[] arr)
    {
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].getScore()>80 && arr[i].getdayScholar())
            {
                count++;
            }
        }
        return count;
    }

    public static Student findStudentwithSecondHighestScore(Student[] arr)
    {
        Student smaxi = null;
        Student maxi = null;
        for(int i=0;i<arr.length;i++)
        {
            if((!arr[i].getdayScholar()))
            {
                if(maxi==null ||(arr[i].getScore()>maxi.getScore()))
                {
                    smaxi = maxi;
                    maxi = arr[i];
                }
                else if(smaxi == null ||(arr[i].getScore()<maxi.getScore() && arr[i].getScore()>smaxi.getScore()))
                {
                    smaxi = arr[i];
                }
            }
        }
        return smaxi;
    }
}

class Student
{
    private int rollno;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

    public Student(int rollno,String name,String branch,double score,boolean dayScholar)
    {
        this.rollno = rollno;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

    public int getrollNo()
    {
        return rollno;
    }

    public String getName()
    {
        return name;
    }

    public String getbranch()
    {
        return branch;
    }

    public double getScore()
    {
        return score;
    }

    public boolean getdayScholar()
    {
        return dayScholar;
    }
}