/*
 * **************************************************************************************************
 * **************************************************************************************************
 * Special notes
 * Inventory is only visible to accounts 
 * Purchase-> make new order is visible to manager and all other 
 * ************************************************purchase will be visible to accounts
 * sales is visible to manager and sales man
 * employee-my profile is visible to all
 * other employee options is only visible to hr
 * reports is only visible to manager and management
 * **************************************************************************************************
 * **************************************************************************************************
 */

package main;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import Resource.design;
import Resource.string;



public class MainWindow {

    /**
     * Variable Declaration
     */
	private static JMenuBar menuBar;
    private static JMenuItem mntmDashboard;
    private static JMenuItem mnInventory;
    private static JMenuItem mntmInventoryList;
    private static JMenuItem mntmManageProduct;
    private static JMenuItem mntmAddProduct;
    private static JMenuItem mntmDeleteProduct;
    private static JMenuItem mntmPurchaseHistory;
    private static JMenuItem mntmVendoreList;
    private static JMenuItem mntmManageVendore;
    private static JMenuItem mntmAddVendore;
    private static JMenuItem mntmDeleteVendore;
    private static JMenuItem mntmNewSale;
    private static JMenuItem mntmRefund;
    private static JMenuItem mntmMyProfile;
    private static JMenuItem mntmAddUser;
    private static JMenuItem mntmManageEmployee;
    private static JMenuItem mntmDeleteEmployee;
    private static JMenuItem mntmDaily;
    private static JMenuItem mntmWeekly;
    private static JMenuItem mntmMonthly;
    private static JMenuItem mntmHalfYearly;
    private static JMenuItem mntmYearly;
    private static JMenuItem mntmMakeNew;
    private static JMenu mnReports;
    private static JMenu mnEmployee;
    private static JMenu mnSales;
    private static JMenu mnPurchase;
    private static JTabbedPane leftMainTab;
    private static JInternalFrame sales;
    private static JInternalFrame estimates;
    private static JInternalFrame products;
    private static JInternalFrame register;
    private static JInternalFrame employee;
    private static JLayeredPane reports;
    private static JTabbedPane tab_sales;
    private static JInternalFrame newSalesPOS;
    private static JInternalFrame salesOrder;
    private static JInternalFrame salesEdit;
    private static JInternalFrame salesExchangeorReturn;
    private static JInternalFrame salesCancel;
    private static JInternalFrame salesPrintReceipt;
    private static JTabbedPane tab_estimates;
    private static JInternalFrame addEsimates;
    private static JInternalFrame editEstimates;
    private static JInternalFrame deleteEstimates;
    private static JInternalFrame approveEstimates;
    private static JInternalFrame denyEstimates;
    private static JInternalFrame generateOrderEstimates;
    private static JInternalFrame printEstimates;
    private static JTabbedPane tab_products;
    private static JInternalFrame addProduct;
    private static JInternalFrame editProducts;
    private static JInternalFrame dProducts;
    private static JInternalFrame productStock;
    private static JInternalFrame label;
    private static JInternalFrame expiri;
    private static JInternalFrame disabled;
    private static JInternalFrame showall;
    private static JTabbedPane tab_register;

    private static JInternalFrame CloseRegister;
    private static JInternalFrame Withdraw;
    private static JInternalFrame addMoney;
    private static JInternalFrame RegisterTotal;

    private static JTabbedPane tab_emp;

    private static JInternalFrame addEmp;
    private static JInternalFrame editEmp;
    private static JInternalFrame delEmp;
    private static JInternalFrame deacEmp;
    private static JInternalFrame copyEmp;
    private static JButton btnLogout = new JButton();
    
    private String uName;
    private String usertype;
    private int employeeID;

    /**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName the uName to set
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}

	/**
	 * @return the usertype
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
     * Calling objects
     */
    static design dcss = new design();
    static users.userLogin ul = new users.userLogin();

