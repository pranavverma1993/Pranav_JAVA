package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.AppConstants;
import com.example.demo.constant.ErrorConstants;
import com.example.demo.constant.SuccessConstants;
import com.example.demo.constant.URIConstants;
import com.example.demo.dto.CommonResponseDto;
import com.example.demo.dto.EmployeeDtoList;
import com.example.demo.dto.EmployeeInputDto;
import com.example.demo.dto.FetchEmployeeInputDto;
import com.example.demo.dto.UpdateInputDto;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	
@Autowired	
EmployeeService employeeService;

@RequestMapping(method = RequestMethod.POST, value = URIConstants.SAVE_USER_DATA)
public CommonResponseDto saveEmployeelist( @RequestBody EmployeeInputDto EmployeeInputDto) {
	CommonResponseDto response = new CommonResponseDto();
	
	try {
		response = employeeService.savelist(EmployeeInputDto);
		response.setResponseCode(AppConstants.SUCCESS_CODE);
		response.setResponseMessage(SuccessConstants.SAVE_EMPLOYEE);
	} catch (Exception e) {
		
		response.setResponseCode(AppConstants.FAILURE_CODE);
		response.setResponseMessage(ErrorConstants.SAVE_EMPLOYEE_ERROR);
	}
	return response;
}



@RequestMapping(method = RequestMethod.POST, value = URIConstants.FETCH_USER_DATA)
public EmployeeDtoList getEmployeelist( @RequestBody FetchEmployeeInputDto fetchEmployeeInputDto) {
	EmployeeDtoList response = new EmployeeDtoList();
	
	try {
		response = employeeService.fetchlist(fetchEmployeeInputDto.getUserId());
		response.setResponseCode(AppConstants.SUCCESS_CODE);
		response.setResponseMessage(SuccessConstants.FETCH_EMPLOYEE);
	} catch (Exception e) {
		
		response.setResponseCode(AppConstants.FAILURE_CODE);
		response.setResponseMessage(ErrorConstants.FETCH_EMPLOYEE_ERROR);
	}
	return response;
}



@RequestMapping(method = RequestMethod.POST, value = URIConstants.UPDATE_USER_DATA)
public CommonResponseDto updateEmployeelist( @RequestBody UpdateInputDto updateInputDto) {
	CommonResponseDto response = new CommonResponseDto();
	
	try {
		response = employeeService.updateEmployeelist(updateInputDto);
		response.setResponseCode(AppConstants.SUCCESS_CODE);
		response.setResponseMessage(SuccessConstants.UPDATE_EMPLOYEE);
	} catch (Exception e) {
		
		response.setResponseCode(AppConstants.FAILURE_CODE);
		response.setResponseMessage(ErrorConstants.UPDATE_EMPLOYEE_ERROR);
	}
	return response;
}

@RequestMapping(method = RequestMethod.POST, value = URIConstants.DELETE_USER_DATA)
public CommonResponseDto deleteEmployeelist( @RequestBody FetchEmployeeInputDto deleteInputDto) {
	CommonResponseDto response = new CommonResponseDto();
	
	try {
		response = employeeService.deleteEmployeelist(deleteInputDto);
		response.setResponseCode(AppConstants.SUCCESS_CODE);
		response.setResponseMessage(SuccessConstants.DELETE_EMPLOYEE);
	} catch (Exception e) {
		
		response.setResponseCode(AppConstants.FAILURE_CODE);
		response.setResponseMessage(ErrorConstants.DELETE_EMPLOYEE_ERROR);
	}
	return response;
}


@RequestMapping(method = RequestMethod.GET, value = URIConstants.FETCH_ALL_USER_DATA)
public EmployeeDtoList getAllEmployeelist() {
	EmployeeDtoList response = new EmployeeDtoList();
	
	try {
		response = employeeService.getAllEmployeelist();
		response.setResponseCode(AppConstants.SUCCESS_CODE);
		response.setResponseMessage(SuccessConstants.FETCH_EMPLOYEE);
	} catch (Exception e) {
		
		response.setResponseCode(AppConstants.FAILURE_CODE);
		response.setResponseMessage(ErrorConstants.FETCH_EMPLOYEE_ERROR);
	}
	return response;
}

}
