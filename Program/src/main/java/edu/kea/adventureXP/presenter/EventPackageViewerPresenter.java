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

// TODO EMPTY FOR NOW
public class EventPackageViewerPresenter {

    private EventPackageViewerUI ui;
    private int selectedRow;

    public EventPackageViewerPresenter(EventPackageViewerUI ui) {
        this.ui = ui;
        this.ui.setDeleteButtonListener(new DeletePackageListener());
        this.ui.setAddButtonListener(new AddPackageListener());
        this.ui.setTableListener(new PackageTableListener());
        List<EventPackage> packageList = EventPackageController.selectAllFromEventPackage();
        this.ui.setTable(packageList);
    }

    public EventPackageViewerUI getUI() {
        return ui;
    }

    // ****

    private class AddPackageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new ManageEventPackagePresenter(new ManagePackageUI(), EventPackageViewerPresenter.this);
        }

    }

    private class DeletePackageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            EventPackageController.removeEventPackage((long)ui.getTable().getValueAt(selectedRow, 0));
            ui.setTable(EventPackageController.selectAllFromEventPackage());
        }

    }


  private class PackageTableListener extends MouseAdapter {
    
    @Override
    public void mouseClicked(MouseEvent e) {
      String activities = "";
      selectedRow = ui.getTable().rowAtPoint(e.getPoint());
      long id =  (long) ui.getTable().getValueAt(selectedRow, 0);
      Set<Activity> set = EventPackageController.selectEventPackageById(id).getActivities();
      for(Activity a : set) {
          activities += a.getName() + "\n"; 
      }
      ui.setPackageContentsArea(activities);

    }
    
  }
}