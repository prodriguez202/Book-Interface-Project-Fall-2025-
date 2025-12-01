import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Inheritance -> inherits from book
// Polymorphism -> overrides from book class
// Encapsulation -> private instance variable accessed w/ getters & setters

public class Printedbook extends Book implements BookInterface {
    private int numPages;

    protected static ArrayList<Printedbook> printedbooks = new ArrayList<>();

    public Printedbook(String title, String author, String genre, int cost, int numPages) {
        super(title, author, genre, cost);
        this.numPages = numPages;
        printedbooks.add(this);
    }

    @Override
    public int getCost() {
        return numPages * 10;
    }

    public int getNumPages() {
        return numPages;
    }

    public static double calculateAvgPages() {
        if (printedbooks.isEmpty()) {
            return 0;
        }
        int pages = 0;
        for (int i = 0; i < printedbooks.size(); i++) {
            pages = pages + printedbooks.get(i).getNumPages();
        }
        return (double) pages / printedbooks.size();
    }

    public static void displayPrintedBooks() {
        for (int i = 0; i < printedbooks.size()/2; i++) {
            System.out.println("-> " + printedbooks.get(i).getTitle());
        }
    }

    public static void displayPrintedBooksLabel() {
        for (int i = 0; i < printedbooks.size()/2; i++) {
            System.out.println("-> " + printedbooks.get(i).getTitle() + " (Printed)");
        }
    }

    public static int printTotalCost() {
        int pTotalCost = 0;
        for(int i = 0; i < printedbooks.size(); i++) {
            pTotalCost = pTotalCost + printedbooks.get(i).getCost();
        }
        return pTotalCost/2;
    }

    public static void saveBookToFile(Printedbook book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("printed.txt", true))) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getCost() + "," + book.getNumPages());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("printed.txt"))) {
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

    public void lastThree() {
        System.out.println("Last 3 Printed Books:");
        int start = Math.max(printedbooks.size() - 3, 0);
        for (int i = start; i < printedbooks.size(); i++) {
            System.out.println("-> " + printedbooks.get(i).getTitle());
        }
    }

    @Override
    public List<String> allBooks() {
        return List.of();
    }
}
