package com.tsmc.template.batch.common.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SampleWriter implements ItemWriter<Integer> {
	
	@Override
	public void write(List<? extends Integer> items) throws Exception {
		
		items.forEach( item -> System.out.println(item));
		
	}
}
