package com.wd.baseKnowledage.util.VO;

import lombok.Data;

@Data
public class NetWork {

	private String ip;
	private Integer ifOutDiscards; 
	private String related_ip;
	private String dstIps;
	private String Event_Table_Name;
}
