package edu.kea.adventureXP.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import edu.kea.adventureXP.model.Activity;

/**
 * User Interface class for creating a new activity as well as edit an old
 * activity. The interface have fields for the activity's name, description and
 * price as well as buttons for saving and discarding.
 * 
 * @see Activity
 */
public class ManageActivityUI extends JFrame {
  
  /**
   * Constructor for building the User Interface. It calls the buildUI method
   * which builds the frame and the panels within.
   */
  public ManageActivityUI() {
    buildUI();
  }
  
  /**
   * Builds the frame and the panels within.
   */
  public void buildUI() {
    setTitle("Manage Activity");
    setSize(400, 400);
    setLayout(new BorderLayout());
    
    setVisible(true);
    set
  }
}
