package com.wd.baseKnowledage.jdk;
/**
* @author wudi
* @version 创建时间：2018年6月21日 下午10:45:17
* @ClassName 类名称
* @Description 类描述
*/
public class JdkTest {

	public static final int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		//testAllocation();
		//testPretenureSizeThreshold();
		testTenuringThreshold();
	}
	
	/**
	 *  -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	public static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 =new byte[2*_1MB];
		allocation2 =new byte[2*_1MB];
		allocation3 =new byte[2*_1MB];
		allocation4 =new byte[4*_1MB];
	}
	
	/**
	 * 大对象直接分配到老年代
	 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
	 */
	public static void testPretenureSizeThreshold(){
		byte[] allocation;
		allocation = new byte[5*_1MB];
	}
	
	/**
	-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:MaxTenuringThreshold=1或者15
	 * 
	 */
	public static void testTenuringThreshold(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 =new byte[_1MB/4];
		allocation2 =new byte[_1MB/4];
		/**
		 * allocation1+allocation2>survior
		 */
		allocation3 =new byte[4*_1MB];
		allocation4 =null;
		allocation4 =new byte[4*_1MB];
	}
	
	
}
