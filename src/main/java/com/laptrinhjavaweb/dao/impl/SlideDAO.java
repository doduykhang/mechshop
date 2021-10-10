package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.ISlideDAO;
import com.laptrinhjavaweb.entity.SlideEntity;

@Repository(value = "slideDAO")
@Transactional(rollbackFor = Exception.class)
public class SlideDAO extends AbtrasctGenericDAO<SlideEntity> implements ISlideDAO{

}
