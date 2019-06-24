package com.accenture.lkm.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.VendorDAO;
import com.accenture.lkm.entity.VendorEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorDAOTest {

	Logger logger = LoggerFactory.getLogger(VendorDAOTest.class);
	
	@Autowired
	private VendorDAO vendorDAO;
	
	  @Test
	  public void notNullVendorDAOTest() {
	    Assert.assertNotNull(vendorDAO);
	  }
	
	  @Test
	  public void findByIdVendorDAOTest() {
		  VendorEntity entity = null;
		  entity = vendorDAO.findById("V001").get();
		  assertNotNull("ENTITY NOT FOUND", entity);
		  assertEquals("VENDOR ID DOES NOT MATCH", entity.getVendorId(), "V001");
	  }
}
