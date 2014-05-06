package edu.kea.adventureXP.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.xswingx.PromptSupport;

import edu.kea.adventureXP.model.EventPackage;

/*
 * This UI is responsible for giving an overview of all existing Event Packages, and allows for
 * removing specific Event Packages
 */
public class EventPackageViewerUI extends JPanel {

    private static final long serialVersionUID = 3954424525672177736L;

    private JComboBox<String> dropDown;
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea packageContentsArea;
    private JTable packageTable;
    private JButton deleteButton;
    private JButton addButton;
    private JButton editButton;

    public EventPackageViewerUI() {
        buildUI();
    }

    /**
     * Method for building the various panels within the PackageViewerUI's panel
     * as well as set the various properties of said panel.
     */
    public void buildUI() {
        setLayout(new BorderLayout());

        buildNorthPanel();
        buildCenterPanel();
        buildSouthPanel();
    }

    /**
     * Builds the North Panel
     * TODO: Implement search function 
     */
    public void buildNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setBackground(UIColors.DARKGREEN);

        dropDown = new JComboBox<String>();
        searchField = new JTextField(15);
        PromptSupport.setPrompt("Type in search...", searchField);

        searchButton = new JButton("Search");

        northPanel.add(dropDown);
        northPanel.add(searchField);
        northPanel.add(searchButton);

        add(northPanel, BorderLayout.NORTH);
    }

    /**
     * TODO
     */
    public void setDropDownOptions(String[] words) {
        for (String s : words)
            dropDown.addItem(s);
    }

    /**
     * Builds the center panel consisting of a JTable showing all activities and
     * a description box showing the description of the selected activity.
     */
    public void buildCenterPanel() {
        JPanel southPanel = new JPanel(new BorderLayout());

        packageTable = new JTable();
        southPanel.add(new JScrollPane(packageTable), BorderLayout.CENTER);

        packageContentsArea = new JTextArea(10, 20);
        packageContentsArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        packageContentsArea.setWrapStyleWord(true);
        packageContentsArea.setLineWrap(true);
        packageContentsArea.setEditable(false);
        PromptSupport.setPrompt("Package Contents", packageContentsArea);

        southPanel.add(packageContentsArea, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.CENTER);
    }

    /**
     * Takes a list of Event Packages and places them into the Table 
     */
    public void setTable(List<EventPackage> packageList) {
        String[] heads = { "ID", "Package Name", "Price", "Duration" };

        DefaultTableModel model = new DefaultTableModel();

        model.setRowCount(packageList.size());
        model.setColumnIdentifiers(heads);

        int row = 0;

        for (EventPackage e : packageList) {
            model.setValueAt(e.getId(), row, 0);
            model.isCellEditable(row, 0);
            model.setValueAt(e.getName(), row, 1);
            model.isCellEditable(row, 1);
            model.setValueAt(e.getPrice(), row, 2);
            model.isCellEditable(row, 2);
            model.setValueAt(e.getDuration(), row, 3);
            model.isCellEditable(row, 3);
            row++;
        }

        packageTable.setModel(model);

    }

    /**
     * Builds the south panel having buttons for deleting, editing and adding
     * packages.
     */
    public void buildSouthPanel() {
        JPanel southPanel = new JPanel();
        southPanel.setBackground(UIColors.DARKGREEN);

        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        addButton = new JButton("Add New");

        southPanel.add(deleteButton);
        // southPanel.add(editButton);
        southPanel.add(addButton);

        add(southPanel, BorderLayout.SOUTH);
    }

    public JTable getTable() {
        return packageTable;
    }

    public void setTableListener(MouseListener listener) {
        packageTable.addMouseListener(listener);
    }

    public void setDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void setEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void setAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void setSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void setPackageContentsArea(String description) {
        packageContentsArea.setText(description);
    }

    public String getSelectedDropDown() {
        return (String) dropDown.getSelectedItem();
    }

    public String getSearchField() {
        return searchField.getText();
    }

}
