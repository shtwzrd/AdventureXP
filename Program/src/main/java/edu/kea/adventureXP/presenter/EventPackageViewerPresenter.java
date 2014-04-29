package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kea.adventureXP.view.EventPackageViewerUI;

// TODO EMPTY FOR NOW
public class EventPackageViewerPresenter {
  
  private EventPackageViewerUI ui;
  
  public EventPackageViewerPresenter(EventPackageViewerUI ui) {
    this.ui = ui;
  }
  
  public EventPackageViewerUI getUI() {
    return ui;
  }
  
  // ****
  
  private class AddPackageListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      // new ManageEventPackagePresenter(new ManageEventPackageUI(), this);
    }
    
  }
  
}
