package com.walker.weibox.service;

import org.springframework.data.domain.Page;

import com.walker.weibox.model.FlowSolution;

public interface FlowSolutionService{
	public Page<FlowSolution> pagination(int page);
	public void addOrUpdate(FlowSolution flowSolution);
	public FlowSolution findById(int id);
	public void del(int id);
}
