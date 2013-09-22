package com.jnaldo.podoteca.util.message;

public enum NivelDoAlerta {

	SUCCESS("success"), INFO("info"), ALERT("alert"), DANGER("danger");

	private String name;

	private NivelDoAlerta(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
