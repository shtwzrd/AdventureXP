package edu.kea.adventureXP;

import java.util.ArrayList;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.presenter.ActivityViewerPresenter;
import edu.kea.adventureXP.view.ActivityViewerUI;

public class Run {
  
  public static void main(String[] args) {
    // ManageActivityUI maUI = new ManageActivityUI();
    // ManageActivityPresenter maPresenter = new ManageActivityPresenter(maUI);
    ActivityViewerUI avUI = new ActivityViewerUI();
    ActivityViewerPresenter avPresenter = new ActivityViewerPresenter(avUI);
    String[] dd = { "ID", "Name", "Price" };
    avUI.setDropDownOptions(dd);
    
    Activity a1 = new Activity("Paintball", "Paintball is funz", 100);
    Activity a2 = new Activity("Dwarf Throwing", "Dwarf Throwing is badz", 5000);
    ArrayList<Activity> activityList = new ArrayList<>();
    activityList.add(a1);
    activityList.add(a2);
    avPresenter.setActivityList(activityList);
    avPresenter.updateUI();
  }
}
