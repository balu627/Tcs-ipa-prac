import java.util.*;
public class FruitsSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Fruits> arr = new Vector<>();
        for(int i = 0;i<4;i++)
        {
            int fruitId = sc.nextInt();
            sc.nextLine();
            String fruitName = sc.nextLine();
            int price = sc.nextInt();
            int rating = sc.nextInt();
            arr.add(new Fruits(fruitId,fruitName,price,rating));
        }
        int Srating = sc.nextInt();


        Fruits ans  = findMaximumPriceByRating(arr,Srating);
        if(ans==null)
        {
            System.out.println("No such Fruit");
        }
        else
        {
            System.out.println(ans.getfruitId());
        }
    }
    public static Fruits findMaximumPriceByRating(Vector<Fruits> arr,int Srating)
    {
        Fruits max = null;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getRating()>Srating && (max==null || arr.get(i).getPrice() > max.getPrice()))
            {
                max = arr.get(i);
            }
        }
        return max;
    }
}

class Fruits
{
    private int  fruitId;
    private String fruitName;
    private int price;
    private int rating;

    public Fruits(int fruitId,String fruitName,int price,int rating)
    {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.rating = rating;
    }

    public int getfruitId()
    {
        return fruitId;
    }

    public String getfruitName()
    {
        return fruitName;
    }

    public int getPrice()
    {
        return price;
    }

    public int getRating()
    {
        return rating;
    }
}