package com.wd.baseKnowledage.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {

	public static void main(String[] args) {
		while(true) {
			try {
				DatagramSocket datagramSocket = new DatagramSocket(6666);
				byte[] b = new byte[1024];
				DatagramPacket datagramPacket = new DatagramPacket(b,b.length);
				System.out.println("正在准备接收……");
				//未接收之前为阻塞状态
				datagramSocket.receive(datagramPacket);
				System.out.println("接收内容："+new String(b,0,b.length));
				System.out.println("已经接收……");
				datagramSocket.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
}
