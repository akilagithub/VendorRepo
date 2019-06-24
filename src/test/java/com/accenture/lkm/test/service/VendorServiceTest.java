package com.accenture.lkm.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.service.VendorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {
 
	@Autowired
    private VendorService vendorService;

    @Test
    public void notNullVendorServiceTest() {
        assertNotNull(vendorService);
    }
    
    @Test
    public void notNullGetVendorDetailsTest() {
    	assertNotNull(vendorService.getVendorDetails());
    }
    
    @Test
    public void countGetVendorDetailsTest() {
    	assertEquals("COUNT NOT MATCH!", 1, vendorService.getVendorDetails().size());
    }

    @Test
    public void recordGetVendorDetailsTest() {
    	assertEquals("RECORD NOT MATCH!", "V001", vendorService.getVendorDetails().get(0).getVendorId());
    }
    
}