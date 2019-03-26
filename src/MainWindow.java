import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

import Resource.design;
import Resource.string;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private static JFrame frmidotsStoreManagement;

	/**
	 * Launch the application. Main Activity
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmidotsStoreManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		
	}
	
	/**
	 * Variable Declaration
	 */
	public static JMenuBar menuBar;
	public static JMenuItem mntmDashboard;
	public static JMenuItem mnInventory;
	public static JMenuItem mntmInventoryList;
	public static JMenuItem mntmManageProduct;
	public static JMenuItem mntmAddProduct;
	public static JMenuItem mntmDeleteProduct;
	public static JMenuItem mntmPurchaseHistory;
	public static JMenuItem mntmVendoreList;
	public static JMenuItem mntmManageVendore;
	public static JMenuItem mntmAddVendore;
	public static JMenuItem mntmDeleteVendore;
	public static JMenuItem mntmNewSale;
	public static JMenuItem mntmRefund;
	public static JMenuItem mntmMyProfile;
	public static JMenuItem mntmAddUser;
	public static JMenuItem mntmManageEmployee;
	public static JMenuItem mntmDeleteEmployee;
	public static JMenuItem mntmDaily;
	public static JMenuItem mntmWeekly;
	public static JMenuItem mntmMonthly;
	public static JMenuItem mntmHalfYearly;
	public static JMenuItem mntmYearly;
	public static JMenuItem mntmMakeNew;
	public static JMenu mnReports;
	public static JMenu mnEmployee;
	public static JMenu mnSales;
	public static JMenu mnPurchase;
	
	
	/**
	 * Calling objects
	 */
	static design dcss = new design();
	static UserLogin ul = new UserLogin();
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmidotsStoreManagement = new JFrame();
		frmidotsStoreManagement.getContentPane().setForeground(dcss.fgcolor("title"));
		frmidotsStoreManagement.getContentPane().setBackground(dcss.bgcolor("mainback"));
		frmidotsStoreManagement.getContentPane().setLayout(new BoxLayout(frmidotsStoreManagement.getContentPane(), BoxLayout.X_AXIS));
		
		/**
		 * Create 2nd window in main window
		 */
		
		JInternalFrame internalFrame = new JInternalFrame();
		internalFrame.setContentPane(ul.getContentPane()); // must be comment out before design
		internalFrame.pack();
		frmidotsStoreManagement.getContentPane().add(internalFrame);
		internalFrame.setVisible(true);
	
		frmidotsStoreManagement.setTitle(string.title);
		frmidotsStoreManagement.setBackground(dcss.bgcolor("mainback"));
		frmidotsStoreManagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmidotsStoreManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//menu bar
		menubar();
		
		
	}
	
	
	/**
	 * Create only the bar for menu
	 */
	private static void menubar() {
		menuBar = new JMenuBar();
		menuBar.setFont(dcss.fonts("menu"));
		menuBar.setForeground(dcss.fgcolor("menu"));
		menuBar.setBackground(dcss.bgcolor("menu"));
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmidotsStoreManagement.setJMenuBar(menuBar);
		
		menu();
	}
		
	
	/**
	 * Insert items in menu bar menu (Sub-directories)
	 */
	private static void menuitem() {	
				
		mntmInventoryList = new JMenuItem(string.invenli);
		mntmInventoryList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmInventoryList.setPreferredSize(new Dimension(160, 50));
		mntmInventoryList.setFont(dcss.fonts("menu"));
		mntmInventoryList.setForeground(dcss.fgcolor("menu"));
		mntmInventoryList.setBackground(dcss.bgcolor("menu"));
		mnInventory.add(mntmInventoryList);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(dcss.fgcolor("separator"));
		separator_2.setBackground(dcss.bgcolor("separator"));
		mnInventory.add(separator_2);
		
		mntmManageProduct = new JMenuItem(string.ManagePro);
		mntmManageProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmManageProduct.setPreferredSize(new Dimension(160, 50));
		mntmManageProduct.setFont(dcss.fonts("menu"));
		mntmManageProduct.setForeground(dcss.fgcolor("menu"));
		mntmManageProduct.setBackground(dcss.bgcolor("menu"));
		mnInventory.add(mntmManageProduct);
		
		mntmAddProduct = new JMenuItem(string.AddPro);
		mntmAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmAddProduct.setPreferredSize(new Dimension(160, 50));
		mntmAddProduct.setFont(dcss.fonts("menu"));
		mntmAddProduct.setForeground(dcss.fgcolor("menu"));
		mntmAddProduct.setBackground(dcss.bgcolor("menu"));
		mnInventory.add(mntmAddProduct);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(dcss.fgcolor("separator"));
		separator_1.setBackground(dcss.bgcolor("separator"));
		mnInventory.add(separator_1);
		
		mntmDeleteProduct = new JMenuItem(string.DeletePro);
		mntmDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmDeleteProduct.setPreferredSize(new Dimension(160, 50));
		mntmDeleteProduct.setFont(dcss.fonts("menu"));
		mntmDeleteProduct.setForeground(dcss.fgcolor("menu"));
		mntmDeleteProduct.setBackground(dcss.bgcolor("menu"));
		mnInventory.add(mntmDeleteProduct);
		
		mntmMakeNew = new JMenuItem(string.MakeNewPur);
		mntmMakeNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmMakeNew.setPreferredSize(new Dimension(160, 50));
		mntmMakeNew.setFont(dcss.fonts("menu"));
		mntmMakeNew.setForeground(dcss.fgcolor("menu"));
		mntmMakeNew.setBackground(dcss.bgcolor("menu"));
		mnPurchase.add(mntmMakeNew);
		
		mntmPurchaseHistory  = new JMenuItem(string.PurHis);
		mntmPurchaseHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmPurchaseHistory.setPreferredSize(new Dimension(160, 50));
		mntmPurchaseHistory.setFont(dcss.fonts("menu"));
		mntmPurchaseHistory.setForeground(dcss.fgcolor("menu"));
		mntmPurchaseHistory.setBackground(dcss.bgcolor("menu"));
		mnPurchase.add(mntmPurchaseHistory);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(dcss.fgcolor("separator"));
		separator.setBackground(dcss.bgcolor("separator"));
		mnPurchase.add(separator);
		
		mntmVendoreList = new JMenuItem(string.VenList);
		mntmVendoreList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmVendoreList.setPreferredSize(new Dimension(160, 50));
		mntmVendoreList.setFont(dcss.fonts("menu"));
		mntmVendoreList.setForeground(dcss.fgcolor("menu"));
		mntmVendoreList.setBackground(dcss.bgcolor("menu"));
		mnPurchase.add(mntmVendoreList);
		
		mntmManageVendore = new JMenuItem(string.ManVen);
		mntmManageVendore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmManageVendore.setPreferredSize(new Dimension(160, 50));
		mntmManageVendore.setFont(dcss.fonts("menu"));
		mntmManageVendore.setForeground(dcss.fgcolor("menu"));
		mntmManageVendore.setBackground(dcss.bgcolor("menu"));
		mnPurchase.add(mntmManageVendore);
		
		mntmAddVendore = new JMenuItem(string.AddVen);
		mntmAddVendore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmAddVendore.setPreferredSize(new Dimension(160, 50));
		mntmAddVendore.setFont(dcss.fonts("menu"));
		mntmAddVendore.setForeground(dcss.fgcolor("menu"));
		mntmAddVendore.setBackground(dcss.bgcolor("menu"));
		mnPurchase.add(mntmAddVendore);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(dcss.fgcolor("separator"));
		separator_3.setBackground(dcss.bgcolor("separator"));
		mnPurchase.add(separator_3);
		
		mntmDeleteVendore = new JMenuItem(string.DelVen);
		mntmDeleteVendore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmDeleteVendore.setPreferredSize(new Dimension(160, 50));
		mntmDeleteVendore.setFont(dcss.fonts("menu"));
		mntmDeleteVendore.setForeground(dcss.fgcolor("menu"));
		mntmDeleteVendore.setBackground(dcss.bgcolor("menu"));
		mnPurchase.add(mntmDeleteVendore);
		
		mntmNewSale = new JMenuItem(string.NewSale);
		mntmNewSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewSale.setPreferredSize(new Dimension(160, 50));
		mntmNewSale.setFont(dcss.fonts("menu"));
		mntmNewSale.setForeground(dcss.fgcolor("menu"));
		mntmNewSale.setBackground(dcss.bgcolor("menu"));
		mnSales.add(mntmNewSale);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(dcss.fgcolor("separator"));
		separator_4.setBackground(dcss.bgcolor("separator"));
		mnSales.add(separator_4);
		
		mntmRefund = new JMenuItem(string.Refund);
		mntmRefund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmRefund.setPreferredSize(new Dimension(160, 50));
		mntmRefund.setFont(dcss.fonts("menu"));
		mntmRefund.setForeground(dcss.fgcolor("menu"));
		mntmRefund.setBackground(dcss.bgcolor("menu"));
		mnSales.add(mntmRefund);
		
		mntmMyProfile = new JMenuItem(string.MyPro);
		mntmMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmMyProfile.setPreferredSize(new Dimension(160, 50));
		mntmMyProfile.setFont(dcss.fonts("menu"));
		mntmMyProfile.setForeground(dcss.fgcolor("menu"));
		mntmMyProfile.setBackground(dcss.bgcolor("menu"));
		mnEmployee.add(mntmMyProfile);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(dcss.fgcolor("separator"));
		separator_5.setBackground(dcss.bgcolor("separator"));
		mnEmployee.add(separator_5);
		
		mntmAddUser = new JMenuItem(string.AddEmp);
		mntmAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmAddUser.setPreferredSize(new Dimension(160, 50));
		mntmAddUser.setFont(dcss.fonts("menu"));
		mntmAddUser.setForeground(dcss.fgcolor("menu"));
		mntmAddUser.setBackground(dcss.bgcolor("menu"));
		mnEmployee.add(mntmAddUser);
		
		mntmManageEmployee = new JMenuItem(string.ManEmp);
		mntmManageEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmManageEmployee.setPreferredSize(new Dimension(160, 50));
		mntmManageEmployee.setFont(dcss.fonts("menu"));
		mntmManageEmployee.setForeground(dcss.fgcolor("menu"));
		mntmManageEmployee.setBackground(dcss.bgcolor("menu"));
		mnEmployee.add(mntmManageEmployee);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(dcss.fgcolor("separator"));
		separator_6.setBackground(dcss.bgcolor("separator"));
		mnEmployee.add(separator_6);
		
		mntmDeleteEmployee = new JMenuItem(string.DelEmp);
		mntmDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmDeleteEmployee.setPreferredSize(new Dimension(160, 50));
		mntmDeleteEmployee.setFont(dcss.fonts("menu"));
		mntmDeleteEmployee.setForeground(dcss.fgcolor("menu"));
		mntmDeleteEmployee.setBackground(dcss.bgcolor("menu"));
		mnEmployee.add(mntmDeleteEmployee);
		
		mntmDaily = new JMenuItem(string.Daily);
		mntmDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmDaily.setPreferredSize(new Dimension(160, 50));
		mntmDaily.setFont(dcss.fonts("menu"));
		mntmDaily.setForeground(dcss.fgcolor("menu"));
		mntmDaily.setBackground(dcss.bgcolor("menu"));
		mnReports.add(mntmDaily);
		
		mntmWeekly = new JMenuItem(string.Weekly);
		mntmWeekly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmWeekly.setPreferredSize(new Dimension(160, 50));
		mntmWeekly.setFont(dcss.fonts("menu"));
		mntmWeekly.setForeground(dcss.fgcolor("menu"));
		mntmWeekly.setBackground(dcss.bgcolor("menu"));
		mnReports.add(mntmWeekly);
		
		mntmMonthly = new JMenuItem(string.Monthly);
		mntmMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmMonthly.setPreferredSize(new Dimension(160, 50));
		mntmMonthly.setFont(dcss.fonts("menu"));
		mntmMonthly.setForeground(dcss.fgcolor("menu"));
		mntmMonthly.setBackground(dcss.bgcolor("menu"));
		mnReports.add(mntmMonthly);
		
		mntmHalfYearly = new JMenuItem(string.HalfYear);
		mntmHalfYearly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmHalfYearly.setPreferredSize(new Dimension(160, 50));
		mntmHalfYearly.setFont(dcss.fonts("menu"));
		mntmHalfYearly.setForeground(dcss.fgcolor("menu"));
		mntmHalfYearly.setBackground(dcss.bgcolor("menu"));
		mnReports.add(mntmHalfYearly);
		
		mntmYearly = new JMenuItem(string.Yearly);
		mntmYearly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmYearly.setPreferredSize(new Dimension(160, 50));
		mntmYearly.setFont(dcss.fonts("menu"));
		mntmYearly.setForeground(dcss.fgcolor("menu"));
		mntmYearly.setBackground(dcss.bgcolor("menu"));
		mnReports.add(mntmYearly);
		
	}
	
	
	/**
	 * Creating Menu (Directories)
	 */
	private static void menu() {
		mntmDashboard = new JMenuItem(string.Dboard);
		mntmDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mntmDashboard.setPreferredSize(new Dimension(160, 50));
		mntmDashboard.setFont(dcss.fonts("menu"));
		mntmDashboard.setForeground(dcss.fgcolor("menu"));
		mntmDashboard.setBackground(dcss.bgcolor("menu"));
		menuBar.add(mntmDashboard);
		
		mnInventory = new JMenu(string.Inven);
		mnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnInventory.setPreferredSize(new Dimension(160, 50));
		mnInventory.setMinimumSize(new Dimension(100, 100));
		mnInventory.setFont(dcss.fonts("menu"));
		mnInventory.setForeground(dcss.fgcolor("menu"));
		mnInventory.setBackground(dcss.bgcolor("menu"));
		menuBar.add(mnInventory);
		
		mnPurchase = new JMenu(string.Pur);
		mnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPurchase.setPreferredSize(new Dimension(160, 50));
		mnPurchase.setMinimumSize(new Dimension(100, 100));
		mnPurchase.setFont(dcss.fonts("menu"));
		mnPurchase.setForeground(dcss.fgcolor("menu"));
		mnPurchase.setBackground(dcss.bgcolor("menu"));
		menuBar.add(mnPurchase);
		
		mnSales = new JMenu(string.Sales);
		mnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnSales.setPreferredSize(new Dimension(160, 50));
		mnSales.setMinimumSize(new Dimension(100, 100));
		mnSales.setFont(dcss.fonts("menu"));
		mnSales.setForeground(dcss.fgcolor("menu"));
		mnSales.setBackground(dcss.bgcolor("menu"));
		menuBar.add(mnSales);
		
		mnEmployee = new JMenu(string.Emp);
		mnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnEmployee.setPreferredSize(new Dimension(160, 50));
		mnEmployee.setMinimumSize(new Dimension(100, 100));
		mnEmployee.setFont(dcss.fonts("menu"));
		mnEmployee.setForeground(dcss.fgcolor("menu"));
		mnEmployee.setBackground(dcss.bgcolor("menu"));
		menuBar.add(mnEmployee);
		
		mnReports = new JMenu(string.Rep);
		mnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnReports.setPreferredSize(new Dimension(160, 50));
		mnReports.setFont(dcss.fonts("menu"));
		mnReports.setForeground(dcss.fgcolor("menu"));
		mnReports.setBackground(dcss.bgcolor("menu"));
		menuBar.add(mnReports);
		
		JButton btnLogout = new JButton(string.LogOut);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setPreferredSize(new Dimension(160, 50));
		btnLogout.setMinimumSize(new Dimension(100, 100));
		btnLogout.setFont(dcss.fonts("menu"));
		btnLogout.setForeground(dcss.fgcolor("menu"));
		btnLogout.setBackground(dcss.bgcolor("menu"));
		menuBar.add(btnLogout);
		
		menuitem();

	}
}
