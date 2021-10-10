package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductStatusDAO;
import com.laptrinhjavaweb.dao.ISlideDAO;
import com.laptrinhjavaweb.entity.ProductStatusEntity;
import com.laptrinhjavaweb.entity.SlideEntity;
import com.laptrinhjavaweb.service.ISlideService;

@Service
@Transactional
public class SlideService extends AbstractGenericService<ISlideDAO, SlideEntity> implements ISlideService{
	@Autowired
	public void setDao(ISlideDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(SlideEntity.class);
	}
}
