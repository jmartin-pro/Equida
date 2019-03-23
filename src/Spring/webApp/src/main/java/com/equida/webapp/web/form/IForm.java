package com.equida.webapp.web.form;

public abstract class IForm<T> {
	
	private boolean isCreation = true;

	public IForm() {
		this(true);
	}
	
	public IForm(boolean isCreation) {
		this.isCreation = isCreation;
	}

    public abstract void fillFromEntity(T entity);

	public boolean getIsCreation() {
		return isCreation;
	}

	public void setIsCreation(boolean isCreation) {
		this.isCreation = isCreation;
	}

}
