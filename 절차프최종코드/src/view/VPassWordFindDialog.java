package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Constant.PassWordFindDialog;
import model.MStudent;

public class VPassWordFindDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	// attributes

	
	// components		
	private JLabel IdLabel;
	private JTextField IdTextField;
	private JLabel NameLabel;
	private JTextField NameTextField;
	private JButton verifyButton;
	
	private Vector<MStudent> studentList;
	
	// constructor
	public VPassWordFindDialog(Vector<MStudent> studentList) {
		// attributes
		this.setTitle(PassWordFindDialog.TITLE);
		this.setIconImage(PassWordFindDialog.ICON);
		this.setSize(PassWordFindDialog.WIDTH, PassWordFindDialog.HEIGHT);
		this.setLocationRelativeTo(null);
		
		// layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.WEST;
		
		// components
		this.studentList = studentList;
		ActionHandler actionHandler = new ActionHandler();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.IdLabel = new JLabel(PassWordFindDialog.ID_LABEL);
		this.add(this.IdLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.IdTextField = new JTextField(PassWordFindDialog.TEXT_SIZE);
		this.add(this.IdTextField,  gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		this.NameLabel = new JLabel(PassWordFindDialog.NAME_LABEL);
		this.add(this.NameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.NameTextField = new JTextField(PassWordFindDialog.TEXT_SIZE);
		this.add(this.NameTextField, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		this.verifyButton = new JButton(PassWordFindDialog.VERIFY_BUTTON_TEXT);
		this.verifyButton.addActionListener(actionHandler);
		this.add(this.verifyButton, gbc);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	// methods
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == verifyButton) {
				findPassword();
			}
		}
	}
	
	// 비밀번호를 찾는 메소드
	private void findPassword() {
		String id = this.IdTextField.getText();
		String name = this.NameTextField.getText();
		for(MStudent mStudent : this.studentList) {
			if (mStudent.getId().equals(id) && mStudent.getName().equals(name)) {
				JOptionPane.showMessageDialog(null, PassWordFindDialog.SUCCESS_MESSAGE + mStudent.getPassword(), null, JOptionPane.INFORMATION_MESSAGE);
				break;
			}else {
				JOptionPane.showMessageDialog(null, PassWordFindDialog.FAIL_MESSAGE, null, JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}

	
}
