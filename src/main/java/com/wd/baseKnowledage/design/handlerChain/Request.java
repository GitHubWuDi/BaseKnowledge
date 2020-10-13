package com.wd.baseKnowledage.design.handlerChain;

import lombok.Data;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月13日 上午8:19:17
* 类说明
*/
@Data
public class Request {
     
	private String requestType;  //请假类型
	private Integer number; //请假天数
}
