package Front;
import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.*;

public class PrimaryPanel extends JPanel{	
	//Panel
	private ChatPanel chatPanel;
	//private JPanel inputPanel;
	private InputPanel inputPanel;
	private Thread chatThread;
	
	public PrimaryPanel(Socket _socket) {				
		setPreferredSize(new Dimension(520, 820));
		setBackground(Color.white);
		setLayout(null);
		
		chatPanel = new ChatPanel(_socket);
		chatPanel.setBounds(10, 10, 500, 600);
		add(chatPanel);
		
		chatThread = new Thread(chatPanel);
		chatThread.start();
		
		//inputPanel
		inputPanel = new InputPanel(_socket);
		add(inputPanel);			
	}
}
