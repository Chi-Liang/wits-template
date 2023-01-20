package com.tsmc.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tsmc.common.entity.OnPhotoLayer;

@Repository
public interface OnPhotoLayerRepository extends JpaRepository<OnPhotoLayer, String> {
	
	String sql = "select PHOTO_LAYER,PHOTO_LAYER_NAME,CONFIG_TYPE from DBO.ON_PHOTO_LAYER where CONFIG_TYPE = :configType";
	
	@Query(nativeQuery = true, value = sql)
	public List<OnPhotoLayer> getConfigType(String configType);

}
