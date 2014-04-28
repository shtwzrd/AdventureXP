package edu.kea.adventureXP.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ActivityControllerTest {
  
  @Test
  public void activityControllerBasicUsageTest() {
    Activity activity = new Activity("Dwarf Toss", "Fun", 200.0, true);
    ActivityController.addActivity(activity);
    
    List<Activity> list = ActivityController.selectAllFromActivity();
    for (Activity a : list)
      System.out.println(a.getName());
    
    Activity returned = ActivityController.selectFromActivity(activity.getName());
    
    assertEquals(activity.getName(), returned.getName());
    
  }
  
  @Test
  public void removeActivityControllerTest() {
    
  }
  
  public void scheduledActivityControllerBasicUsageTest() {
    Activity activity = new Activity("Dwarf Toss", "Not fun", 400.0, true);
    ActivityController.addActivity(activity);
    
    List<Activity> list = ActivityController.selectAllFromActivity();
    for (Activity a : list)
      System.out.println(a.getName());
    
    Activity returned = ActivityController.selectFromActivity(activity.getName());
    
    assertEquals(activity.getName(), returned.getName());
    
  }
  
}
