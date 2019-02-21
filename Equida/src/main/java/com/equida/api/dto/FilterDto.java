package com.equida.api.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class FilterDto {
	
	@Min(1)
	@Max(100)
	private Integer limit = 20;
	
	@Min(0)
	private Integer offset = 0;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
