package com.example.demo.dto;

import java.util.List;

public class EmployeeDtoList extends CommonResponseDto {

	List<EmployeeDto> response;

	public List<EmployeeDto> getResponse() {
		return response;
	}

	public void setResponse(List<EmployeeDto> response) {
		this.response = response;
	}
}
