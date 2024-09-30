import java.util.HashMap;

public class SportsTimeTracker {

    private HashMap<String, Integer> activities;
    public SportsTimeTracker() {
        activities = new HashMap<>();
    }

    public void logActivity(String activity, int time) {
        if (time <= 0 || activity == null || activity.isEmpty()) {
            throw new IllegalArgumentException("Activity or time is invalid");
        }
        activities.put(activity, activities.getOrDefault(activity, 0) + time);
    }

    public HashMap<String, Integer> viewActivities() {
        return activities;
    }

    public int calculateTotalTime() {
        return activities.values().stream().mapToInt(Integer::intValue).sum();
    }
}
