package com.accenture.lkm.test.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.controller.VendorController;
import com.accenture.lkm.service.VendorService;

@RunWith(SpringRunner.class)
@WebMvcTest(VendorController.class)
public class VendorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VendorService vendorServiceMock;

	@Test
	public void indexVendorControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
				.andExpect(content().string("Welcome to Spring Boot Vendor Service API!"));
	}

	@Test
	public void vendorListVendorControllerTest() throws Exception {

		VendorBean bean = new VendorBean("V001", "KZN Textile", "Dombivali", "Khozema Nullwala", "9819000000");
		List<VendorBean> vendorBeans = new ArrayList<>();
		vendorBeans.add(bean);

		when(vendorServiceMock.getVendorDetails()).thenReturn(vendorBeans);

		mockMvc.perform(MockMvcRequestBuilders.get("/vendor/controller/getVendors")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].vendorId", is("V001")))
				.andExpect(jsonPath("$[0].vendorName", is("KZN Textile")))
				.andExpect(jsonPath("$[0].vendorAddress", is("Dombivali")))
				.andExpect(jsonPath("$[0].contactPerson", is("Khozema Nullwala")))
				.andExpect(jsonPath("$[0].contactNumber", is("9819000000")));

	}

}
