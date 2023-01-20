package com.tsmc.common.processor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.entity.OnPhotoLayerTemp;

@Component
public class PhotoLayerProcessor implements ItemProcessor<List<OnPhotoLayer>, List<OnPhotoLayerTemp>> {


	@Override
	public List<OnPhotoLayerTemp> process(List<OnPhotoLayer> items) throws Exception {
		
		List<OnPhotoLayerTemp> onPhotoLayerTempList = items.stream().map( item -> {
			OnPhotoLayerTemp onPhotoLayerTemp = new OnPhotoLayerTemp();
			onPhotoLayerTemp.setPhotoLayer(item.getPhotoLayer());
			onPhotoLayerTemp.setPhotoLayerName(item.getPhotoLayerName() + "temp");
			onPhotoLayerTemp.setConfigType(item.getConfigType() + "temp");
			return onPhotoLayerTemp;
		}).collect(Collectors.toList());
		
		return onPhotoLayerTempList;
	}

}
