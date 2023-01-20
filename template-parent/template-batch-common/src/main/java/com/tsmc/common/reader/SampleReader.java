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
@RequiredArgsConstructor
public class SampleReader implements ItemReader<Integer> {
	
	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	int i = 0;

	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Inside Item Reader");
		Integer item;
		if(i < list.size()) {
			item = list.get(i);
			i++;
			return item;
		}
		i = 0;
		return null;
	}
	
}
