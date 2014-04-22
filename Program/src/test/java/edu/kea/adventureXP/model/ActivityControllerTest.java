package edu.kea.adventureXP.model;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.kea.adventureXP.model.Activity;

public class ActivityControllerTest {

  @Test
  public void activityControllerBasicUsageTest() {
    Activity activity = new Activity("Dwarf Toss", "Fun", 200.0);
    ActivityController.addActivity(activity);

     List<Activity> list = ActivityController.selectAllFromActivity();
    for(Activity a : list) {
      System.out.println(a.getName());
    } 

    Activity returned =
      ActivityController.selectFromActivity(activity.getName());



    assertEquals(activity.getName(), returned.getName());

  }
  
  @Test
  public void scheduledActivityControllerBasicUsageTest() {
    Activity ScheduledActivity = new Activity(1, );
    ActivityController.addActivity(activity);

     List<Activity> list = ActivityController.selectAllFromActivity();
    for(Activity a : list) {
      System.out.println(a.getName());
    } 

    Activity returned =
      ActivityController.selectFromActivity(activity.getName());



    assertEquals(activity.getName(), returned.getName());

  }


	@Test
	public void removeActivityControllerTest() {
  }

}
