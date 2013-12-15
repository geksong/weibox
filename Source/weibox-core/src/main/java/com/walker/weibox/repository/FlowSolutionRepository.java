package com.walker.weibox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walker.weibox.model.FlowSolution;

@Repository("flowSolutionRepository")
public interface FlowSolutionRepository extends JpaRepository<FlowSolution, Integer> {
}
