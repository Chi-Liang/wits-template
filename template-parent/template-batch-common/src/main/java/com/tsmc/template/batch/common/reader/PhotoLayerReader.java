package com.tsmc.template.batch.common.reader;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.tsmc.template.common.entity.OnPhotoLayer;
import com.tsmc.template.common.repository.OnPhotoLayerRepository;
import lombok.RequiredArgsConstructor;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class PhotoLayerReader implements ItemReader<List<OnPhotoLayer>>, StepExecutionListener {
	
    private final OnPhotoLayerRepository onPhotoLayerRepository;
	
    private boolean execute = false;
    
    List<OnPhotoLayer> onPhotoLayerList;
    
	@Override
	public List<OnPhotoLayer> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(!execute) {
			execute = true;
		} else {
			onPhotoLayerList = null;
		}
		return onPhotoLayerList;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		onPhotoLayerList = onPhotoLayerRepository.getByConfigType("bbb");
//		onPhotoLayerList = onPhotoLayerRepository.findAll();
		execute = false;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		execute = false;
		onPhotoLayerList = null;
		return null;
	}
	
}
