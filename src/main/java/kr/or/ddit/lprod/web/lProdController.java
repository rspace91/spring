package kr.or.ddit.lprod.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.service.ILprodService;

@RequestMapping("lprod/")
@Controller
public class lProdController {
	private static final Logger logger = LoggerFactory.getLogger(lProdController.class);

	
	@Resource(name="lprodService")
	private ILprodService lprodService;
	/**
	 * Method : LprodList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param model
	 * @return
	 * Method 설명 : Lprod 리스트 조회
	 */
	@RequestMapping(path = "lprodList", method = RequestMethod.GET )
	public String lprodList(Model model) {
		model.addAttribute("lprodList", lprodService.getLprodList());
		return "lprod/lprodList";
	}
	/**
	 * Method : lprodPagingList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param model
	 * @param page
	 * @return
	 * Method 설명 :
	 */
	@RequestMapping(path = "lprodPagingList'", method = RequestMethod.GET)
//	public String lprodPagingList(Model model, Page page) {
	public String lprodPagingList(@RequestParam(name="page",defaultValue = "1") int  p,
			  @RequestParam(defaultValue = "5") int pagesize, Model model) {
		Page page = new Page(p, pagesize);
		model.addAttribute("pageVo", page);
		
		logger.debug("page:{}",page);
		List<Lprod> resultList = lprodService.getLprodPagingList(page);
		model.addAllAttributes(resultList);
		return "lprod/lprodPagingList";
	}
	
}
