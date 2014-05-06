package edu.kea.adventureXP.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import edu.kea.adventureXP.model.Booking;
import edu.kea.adventureXP.model.BookingController;
import edu.kea.adventureXP.model.Member;
import edu.kea.adventureXP.model.ScheduledActivity;
import edu.kea.adventureXP.model.ScheduledActivityController;
import edu.kea.adventureXP.view.CustomerViewerUI;
import edu.kea.adventureXP.view.ManageBookingUI;

public class ManageBookingPresenter {
	ManageBookingUI bui;
	Member customer;
	int selectedRow;
	List<ScheduledActivity> activityList;
	List<Booking> bookingList;
	
	public ManageBookingPresenter(Member customer, ManageBookingUI bui){
		this.bui = bui;
		this.customer = customer;
		activityList = ScheduledActivityController.selectAllFromScheduledActivity();
		bookingList = BookingController.selectAllFromBooking("from Booking where customer = '" + customer + "'");
		bui.setCancelListener(new CancelBookinListener());
		bui.setEditListener(new EditListener());
		bui.setBookListener(new BookingListener());
		bui.setActivityTableListener(new ActivityTableListener());
		bui.setBookingTableListener(new BookingTableListener());
		bui.setCustomerName("You need to select a customer in the customer page.");
	}
	
	public ManageBookingPresenter(ManageBookingUI bui){
		this.bui = bui;
		activityList = ScheduledActivityController.selectAllFromScheduledActivity();
		//bookingList = BookingController.selectAllFromBooking("from Booking where customer = '" + customer + "'");
		bui.setCancelListener(new CancelBookinListener());
		bui.setEditListener(new EditListener());
		bui.setBookListener(new BookingListener());
		bui.setActivityTableListener(new ActivityTableListener());
		bui.setBookingTableListener(new BookingTableListener());
	}
	
	 
	  public ManageBookingUI getUI() {
	    return bui;
	  }
	 
	/**
	* MouseListener class used to listen for clicks happening within a JTable.
	*/
	private class ActivityTableListener implements MouseListener {
		    
		@Override
		public void mousePressed(MouseEvent e) {
			selectedRow = bui.getActivityTable().rowAtPoint(e.getPoint());
		    ScheduledActivity a = activityList.get(selectedRow);
		}
		    
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		    
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		    
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		    
		@Override
		public void mouseExited(MouseEvent e) {
		}    
	}
	
	 
	/**
	* MouseListener class used to listen for clicks happening within a JTable.
	*/
	private class BookingTableListener implements MouseListener {
		    
		@Override
		public void mousePressed(MouseEvent e) {
			selectedRow = bui.getBookedTable().getSelectedRow();
		    Booking b = bookingList.get(selectedRow);
		}
		    
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		    
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		    
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		    
		@Override
		public void mouseExited(MouseEvent e) {
		}    
	}
	
	 
	  /**
	   * Updates the UI
	   */
	  public void updateUI() {
	    bui.setBookedTable(bookingList);
	    bui.setActivityTable(activityList);
	    bui.revalidate();
	  }
	
	 
	  /**
	   * Listens to the cancel button within the UI.
	   */
	  private class CancelBookinListener implements ActionListener {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	      if (selectedRow != -1) {
	        Booking cancelBooking = bookingList.remove(selectedRow);
	        BookingController.removeBooking(cancelBooking);
	        updateUI();
	      }
	    }
	  }
	  
	  
	  /**
	   * Listens to the cancel button within the UI.
	   */
	  private class BookingListener implements ActionListener {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	      if (selectedRow != -1) {
	        ScheduledActivity activity = activityList.get(selectedRow);
	        Booking newBooking = new Booking(activity, customer);
	        BookingController.saveBooking(newBooking);
	        bookingList.add(newBooking);
	        updateUI();
	      }
	    }
	  }
	  
	  
	  /**
	   * Listens to the cancel button within the UI.
	   */
	  private class EditListener implements ActionListener {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	      if (selectedRow != -1) {
	        Booking booking = bookingList.get(selectedRow);
	        updateUI();
	      }
	    }
	  }
}
