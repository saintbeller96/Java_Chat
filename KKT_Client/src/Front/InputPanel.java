package Front;
import javax.swing.*;

import client.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.io.*;

public class InputPanel extends JPanel{
	private JButton inputButton;
	private JTextArea inputText;
	private JScrollPane inputScroll;
	private InputListener inputListener;
	
	private Socket _socket;
	private PrintWriter send_writer;
	
	public InputPanel(Socket _s) {
		_socket = _s;
		inputListener = new InputListener();
		
		try {
			send_writer = new PrintWriter(_socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		send_writer.println("ID::" + Client.user_id);
		send_writer.println("\\e");
		send_writer.flush();
		
		setLayout(null);
		setBounds(10, 620, 500, 190);
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.lightGray));
		setLayout(new FlowLayout());
		
		inputText = new JTextArea(10, 38);
		inputText.setLayout(null);
		inputText.setLineWrap(true);
		inputText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		inputScroll = new JScrollPane(inputText);
		inputScroll.setBounds(10, 10, 450, 150);
		inputScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		inputScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
		add(inputScroll);
		
		inputButton = new JButton("Àü¼Û");
		inputButton.addActionListener(inputListener);
		add(inputButton);
	}
	
	private class InputListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String sendString = inputText.getText();		
			if(!sendString.equals("")) {
				send_writer.println(sendString);
				send_writer.println("\\e");
				send_writer.flush();
				inputText.setText("");
			}		
		}	
	}
	
	
}
