import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Inheritance -> inherits from book
// Polymorphism -> overrides from book class
// Encapsulation -> private instance variable accessed w/ getters & setters

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
        for (int i = 0; i < audiobooks.size()/2; i++) {
            System.out.println("-> " + audiobooks.get(i).getTitle());
        }
    }

    public static void displayAudiobooksLabel() {
        for (int i = 0; i < audiobooks.size()/2; i++) {
            System.out.println("-> " + audiobooks.get(i).getTitle() + " (Audio)");
        }
    }

    public static void saveBookToFile(Audiobook book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("audio.txt", true))) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getCost() + "," + book.getAudioLength());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("audio.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String title = parts[0];
                    String author = parts[1];
                    String genre = parts[2];
                    int cost = Integer.parseInt(parts[3]);
                    int audioLength = Integer.parseInt(parts[4]);
                    new Audiobook(title, author, genre, cost, audioLength);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void lastThree() {
        System.out.println("Last 3 Audiobooks:");
        int start = Math.max(audiobooks.size() - 3, 0);
        for (int i = start; i < audiobooks.size(); i++) {
            System.out.println("-> " + audiobooks.get(i).getTitle());
        }
    }

    @Override
    public List<String> allBooks() {
        return List.of();
    }

    public static int printTotalCost() {
        int pTotalCost = 0;
        for (int i = 0; i < audiobooks.size(); i++) {
            pTotalCost = pTotalCost + audiobooks.get(i).getCost();
        }
        return pTotalCost / 2;

    }
}

