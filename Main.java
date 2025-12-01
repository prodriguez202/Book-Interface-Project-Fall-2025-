import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Printedbook.loadBooksFromFile();
        Audiobook.loadBooksFromFile();
        Book.loadBooksFromFile();

        Scanner scnr = new Scanner(System.in);

        boolean menuFlag = true;
        printMenu();
        while (menuFlag) {
            int mainMenu = Integer.parseInt(scnr.nextLine());
            switch (mainMenu) {
                case 0 -> {
//                0 - View Printed Book Options
                    boolean printedFlag = true;
                    printedBooksMenu();
                    Printedbook.loadBooksFromFile();
                    while (printedFlag) {
                    int printedMenu = Integer.parseInt(scnr.nextLine());
                        switch (printedMenu) {
                            case 0 -> {
//                          0 - Add a Printed Book
                            System.out.print("Enter the book title: ");
                            String title = scnr.nextLine();
                            System.out.print("Enter the book author: ");
                            String author = scnr.nextLine();
                            System.out.print("Enter the book genre: ");
                            String genre = scnr.nextLine();
                            System.out.print("Enter the total number of pages in the book: ");
                            int numPages = scnr.nextInt();
                            scnr.nextLine();
                            int cost = 0;
                            new Printedbook(title, author, genre, cost, numPages);
                            Printedbook newBook = new Printedbook(title, author, genre, cost, numPages);
                            Printedbook.saveBookToFile(newBook);
                            Printedbook.loadBooksFromFile();
                            Book.saveBookToFile(newBook);
                            Book.loadBooksFromFile();
                            System.out.println("Printed book added successfully!");
                            break;
                        }
                        case 1 -> {
//                          1 - Display the Last 3 Printed Books
                            if (!Printedbook.printedbooks.isEmpty())
                            {
                                Printedbook printedbookList = Printedbook.printedbooks.get(0);
                                printedbookList.lastThree();
                            }
                            else
                            {
                                System.out.println("No printed books available.");
                            }
                            System.out.println("---------------------------");
                            break;
                        }
                        case 2 -> {
//                          2 - Display the Total Cost of All Printed Books
                            System.out.print("Total Cost of All Printed Books: $");
                            System.out.println(Printedbook.printTotalCost());
                            break;
                        }

                        case 3 -> {
//                          3 - Display the Average Page Count of All Printed Books
                            System.out.print("Average Page Count of All Printed Books in the App: ");
                            System.out.println(Printedbook.calculateAvgPages());
                            break;
                        }
                        case 4 -> {
//                              4 - Display Current Printed Book List
                            System.out.println("""
                                    ===========================
                                         PRINTED BOOK LIST
                                    ===========================""");

                            if (!Printedbook.printedbooks.isEmpty())
                            {
                                Printedbook printedbookList = Printedbook.printedbooks.get(0);
                                printedbookList.displayPrintedBooks();
                            }
                            else
                            {
                                System.out.println("No printed books available.");
                            }
                                    System.out.println("---------------------------");
                            break;
                        }
                        case 5 -> {
//                          5 - Back to Main Menu
                            printedFlag = false;
                            printMenu();
                            break;
                        }
                        default -> printedFlag = false;
                    }
                        if (printedFlag) {
                            System.out.print("Do you want to do something else? (Y/N): ");
                            char answer = scnr.nextLine().charAt(0);
                            if (answer == 'n' || answer == 'N') {
                                printedFlag = false;
                                printMenu();
                            } else printedBooksMenu();;
                        }
                    }
                }
                case 1 -> {
//              1 - View Audiobook Options
                    boolean audioFlag = true;
                    audiobooksMenu();
                    Audiobook.loadBooksFromFile();
                    while (audioFlag) {
                    int audioMenu = Integer.parseInt(scnr.nextLine());
                        switch (audioMenu) {
                            case 0 -> {
//                          0 - Add an Audiobook
                                System.out.print("Enter the book title: ");
                                String title = scnr.nextLine();
                                System.out.print("Enter the book author: ");
                                String author = scnr.nextLine();
                                System.out.print("Enter the book genre: ");
                                String genre = scnr.nextLine();
                                System.out.print("Enter the total length (in seconds) for the book: ");
                                int audioLength = scnr.nextInt();
                                scnr.nextLine();
                                int cost = 0;
                                new Audiobook(title, author, genre, cost, audioLength);
                                Audiobook newBook = new Audiobook(title, author, genre, cost, audioLength);
                                Audiobook.saveBookToFile(newBook);
                                Audiobook.loadBooksFromFile();
                                Book.saveBookToFile(newBook);
                                Book.loadBooksFromFile();
                                System.out.println("Audiobook added successfully!");
                                break;
                            }
                            case 1 -> {
//                              1 - Display the Last 3 Audiobooks
                                if (!Audiobook.audiobooks.isEmpty())
                                {
                                    Audiobook audiobookList = Audiobook.audiobooks.get(0);
                                    audiobookList.lastThree();
                                }
                                else
                                {
                                    System.out.println("No audiobooks available.");
                                }
                                System.out.println("---------------------------");
                                break;
                            }
                            case 2 -> {
//                              2 - Display the Total Cost of All Audiobooks
                                System.out.print("Total Cost of All Audiobooks: $");
                                System.out.println(Audiobook.printTotalCost());
                                break;
                            }
                            case 3 -> {
//                              3 - Display the Average Length of Time of All Audiobooks
                                System.out.print("Average Length of Time of All Audiobooks in the App: ");
                                System.out.println(Audiobook.calculateAvgTime());
                                break;
                            }
                            case 4 -> {
//                              4 - Display Current Audiobook List
                                System.out.println("""
                                    ===========================
                                          AUDIOBOOK LIST
                                    ===========================""");

                                if (!Audiobook.audiobooks.isEmpty())
                                {
                                    Audiobook audiobookList = Audiobook.audiobooks.get(0);
                                    audiobookList.displayAudiobooks();
                                }
                                else
                                {
                                    System.out.println("No audiobooks available.");
                                }
                                System.out.println("---------------------------");
                                break;
                            }
                            case 5 -> {
//                              6 - Back to Main Menu
                                audioFlag = false;
                                printMenu();
                                break;
                            }
                            default -> audioFlag = false;
                        }
                        if (audioFlag) {
                            System.out.print("Do you want to do something else? (Y/N): ");
                            char answer = scnr.nextLine().charAt(0);
                            if (answer == 'n' || answer == 'N') {
                                audioFlag = false;
                                printMenu();
                            } else audiobooksMenu();
                        }

                    }
                }
                case 2 -> {
//              2 - Display Current Book List
                    System.out.println("---------------------------");
                    System.out.println("Current Book List:");
                    if (!Printedbook.printedbooks.isEmpty()) {
                        Printedbook printedbookListLabel = Printedbook.printedbooks.get(0);
                        printedbookListLabel.displayPrintedBooksLabel();
                    }
                    else {
                        System.out.println("No printed books available.");
                    }

                    if (!Audiobook.audiobooks.isEmpty()) {
                        Audiobook audiobookListLabel = Audiobook.audiobooks.get(0);
                        audiobookListLabel.displayAudiobooksLabel();
                    }
                    else {
                        System.out.println("No audiobooks available.");
                    }
                    System.out.println("---------------------------");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                break;
                        }

                case 3 -> {
//              3 - Display the Last 6 Books
                    System.out.println("---------------------------");
                    System.out.println("Last 6 Books:");
                    if (!Printedbook.printedbooks.isEmpty())
                    {
                        Printedbook printedbookList = Printedbook.printedbooks.get(0);
                        printedbookList.lastThree();
                    }
                    else
                    {
                        System.out.println("No printed books available.");
                    }
                    System.out.println("---------------------------");
                    if (!Audiobook.audiobooks.isEmpty())
                    {
                        Audiobook audiobookList = Audiobook.audiobooks.get(0);
                        audiobookList.lastThree();
                    }
                    else
                    {
                        System.out.println("No audiobooks available.");
                    }
                    System.out.println("---------------------------");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                break;
                }

                case 4 -> {
//              4 - Display Number of Books per Genre
                System.out.println("Books per Genre: ");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                break;
                }

                case 5 -> {
//              5 - Display the Total Cost of All Books
                System.out.print("Total Cost of all Printed & Audiobooks: $");
                    System.out.println(Book.actualTotalCost()/2);
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                    break;
                }

                case 6 -> {
//              7 - Exit
                    menuFlag = false;
                    break;
                }
                default -> menuFlag = false;
                    }
                }
                    System.out.println("--- Thank you! Program is shutting down! ---");
                }

    private static void printMenu(){
        //use java textBlock to print the menu options
        String textBlock = """
                    
                    ~ Welcome to the Book Application System! ~
                   
                    Please refer to the menu below and make your selection accordingly.
                    ===========================
                      BOOK APPLICATION SYSTEM
                    ===========================
                    0 - View Printed Book Options
                    1 - View Audiobook Options
                    2 - Display Current Book List
                    3 - Display the Last 6 Books
                    4 - Display Number of Books per Genre
                    5 - Display the Total Cost of All Books
                    6 - Exit
                    ---------------------------
                    Enter a number the action you want to conduct: """;

        System.out.print(textBlock + " ");
    }

    private static void printedBooksMenu() {
        //use java textBlock to print the menu options
        String textBlock = """
                    ===========================
                        PRINTED BOOK OPTIONS
                    ===========================
                    0 - Add a Printed Book
                    1 - Display the Last 3 Printed Books
                    2 - Display the Total Cost of All Printed Books
                    3 - Display the Average Page Count of All Printed Books
                    4 - Display Current Printed Book List
                    5 - Back to Main Menu
                    ---------------------------
                    Enter a number the action you want to conduct: """;

        System.out.print(textBlock + " ");
    }

    private static void audiobooksMenu() {
        //use java textBlock to print the menu options
        String textBlock = """
                    ===========================
                         AUDIOBOOK OPTIONS
                    ===========================
                    0 - Add an Audiobook
                    1 - Display the Last 3 Audiobooks
                    2 - Display the Total Cost of All Audiobooks
                    3 - Display the Average Time of All Printed Books
                    4 - Display Current Audiobook List
                    5 - Back to Main Menu
                    ---------------------------
                    Enter a number the action you want to conduct: """;

        System.out.print(textBlock + " ");
    }
}