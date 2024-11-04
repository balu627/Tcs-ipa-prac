import java.util.*;
public class courseProgram
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        Vector<Course> arr = new Vector<>();
        while (true){
            if (sc.hasNextInt())
            {
                int id = sc.nextInt();
                sc.nextLine();
                String Name = sc.nextLine();
                String Admin = sc.nextLine();
                int quiz = sc.nextInt();
                sc.nextLine();
                int handson = sc.nextInt();
                sc.nextLine();
                arr.add(new Course(id,Name,Admin,quiz,handson));
            }
            else{
                break;
            }
        }
        String sAdmin = sc.nextLine();
        int handsonLimit = sc.nextInt();

        int avgofquiz = findAvgOfQuizByAdmin(arr,sAdmin);
        if(avgofquiz==0)
        {
            System.out.println("No Course found");
        }
        else{
            System.out.println(avgofquiz);
        }

        Vector<Course> ans = sortCourseByHandsOn(arr,handsonLimit);
        if(ans==null)
        {
            System.out.println("No Course found with mentioned attributes");
        }
        else{
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getCourseName());
            }
        }
    }

    public static int findAvgOfQuizByAdmin(Vector<Course> arr,String sAdmin)
    {
        int sum =0;
        int count =0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getCourseAdmin().equalsIgnoreCase(sAdmin))
            {
                sum += arr.get(i).getCourseQuiz();
                count++;
            }
        }
        if(count==0)
        {
            return 0;
        }
        int avg = (sum/count);
        return avg;
    }

    public static Vector<Course> sortCourseByHandsOn(Vector<Course> arr,int handsonLimit)
    {
        Vector<Course> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getCourseHandson()< handsonLimit)
            {
                ans.add(arr.get(i));
            }
        }

        if( ans.size()>1)
        {
            for(int i=1;i<ans.size();i++)
            {
                for(int j=i;j<ans.size();j++)
                {
                    if(ans.get(j-1).getCourseHandson()>ans.get(j).getCourseHandson())
                    {
                        Course temp = ans.get(j-1);
                        ans.set(j-1,ans.get(j));
                        ans.set(j,temp);
                    }
                }
            }
        }
        if(ans.size()==0)
        {
            return null;
        }
        return ans;
    }
}

class Course
{
    private int CourseId;
    private String CourseName;
    private String CourseAdmin;
    private int quiz;
    private int handson;

    public Course(int CourseId,String CourseName,String CourseAdmin,int quiz,int handson)
    {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        this.CourseAdmin = CourseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }

    public int getCourseId()
    {
        return CourseId;
    }

    public void setCourseId(int CourseId)
    {
        this.CourseId = CourseId;
    }

    public String getCourseName()
    {
        return CourseName;
    }

    public void setCourseName(String CourseName)
    {
        this.CourseName = CourseName;
    }

    public String getCourseAdmin()
    {
        return CourseAdmin;
    }

    public void setCourseAdmin(String CourseAdmin)
    {
        this.CourseAdmin = CourseAdmin;
    }

    public int getCourseQuiz()
    {
        return quiz;
    }

    public void setCourseQuiz(int quiz)
    {
        this.quiz = quiz;
    }

    public int getCourseHandson()
    {
        return handson;
    }

    public void setCourseHandson(int handson)
    {
        this.handson = handson;
    }
}