package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.walker.weibox.common.constants.Constants;
import com.walker.weibox.model.FlowSolution;
import com.walker.weibox.repository.FlowSolutionRepository;
import com.walker.weibox.service.FlowSolutionService;

@Service("flowSolutionService")
public class FlowSolutionServiceImpl implements
		FlowSolutionService {
	@Autowired
	private FlowSolutionRepository flowSolutionRepository;

	@Override
	public Page<FlowSolution> pagination(int page) {
		page -= 1;
		return flowSolutionRepository.findAll(new PageRequest(page, Constants.BACK_PAGE_SIZE,
				new Sort(new Order(Direction.ASC, "solutionPrice"))));
	}

	@Override
	public void addOrUpdate(FlowSolution flowSolution) {
		flowSolutionRepository.save(flowSolution);
	}

	@Override
	public FlowSolution findById(int id) {
		return flowSolutionRepository.findOne(id);
	}

	@Override
	public void del(int id) {
		flowSolutionRepository.delete(id);
	}
}
