import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SportsTimeTracker tracker = new SportsTimeTracker();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Weekly Sports Time Tracker");
            System.out.println("--------------------------");
            System.out.println("1. Log a sports activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (option) {
                case 1:
                    logActivity(tracker, scanner);
                    break;
                case 2:
                    viewActivities(tracker);
                    break;
                case 3:
                    calculateTotalTime(tracker);
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void logActivity(SportsTimeTracker tracker, Scanner scanner) {
        System.out.print("Enter the name of the activity: ");
        String activity = scanner.nextLine();
        System.out.print("Enter time spent (in minutes): ");
        int time = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        try {
            tracker.logActivity(activity, time);
            System.out.println("Activity logged successfully!\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewActivities(SportsTimeTracker tracker) {
        System.out.println("\nLogged Activities:");
        if (tracker.viewActivities().isEmpty()) {
            System.out.println("No activities logged yet.\n");
        } else {
            tracker.viewActivities().forEach((activity, time) ->
                    System.out.println(activity + ": " + time + " minutes")
            );
            System.out.println();
        }
    }

    private static void calculateTotalTime(SportsTimeTracker tracker) {
        int totalTime = tracker.calculateTotalTime();
        System.out.println("\nTotal time spent on sports: " + totalTime + " minutes\n");
    }
}
