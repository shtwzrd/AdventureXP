package edu.kea.adventureXP.model;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.kea.adventureXP.model.Instructor;

public class InstructorControllerTest {

  @Test
  public void instructorControllerBasicUsageTest() {
    List<String> phones = new ArrayList<>();
    phones.add("12 34 56 78");
    Instructor instructor = new Instructor("John", "Jacob", "123", "Sesame Street",
        "12345-3456", "City", "Country", phones, "bigbird43@s.se");  
    InstructorController.addInstructor(instructor);

     List<Instructor> list = InstructorController.selectAllFromInstructor();
    for(Instructor i : list) {
      System.out.println(i.getFirstName() + " " + i.getLastName());
    } 

    List<Instructor> returned =
      InstructorController.selectAllFromInstructor(
          "from Instructor "+
          "where firstName = " + "'" + "John" + "'");

    assertEquals(instructor.getId(), returned.get(0).getId());

  }

	@Test
	public void removeInstructorControllerTest() {

  }

}
