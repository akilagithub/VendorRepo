package com.accenture.lkm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping("/")
	public String index() {
		return "FOR DEMO CHAGED!";
	}
	
	@GetMapping("/vendor/controller/getVendors")
	public ResponseEntity<Collection<VendorBean>> getVendorDetails() {
		Collection<VendorBean> vendorBeans = vendorService.getVendorDetails();
		return new ResponseEntity<Collection<VendorBean>>(vendorBeans, HttpStatus.OK);
	}
}
