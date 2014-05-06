package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.xswingx.PromptSupport;

import edu.kea.adventureXP.model.Activity;

/**
 * User interface which takes care of managing the packages From this UI, the
 * user can create new Event Packages.
 *
 */
public class ManagePackageUI extends JFrame {

    private JButton addActivityButton;
    private JButton removeActivityButton;
    private JButton savePackageButton;
    private JTable activityTable;
    private JTable selectedTable;
    private JTextField nameField;
    private JTextField durationField;
    private JTextField priceField;
    private JButton discardPackageButton;

    public ManagePackageUI() {
        buildUI();
    }

    /**
     * Method for building the various panels within the ManagePackageUI frame
     * as well as set the various properties of said panel.
     */
    public void buildUI() {
        setLayout(new BorderLayout());
        setSize(900, 600);

        buildNorthPanel();
        buildCenterPanel();
        buildSouthPanel();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ------- North Panel -------

    public void buildNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setBackground(UIColors.DARKGREEN);

        add(northPanel, BorderLayout.NORTH);
    }

    // ------- Center Panel -------

    public void buildCenterPanel() {
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));

        centerPanel.add(buildEastCenterPanel());

        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.setBackground(UIColors.LIGHTGREEN);
        activityTable = new JTable();
        westPanel.setBorder(new TitledBorder(null, "Available Activities",
                        TitledBorder.CENTER, TitledBorder.TOP));
        westPanel.add(new JScrollPane(activityTable));
        centerPanel.add(westPanel);

        add(centerPanel, BorderLayout.CENTER);
    }

    public JPanel buildEastCenterPanel() {
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setBackground(UIColors.LIGHTGREEN);
        eastPanel.setBorder(new TitledBorder(null, "Package Information",
                        TitledBorder.CENTER, TitledBorder.TOP));

        // North panel inside eastPanel
        JPanel east_northPanel = new JPanel(new GridLayout(3, 2));
        east_northPanel.setBackground(UIColors.LIGHTGREEN);
        JLabel nameLabel = new JLabel("  Name: ");
        nameField = new JTextField(10);
        PromptSupport.setPrompt("Package name", nameField);
        east_northPanel.add(nameLabel);
        east_northPanel.add(nameField);

        JLabel priceLabel = new JLabel("  Price: ");
        priceField = new JTextField(10);
        PromptSupport.setPrompt("Package price [DKK]", priceField);
        east_northPanel.add(priceLabel);
        east_northPanel.add(priceField);

        JLabel durationLabel = new JLabel("  Duration: ");
        durationField = new JTextField(10);
        PromptSupport.setPrompt("Package duration [minutes]", durationField);
        east_northPanel.add(durationLabel);
        east_northPanel.add(durationField);

        eastPanel.add(east_northPanel, BorderLayout.NORTH);

        // Center panel inside eastPanel
        selectedTable = new JTable();
        eastPanel.add(new JScrollPane(selectedTable), BorderLayout.CENTER);

        // South panel inside eastPanel
        JPanel east_southPanel = new JPanel();
        east_southPanel.setBackground(UIColors.LIGHTGREEN);
        removeActivityButton = new JButton("Remove Activity");
        east_southPanel.add(removeActivityButton);

        addActivityButton = new JButton("Add Activity");
        east_southPanel.add(addActivityButton);
        eastPanel.add(east_southPanel, BorderLayout.SOUTH);

        return eastPanel;
    }

    /**
     * Methods which allows you to get name, price and duration
     */
    @Override
    public String getName() {
        return nameField.getText();
    }

    public String getPrice() {
        return priceField.getText();
    }

    public String getDuration() {
        return durationField.getText();
    }

    /**
     * Displays an error in a JOptionPane
     * 
     * @param error
     *            The error message to display
     */
    public void displayError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error Message",
                        JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Method which is seting the JTable
     * 
     * @param activityList
     *            takes parameter of type List
     * @param table
     *            takes parameter of type JTable
     */
    public void setTable(List<Activity> activityList, JTable table) {
        String[] heads = { "ID", "Name" };

        DefaultTableModel model = new DefaultTableModel();

        model.setRowCount(activityList.size());
        model.setColumnIdentifiers(heads);

        int row = 0;

        for (Activity activity : activityList) {
            model.setValueAt(activity.getId(), row, 0);
            model.setValueAt(activity.getName(), row, 1);
            row++;
        }

        table.setModel(model);
    }

    /**
     * Method which allows you to set up table
     * 
     * @param selectedActivityList
     *            stands for parameter of type List
     */
    public void setSelectedTable(List<Activity> selectedActivityList) {
        setTable(selectedActivityList, selectedTable);
    }

    /**
     * Method which allows you to set up table
     * 
     * @param activityList
     *            stands for parameter of type List
     */
    public void setActivityTable(List<Activity> activityList) {
        setTable(activityList, activityTable);
    }

    /**
     * Method which allows you to get table
     * 
     * @return the selected table
     */
    public JTable getSelectedTable() {
        return selectedTable;
    }

    /**
     * Method which allows you to get table
     * 
     * @return the activity table
     */
    public JTable getActivityTable() {
        return activityTable;
    }

    // ------- South Panel -------

    public void buildSouthPanel() {
        JPanel southPanel = new JPanel();
        southPanel.setBackground(UIColors.DARKGREEN);

        discardPackageButton = new JButton("Discard Package");
        southPanel.add(discardPackageButton);

        savePackageButton = new JButton("Save Package");
        southPanel.add(savePackageButton);

        add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Methods which holds the actions for the buttons in the user interface
     * 
     * @param listener
     */
    public void setAddActivityListener(ActionListener listener) {
        addActivityButton.addActionListener(listener);
    }

    public void setDiscardPackageListener(ActionListener listener) {
        discardPackageButton.addActionListener(listener);
    }

    public void setRemoveActivityListener(ActionListener listener) {
        removeActivityButton.addActionListener(listener);
    }

    public void setSavePackageListener(ActionListener listener) {
        savePackageButton.addActionListener(listener);
    }

    public int getDurationField() {
        return Integer.parseInt(durationField.getText());
    }

    public double getPriceField() {
        return Double.parseDouble(priceField.getText());
    }

}
