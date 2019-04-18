package databaseConnection;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

	public class DisappearingMessage implements ActionListener
	{
	    private final int ONE_SECOND = 1000;
	
	    private Timer timer;
	    private JFrame frame;
	    private JLabel msgLabel;
	
		public DisappearingMessage (String str, int seconds) 
		{
		frame = new JFrame ("Success Login");
		msgLabel = new JLabel (str, SwingConstants.CENTER);
		msgLabel.setPreferredSize(new Dimension(600, 400));
		
		timer = new Timer (this.ONE_SECOND * seconds, this);
		// only need to fire up once to make the message box disappear
		timer.setRepeats(false);
		}
	
	public DisappearingMessage(String a, int b, String c) {
			// TODO Auto-generated constructor stub
		DisappearingMessage dm = new DisappearingMessage("Welcome "+a+" you are successfully loged in\n"
				+ "your piority level is "+c, b);
		dm.start();
		}

	/**
	 * Start the timer
	 */
		public void start ()
		{
		// make the message box appear and start the timer
		frame.getContentPane().add(msgLabel, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		timer.start();
		}
	
	/**
	 * Handling the event fired by the timer
	 */
		public void actionPerformed (ActionEvent event)
		{
		// stop the timer and kill the message box
		timer.stop();
		frame.dispose();
		}
	
		public static void main (String[] args)
		{
		DisappearingMessage dm = new DisappearingMessage("You are successfully login", 5);
		dm.start();
		}
		
		public void passing(String uname, String utype, int eid) {
			main.MainWindow mw = new main.MainWindow();
			mw.setEmployeeID(eid);
			mw.setuName(uname);
			mw.setUsertype("manager");
			mw.frmidotsStoreManagement.validate();
		}
	}