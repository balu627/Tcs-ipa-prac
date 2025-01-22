import java.util.*;
public class InventorySol{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Inventory> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int inventoryId = sc.nextInt();
            int maximumQuantity = sc.nextInt();
            int currentQuantity = sc.nextInt();
            int threshold = sc.nextInt();
            arr.add(new Inventory(inventoryId,maximumQuantity,currentQuantity,threshold));
        }
        int limit = sc.nextInt();

        Vector<Inventory> ans = Replenish(arr,limit);
        if(ans.size()==0)
        {
            System.out.println("none");
        }
        else
        {
            for(int i=0;i<ans.size();i++)
            {
                if(ans.get(i).getthreshold()>75)
                {
                    System.out.println(ans.get(i).getinventoryId()+" Critical Filling");
                }
                else if(ans.get(i).getthreshold()<=75 && ans.get(i).getthreshold()>=50)
                {
                    System.out.println(ans.get(i).getinventoryId()+" Moderate Filling");
                }
                else
                {
                    System.out.println(ans.get(i).getinventoryId()+" Non Critical Filling");
                }
            }
        }
    }
    public static Vector<Inventory>  Replenish(Vector<Inventory> arr,int limit)
    {
        Vector<Inventory> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(limit>=arr.get(i).getthreshold())
            {
                ans.add(arr.get(i));
            }
        }
        return ans;
    }
}

class Inventory
{
    private int inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public Inventory(int inventoryId,int maximumQuantity,int currentQuantity,int threshold)
    {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    public int getinventoryId()
    {
        return inventoryId;
    }

    public int getmaximumQuantity()
    {
        return maximumQuantity;
    }

    public int getcurrentQuantity()
    {
        return currentQuantity;
    }

    public int getthreshold()
    {
        return threshold;
    }
}