    public static JFrame frmidotsStoreManagement;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    MainWindow.frmidotsStoreManagement.setVisible(true);


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
    	if(employeeID==0) {
        initialize("", "", 0);
    	}else {
    		initialize(getuName(), getUsertype(), getEmployeeID());
    	}
    }




    /**
     * Initialize the contents of the frame.
     */
    public static void initialize(String uname, String utype, int id) {
        frmidotsStoreManagement = new JFrame();
        frmidotsStoreManagement.setBounds(0, 0, 1280, 720);
        frmidotsStoreManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmidotsStoreManagement.getContentPane().setForeground(dcss.fgcolor("title"));
        frmidotsStoreManagement.getContentPane().setBackground(dcss.bgcolor("mainback"));
        frmidotsStoreManagement.getContentPane().setLayout(
        		new BoxLayout(frmidotsStoreManagement.getContentPane(), BoxLayout.X_AXIS));
        leftMainTab = new JTabbedPane(JTabbedPane.LEFT);
        
        if(utype.isEmpty()) {
        	leftMainTab.setEnabled(false);
            frmidotsStoreManagement.getContentPane().add(leftMainTab);
            btnLogout.setText(string.logout);
            
            
            //menu bar
            menubar();
        } else if (utype.equals("manager")){
            	leftMainTab.setEnabled(true);
                frmidotsStoreManagement.getContentPane().add(leftMainTab);
                btnLogout.setText(string.login);
                
                
                //menu bar
                menubar();
                
            	
        }
        



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
				ul.setVisible(true);
			}
		});
		btnLogout.setPreferredSize(new Dimension(160, 50));
		btnLogout.setMinimumSize(new Dimension(100, 100));
		btnLogout.setFont(dcss.fonts("menu"));
		btnLogout.setForeground(dcss.fgcolor("menu"));
		btnLogout.setBackground(dcss.bgcolor("menu"));
		menuBar.add(btnLogout);
		
		menuitem();
		sales(); estimates(); products();users();register();
	}



   
    public static void sales() {
        sales = new JInternalFrame("Sales");
        sales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                visibility("sales");

            }
        });
        leftMainTab.addTab(string.Sales, null, sales, null);
        sales.getContentPane().setLayout(new BorderLayout(0, 0));

        tab_sales = new JTabbedPane(JTabbedPane.TOP);
        sales.getContentPane().add(tab_sales);

        newSalesPOS = new JInternalFrame("New Sales - POS");
        tab_sales.addTab("New Sales - POS", null, newSalesPOS, null);

        salesOrder = new JInternalFrame("Order");
        tab_sales.addTab("Order", null, salesOrder, null);

        salesEdit = new JInternalFrame("Edit");
        tab_sales.addTab("Edit", null, salesEdit, null);

        salesExchangeorReturn = new JInternalFrame("Exchange / Return");
        tab_sales.addTab("Exchange / Return", null, salesExchangeorReturn, null);

        salesCancel = new JInternalFrame("Cancel");
        tab_sales.addTab("Cancel", null, salesCancel, null);

        salesPrintReceipt = new JInternalFrame("Print Receipt");
        tab_sales.addTab("Print Receipt", null, salesPrintReceipt, null);

    }

    public static void estimates() {
        estimates = new JInternalFrame(string.est);
        estimates.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visibility("estimates");
            }
        });
        leftMainTab.addTab(string.est, null, estimates, null);
        estimates.getContentPane().setLayout(new BorderLayout(0, 0));

        tab_estimates = new JTabbedPane(JTabbedPane.TOP);
        estimates.getContentPane().add(tab_estimates);

        addEsimates = new JInternalFrame("Add");
        tab_estimates.addTab("Add", null, addEsimates, null);

        editEstimates = new JInternalFrame("Edit");
        tab_estimates.addTab("Edit", null, editEstimates, null);

        deleteEstimates = new JInternalFrame("Delete");
        tab_estimates.addTab("Delete", null, deleteEstimates, null);

        approveEstimates = new JInternalFrame("Approve");
        tab_estimates.addTab("Approve", null, approveEstimates, null);

        denyEstimates = new JInternalFrame("Deny");
        tab_estimates.addTab("Deny", null, denyEstimates, null);

        generateOrderEstimates = new JInternalFrame("Generate Order");
        tab_estimates.addTab("Generate Order", null, generateOrderEstimates, null);

        printEstimates = new JInternalFrame("Print");
        tab_estimates.addTab("Print", null, printEstimates, null);

    }

    public static void products() {

        products = new JInternalFrame(string.product);
        products.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visibility("products");
            }
        });
        leftMainTab.addTab(string.product, null, products, null);
        products.getContentPane().setLayout(new BorderLayout(0, 0));

        tab_products = new JTabbedPane(JTabbedPane.TOP);
        products.getContentPane().add(tab_products);

        addProduct = new JInternalFrame("Add");
        tab_products.addTab("Add", null, addProduct, null);

        editProducts = new JInternalFrame("Edit Products");
        tab_products.addTab("Edit Products", null, editProducts, null);

        dProducts = new JInternalFrame("Delete Products");
        tab_products.addTab("Delete Products", null, dProducts, null);

        productStock = new JInternalFrame("Stocks");
        tab_products.addTab("Stocks", null, productStock, null);

        label = new JInternalFrame("Label");
        tab_products.addTab("Label", null, label, null);

        expiri = new JInternalFrame("Expiration");
        tab_products.addTab("Expiration", null, expiri, null);

        disabled = new JInternalFrame("disabled");
        tab_products.addTab("disabled", null, disabled, null);

        showall = new JInternalFrame("showall");
        tab_products.addTab("showall", null, showall, null);



    }

    public static void register() {
        register = new JInternalFrame(string.regi);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visibility("register");
            }
        });
        leftMainTab.addTab(string.regi, null, register, null);
        register.getContentPane().setLayout(new BorderLayout(0, 0));

        tab_register = new JTabbedPane(JTabbedPane.TOP);
        register.getContentPane().add(tab_register);

        CloseRegister = new JInternalFrame("Close Register");
        tab_register.addTab("Close Register", null, CloseRegister, null);

        RegisterTotal = new JInternalFrame("Total");
        tab_register.addTab("Total", null, RegisterTotal, null);


        addMoney = new JInternalFrame("Add Money");
        tab_register.addTab("Add Money", null, addMoney, null);


        Withdraw = new JInternalFrame("Withdraw Cash");
        tab_register.addTab("Withdraw Cash", null, Withdraw, null);

    }

    public static void users() {


        employee = new JInternalFrame(string.Emp);
        employee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visibility("employee");
            }
        });
        leftMainTab.addTab(string.Emp, null, employee, null);
        employee.getContentPane().setLayout(new BorderLayout(0, 0));

        tab_emp = new JTabbedPane(JTabbedPane.TOP);
        employee.getContentPane().add(tab_emp);

        addEmp = new JInternalFrame("New Employee");
        tab_emp.addTab("New Employee", null, addEmp, null);

        editEmp = new JInternalFrame("Edit Employee");
        tab_emp.addTab("Edit Employee", null, editEmp, null);

        delEmp = new JInternalFrame("Delete Employee");
        tab_emp.addTab("Delete Employee", null, delEmp, null);

        deacEmp = new JInternalFrame("Deactive Employee");
        tab_emp.addTab("Deactive Employee", null, deacEmp, null);

        copyEmp = new JInternalFrame("Copy Employee");
        tab_emp.addTab("Copy Employee", null, copyEmp, null);

        reports = new JLayeredPane();
        leftMainTab.addTab(string.Rep, null, reports, null);
    }

    private static String visibility(String a) {

        switch (a) {
            case "sales":
                salesPrintReceipt.setVisible(true);
                salesCancel.setVisible(true);
                salesExchangeorReturn.setVisible(true);
                salesEdit.setVisible(true);
                salesOrder.setVisible(true);
                newSalesPOS.setVisible(true);
                break;
            case "estimates":
                printEstimates.setVisible(true);
                generateOrderEstimates.setVisible(true);
                denyEstimates.setVisible(true);
                approveEstimates.setVisible(true);
                deleteEstimates.setVisible(true);
                editEstimates.setVisible(true);
                addEsimates.setVisible(true);
                break;

            case "register":
                CloseRegister.setVisible(true);
                Withdraw.setVisible(true);
                addMoney.setVisible(true);
                RegisterTotal.setVisible(true);
                break;
            case "products":
                productStock.setVisible(true);
                label.setVisible(true);
                expiri.setVisible(true);
                disabled.setVisible(true);
                showall.setVisible(true);
                dProducts.setVisible(true);
                editProducts.setVisible(true);
                addProduct.setVisible(true);
                break;
        }
        return a;
    }



}