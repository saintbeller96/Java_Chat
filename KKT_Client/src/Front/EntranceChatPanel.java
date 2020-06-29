package Front;
import java.awt.Rectangle;

import javax.swing.*;

public class EntranceChatPanel extends SubChatPanel{
	
	private JLabel idLabel;
	public EntranceChatPanel(String text, Rectangle r) {
		idLabel = new JLabel(text);
		this.setBounds(r);
		this.add(idLabel);
	}
	@Override
	public void init(String text) {}
}
