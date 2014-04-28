import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.kea.adventureXP.model.ActivityControllerTest;
import edu.kea.adventureXP.model.ActivityTest;
import edu.kea.adventureXP.model.InstructorControllerTest;
import edu.kea.adventureXP.model.InstructorTest;
import edu.kea.adventureXP.presenter.ActivityViewerPresenterTest;
import edu.kea.adventureXP.presenter.ManageActivityPresenterTest;
import edu.kea.adventureXP.presenter.ManageInstructorPresenterTest;

@RunWith(Suite.class)
@SuiteClasses({ ActivityControllerTest.class, ActivityTest.class,
    InstructorControllerTest.class, InstructorTest.class,
    ActivityViewerPresenterTest.class, ManageActivityPresenterTest.class,
    ManageInstructorPresenterTest.class })
public class AllTests {
  
}
