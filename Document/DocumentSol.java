import java.util.*;
public class DocumentSol
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Document> arr = new Vector<>();
        for(int i=0;i<4;i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String folderName = sc.nextLine();
            int pages = sc.nextInt();
            arr.add(new Document(id,title,folderName,pages));
        }

        Vector<Document> ans = docsWithOddPages(arr);
        if(ans==null)
        {
            System.out.println("None");
        }
        else
        {
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i).getId()+" "+ans.get(i).gettitle()+" "+ans.get(i).getfolderName()+" "+ans.get(i).getpages());
            }
        }
        
    }
        public static Vector<Document> docsWithOddPages(Vector<Document> arr)
        {
            Vector<Document> ans = new Vector<>();
            for(int i=0;i<arr.size();i++)
            {
                if((arr.get(i).getpages()%2!=0))
                {
                    ans.add(arr.get(i));
                }
            }

            for(int i=0;i<ans.size();i++)
            {
                for(int j=1;j<ans.size();j++)
                {
                    if(ans.get(j-1).getId() > ans.get(j).getId())
                    {
                        Document temp = ans.get(j-1);
                        ans.set(j-1,ans.get(j));
                        ans.set(j,temp);
                    }
                }
            }
            return ans;
        }
}
class Document
{
    private int id;
    private String title;
    private String folderName;
    private int pages;

    public Document(int id,String title,String folderName,int pages)
    {
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }

    public int getId()
    {
        return id;
    }

    public String gettitle()
    {
        return title;
    }

    public String getfolderName()
    {
        return folderName;
    }

    public int getpages()
    {
        return pages;
    }
}