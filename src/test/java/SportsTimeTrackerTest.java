import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SportsTimeTrackerTest {

    private SportsTimeTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new SportsTimeTracker();
    }

    // Test logging a valid activity
    @Test
    void testLogActivityValid() {
        tracker.logActivity("Football", 60);
        HashMap<String, Integer> activities = tracker.viewActivities();
        assertEquals(60, activities.get("Football"));
    }

    // Test logging multiple activities
    @Test
    void testLogMultipleActivities() {
        tracker.logActivity("Football", 60);
        tracker.logActivity("Running", 30);
        HashMap<String, Integer> activities = tracker.viewActivities();
        assertEquals(60, activities.get("Football"));
        assertEquals(30, activities.get("Running"));
    }

    // Test invalid activity logging: empty name
    @Test
    void testLogActivityInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tracker.logActivity("", 45);
        });
        assertEquals("Activity or time is invalid", exception.getMessage());
    }

    // Test invalid activity logging: null name
    @Test
    void testLogActivityNullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tracker.logActivity(null, 45);
        });
        assertEquals("Activity or time is invalid", exception.getMessage());
    }

    // Test invalid activity logging: zero time
    @Test
    void testLogActivityZeroTime() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tracker.logActivity("Tennis", 0);
        });
        assertEquals("Activity or time is invalid", exception.getMessage());
    }

    // Test invalid activity logging: negative time
    @Test
    void testLogActivityNegativeTime() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tracker.logActivity("Tennis", -30);
        });
        assertEquals("Activity or time is invalid", exception.getMessage());
    }

    // Test viewing activities
    @Test
    void testViewActivities() {
        tracker.logActivity("Football", 60);
        tracker.logActivity("Running", 30);
        HashMap<String, Integer> activities = tracker.viewActivities();
        assertEquals(2, activities.size());
        assertTrue(activities.containsKey("Football"));
        assertTrue(activities.containsKey("Running"));
    }

    // Test calculating total time for a single activity
    @Test
    void testCalculateTotalTimeSingleActivity() {
        tracker.logActivity("Football", 90);
        int totalTime = tracker.calculateTotalTime();
        assertEquals(90, totalTime);
    }

    // Test calculating total time for multiple activities
    @Test
    void testCalculateTotalTimeMultipleActivities() {
        tracker.logActivity("Football", 60);
        tracker.logActivity("Running", 30);
        int totalTime = tracker.calculateTotalTime();
        assertEquals(90, totalTime);
    }

    // Test calculating total time with no activities logged
    @Test
    void testCalculateTotalTimeNoActivities() {
        int totalTime = tracker.calculateTotalTime();
        assertEquals(0, totalTime);
    }
}
