import java.util.*;
public class EngineSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Engine> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int engineId = sc.nextInt();
            sc.nextLine();
            String engineName = sc.nextLine();
            String engineType = sc.nextLine();
            double enginePrice = sc.nextDouble();
            sc.nextLine();
            arr.add(new Engine(engineId,engineName,engineType,enginePrice));
        }
        String SengineType = sc.nextLine();
        String SengineName = sc.nextLine();
        
        int avg = findAvgEnginePriceByType(arr,SengineType);
        if(avg==0)
        {
            System.out.println("findAvgEnginePriceByType");
        }
        else{
            System.out.println(avg);
        }

        Vector<Engine> ans = searchEngineByName(arr,SengineName);
        if(ans.size()==0)
        {
            System.out.println("There are no engine with the given name");
        }
        else{
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getengineId());
            }
        }
    }
    public static int findAvgEnginePriceByType(Vector<Engine> arr, String SengineType)
    {
        int count = 0;
        double sum = 0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getengineType().equals(SengineType))
            {
                count++;
                sum+=arr.get(i).getenginePrice();
            }
        }
        if(count!=0)
        {
            int res = ((int)sum/count);
            return res;
        }
        return 0;
    }

    public static Vector<Engine> searchEngineByName(Vector<Engine> arr,String SengineName)
    {
        Vector<Engine> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getengineName().equals(SengineName))
            {
                ans.add(arr.get(i));
            }
        }

        if(ans.size()==0)
        {
            return ans;
        }

        for(int i=0;i<ans.size();i++)
        {
            for(int j=1;j<ans.size();j++)
            {
                if(ans.get(j-1).getengineId()>ans.get(j).getengineId())
                {
                    Engine temp =  ans.get(j);
                    ans.set(j,ans.get(j-1));
                    ans.set(j-1,temp);
                }
            }
        }
        return ans;
    }
}

class Engine
{
    private int engineId;
    private String engineName;
    private String engineType;
    private double enginePrice;

    public Engine(int engineId,String engineName,String engineType,double enginePrice)
    {
        this.engineId = engineId;
        this.engineName = engineName;
        this.engineType = engineType;
        this.enginePrice = enginePrice;
    }

    public int getengineId()
    {
        return engineId;
    }

    public String getengineName()
    {
        return engineName;
    }

    public String getengineType()
    {
        return engineType;
    }

    public double getenginePrice()
    {
        return enginePrice;
    }
}