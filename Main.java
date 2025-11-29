import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Printedbook.loadBooksFromFile();
        Audiobook.loadBooksFromFile();
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
                    while (printedFlag) {
                    int printedMenu = Integer.parseInt(scnr.nextLine());
                    switch (printedMenu) {
                        case 0 -> {
//                              0 - Add a Printed Book
                            System.out.print("Enter the book title: ");
                            String title = scnr.nextLine();
                            System.out.print("Enter the book author: ");
                            String author = scnr.nextLine();
                            System.out.print("Enter the book genre: ");
                            String genre = scnr.nextLine();
                            System.out.print("Enter the total number of pages in the book: ");
                            int numPages = scnr.nextInt();
                            scnr.nextLine();
                            int cost = numPages * 10;
                            new Printedbook(title, author, genre, cost, numPages);
                            Printedbook newBook = new Printedbook(title, author, genre, cost, numPages);
                            Printedbook.saveBookToFile(newBook);
                            System.out.println("Printed book added successfully!");
                            break;
                        }
                        case 1 -> {
//                              1 - Display the Last 3 Printed Books
                            System.out.println("Last 3 Printed Books: ");
                            System.out.println("-> The Very Hungry Caterpillar");
                            System.out.println("-> Harry Potter and the Goblet of Fire");
                            System.out.println("-> Fahrenheit 451");
                            break;
                        }
                        case 2 -> {
//                              2 - Display the Total Cost of All Printed Books
                            System.out.print("Total Cost of All Printed Books: ");
                            break;
                        }

                        case 3 -> {
//                              3 - Display the Average Page Count of All Printed Books
                            System.out.println("Average Page Count of All Printed Books in the App:");
                            break;
                        }
                        case 4 -> {
//                              4 - Display Current Printed Book List
                            System.out.println("""
                                    ===========================
                                         PRINTED BOOK LIST
                                    ===========================
                                    -> The Very Hungry Caterpillar
                                    -> Harry Potter and the Goblet of Fire
                                    -> Fahrenheit 451
                                    -> To Kill a Mockingbird
                                    -> Don Quixote
                                    -> The Giver                              
                                    ---------------------------""");
                            break;
                        }
                        case 5 -> {
//                              5 - Remove a Printed Book
                            System.out.println("Book Removed.");
                            System.out.println("Do you want to do something else? (Y/N): ");
                            char answer = scnr.next().charAt(0);
                            if ((answer == 'y') || (answer == 'Y')) {
                                printedBooksMenu();
                                printedFlag = true;
                            } else printedFlag = false;
                            break;
                        }
                        case 6 -> {
//                              6 - Back to Main Menu
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
                    while (audioFlag) {
                        int audioMenu = Integer.parseInt(scnr.nextLine());
                        switch (audioMenu) {
                            case 0 -> {
//                          0 - Add an Audiobook
                                System.out.print("Enter the book title: ");
                                String title = scnr.next();
                                System.out.print("Enter the book author: ");
                                String author = scnr.next();
                                System.out.print("Enter the book genre: ");
                                String genre = scnr.next();
                                System.out.print("Enter the total length (in seconds) for the book: ");
                                int audioLength = scnr.nextInt();
                                scnr.nextLine();
                                int cost = (audioLength / 60) * 5;
                                new Audiobook(title, author, genre, cost, audioLength);
                                Audiobook newBook = new Audiobook(title, author, genre, cost, audioLength);
                                Audiobook.saveBookToFile(newBook);
                                System.out.println("Audiobook added successfully!");
                                break;
                            }
                            case 1 -> {
//                              1 - Display the Last 3 Printed Books
                                System.out.println("Last 3 Audiobooks: ");
                                System.out.println("-> Book 1");
                                System.out.println("-> Book 2");
                                System.out.println("-> Book 3");
                                break;
                            }
                            case 2 -> {
//                              2 - Display the Total Cost of All Printed Books
                                System.out.println("Total Cost of All Audiobooks:");
                                break;
                            }
                            case 3 -> {
//                              3 - Display the Average Page Count of All Printed Books
                                System.out.println("Average Length of All Audiobooks in the App:");
                                break;
                            }
                            case 4 -> {
//                              4 - Display Current Printed Book List
                                System.out.print("""
                                        ===========================
                                              AUDIOBOOK LIST
                                        ===========================
                                        -> Book
                                        -> Book
                                        -> Book
                                        -> Book
                                        -> Book
                                        -> Book
                                        -> Book
                                        ---------------------------""");
                                break;
                            }
                            case 5 -> {
//                              5 - Remove a Printed Book
                                System.out.print("Book Removed.");
                                break;
                            }
                            case 6 -> {
//                              6 - Back to Main Menu
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
                System.out.println("Current Book List.");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                break;
                        }

                case 3 -> {
//              3 - Display the Last 6 Books
                System.out.println("Last 6 Books.");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                break;
                }

                case 4 -> {
//              4 - Display Number of Books per Genre
                System.out.println("Books per Genre.");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                break;
                }

                case 5 -> {
//              5 - Display the Total Cost of All Books
                System.out.println("Total Cost of all Printed & Audiobooks:");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                    break;
                }

                case 6 -> {
//              6 - Remove a Previously Added Book
                System.out.println("Book Removed.");
                    System.out.print("Do you want to do something else? (Y/N): ");
                    char answer = scnr.nextLine().charAt(0);
                    if (answer == 'n' || answer == 'N') {
                        menuFlag = false;
                    } else printMenu();
                    break;
                }

                case 7 -> {
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
                    6 - Remove a Previously Added Book
                    7 - Exit
                    ---------------------------
                    Enter a number for which actions you want to do: """;

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
                    5 - Remove a Printed Book
                    6 - Back to Main Menu
                    ---------------------------
                    Enter a number for which actions you want to do: """;

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
                    5 - Remove an Audiobook
                    6 - Back to Main Menu
                    ---------------------------
                    Enter a number for which actions you want to do: """;

        System.out.print(textBlock + " ");
    }
}