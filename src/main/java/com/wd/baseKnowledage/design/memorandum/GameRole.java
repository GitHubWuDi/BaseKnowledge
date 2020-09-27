package com.wd.baseKnowledage.design.memorandum;

import lombok.Data;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月27日 上午8:49:14
* 类说明
*/
@Data
public class GameRole {
    private Long vitality;
    private Long attack;
    private Long defense;


  public void showState(String name) {
	  System.out.println(name+"\n 生命力："+this.vitality+"\n 攻击力："+this.attack+"\n 防御力："+this.defense);
  }
   
  
  public void initState() {
	  this.vitality = 100L;
	  this.attack = 100L;
	  this.defense = 100L;
  }
  
  
  /**
   * 存储备份状态
   * @return
   */
  public RoleMemorandum saveState() {
	   RoleMemorandum roleMemorandum = new RoleMemorandum(vitality, attack, defense);
	   return roleMemorandum;
  }
  
  public void recoveryState(RoleMemorandum roleMemorandum) {
	  this.vitality = roleMemorandum.getVit();
	  this.attack = roleMemorandum.getAck();
	  this.defense = roleMemorandum.getDef();
  }
  
  
  public void fight() {
	  this.vitality = 0L;
	  this.attack = 0L;
	  this.defense = 0L;
  }
  
  

}
