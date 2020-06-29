package Front;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.*;

import client.Client;

public class ChatPanel extends JPanel implements Runnable{
	
	private JScrollPane scroll;
	private JPanel panel;
	private Socket _socket;
	int cur;
	
	public ChatPanel(Socket _socket) {		
		this._socket = _socket;
		MainFrame.chatList = new ArrayList<SubChatPanel>();
		cur = 5;
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setLayout(null);
		
		panel = new JPanel();	
		panel.setLayout(null);
			
		scroll = new JScrollPane(panel);
		scroll.setBounds(10, 10, 480, 580);
		scroll.setHorizontalScrollBar(null);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scroll);	
	}
	
	public void run() {
		try {
			BufferedReader buff = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			String receiveString, line;
			String[] split;
			while(true) {
				StringBuilder strb = new StringBuilder();
				int numofLines = 0;
				while((line = buff.readLine())!=null) {
					if(line.equals("\\e"))
						break;
					strb.append(line +"\n");	
					numofLines++;
				}
				receiveString = strb.deleteCharAt(strb.length()-1).toString();
				//문자열의 길이가 TextArea의 길이를 초과하면 줄의 개수를 늘려줌
				int lengthofString = (int)receiveString.length();
				if(numofLines == 1 && lengthofString >= 38 ) {				
					numofLines = (int)(lengthofString/38) +1;
				}
				
				split = receiveString.split(">");
				if(split.length >= 2 && split[0].equals(Client.user_id)) {
					this.appendChat(null, split[1], numofLines, 1);
				}//본인의 채팅
				else if(split.length >= 2 && !split[0].equals(Client.user_id)) {
					this.appendChat(split[0], split[1],numofLines, 2);
				}//상대방의 채팅
				else if(split.length == 1){
					this.appendChat(null, receiveString,numofLines, 3);
				}//누군가 입장했을 때
			}				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void appendChat(String id, String text, int lines,  int mode) {
		SubChatPanel p;
		if(mode == 1) {
			p = new MyChatPanel(text, new Rectangle(5, cur, 450, 20*lines));
			cur += 20*lines +10;
		}
		else if(mode == 2) {
			p = new UserChatPanel(id, text, new Rectangle(5, cur, 450, 38*lines));
			cur += 38*lines +10;
		}
		else{
			p = new EntranceChatPanel(text, new Rectangle(5, cur, 450, 20));
			cur += 20*lines + 10;
		}
		
		//패널 크기 조정 후 SubChatPanel 삽입
		panel.setPreferredSize(new Dimension(480, cur + 15));	
		panel.add(p);
		panel.updateUI();
		
		MainFrame.chatList.add(p);
		//스크롤을 가장 아래로
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
	}

}
