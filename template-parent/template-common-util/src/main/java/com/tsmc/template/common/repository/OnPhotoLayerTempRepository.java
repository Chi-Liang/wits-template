package com.tsmc.template.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsmc.template.common.entity.OnPhotoLayerTemp;

@Repository
public interface OnPhotoLayerTempRepository extends JpaRepository<OnPhotoLayerTemp, String> {
	

}
