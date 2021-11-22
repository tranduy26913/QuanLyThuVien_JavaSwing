package GUI;

import javax.swing.JOptionPane;

public class Alert {
	static public void ShowMessageInfo(String msg,String title) {
		JOptionPane optionPane = new JOptionPane();
		optionPane.showMessageDialog(null, msg, title,
				JOptionPane.INFORMATION_MESSAGE);
	}
	static public void ShowMessageWarn(String msg,String title) {
		JOptionPane optionPane = new JOptionPane();
		optionPane.showMessageDialog(null, msg, title,
				JOptionPane.WARNING_MESSAGE);
	}
	static public void ShowMessageError(String msg,String title) {
		JOptionPane optionPane = new JOptionPane();
		optionPane.showMessageDialog(null, msg, title,
				JOptionPane.ERROR_MESSAGE);
	}
}
