import java.util.HashMap;
import java.util.Scanner;

public class SportsTimeTracker {

    private static HashMap<String, Integer> activities = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Log a sports activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    logActivity(scanner);
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    calculateTotalTime();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void logActivity(Scanner scanner) {
        System.out.print("Enter the name of the activity: ");
        String activity = scanner.nextLine();
        System.out.print("Enter time spent (in minutes): ");
        int time = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        activities.put(activity, activities.getOrDefault(activity, 0) + time);
        System.out.println("Activity logged!");
    }

    private static void viewActivities() {
        System.out.println("Logged activities:");
        for (String activity : activities.keySet()) {
            System.out.println(activity + ": " + activities.get(activity) + " minutes");
        }
    }

    private static void calculateTotalTime() {
        int totalTime = activities.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total time spent on sports: " + totalTime + " minutes");
    }
}
