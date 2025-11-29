import java.util.List;

public interface BookInterface {

    List <String> allBooks();

    default void lastSix(){
        List<String> books = allBooks();
        System.out.print("""
                =======================
                    Last Six Books
                =======================
                """);

        int start = Math.max(books.size() - 6, 0);

        for (int i = start; i < books.size(); i++) {
            System.out.println("-> " + books.get(i));
        }
        System.out.println("-----------------------");
    }

    int getNumOfBooks(String genre);

    int getTotalCost();

}
