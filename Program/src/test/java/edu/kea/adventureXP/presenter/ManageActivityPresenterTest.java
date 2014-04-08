package edu.kea.adventureXP.presenter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.kea.adventureXP.model.ActivityController;
import edu.kea.adventureXP.view.ManageActivityUI;

public class ManageActivityPresenterTest {
  
  @Test
  public void validateNameTest() {
    ManageActivityPresenter map = new ManageActivityPresenter();
    
    assertTrue(map.validateName("Kim"));
    assertTrue(!map.validateName(""));
    assertTrue(map.validateName("123"));
  }
  
  @Test
  public void validatePriceTest() {
    ManageActivityPresenter map = new ManageActivityPresenter();
    
    assertTrue(map.validatePrice(48.1));
    assertTrue(!map.validatePrice(-48));
    assertTrue(map.validatePrice(0));
  }
  
}
