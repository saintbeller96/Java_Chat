package Front;
import javax.swing.*;

import client.Client;

import java.awt.*;

public class UserChatPanel extends SubChatPanel{
	private JLabel userLabel;
	private GridBagConstraints gbc;
	
	public UserChatPanel(String id, String text, Rectangle r) {				
		this.setBounds(r);
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		userLabel = new JLabel(id);	
		userLabel.setFont(new Font("µ¸¿ò", Font.BOLD, 17));

		init(text);
	}
	
	@Override
	public void init(String text) {		
		chatArea = new JTextArea(text);
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setColumns(10);
		chatArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		chatArea.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));	
		
		numofReadLabel = new JLabel("1");
		numofReadLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		numofReadLabel.setHorizontalAlignment(SwingConstants.LEFT);		
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;	
		setGrid(0, 0, 1, 1);		
		this.add(userLabel, gbc);	
		gbc.weighty = 4.0;	
		setGrid(0, 1, 1, 1);
		this.add(chatArea, gbc);
		setGrid(1, 1, 1, 1);
		gbc.ipadx = 220;
		this.add(numofReadLabel, gbc);
	}
	
	private void setGrid(int x, int y, int w,int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		
	}
}
