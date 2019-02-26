package com.equida.rest.api.dto.filter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.data.domain.PageRequest;


public class BasicFilterDto {
	
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

	public PageRequest getPageRequest() {
		return PageRequest.of(offset, limit);
	}
}
