package pokemonhotel;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Aldana
 * @author Fabricio
 * @author Fermin
 *
 */
public class Menu {

    //To give format to the programme
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BLACK_BOLD = "\033[1;30m";

    int choice;

    public Menu() {
    }

    public void MyMenu(Accomodation acc) throws IOException {
        MenuSetUp mSu = new MenuSetUp();
        Scanner nScan = new Scanner(System.in);
        int choice = -1;

        System.out.println("\n\n\u001B[36m============================================================\n\n");
        System.out.println("\u001B[35m                  Welcome to POKEMON HOTEL");
        System.out.println("\n\n\u001B[36m============================================================");
        System.out.println("\nMAIN MENU");
        System.out.println("\nSELECT ONE OF THE OPTIONS BELOW:");
        System.out.println("\n(1) Pokemon group seeking rooms");
        System.out.println("(2) Pokemon group your hotel can accommodate ");
        System.out.println("(3) Pokemon group your hotel cannot accommodate");
        System.out.println("(4) Pokemon Assistant Assigned ");
        System.out.println("(5) Pokemon Assistant No Assigned ");
        System.out.println("(6) Rooms occupied");
        System.out.println("(7) Personal assistants and assigned Pokemon");
        System.out.println("(8) Choose a Room");
        System.out.println("(9) Search a particular Generic Stamp");

        System.out.println("(10) Quit");

        do {
            choice = nScan.nextInt();
            switch (choice) {
                case 1: {
                    mSu.case1();
                    MyMenu(acc);
                    break;
                }
                case 2: {
                    mSu.case2();
                    MyMenu(acc);
                    break;
                }
                case 3: {
                    mSu.case3();
                    MyMenu(acc);
                    break;
                }
                case 4: {
                    mSu.case4();
                    MyMenu(acc);
                    break;
                }
                case 5: {
                    mSu.case5();
                    MyMenu(acc);
                    break;
                }
                case 6: {
                    mSu.case5();
                    MyMenu(acc);
                    break;
                }
                case 7: {
                    mSu.case7(acc);
                    MyMenu(acc);
                    break;
                }
                case 8: {
                    mSu.case8(acc);
                    MyMenu(acc);
                    break;
                }
                case 9: {
                    mSu.case9(acc);
                    MyMenu(acc);
                    break;
                }
                case 10: {
                    mSu.turnDown();
                    break;
                }
                default: {
                    mSu.error();
                    MyMenu(acc);
                    break;
                }
            }// end of switch

        } while (choice != 7); // end of loop do-while
    }
}
