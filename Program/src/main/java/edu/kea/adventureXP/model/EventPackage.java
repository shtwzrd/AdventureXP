package edu.kea.adventureXP.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

/**
 * Class representing an EventPackage with a name, duration, price and an
 * associated set of Activities.
 */
@Entity
@Table(name = "EVENTPACKAGE")
public class EventPackage implements Comparable<EventPackage> {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
                    name = "ACTIVITY_PACKAGE_RELATION",
                    joinColumns = { @JoinColumn(name = "activity_id") },
                    inverseJoinColumns = { @JoinColumn(name = "package_id") })
    private Set<Activity> activities;

    @Column
    private int duration;

    @Column
    private double price;

    /**
     * Constructor for creating an EventPackage
     * 
     * @param name
     *            The name of the Package
     * @param activities
     *            a set containing the activities of the EventPackage
     * @param duration
     *            combined length, in hours, of the activities
     * @param price
     *            price of the package
     */
    public EventPackage(String name, Set<Activity> activities, int duration,
                    double price) {
        this.name = name;
        this.activities = activities;
        this.duration = duration;
        this.price = price;
    }

    /**
     * Constructor for creating an empty EventPackage
     * 
     * @param name
     *            The name of the EventPackage.
     */
    public EventPackage(String name) {
        this.name = name;
        this.activities = new HashSet<>();
        this.duration = 0;
    }

    /**
     * Empty EventPackage constructor for Hibernate
     */
    public EventPackage() {

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Set<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(Set<Activity> set) {
        this.activities = set;
    }

    public void addActivity(Activity a) {
        this.activities.add(a);
    }

    public void removeActivity(Activity a) {
        this.activities.remove(a);
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int d) {
        this.duration = d;
    }

    @Override
    public int compareTo(EventPackage arg0) {
        if (this.getId() == arg0.getId()) {
            return 0;
        }
        return -1;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(this.name + "\n");
        b.append("Duration: " + this.duration + "\n");
        b.append("Price: " + this.price + "\n");
        for (Activity a : this.activities) {
            b.append(a.toString() + "\n");
        }
        return b.toString();
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}