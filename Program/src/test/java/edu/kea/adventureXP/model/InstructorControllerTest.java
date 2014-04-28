package edu.kea.adventureXP.model;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.kea.adventureXP.model.Member;

public class InstructorControllerTest {

  @Test
  public void instructorControllerBasicUsageTest() {
    Member instructor = new Member("John", "Jacob", "Sesame Street",
        "12345-3456", "City", "Country", "2222222", "bigbird43@s.se", true);  
    MemberController.addMember(instructor);

     List<Member> list = MemberController.getAllInstructors();
    for(Member i : list) {
      System.out.println(i.getFirstName() + " " + i.getLastName());
    } 

    List<Member> returned =
      MemberController.selectAllFromMember(
          "from Member "+
          "where firstName = " + "'" + "John" + "'");

    assertEquals(instructor.getId(), returned.get(0).getId());

  }

	@Test
	public void removeInstructorControllerTest() {

  }

}
