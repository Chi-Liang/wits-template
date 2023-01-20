package com.tsmc.common.processor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.entity.OnPhotoLayerTemp;

@Component
public class SampleProcessor implements ItemProcessor<Integer, Integer> {

	@Override
	public Integer process(Integer item) throws Exception {
		return item + 1;
	}

}
