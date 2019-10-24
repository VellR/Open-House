package com.perscholas.objects_class_variables;

public class ClassOne {
	//String string1;
	public String string1;
	public String string2;
	//protected String string3;
	public String string3;
	private String string4;
	
	public ClassOne() {
		string1 = "String One";
		string2 = "String Two";
		string3 = "String Three";
		setString4("String Four");
	}

	public String getString4() {
		return string4;
	}

	public void setString4(String string4) {
		this.string4 = string4;
	}
}
