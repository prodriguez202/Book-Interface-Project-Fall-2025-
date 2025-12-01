import java.io.*;
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
        for(Book book : books) {
            totalCost += book.getCost();
        }
        return totalCost;
    }

    public static void saveBookToFile(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("booklist.txt", true))) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getCost());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("booklist.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String title = parts[0];
                    String author = parts[1];
                    String genre = parts[2];
                    int cost = Integer.parseInt(parts[3]);
                    int numPages = Integer.parseInt(parts[4]);
                    new Printedbook(title, author, genre, cost, numPages);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static int actualTotalCost() {
        int totalCost = 0;
        for(Book book : books) {
            totalCost += book.getCost();
        }
        return totalCost;
    }

    @Override
    public int getNumOfBooks(String genre) {
        int count = 0;
        for (int i = 0; i < books.size()/2; i++) {
            if (books.get(i).getGenre().equalsIgnoreCase(genre)) {
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
