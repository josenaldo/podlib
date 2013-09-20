package com.jnaldo.podoteca.model;

public abstract class EntidadeBase {

	protected Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNovo() {
		return (this.id == null);
	}
}
