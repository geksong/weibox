package com.walker.weibox.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walker.weibox.model.FlowSolution;
import com.walker.weibox.service.FlowSolutionService;

/**
 * author geksong <br/>
 * function 流量套餐管理<br/>
 **/
@Controller
@RequestMapping("/back/flowsolution")
public class FlowSolutionController extends BaseBackController {
	@Autowired
	private FlowSolutionService flowSolutionService;
	
	@RequestMapping("list")
	public String list(@RequestParam(value="page", defaultValue="1", required=false) int page,
			Model model) {
		if(page <= 0)
			page = 1;
		Page<FlowSolution> pageList = flowSolutionService.pagination(page);
		model.addAttribute("pageList", pageList);
		model.addAttribute("page", page);
		return "/WEB-INF/back/flowsolution/flowsolution-list";
	}
	
	@RequestMapping("toadd")
	public String toAdd() {
		return "/WEB-INF/back/flowsolution/flowsolution-add";
	}
	
	@RequestMapping("add")
	public ModelAndView add(@RequestParam(value="textMsgNum") int textMsgNum,
			@RequestParam(value="imgtxtMsgNum") int imgtxtMsgNum,
			@RequestParam(value="vadioMsgNum") int vadioMsgNum,
			@RequestParam(value="solutionPrice") BigDecimal solutionPrice,
			@RequestParam(value="solutionDiscount") int solutionDiscount) {
		ModelAndView jsonView = getDefaultJSONView();
		if(textMsgNum <= 0 || imgtxtMsgNum <= 0 || vadioMsgNum <=0
				|| 0 >= solutionPrice.compareTo(new BigDecimal(0))
				|| 0 >= solutionDiscount) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "流量套餐信息不完整");
			return jsonView;
		}
		FlowSolution flowSolution = new FlowSolution();
		flowSolution.setTextMsgNum(textMsgNum);
		flowSolution.setImgtxtMsgNum(imgtxtMsgNum);
		flowSolution.setVadioMsgNum(vadioMsgNum);
		flowSolution.setSolutionDiscount(solutionDiscount);
		flowSolution.setSolutionPrice(solutionPrice);
		flowSolutionService.addOrUpdate(flowSolution);
		jsonView.addObject("msg", "添加成功");
		return jsonView;
	}
	
	@RequestMapping("toupdate")
	public String toUpdate(@RequestParam(value="id") int id, Model model) {
		FlowSolution flowSolution = flowSolutionService.findById(id);
		model.addAttribute("flowSolution", flowSolution);
		return "/WEB-INF/back/flowsolution/flowsolution-update";
	}
	
	@RequestMapping("update")
	public ModelAndView update(@RequestParam(value="id") int id,
			@RequestParam(value="textMsgNum") int textMsgNum,
			@RequestParam(value="imgtxtMsgNum") int imgtxtMsgNum,
			@RequestParam(value="vadioMsgNum") int vadioMsgNum,
			@RequestParam(value="solutionPrice") BigDecimal solutionPrice,
			@RequestParam(value="solutionDiscount") int solutionDiscount) {
		ModelAndView jsonView = getDefaultJSONView();
		if(textMsgNum <= 0 || imgtxtMsgNum <=0 || vadioMsgNum <= 0
				|| 0 >= solutionPrice.compareTo(new BigDecimal(0))
				|| 0 >= solutionDiscount) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "流量套餐信息不完整");
			return jsonView;
		}
		FlowSolution flowSolution = new FlowSolution();
		flowSolution.setId(id);
		flowSolution.setTextMsgNum(textMsgNum);
		flowSolution.setImgtxtMsgNum(imgtxtMsgNum);
		flowSolution.setVadioMsgNum(vadioMsgNum);
		flowSolution.setSolutionDiscount(solutionDiscount);
		flowSolution.setSolutionPrice(solutionPrice);
		flowSolutionService.addOrUpdate(flowSolution);
		jsonView.addObject("msg", "更新成功");
		return jsonView;
	}
	
	@RequestMapping("del")
	public ModelAndView del(@RequestParam(value="id") int id) {
		ModelAndView jsonView = getDefaultJSONView();
		flowSolutionService.del(id);
		jsonView.addObject("msg", "删除成功");
		return jsonView;
	}
}
