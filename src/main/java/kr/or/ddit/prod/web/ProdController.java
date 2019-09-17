package kr.or.ddit.prod.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.prod.model.Prod;
import kr.or.ddit.prod.service.IProdService;
@RequestMapping("prod/")
@Controller
public class ProdController {
	private static final Logger logger = LoggerFactory.getLogger(ProdController.class);
	
	@Resource(name="prodService")
	private IProdService prodService;
	
	public String prodList(Model model,String prodId) {
		model.addAttribute("prod", prodId);
		
		List<Prod> resultMap = prodService.getProdList(prodId);
		return "prod/prodList";
	}
}
