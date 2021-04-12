package com.wd.baseKnowledage.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.google.gson.Gson;
import com.wd.baseKnowledage.util.VO.NetWork;

public class UdpTool {

	
	public static void main(String[] args) {
		String netWorkJson = getNetWorkJson();
		while(true) {
			try {
				DatagramSocket datagramSocket = new DatagramSocket();
				DatagramPacket datagramPacket = new DatagramPacket(netWorkJson.getBytes(),netWorkJson.getBytes().length,InetAddress.getByName("192.168.120.103"),6666);
				//发送
				System.out.println("正在准备发送……");
				datagramSocket.send(datagramPacket);
				System.out.println("已发送……");
				datagramSocket.close();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	private static String getNetWorkJson() {
		NetWork netWork = new NetWork();
		netWork.setDstIps("192.168.115.118");
		netWork.setIfOutDiscards(150);
		netWork.setIp("192.168.120");
		netWork.setRelated_ip("192.168.115.117");
		netWork.setEvent_Table_Name("network");
		Gson gson = new Gson();
		String json = gson.toJson(netWork);
		return json;
	}
	
	
}
