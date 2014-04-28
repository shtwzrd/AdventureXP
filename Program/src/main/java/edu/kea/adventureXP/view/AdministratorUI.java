package edu.kea.adventureXP.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import edu.kea.adventureXP.presenter.ActivityViewerPresenter;
import edu.kea.adventureXP.presenter.EquipmentViewerPresenter;
import edu.kea.adventureXP.presenter.InstructorViewerPresenter;

/**
 * Main User Interface for administrators. It have tabs for Activities &
 * Instructors (more to come).
 */
public class AdministratorUI extends JFrame {
  
  private JTabbedPane tabPane;
  
  public AdministratorUI() {
    buildUI();
  }
  
  /**
   * Builds the main frame and adds the various tabs to it.
   */
  public void buildUI() {
    setTitle("Administrator");
    setLayout(new BorderLayout());
    setSize(600, 600);
    JPanel contentPane = new JPanel(new BorderLayout());
    
    tabPane = new JTabbedPane(SwingConstants.TOP);
    tabPane.setBackground(UIColors.LIGHTGREEN);
    tabPane.setOpaque(true);
    tabPane
        .add("Activities", new ActivityViewerPresenter(new ActivityViewerUI()).getUI());
    tabPane.add("Instructors",
        new InstructorViewerPresenter(new InstructorViewerUI()).getUI());
    tabPane.add("Equipments",
        new EquipmentViewerPresenter(new EquipmentViewerUI()).getUI());
    
    contentPane.add(tabPane);
    add(contentPane);
    
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
