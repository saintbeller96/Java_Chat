package Front;
import java.awt.Rectangle;

import javax.swing.*;

public abstract class SubChatPanel extends JPanel{
	protected JLabel numofReadLabel;
	protected JTextArea chatArea;
	protected int numofRead;
	
	public abstract void init(String text);
}