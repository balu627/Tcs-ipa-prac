import java.util.*;
public class NavalVesselSol{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<NavalVessel> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int NavalVessel = sc.nextInt();
            sc.nextLine();
            String vesselName = sc.nextLine();
            int noOfVoyagesPlanned = sc.nextInt();
            int noOfVoyagesCompleted = sc.nextInt();
            sc.nextLine();
            String purpose = sc.nextLine();
            arr.add(new NavalVessel(NavalVessel,vesselName,noOfVoyagesPlanned,noOfVoyagesCompleted,purpose));
        }
        int Spercent = sc.nextInt();
        sc.nextLine();
        String SPurpose = sc.nextLine();

        int ans = findAvgVoyagesByPct(arr,Spercent);
        System.out.println(ans);

        NavalVessel sans = findVesselByGrade(arr,SPurpose);
        if(sans!=null)
        {
            System.out.println(sans.getvesselName()+"%"+sans.getclassification());
        }
        else{
            System.out.println("No Naval Vessel is available with the specified purpose");
        }
        
    }
    public static int findAvgVoyagesByPct(Vector<NavalVessel> arr,int Spercent)
    {   int sum = 0;
        int count =0;
        for(int i=0;i<arr.size();i++)
        {
            int opercent = (arr.get(i).getnoOfVoyagesCompleted()*100)/(arr.get(i).getnoOfVoyagesPlanned());
            if(opercent>Spercent)
            {
                count++;
                sum+=arr.get(i).getnoOfVoyagesCompleted();  
            }
        }
        if(count>0)
        {
            return  sum/count;
        }
        return 0;
    }

    public static NavalVessel findVesselByGrade(Vector<NavalVessel> arr,String SPurpose)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getpurpose().equalsIgnoreCase(SPurpose))
            {
                int percent = (arr.get(i).getnoOfVoyagesCompleted()*100/arr.get(i).getnoOfVoyagesPlanned());
                if(percent==100)
                {
                    arr.get(i).setclassification("Star");
                }
                else if(percent>= 80 && percent<=99)
                {
                    arr.get(i).setclassification("Leader");
                }
                else if(percent>=55 && percent<=79)
                {
                    arr.get(i).setclassification("Inspirer");
                }
                else{
                    arr.get(i).setclassification("Striver");
                }
                return arr.get(i);
            }
        }
        return null;
    }
}
class NavalVessel{
    private int vesselld;
    private String vesselName;
    private int noOfVoyagesPlanned;
    private int noOfVoyagesCompleted;
    private String purpose;
    private String classification;

    public NavalVessel(int vesselld,String vesselName,int noOfVoyagesPlanned,int noOfVoyagesCompleted,String purpose)
    {
        this.vesselld = vesselld;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
        this.classification = "";
    }

    public int getvesselld()
    {
        return vesselld;
    }

    public String getvesselName()
    {
        return vesselName;
    }

    public int getnoOfVoyagesPlanned()
    {
        return noOfVoyagesPlanned;
    }

    public int getnoOfVoyagesCompleted()
    {
        return noOfVoyagesCompleted;
    }

    public String getpurpose()
    {
        return purpose;
    }

    public String getclassification()
    {
        return classification;
    }

    public void setclassification(String classification)
    {
        this.classification = classification;
    }
}