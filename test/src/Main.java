import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello!");
//        test1(sc);
        System.out.println(test2(sc));
//        test3(sc);
//        System.out.println(test4(sc));
//        test5(sc);
//        test6(sc);
        System.out.println("Goodbye.");
    }

    //Do while loop with a nested do while loop, doesn't have a return value
    private static void test1(Scanner sc) {
        do {
            int input;
            System.out.println("Beginning of the method.");
            do {
                System.out.println("Insert a number:");
                input = sc.nextInt();
                if (input == 18) {
                    return;  // stops the method
                }
                if (input == 13) {
                    break; // doesn't go further, stops the inner loop and goes back to the main loop
                }

                if (input == 15) {
                    continue; // doesn't go further, checks the condition of the while in the do while loop and if it fails it goes back to the main loop
                }

                // prints only if none of the if conditions were met
                // prints only once if the condition of the while in the do while loop wasn't met, otherwise prints every time the condition is met
                System.out.println("Text within the inner loop.");
            } while (input == 5);
            System.out.println("End of the inner loop.");
            System.out.println("Would you like to go again? (y/n)");
            String repeat = sc.next();
            if (repeat.equals("n")) {
                break;
            }
        } while (true);
    }

    //Do while loop with a nested do while loop, has a return value
    private static String test2(Scanner sc) {
        do {
            int input;
            System.out.println("Beginning of the method.");
            do {
                System.out.println("Insert a number:");
                input = sc.nextInt();
                if (input == 18) {
                    return "Stopping the method from within the nested loop."; // stops the method and returns a value
                }
                if (input == 13) {
                    break;
                }

                if (input == 15) {
                    continue;
                }

                System.out.println("Text within the inner loop.");
            } while (input == 5);
            System.out.println("End of the inner loop.");
            System.out.println("Would you like to go again? (y/n)");
            String repeat = sc.next();
            if (repeat.equals("n")) {
                return "Stopping the method from within the main loop.";
            }
        } while (true);
    }

    //Do while loop, doesn't have a return value
    private static void test3(Scanner sc) {
        int input;
        System.out.println("Beginning of the method.");
        do {
            System.out.println("Insert a number");
            input = sc.nextInt();
            if (input == 18) {
                return;
            }
            if (input == 13) {
                break;
            }

            if (input == 15) {
                continue;
            }

            System.out.println("Text within the loop.");
        } while (input == 5);
        System.out.println("End of the loop.");
    }

    //Do while loop, has a return value
    private static String test4(Scanner sc) {
        int input;
        System.out.println("Beginning of the method.");
        do {
            System.out.println("Insert a number:");
            input = sc.nextInt();
            if (input == 18) {
                return "Stopping the method from within the loop.";
            }
            if (input == 13) {
                break;
            }

            if (input == 15) {
                continue;
            }

            System.out.println("Text within the loop");
        } while (input == 5);
        System.out.println("End of the loop.");
        return "Stopping the method from outside the loop.";
    }

    //For loop with an example of what happens when the loop "breaks" or "continues"
    private static void test5(Scanner sc) {
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number:");
            int number = sc.nextInt();

            if (number == 13) {
                break;
            }

            if (number == 15) {
                continue;
            }

            System.out.println("You've entered: " + number);
        }
    }

    //While loop with a switch to display what happens when it "breaks" or "continues"
    private static void test6(Scanner sc) {
        while (true) {
            System.out.print("Enter a number (1-3), 0 to quit, 9 to skip:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You chose option 1.");
                    break; // exits switch, not the while loop

                case 2:
                    System.out.println("You chose option 2.");
                    break; // exits switch, not the while loop

                case 3:
                    System.out.println("You chose option 3.");
                    break; // exits switch, not the while loop

                case 0:
                    System.out.println("Exiting the program.");
                    return; // exits the whole method

                case 9:
                    System.out.println("Skipping the rest of the loop...");
                    continue; // skips rest of loop body, goes to next loop iteration

                default:
                    System.out.println("Invalid option.");
            }

            System.out.println("End of current iteration.\n");
        }
    }
}