package com.equida.api.dto;

public interface IDto<T, U> {
	public static <T, U> U convertToDto(T entity) {
		return null;
	}
	
	public T convertToEntity();
}
