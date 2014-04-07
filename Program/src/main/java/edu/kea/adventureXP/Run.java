package edu.kea.adventureXP;

import edu.kea.adventureXP.model.ActivityController;
import edu.kea.adventureXP.presenter.ManageActivityPresenter;
import edu.kea.adventureXP.view.ManageActivityUI;

public class Run {
  
  public static void main(String[] args) {
    ManageActivityUI maUI = new ManageActivityUI();
    ActivityController controller = new ActivityController();
    ManageActivityPresenter maPresenter = new ManageActivityPresenter(maUI, controller);
  }
  
}
