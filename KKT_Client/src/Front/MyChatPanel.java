package Front;
import java.awt.*;
import javax.swing.*;


public class MyChatPanel extends SubChatPanel{
	
	public MyChatPanel(String text, Rectangle r) {		
		this.setBounds(r);
		//this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setLayout(new GridLayout(1, 2));
		//this.setLayout(new BorderLayout());
		init(text);
	}
	
	@Override
	public void init(String text) {		
		chatArea = new JTextArea(text);
		chatArea.setBackground(Color.yellow);
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setColumns(10);
		chatArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		chatArea.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));	
		
		numofReadLabel = new JLabel("1");
		numofReadLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		numofReadLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.add(numofReadLabel);
		this.add(chatArea);	
	}
	

}