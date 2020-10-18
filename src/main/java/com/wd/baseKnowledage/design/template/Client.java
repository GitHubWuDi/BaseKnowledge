package com.wd.baseKnowledage.design.template;

public class Client {
    
	public static void main(String[] args) {
		AbstractTemplateClass abstractTemplateClass = new ConcreteTemplate();
		abstractTemplateClass.templateMethod();
	}
}
