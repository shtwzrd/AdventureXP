package edu.kea.adventureXP.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import edu.kea.adventureXP.presenter.ActivityViewerPresenter;
import edu.kea.adventureXP.presenter.CustomerViewerPresenter;
import edu.kea.adventureXP.presenter.EquipmentViewerPresenter;
import edu.kea.adventureXP.presenter.InstructorViewerPresenter;
import edu.kea.adventureXP.presenter.EventPackageViewerPresenter;
import edu.kea.adventureXP.presenter.ManageBookingPresenter;

/**
 * Main User Interface for administrators. It have tabs for Activities,
 * Instructors (more to come).
 */
public class AdministratorUI extends JFrame {
  
  private static final long serialVersionUID = -2853822743439953004L;
  
  private JTabbedPane       tabPane;
  
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
    tabPane.add("Packages", new EventPackageViewerPresenter(new EventPackageViewerUI()).getUI());
    tabPane.add("Equipment",
        new EquipmentViewerPresenter(new EquipmentViewerUI()).getUI());
    tabPane.add("Instructors",
        new InstructorViewerPresenter(new InstructorViewerUI()).getUI());
    new InstructorViewerPresenter(new InstructorViewerUI());
    tabPane.add("Customers", new CustomerViewerPresenter(new CustomerViewerUI()).getUI());
    tabPane.add("Bookings", new ManageBookingPresenter(new ManageBookingUI()).getUI());
    
    contentPane.add(tabPane);
    add(contentPane);
    
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
