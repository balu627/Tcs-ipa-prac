import java.util.*;

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Library lib = new Library();
		for(int i=0;i<n;i++)
		{
		    int bookId = sc.nextInt();
		    sc.nextLine();
		    String name = sc.nextLine();
		    String author = sc.nextLine();
		    lib.addbook(new Book(bookId,name,author));
		}
		int rm = sc.nextInt();
		lib.removebook(rm);
		lib.display();
		lib.authorcountdisplay();
	} 
}
class Library{
    private ArrayList<Book> Books = new ArrayList<>();
    private HashSet<Integer> uniqueBooks = new HashSet<>();
    private HashMap<String,Integer> authorcount = new HashMap<>();
    
    public void addbook(Book tempbook)
    {
        if(!(uniqueBooks.contains(tempbook.getbookId())))
        {
            Books.add(tempbook);
            uniqueBooks.add(tempbook.getbookId());
            if(authorcount.containsKey(tempbook.getauthor()))
            {
                authorcount.put(tempbook.getauthor(),authorcount.get(tempbook.getauthor())+1);
            }
            else{
                authorcount.put(tempbook.getauthor(),1);
            }
            System.out.println("Book added:"+tempbook.gettitle());
        }
        else{
            System.out.println("Duplicate book not added:"+tempbook.gettitle());
        }
    }
    
    public void removebook(int idx)
    {
        for(int i=0;i<Books.size();i++)
        {
            if(Books.get(i).getbookId()==idx)
            {
                if(authorcount.get(Books.get(i).getauthor())>1)
                {
                    authorcount.put(Books.get(i).getauthor(),authorcount.get(Books.get(i).getauthor())-1);
                }
                else{
                    // authorcount.put(Books.get(i).getauthor(),authorcount.get(Books.get(i).getauthor())-1);
                     authorcount.remove(Books.get(i).getauthor());
                    uniqueBooks.remove(Books.get(i).getbookId());
                }
                System.out.println("Book removed:"+Books.get(i).gettitle());
                Books.remove(i);
            }
        }
    }
    
    public void display()
    {
        for(int i=0;i<Books.size();i++)
        {
            System.out.println(Books.get(i).getbookId()+" "+Books.get(i).gettitle()+" "+Books.get(i).getauthor());
        }
    }
    
    public void authorcountdisplay()
    {
        for(Map.Entry<String,Integer> e: authorcount.entrySet())
        {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
}

class Book{
    int bookId;
    String title;
    String author;
    
    public Book(int bookId,String title,String author)
    {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    
    public int getbookId()
    {
        return bookId;
    }
    
    public String gettitle()
    {
        return title;
    }
    
    public String getauthor()
    {
        return author;
    }
}