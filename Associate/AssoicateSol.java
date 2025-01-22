import java.util.*;
public class AssoicateSol
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Associate> arr = new Vector<>();
        for(int i=0;i<5;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String technology = sc.nextLine();
            int experienceInYears = sc.nextInt();
            arr.add(new Associate(id,name,technology, experienceInYears));
        }
        sc.nextLine();
        String Stechnology = sc.nextLine();

        Vector<Associate> ans = associatesForGivenTechnology(arr,Stechnology);
        if(ans.size()==0)
        {
            System.out.println("None found");
        }
        else
        {
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getId());
            }
        }
    }
    public static Vector<Associate> associatesForGivenTechnology(Vector<Associate> arr,String Stechnology)
    {
        Vector<Associate> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getTechnology().equals(Stechnology) && arr.get(i).getExperienceInYears()%5==0)
            {
                ans.add(arr.get(i));
            }
        }
        return ans;
    }
}

class Associate
{
    private int id;
    private String name;
    private String technology;
    private int experienceInYears;

    public Associate(int id,String name,String technology,int experienceInYears)
    {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.experienceInYears = experienceInYears;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getTechnology()
    {
        return technology;
    }

    public int getExperienceInYears()
    {
        return experienceInYears;
    }
}