package users;

import java.awt.BorderLayout;
import databaseConnection.*;
import main.MainWindow;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Resource.string;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class userLogin extends JFrame {

	private JPanel contentPane;
	private JTextField uName;
	private JPasswordField pwd;
	private JTextField recapcha;
	private JLabel recapIdel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userLogin frame = new userLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public userLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(userLogin.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		setTitle("3Idots Store Management Solution  || USER LOGIN");
		
		recapcha();
        
        
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1011, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUserName.setForeground(new Color(0, 0, 204));
		lblUserName.setBounds(555, 148, 106, 26);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPassword.setForeground(new Color(0, 0, 204));
		lblPassword.setBounds(555, 185, 106, 26);
		contentPane.add(lblPassword);
		
		uName = new JTextField();
		uName.setFont(new Font("Dialog", Font.BOLD, 12));
		uName.setForeground(new Color(0, 0, 204));
		uName.setBounds(671, 148, 258, 26);
		contentPane.add(uName);
		uName.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setFont(new Font("Dialog", Font.BOLD, 12));
		pwd.setForeground(new Color(0, 0, 204));
		pwd.setBounds(671, 185, 258, 26);
		contentPane.add(pwd);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 12));
		btnLogin.setForeground(new Color(0, 0, 204));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(uName.getText().toString().isEmpty() || pwd.getText().toString().isEmpty() || !recapcha.getText().toString().equals(recapIdel.getText().toString())) {
					JOptionPane.showMessageDialog(null, "Invalid username or Password or Recapcha", "Error", JOptionPane.ERROR_MESSAGE);
					recapIdel.setText(recapcha());
				}else {
					databaseConnection.userLogin.userLogins(uName.getText().toString(), pwd.getText().toString());
				}
				
			}
		});
		btnLogin.setBounds(765, 322, 164, 26);
		contentPane.add(btnLogin);
		
		recapcha = new JTextField();
		recapcha.setForeground(new Color(0, 0, 204));
		recapcha.setBounds(555, 237, 190, 46);
		contentPane.add(recapcha);
		recapcha.setColumns(10);
		recapcha.setFont(new Font("Dialog", Font.BOLD, 12));
		
		recapIdel = new JLabel(recapcha());
		recapIdel.setHorizontalAlignment(SwingConstants.CENTER);
		recapIdel.setHorizontalTextPosition(SwingConstants.CENTER);
		recapIdel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(102, 0, 153), new Color(153, 153, 51), new Color(153, 51, 102), new Color(255, 0, 102)));
		recapIdel.setForeground(new Color(0, 51, 102));
		recapIdel.setBackground(new Color(102, 0, 0));
		recapIdel.setFont(new Font("Yellowtail", Font.BOLD, 35));
		recapIdel.setBounds(555, 294, 190, 54);
		contentPane.add(recapIdel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Dialog", Font.BOLD, 12));
		btnReset.setForeground(new Color(0, 0, 204));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recapIdel.setText(recapcha());
				
			}
		});
		btnReset.setBounds(765, 288, 164, 26);
		contentPane.add(btnReset);
		
		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		btnForgetPassword.setForeground(new Color(0, 0, 204));
		btnForgetPassword.setBounds(765, 249, 164, 26);
		contentPane.add(btnForgetPassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(userLogin.class.getResource("/resourceImages/login-page-background-image-3-2 11x500.png")));
		label.setBounds(0, 0, 1108, 461);
		contentPane.add(label);
	}

	private String recapcha() {
		String SALTCHARS = "abcdefghijklmnopqrstuvxxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
	}
	
	public void successLogin(String uname, String piority, String employeeid) {
		int pio = Integer.parseInt(piority);
		MainWindow mw = new MainWindow();

		mw.setuName(uname);
		mw.setUsertype("manager");
		mw.setEmployeeID(Integer.parseInt(employeeid));
		mw.frmidotsStoreManagement.invalidate();
		mw.frmidotsStoreManagement.validate();
		mw.frmidotsStoreManagement.repaint();
//			mw.initialize(uname, Integer.parseInt(employeeid), pio); 
//			mw.btnLogout.setText("Logout");
			dispose();
	}
}
