package Front;
import javax.swing.*;

import client.Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class MainFrame {
	public static ArrayList<SubChatPanel> chatList;
	private PrimaryPanel primary;
	public Socket _socket;

	public MainFrame() {	
		Client.user_id = (String)JOptionPane.showInputDialog("Enter your nickname");
		
		JFrame frame = new JFrame("KOKOA Talk");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		try {
			//ip와 port 번호 입력
			_socket = new Socket("192.168.0.4", 7777);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		primary = new PrimaryPanel(_socket);
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}
