package com.tsmc.template.common.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.tsmc.template.common.dao.PhotoAndTempDao;
import com.tsmc.template.common.dto.PhotoAndTempDto;

@Repository
public class PhotoAndTempDaoImpl implements PhotoAndTempDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<PhotoAndTempDto> getPhotoAndConfigType() {
		String sql = "select a.PHOTO_LAYER,a.PHOTO_LAYER_NAME,b.CONFIG_TYPE,b.CONFIG_TYPE1"
				+ " from DBO.ON_PHOTO_LAYER a,DBO.ON_PHOTO_LAYER_TEMP b";
		Query query =  entityManager.createNativeQuery(sql, "PhotoAndTempMapping");
		List<PhotoAndTempDto> photoAndTempDtoList  = query.getResultList();
		return photoAndTempDtoList;
	}

}
