package com.rufaida.domain.test;

import java.io.Serializable;

public class TestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public String a;
	public String b;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

}
