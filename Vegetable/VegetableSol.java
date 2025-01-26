    import java.util.*;
    public class VegetableSol
    {
        public static void main(String [] args)
        {
            Scanner sc = new Scanner(System.in);
            Vegetable[] arr = new Vegetable[4];
            for(int i=0;i<arr.length;i++)
            {
                int VegetableId = sc.nextInt();
                sc.nextLine();
                String VegetableName = sc.nextLine();
                int price = sc.nextInt();
                int rating = sc.nextInt();
                arr[i] = new Vegetable(VegetableId,VegetableName,price,rating);
            }
            int Srating  = sc.nextInt();

            Vegetable ans = findMinimumPriceByRating(arr,Srating);
            if(ans==null)
            {
                System.out.println("No such Vegetables");
            }
            else
            {
                System.out.println(ans.getvegetableId());
            }
        }

        public static Vegetable findMinimumPriceByRating(Vegetable[] arr,int Srating)
        {
            Vegetable min = null;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i].getrating()>Srating && (min==null||arr[i].getprice()<min.getprice()))
                {
                    min = arr[i];
                }
            }
            return min;
        }
    }
    class Vegetable
    {
        private int VegetableId;
        private String VegetableName;
        private int price;
        private int rating;

        public Vegetable(int VegetableId,String VegetableName,int price,int rating)
        {
            this.VegetableId = VegetableId;
            this.VegetableName = VegetableName;
            this.price = price;
            this.rating = rating;
        }

        public int getvegetableId()
        {
            return VegetableId;
        }

        public String getvegetableName()
        {
            return VegetableName;
        }

        public int getprice()
        {
            return price;
        }

        public int getrating()
        {
            return rating;
        }
    }