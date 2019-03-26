import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Resource.design;
import Resource.string;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfUName;
	private JTextField tfPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		design dcss = new design();
		contentPane.setLayout(new MigLayout("", "[72px][5px][12px][143px][89px][][][][][][][][][][][][][][]", "[40px][40px][23px][][][][][][][][][][][][][][][][][][]"));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UserLogin.class.getResource("/Resource/Images/log-clipart-user-login-672384-4775856.png")));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(label, "cell 4 3");
		
		JLabel jlUName = new JLabel(string.uname);
		jlUName.setFont(dcss.fonts("body"));
		contentPane.add(jlUName, "cell 4 8,growx,aligny center");
		
		tfUName = new JTextField();
		tfUName.setFont(dcss.fonts("body"));
		contentPane.add(tfUName, "cell 6 8 5 1,alignx left,growy");
		tfUName.setColumns(10);
		
		JLabel jLPwd = new JLabel(string.pwd);
		jLPwd.setFont(dcss.fonts("body"));
		contentPane.add(jLPwd, "cell 4 9,alignx left,aligny center");
		
		tfPwd = new JTextField();
		tfPwd.setFont(dcss.fonts("body"));
		contentPane.add(tfPwd, "cell 6 9 5 1,alignx left,growy");
		tfPwd.setColumns(10);
		
		JButton btnLogin = new JButton(string.login);
		btnLogin.setForeground(dcss.fgcolor("buttn"));
		btnLogin.setFont(dcss.fonts("buttn"));
		btnLogin.setBackground(dcss.bgcolor("buttn"));
		contentPane.add(btnLogin, "cell 11 10,grow");
	}
}
