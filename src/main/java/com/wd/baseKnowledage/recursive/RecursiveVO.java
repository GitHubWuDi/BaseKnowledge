package com.wd.baseKnowledage.recursive;

import java.util.List;

import lombok.Data;

@Data
public class RecursiveVO {

	private String a1;
	private String a2;
	private String a3;
	private RecursiveChildVO a4;
	private List<RecursiveArrayVO> a5;
}
