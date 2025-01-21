import java.util.*;
public class FlowersSol
{
    public static void main(String[] args)
    {
         Scanner sc = new Scanner(System.in);
        Vector<Flowers> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int flowerId = sc.nextInt();
            sc.nextLine();
            String flowerName = sc.nextLine();
            int price = sc.nextInt();
            int rating = sc.nextInt();
            sc.nextLine();
            String type = sc.nextLine();
            arr.add(new Flowers(flowerId,flowerName,price,rating,type));
        }
        
        String sType = sc.nextLine();
        
        Flowers ans = findMinPriceByType(arr,sType);
        if(ans!=null)
        {
            System.out.println(ans.getflowerId());
        }
        else
        {
            System.out.println("There is no flower with given type");
        }
    }


    public static Flowers findMinPriceByType(Vector<Flowers> arr, String sType)
    {
        Flowers ans = null;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).gettype().equalsIgnoreCase(sType) && arr.get(i).getrating()>3)
            {
                if(ans==null || ans.getPrice()>arr.get(i).getPrice())
                {
                    ans = arr.get(i);
                }
            }
        }
        return ans;
    }
}

class Flowers
{
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;

    public Flowers(int flowerId, String flowerName,int price,int rating,String type)
    {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.rating  = rating;
        this.type = type;
    }

    public int getflowerId()
    {
        return flowerId;
    }

    public String getflowerName()
    {
        return flowerName;
    }

    public int getPrice()
    {
        return price;
    }

    public int getrating()
    {
        return rating;
    }
    
    public String gettype()
    {
        return type;
    }
}