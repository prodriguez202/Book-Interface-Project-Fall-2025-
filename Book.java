import java.util.ArrayList;
import java.util.List;

abstract public class Book implements BookInterface {
    protected String title;
    protected String author;
    protected String genre;
    protected int cost;
    protected static List<Book> books = new ArrayList<>();

    public Book(String title, String author, String genre, int cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        books.add(this);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }


    public int getCost() {
        return cost;
    }

    @Override
    public int getTotalCost() {
        int totalCost = 0;
        for (Book book : books) {
            totalCost += book.getCost();
        }
        return totalCost;
    }


    @Override
    public int getNumOfBooks(String genre) {
        int count = 0;
        for (Book book : books) {
            if (book.genre.equalsIgnoreCase(genre)) {
                count++;
            }
        }
        return count;
    }

    public void lastSix() {
        System.out.println("Last 6 Books:");
        int start = Math.max(books.size() - 6, 0);
        for (int i = start; i < books.size(); i++) {
            System.out.println("-> " + books.get(i).getTitle());
        }
    }
}
