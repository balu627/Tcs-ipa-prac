import java.util.*;
public class Character_odd_place{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = "";
        for(int i=0;i<str.length();i++)
        {
            if(i%2!=0)
            {
                ans+=str.charAt(i);
            }
        }
        System.out.println(ans);
    }
}