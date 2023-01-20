package com.tsmc.common.reader;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.entity.OnPhotoLayerTemp;
import com.tsmc.common.repository.OnPhotoLayerRepository;
import com.tsmc.common.repository.OnPhotoLayerTempRepository;

import lombok.RequiredArgsConstructor;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class PhotoLayerReader implements ItemReader<List<OnPhotoLayer>> {
	
    private final OnPhotoLayerRepository onPhotoLayerRepository;
	
    private boolean execute = false;
    
	@Override
	public List<OnPhotoLayer> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("aaaaaaaaaa:" + execute);
		List<OnPhotoLayer> onPhotoLayerList = null;
		
		if(!execute) {
			onPhotoLayerList = onPhotoLayerRepository.getConfigType("bbb");
			execute = true;
		} else {
			execute = false;
		}
		
		return onPhotoLayerList;
	}
	
}
