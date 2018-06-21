package com.wd.baseKnowledage.proxy.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import lombok.Data;

/**
 * @author wudi
 * @version 创建时间：2018年5月24日 下午11:04:09
 * @ClassName 类名称
 * @Description 动态获得类成员
 */
@Data
public class User {

	private String guid; // guid
	private String name; // 名称
	private String sex; // 性别

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		User user = new User();
		user.setGuid("1");
		user.setName("wudi");
		user.setSex("men");
		String userStr = gson.toJson(user);
		try {
			Class<?> clazz = Class.forName("com.wd.baseKnowledage.proxy.model.User");
			Object object = gson.fromJson(userStr, clazz);
			Class<? extends Object> class1 = object.getClass();
			Field[] declaredFields = class1.getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				Object object2 = field.get(object);
				map.put(field.getName(), object2);
			}
			System.out.println(map);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
