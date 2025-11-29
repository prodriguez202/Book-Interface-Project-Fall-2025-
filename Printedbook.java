import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Printedbook extends Book implements BookInterface {
    private int numPages;

    private static ArrayList<Printedbook> printedbooks = new ArrayList<>();

    public Printedbook(String title, String author, String genre, int cost, int numPages) {
        super(title, author, genre, cost);
        this.numPages = numPages;
        printedbooks.add(this);
    }

    @Override
    public int getTotalCost() {
        return numPages * 10;
    }

    public int getNumPages() {
        return numPages;
    }

    public static double calculateAvgPages() {
        if (printedbooks.isEmpty()) {
            return 0;
        }
        int totalPages = 0;
        for (Printedbook book : printedbooks) {
            totalPages += book.numPages;
        }
        return (double) totalPages / printedbooks.size();
    }

    public static void displayPrintedBooks() {
        System.out.println("Printed Books:");
        for (Printedbook book : printedbooks) {
            System.out.println("-> " + book.getTitle() + " (" + book.numPages + " pages)");
        }


    }

    public static void saveBookToFile(Printedbook book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("booklist.txt", true))) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getCost() + "," + book.getNumPages());
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

    @Override
    public List<String> allBooks() {
        return List.of();
    }
}
