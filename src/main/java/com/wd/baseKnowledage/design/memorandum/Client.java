package com.wd.baseKnowledage.design.memorandum;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月27日 上午9:15:53
* 类说明
*/
public class Client {

	public static void main(String[] args) {
		GameRole gameRole = new GameRole();
		gameRole.initState();  //初始化状态
		gameRole.showState("初始状态：");
		RoleStateManager roleStateManager = new RoleStateManager(); //角色状态管理机制
		roleStateManager.setRoleMemorandum(gameRole.saveState());   //存储状态
		gameRole.fight(); 
		gameRole.showState("战斗以后：");
		gameRole.recoveryState(roleStateManager.getRoleMemorandum());
		gameRole.showState("重新去读取存档以后：");
		
	}
	
	
	
}
