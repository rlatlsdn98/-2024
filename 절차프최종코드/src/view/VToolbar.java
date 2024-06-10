package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import constants.Constant.Toolbar;

public class VToolbar extends JToolBar {
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private JButton LogOutButton;
	
	// associate
	private VMainFrame vMainFrame;
	public void associate(VMainFrame vMainFrame) { this.vMainFrame = vMainFrame; }
	
	// constructor
	public VToolbar() {
		// attribute
		this.setRollover(true);
		this.setFloatable(false);
		
		// component
		ActionHandler actionHandler = new ActionHandler();
		this.LogOutButton = new JButton(Toolbar.LOGOUT_BUTTON_TEXT);
		this.LogOutButton.addActionListener(actionHandler);
		this.add(this.LogOutButton);
	}
	
	// methods
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == LogOutButton) { // 로그아웃 버튼 클릭시
				if (vMainFrame != null) {
					int response = JOptionPane.showConfirmDialog(null, Toolbar.DIALOG_MESSAGE, Toolbar.DIALOG_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {						
						vMainFrame.switchToLogInPanel();
						vMainFrame.LogInReset();
					}
				}
			}
		}
	}
	
}// class
