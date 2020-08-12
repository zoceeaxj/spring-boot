package com.rab3tech.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.rest.vo.CompanyVO;
import com.rab3tech.rest.vo.EmployeVO;

@RestController
@RequestMapping("/api2")
public class CompanyController {


	@GetMapping("/companies/{cid}/employees")
	public List<EmployeVO> findCompanyEmployees(@PathVariable int cid){
		List<EmployeVO> employeVOs=new ArrayList<EmployeVO>();
         return employeVOs;
	}

	@GetMapping("/companies/{cid}/employees/{eid}")
	public EmployeVO findCompanyEmployee(@PathVariable int cid,@PathVariable int eid){
         return new EmployeVO();
	}

	@PostMapping("/companies/{cid}/employees")
	public List<EmployeVO> creatCompanyEmployees(@RequestBody EmployeVO employeVO,@PathVariable int cid){
		List<EmployeVO> employeVOs=new ArrayList<EmployeVO>();
         return employeVOs;
	}

	@DeleteMapping("/companies/{cid}/employees/{eid}")
	public AppResponse deleteCompanyEmployee(@PathVariable int cid,@PathVariable int eid){
		AppResponse appResponse=new AppResponse();
		appResponse.setCode(13);
		appResponse.setMessage("Company is deleted sucessfully.");
		return appResponse;
	}


	@DeleteMapping("/companies/{cid}")
	public AppResponse deleteCompanyByCid(@PathVariable int cid){
		AppResponse appResponse=new AppResponse();
		appResponse.setCode(13);
		appResponse.setMessage("Company is deleted sucessfully.");
		return appResponse;
	}

	@DeleteMapping("/companies")
	public AppResponse deleteCompanies(){
		AppResponse appResponse=new AppResponse();
		appResponse.setCode(13);
		appResponse.setMessage("Companies are deleted sucessfully.");
		return appResponse;
	}

	@GetMapping("/companies")
	public List<CompanyVO> findCompanies(){
		List<CompanyVO> companyVOs=new ArrayList<CompanyVO>();
         return companyVOs;
	}

	@PostMapping("/companies")
	public CompanyVO createCompany(@RequestBody CompanyVO companyVO){
          System.out.println(companyVO);
          return companyVO;
	}

	@PutMapping("/companies")
	public CompanyVO updateCompany(@RequestBody CompanyVO companyVO){
          System.out.println(companyVO);
          return companyVO;
	}

}