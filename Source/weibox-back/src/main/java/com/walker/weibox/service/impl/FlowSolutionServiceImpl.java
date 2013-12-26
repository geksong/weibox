package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walker.weibox.repository.FlowSolutionRepository;
import com.walker.weibox.service.FlowSolutionService;

@Service("flowSolutionService")
public class FlowSolutionServiceImpl implements
		FlowSolutionService {
	@Autowired
	private FlowSolutionRepository flowSolutionRepository;
}
