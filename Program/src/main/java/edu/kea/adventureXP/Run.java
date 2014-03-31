package edu.kea.adventureXP;

import edu.kea.adventureXP.presenter.ManageActivityPresenter;
import edu.kea.adventureXP.view.ManageActivityUI;

public class Run {
  
  public static void main(String[] args) {
    ManageActivityUI maUI = new ManageActivityUI();
    ManageActivityPresenter maPresenter = new ManageActivityPresenter(maUI);
  }
  
}
