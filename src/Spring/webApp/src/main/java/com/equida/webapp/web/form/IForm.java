package com.equida.webapp.web.form;

public abstract class IForm<T> {
	
	private boolean isCreation = true;

	public IForm() {
		this(true);
	}
	
	public IForm(boolean isCreation) {
		this.isCreation = isCreation;
	}

    abstract void fillFromEntity(T entity);

	public boolean isIsCreation() {
		return isCreation;
	}

}
