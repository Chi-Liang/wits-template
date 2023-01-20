package com.tsmc.common.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import com.tsmc.common.entity.OnPhotoLayerTemp;
import com.tsmc.common.repository.OnPhotoLayerTempRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PhotoLayerWriter implements ItemWriter<List<OnPhotoLayerTemp>> {
	
	private final OnPhotoLayerTempRepository onPhotoLayerTempRepository;

	@Override
	public void write(List<? extends List<OnPhotoLayerTemp>> items) throws Exception {
		
		items.forEach(item -> {
			
			onPhotoLayerTempRepository.saveAll(item);
			
		});
		
	}
	
	
}
