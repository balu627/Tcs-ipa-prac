import java.util.*;

public class MedicineSol{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Medicine> arr = new Vector<Medicine>();
        for(int i=0;i<4;i++)
        {
            String MedicineName = sc.nextLine();
            String batch = sc.nextLine();
            String disease = sc.nextLine();
            int price = sc.nextInt();
            arr.add(new Medicine(MedicineName,batch,disease,price));
            sc.nextLine();
        String Sdisease = sc.nextLine();
        Vector<Integer> sprice = getPriceByDisease(arr, Sdisease);
        for(int i=0;i<sprice.size();i++)
        {
            System.out.println(sprice.get(i));
        }
    }

    public static Vector<Integer> getPriceByDisease(Vector<Medicine>arr,String Sdisease)
    {
        Vector<Integer> ans = new Vector<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getDisease().equalsIgnoreCase(Sdisease))
            {
                ans.add(arr.get(i).getPrice());
            }
        }

        for(int i=1;i<ans.size();i++)
        {
            for(int j=i;j<ans.size();j++)
            {
                if(ans.get(j-1)>ans.get(j))
                {
                    int temp = ans.get(j-1);
                    ans.set(j-1,ans.get(j));
                    ans.set(j,temp);
                }
            }
        }
        return ans;
    }
}

class Medicine{
    private String MedicineName;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String MedicineName,String batch,String disease,int price)
    {
        this.MedicineName = MedicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getMedicineName()
    {
        return MedicineName;
    }

    public String getBatch()
    {
        return batch;
    }

    public String getDisease()
    {
        return disease;
    }

    public int getPrice()
    {
        return price;
    }
}
