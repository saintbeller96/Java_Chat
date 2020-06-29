package server;

import java.io.*;
import java.util.*;
import java.net.*;

public class MainServer {
	public static ArrayList<PrintWriter> output_list;
	public static ArrayList<Integer> room_list;

	public static void main(String[] args) {
		output_list = new ArrayList<PrintWriter>();
		room_list = new ArrayList<Integer>();
		try {
			ServerSocket s_socket = new ServerSocket(7777);
			while(true) {
				Socket c_socket = s_socket.accept();
				ManagerThread m_thread = new ManagerThread();
				m_thread.setSocket(c_socket);
				
				output_list.add(new PrintWriter(c_socket.getOutputStream()));
				
				m_thread.start();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
