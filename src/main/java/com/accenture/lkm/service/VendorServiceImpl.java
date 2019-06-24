package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.dao.VendorDAO;
import com.accenture.lkm.entity.VendorEntity;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	private VendorDAO vendorDAO;
	
	@Override
	public List<VendorBean> getVendorDetails() {
		List<VendorBean> vendorBeans = new ArrayList<>();
		// Use the VendorDAO to get all the vendors
		List<VendorEntity> vendorEntities = vendorDAO.findAll();

		VendorBean bean = null;
		
		for(VendorEntity entity: vendorEntities) {
			bean = new VendorBean();
			BeanUtils.copyProperties(entity, bean);
			vendorBeans.add(bean);
		}
		
		return vendorBeans;
	} 

}
