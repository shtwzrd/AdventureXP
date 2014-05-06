package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.kea.adventureXP.model.Activity;
import edu.kea.adventureXP.model.ActivityController;
import edu.kea.adventureXP.model.EventPackage;
import edu.kea.adventureXP.model.EventPackageController;
import edu.kea.adventureXP.view.ManagePackageUI;

/**
 * Presenter class for the ManagePackageUI. It gets and saves information about
 * EventPackages for the view.
 * 
 * @see ManagePackageUI
 */
public class ManageEventPackagePresenter {

    private ManagePackageUI ui;
    private EventPackageViewerPresenter epvp;
    private EventPackage event = null;
    private boolean edit = false;
    private List<Activity> selectedActivities;

    /**
     * Constructor for wanting to open 'Manage EventPackage' with pre-filled
     * fields. This is currently disabled as Editing an EventPackage is not a
     * requirement.
     * 
     * @param ui
     *            UI for 'Manage EventPackage'
     * @param activity
     *            Object of EventPackage, which delivers information to the
     *            fields
     * @param epvp
     *            The Viewer that should be updated after the activity has been
     *            edited
     */
    /*
     * public ManageEventPackagePresenter(ManagePackageUI ui, EventPackage
     * package, EventPackageViewerPresenter avp) { }
     */

    /**
     * Constructor for 'Manage EventPackage', which adds listeners to the
     * buttons.
     * 
     * @param ui
     *            UI for 'Manage EventPackage'
     * @param avp
     *            The Viewer that should be updated after an EventPackage has
     *            been saved
     */
    public ManageEventPackagePresenter(ManagePackageUI ui,
                    EventPackageViewerPresenter epvp) {
        this.ui = ui;
        this.epvp = epvp;
        ui.setSavePackageListener(new SaveButtonListener());
        ui.setDiscardPackageListener(new DiscardButtonListener());
        ui.setAddActivityListener(new AddActivityButtonListener());
        ui.setRemoveActivityListener(new RemoveActivityButtonListener());
        ui.setActivityTable(ActivityController.selectAllFromActivity());
        this.selectedActivities = new ArrayList<>();
    }

    /**
     * Validates the name field in ManageActivityUI.
     * 
     * @param name
     *            The String in the text field.
     * @return true if the field is not empty
     */
    public boolean validateName(String name) {
        if (name == null) {
            return false;
        }
        return !name.isEmpty();
    }

    /**
     * Validates the price field in ManageActivityUI.
     * 
     * @param price
     *            The price as double.
     * @return true if price is not negative.
     */
    public boolean validatePrice(double price) {
        return price >= 0;
    }

    /**
     * Inner private class implementing the behavior of an ActionListener. The
     * class has the behavior for saving an EventPackage.
     */
    private class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String errorMessage = "";
            boolean flag = true;

            if (!validateName(ui.getName())) {
                errorMessage += "- Name field cannot be empty.\n";
                flag = false;
            }

            if (!validatePrice(ui.getPriceField())) {
                errorMessage += "- Price must be greater than or equal to 0.\n";
                flag = false;
            }

            if (flag) {
                // if (edit) {
                // event.setDuration(ui.getDurationField());
                // event.setName(ui.getNameField());
                // event.setPrice(ui.getPriceField());
                // event.setIsActive(ui.getIsActive());
                // EventPackageController.(event);
                // }

                // else {
                EventPackage toAdd = new EventPackage(ui.getName(),
                                new HashSet<>(selectedActivities),
                                ui.getDurationField(), ui.getPriceField());
                EventPackageController.addEventPackage(toAdd);
                List<EventPackage> p = EventPackageController
                                .selectAllFromEventPackage();
                System.out.println(p);
                System.out.println(p.get(0).getActivities());
                epvp.refreshTable();
                ui.dispose();
            }
            ui.displayError(errorMessage);
        }

    }

    /**
     * Inner private class implementing the behaviour of an ActionListener. The
     * class has the behaviour for discarding the changes made to an
     * EventPackage.
     */
    private class DiscardButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ui.dispose();
        }

    }

    /**
     * Inner private class that handles moving an Activity from the List of
     * Available Activities over to the list of selected Activities.
     */
    private class AddActivityButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = ui.getActivityTable().getSelectedRow();
            Activity toAdd = ActivityController.selectFromActivity((long) ui
                            .getActivityTable().getValueAt(row, 0));

            selectedActivities.add(toAdd);
            System.out.println(ui.getActivityTable().getValueAt(row, 0));

            ui.setSelectedTable(selectedActivities);
            epvp.refreshTable();
        }

    }

    /**
     * Inner private class that handles removing an Activity from the List of
     * Selected Activities
     */
    private class RemoveActivityButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = ui.getActivityTable().getSelectedRow();
            Activity toRemove = ActivityController.selectFromActivity((long) ui
                            .getSelectedTable().getValueAt(row, 0));

            selectedActivities.remove(toRemove);
            ui.setSelectedTable(selectedActivities);
            ui.dispose();
        }

    }

}
