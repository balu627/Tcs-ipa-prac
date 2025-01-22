import java.util.*;
public class InstitutionSol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Institution> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int institutionId = sc.nextInt();
            sc.nextLine();
            String institutionName = sc.nextLine();
            int noOfStudentsPlaced = sc.nextInt();
            sc.nextLine();
            int noOfStudentsCleared = sc.nextInt();
            sc.nextLine();
            String location = sc.nextLine();
            arr.add(new Institution(institutionId,institutionName,noOfStudentsPlaced,noOfStudentsCleared,location));
        }
        String Slocation = sc.nextLine();
        String SinstitutionName = sc.nextLine();
        int ans = FindNumClearancedByLoc(arr,Slocation);
        if(ans==0)
        {
            System.out.println("There are no cleared students in this particular location");
        }
        else
        {
            System.out.println(ans);
        }

        Institution res = UpdateInstitutionGrade(arr,SinstitutionName);
        if(res==null)
        {
            System.out.println("No Institute is available with the specified name");
        }
        else
        {
            System.out.println(res.getinstitutionName()+"::"+res.getgrade());
        }

    }
    public static int FindNumClearancedByLoc(Vector<Institution> arr,String Slocation)
    {
        int sum = 0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getlocation().equals(Slocation))
            {
                sum+=arr.get(i).getnoOfStudentsCleared();
            }
        }
        return sum;
    }

    public static Institution UpdateInstitutionGrade(Vector<Institution> arr,String SinstitutionName)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getinstitutionName().equals(SinstitutionName))
            {
                int rating = (arr.get(i).getnoOfStudentsPlaced()*100)/arr.get(i).getnoOfStudentsCleared();
                if(rating >= 80)
                {
                    arr.get(i).setgrade("A");
                }
                else{
                    arr.get(i).setgrade("B");
                }
                return arr.get(i);
            }
        }
        return null;

    }
}

class Institution
{
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    public Institution(int institutionId,String institutionName,int noOfStudentsPlaced,int noOfStudentsCleared,String location)
    {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
        this.grade = "";
    }

    public int getinstitutionId()
    {
        return institutionId;
    }

    public String getinstitutionName()
    {
        return institutionName;
    }

    public int getnoOfStudentsPlaced()
    {
        return noOfStudentsPlaced;
    }

    public int getnoOfStudentsCleared()
    {
        return noOfStudentsCleared;
    }

    public String getlocation()
    {
        return location;
    }

    public String getgrade()
    {
        return grade;
    }
    
    public void setgrade(String grade)
    {
        this.grade = grade;
    }
}
