
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Audiobook extends Book implements BookInterface {

    private int audioLength; // in seconds

    protected static ArrayList<Audiobook> audiobooks = new ArrayList<>();

    public Audiobook(String title, String author, String genre, int cost, int audioLength) {
        super(title, author, genre, cost);
        this.audioLength = audioLength;
        audiobooks.add(this);
    }

    @Override
    public int getCost() {
        return (audioLength / 60) * 5;
    }

    public int getAudioLength() {
        return audioLength;
    }

    public static double calculateAvgTime() {
        if (audiobooks.isEmpty()) {
            return 0;
        }
        int totalSeconds = 0;
        for (Audiobook book : audiobooks) {
            totalSeconds += book.audioLength;
        }
        return (double) totalSeconds / audiobooks.size();
    }

    public static void displayAudiobooks() {
        System.out.println("Audiobooks:");
        for (Audiobook book : audiobooks) {
            System.out.println("-> " + book.getTitle() + " (" + book.audioLength + " seconds)");
        }
    }
    public static void saveBookToFile(Audiobook book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("booklist.txt", true))) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getCost() + "," + book.getAudioLength());
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

