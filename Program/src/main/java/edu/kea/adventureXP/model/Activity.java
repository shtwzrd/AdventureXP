package edu.kea.adventureXP.model;

/**
 * Class representing an Activity with a name, description and price.
 */
public class Activity {
  
  private String name;
  private String description;
  private double price;
  
  /**
   * Controller for creating an Activity parsing its name, description and
   * price.
   * 
   * @param name The name of the Activity
   * @param description A description describing the Activity
   * @param price The price of the activity (per person per hour)
   */
  public Activity(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }
  
  /**
   * Constructor for creating an Activity only parsing in the name of said
   * Activity.
   * 
   * @param name The name of the Activity.
   */
  public Activity(String name) {
    this(name, "", 0);
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
}
