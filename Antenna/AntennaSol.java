import java.util.*;
public class AntennaSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Antenna> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int antennaid = sc.nextInt();
            sc.nextLine();
            String antennaName = sc.nextLine();
            String projectLead = sc.nextLine();
            double antennaVSWR = sc.nextDouble();
            sc.nextLine();
            arr.add(new Antenna(antennaid,antennaName,projectLead,antennaVSWR));
        }
        String SantennaName = sc.nextLine();
        double SantennaVSWR = sc.nextDouble();

        int res = searchAntennaByName(arr,SantennaName);
        if(res!=0)
        {
            System.out.println(res);
        }
        else{
            System.out.println("There is no antenna with the given parameter");
        }

        Vector<Antenna> ans = sortAntennaByVSWR(arr,SantennaVSWR);
        if(ans.size()==0)
        {
            System.out.println("No Antenna found");
        }
        else{
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getprojectLead());
            }
        }

    }
    public static int searchAntennaByName(Vector<Antenna> arr,String SantennaName)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getantennaName().equalsIgnoreCase(SantennaName))
            {
                return arr.get(i).getantennaId();
            }
        }
        return 0;
    }

    public static Vector<Antenna> sortAntennaByVSWR(Vector<Antenna> arr,double SantennaVSWR)
    {
        for(int i=0;i<arr.size();i++)
        {
            for(int j=1;j<arr.size()-i;j++)
            {
                if(arr.get(j-1).getantennaVSWR()>arr.get(j).getantennaVSWR())
                {
                    Antenna temp = arr.get(j-1);
                    arr.set(j-1,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }

        Vector<Antenna> ans = new Vector<>();
         for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getantennaVSWR()<SantennaVSWR)
            {
                ans.add(arr.get(i));
            }
            else
            {
                break;
            }
        }
        return ans;
    }
   
}
class Antenna
{
    private int antennaid;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;

    public Antenna(int antennaid,String antennaName,String projectLead,double antennaVSWR)
    {
        this.antennaid = antennaid;
        this.antennaName = antennaName;
        this.projectLead = projectLead;
        this.antennaVSWR = antennaVSWR;
    }

    public int getantennaId()
    {
        return antennaid;
    }

    public String getantennaName()
    {
        return antennaName;
    }

    public String getprojectLead()
    {
        return projectLead;
    }

    public double getantennaVSWR()
    {
        return antennaVSWR;
    }
}