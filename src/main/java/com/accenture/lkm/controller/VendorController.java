package com.accenture.lkm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Welcome to Vendor Service API!";
	}
	
	@GetMapping("/vendor/controller/getVendors")
	public ResponseEntity<Collection<VendorBean>> getVendorDetails() {
		Collection<VendorBean> vendorBeans = vendorService.getVendorDetails();
		return new ResponseEntity<Collection<VendorBean>>(vendorBeans, HttpStatus.OK);
	}
}
