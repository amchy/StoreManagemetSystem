package Resource;
import java.awt.Color;
import java.awt.Font;

public class design {
	
	
	/**
	 * 
	 * @param Foreground color
	 * @return color
	 */
public Color fgcolor(String colorfor) {
		
		/**
		 * Check for the use of the BackgroundColor
		 */
		if(colorfor.equals("body")) {
			Color body = Color.BLUE;
			return body;
		}else if(colorfor.equals("header1")) {
			Color header1 = Color.BLUE;
			return header1;
		}else if(colorfor.equals("header2")) {
			Color header2 = Color.BLUE;
			return header2;
		}else if(colorfor.equals("header3")) {
			Color header3 = Color.BLUE;
			return header3;
		}else if(colorfor.equals("header4")) {
			Color header4 = Color.BLUE;
			return header4;
		}else if(colorfor.equals("header5")) {
			Color header5 = Color.BLUE;
			return header5;
		}else if(colorfor.equals("header6")) {
			Color header6 = Color.BLUE;
			return header6;
		}else if(colorfor.equals("link")) {
			Color link = Color.BLUE;
			return link;
		}else if(colorfor.equals("report")) {
			Color report = Color.BLUE;
			return report;
		}else if(colorfor.equals("error")) {
			Color error = Color.RED;
			return error;
		}else if(colorfor.equals("buttn")) {
			Color buttn = Color.WHITE;
			return buttn;
		}else if(colorfor.equals("menu")) {
			Color menu = Color.WHITE;
			return menu;
		}else if(colorfor.equals("separator")) {
			Color separator = Color.WHITE;;
			return separator;
		}else if(colorfor.equals("title")) {
			Color title = Color.WHITE;;
			return title;
		}
		
		return null;
	}
	
	
	
	/**
	 * 
	 * @param Background color
	 * @return color
	 */
public Color bgcolor(String colorfor) {
		
		/**
		 * Check for the use of the BackgroundColor
		 */
	
		if(colorfor.equals("body")) {
			Color body = Color.BLUE;
			return body;
		}else if(colorfor.equals("header1")) {
			Color header1 = Color.BLUE;
			return header1;
		}else if(colorfor.equals("header2")) {
			Color header2 = Color.BLUE;
			return header2;
		}else if(colorfor.equals("header3")) {
			Color header3 = Color.BLUE;
			return header3;
		}else if(colorfor.equals("header4")) {
			Color header4 = Color.BLUE;
			return header4;
		}else if(colorfor.equals("header5")) {
			Color header5 = Color.BLUE;
			return header5;
		}else if(colorfor.equals("header6")) {
			Color header6 = Color.BLUE;
			return header6;
		}else if(colorfor.equals("link")) {
			Color link = Color.BLUE;
			return link;
		}else if(colorfor.equals("report")) {
			Color report = Color.BLUE;
			return report;
		}else if(colorfor.equals("error")) {
			Color error = Color.RED;
			return error;
		}else if(colorfor.equals("buttn")) {
			Color buttn = Color.BLUE;
			return buttn;
		}else if(colorfor.equals("menu")) {
			Color menu = Color.BLUE;
			return menu;
		}else if(colorfor.equals("separator")) {
			Color separator = Color.GREEN;;
			return separator;
		}else if(colorfor.equals("mainback")) {
			Color mainback = Color.DARK_GRAY;
			return mainback;
		}
		
		return null;
	}
	
	
	
	/***
	 * 
	 * @param Font size and Font Family type
	 * @return Font style Default return null
	 */
	
	public Font fonts(String fontfor) {
		
		/**
		 * Check for the use for the font
		 */
		if(fontfor.equals("body")) {
			Font body = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 14);
			return body;
		}else if(fontfor.equals("header1")) {
			Font header1 = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 22);
			return header1;
		}else if(fontfor.equals("header2")) {
			Font header2 = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 20);
			return header2;
		}else if(fontfor.equals("header3")) {
			Font header3 = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 18);
			return header3;
		}else if(fontfor.equals("header4")) {
			Font header4 = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 16);
			return header4;
		}else if(fontfor.equals("header5")) {
			Font header5 = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 14);
			return header5;
		}else if(fontfor.equals("header6")) {
			Font header6 = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 12);
			return header6;
		}else if(fontfor.equals("link")) {
			Font link = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 12);
			return link;
		}else if(fontfor.equals("report")) {
			Font report = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 14);
			return report;
		}else if(fontfor.equals("error")) {
			Font error = new Font("Adobe Fan Heiti Std B", Font.PLAIN, 15);
			return error;
		}else if(fontfor.equals("buttn")) {
			Font buttn = new Font("Segoe UI Symbol", Font.ITALIC, 14);
			return buttn;
		}else if(fontfor.equals("menu")) {
			Font menu = new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 16);
			return menu;
		}else if(fontfor.equals("separator")) {
			Font separator = new Font("Segoe UI Symbol", Font.ITALIC, 14);
			return separator;
		}
		
		return null;
	}
	
	
	
	

}
