package com.tsmc.common.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import com.tsmc.common.entity.OnPhotoLayerTemp;
import com.tsmc.common.repository.OnPhotoLayerTempRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SampleWriter implements ItemWriter<Integer> {
	
	@Override
	public void write(List<? extends Integer> items) throws Exception {
		
		items.forEach( item -> System.out.println(item));
		
	}
}
