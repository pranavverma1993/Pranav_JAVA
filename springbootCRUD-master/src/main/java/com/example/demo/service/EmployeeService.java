package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.constant.AppConstants;
import com.example.demo.constant.ErrorConstants;
import com.example.demo.dto.CommonResponseDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeDtoList;
import com.example.demo.dto.EmployeeInputDto;
import com.example.demo.dto.FetchEmployeeInputDto;
import com.example.demo.dto.UpdateInputDto;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repo.EmployeeRepo;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	public CommonResponseDto savelist(EmployeeInputDto employeeInputDto) throws Exception {
		
		CommonResponseDto response = new CommonResponseDto();
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		try {
			employeeEntity.setUserId(employeeInputDto.getUserId());
			employeeEntity.setLastName(employeeInputDto.getLastName());
			employeeEntity.setFirstName(employeeInputDto.getFirstName());
			employeeRepo.save(employeeEntity);
		}
		catch (Exception exception) {
			response.setResponseCode(AppConstants.FAILURE_CODE);
			response.setResponseMessage(ErrorConstants.SAVE_EMPLOYEE_ERROR);
	
	}
		return response;
	}
	
	
	//fetch data based on userId
	public EmployeeDtoList fetchlist(Integer userId) {
		EmployeeDtoList response = new EmployeeDtoList();
		List<Object[]> objList = new ArrayList<>();
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		
		try {
			objList=employeeRepo.findByRequiredUserId(userId);
			for (Object[] tempObj : objList) {
				EmployeeDto fetchDelegateOutputDto = new EmployeeDto();
				
				fetchDelegateOutputDto.setFirstName(String.valueOf(tempObj[0]));
				fetchDelegateOutputDto.setLastName(String.valueOf(tempObj[1]));
				
			
				employeeDtoList.add(fetchDelegateOutputDto);
			}
	
			response.setResponse(employeeDtoList);
		}
		catch (Exception exception) {
			response.setResponseCode(AppConstants.FAILURE_CODE);
			response.setResponseMessage(ErrorConstants.FETCH_EMPLOYEE_ERROR);
			}

		return response;
}

	@Transactional()
	public CommonResponseDto updateEmployeelist(UpdateInputDto updateInputDto) {
		CommonResponseDto response = new CommonResponseDto();
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		try {
			employeeEntity.setUserId(updateInputDto.getUserId());
			employeeEntity.setFirstName(updateInputDto.getFirstName());
			employeeEntity.setLastName(updateInputDto.getLastName());
			employeeRepo.updateEmployeeList(employeeEntity.getFirstName(),employeeEntity.getLastName(),employeeEntity.getUserId());
		}
		catch (Exception exception) {
			response.setResponseCode(AppConstants.FAILURE_CODE);
			response.setResponseMessage(ErrorConstants.SAVE_EMPLOYEE_ERROR);
	
	}
		return response;
	}

	@Transactional()
	public CommonResponseDto deleteEmployeelist(FetchEmployeeInputDto deleteInputDto) {
		CommonResponseDto response = new CommonResponseDto();
		try {
			
			employeeRepo.deleteByUserId(deleteInputDto.getUserId());
		}
		catch (Exception exception) {
			response.setResponseCode(AppConstants.FAILURE_CODE);
			response.setResponseMessage(ErrorConstants.DELETE_EMPLOYEE_ERROR);
	
	}
		
		
		return response;
	}


	public EmployeeDtoList getAllEmployeelist() {
		EmployeeDtoList response = new EmployeeDtoList();
		List<EmployeeEntity> objList = new ArrayList<>();
		List<EmployeeDto> employeeDtoList = new ArrayList<>();
		
		try {
			objList=employeeRepo.findAll();
			for (EmployeeEntity tempObj : objList) {
				EmployeeDto fetchDelegateOutputDto = new EmployeeDto();
				
				fetchDelegateOutputDto.setFirstName(tempObj.getFirstName());
				fetchDelegateOutputDto.setLastName(tempObj.getLastName());
				fetchDelegateOutputDto.setUserId(tempObj.getUserId());
				
			
				employeeDtoList.add(fetchDelegateOutputDto);
			}
	
			response.setResponse(employeeDtoList);
		}
		catch (Exception exception) {
			response.setResponseCode(AppConstants.FAILURE_CODE);
			response.setResponseMessage(ErrorConstants.FETCH_EMPLOYEE_ERROR);
			}

		return response;
	}
}
