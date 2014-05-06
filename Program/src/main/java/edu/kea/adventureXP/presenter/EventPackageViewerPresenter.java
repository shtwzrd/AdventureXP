package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Set;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.model.EventPackage;
import edu.kea.adventureXP.model.EventPackageController;
import edu.kea.adventureXP.view.EventPackageViewerUI;
import edu.kea.adventureXP.view.ManagePackageUI;

/**
 * Presenter that manages the UI for viewing all existing Event Packages. This
 * presenter also handles removing a selected Event Package.
 * 
 * @see EventPackageViewerUI
 */
public class EventPackageViewerPresenter {

    private EventPackageViewerUI ui;
    private int selectedRow;

    /**
     * Constructor associating the ui with the presenter and setting listeners
     * on all needed components within the UI.
     * 
     * @param ui
     *            The UI to listen to input from.
     */
    public EventPackageViewerPresenter(EventPackageViewerUI ui) {
        this.ui = ui;
        this.ui.setDeleteButtonListener(new DeletePackageListener());
        this.ui.setAddButtonListener(new AddPackageListener());
        this.ui.setTableListener(new PackageTableListener());
        this.refreshTable();
    }

    public EventPackageViewerUI getUI() {
        return ui;
    }

    /*
     * Method to force the ui to update its table with the latest information
     * from the database.
     */

    public void refreshTable() {
        List<EventPackage> packageList = EventPackageController
                        .selectAllFromEventPackage();
        this.ui.setTable(packageList);
    }

    /**
     * Private Inner class for handling when the user presses the Add Event
     * Package button. It creates a new ManageEventPackagePresenter and UI.
     * 
     * @see ManageEventPackagePresenter
     */
    private class AddPackageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new ManageEventPackagePresenter(new ManagePackageUI(),
                            EventPackageViewerPresenter.this);
        }

    }

    /**
     * Private Inner Class that handles deleting an Event Package from the list
     * of Event Packages.
     */
    private class DeletePackageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            EventPackageController.removeEventPackage((long) ui.getTable()
                            .getValueAt(selectedRow, 0));
            ui.setTable(EventPackageController.selectAllFromEventPackage());
        }

    }

    /**
     * Private Inner Class that handles the event in which the user clicks on an
     * Event Package and we must display the Event Package details to the user.
     */
    private class PackageTableListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            String activities = "";
            selectedRow = ui.getTable().rowAtPoint(e.getPoint());
            long id = (long) ui.getTable().getValueAt(selectedRow, 0);
            Set<Activity> set = EventPackageController.selectEventPackageById(
                            id).getActivities();
            for (Activity a : set) {
                activities += a.getName() + "\n";
            }
            ui.setPackageContentsArea(activities);

        }

    }
}