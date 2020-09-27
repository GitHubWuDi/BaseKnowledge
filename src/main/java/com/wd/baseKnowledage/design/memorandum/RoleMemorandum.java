package com.wd.baseKnowledage.design.memorandum;

import lombok.Data;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月27日 上午8:56:58
* 类说明   角色备份信息
*/
@Data
public class RoleMemorandum {
     
	private Long vit;
	private Long ack;
	private Long def;
	
	
	public RoleMemorandum(Long vit,Long ack,Long def) {
		this.vit = vit;
		this.ack = ack;
		this.def = def;
	}
	
}
