package vehicles;

import org.apache.log4j.Logger;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private int choice;
    private String[] options;
    Scanner sc;
    Logger log;

    public Menu() {
        sc = new Scanner(System.in);
        log = Logger.getLogger(Menu.class);
        ConsoleAppender ca = new ConsoleAppender();
        ca.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"));
        ca.activateOptions();
        Logger.getRootLogger().addAppender(ca);

        options = new String[] {"Cars", "Boats", "Planes",
                                "Bicycles", "All vehicles", "EXIT"};

        choice = 0;


        System.out.println("--------SpeedRanker--------");
    }

    public int get_choice() {
        System.out.println("\nChoose the ranking: \n");
        for(int opt = 0; opt < options.length; opt++) {
            System.out.printf("%d. %s\n", opt+1, options[opt]);
        }
        try {
            choice = sc.nextInt();
            log.info("Chosen menu option: " + options[choice-1]);
        }
        catch (InputMismatchException e) {
            log.error("Invalid data type.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            log.error("Not a valid menu option.");
        }

        sc.nextLine();
        return choice;
    }

}
