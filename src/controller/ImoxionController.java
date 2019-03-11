package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ImoxionService;
import vo.Article;

@Controller
public class ImoxionController {
	
	String path;
	
	private ImoxionService imoxionService;

	public void setImoxionService(ImoxionService imoxionService) {
		this.imoxionService = imoxionService;
	}//setImoxionService end

	@RequestMapping(value = { "/main", "/" }, method = RequestMethod.GET)
	public String goMain(HttpServletRequest request, Model model) {
		path = request.getServletContext().getRealPath("/WEB-INF/datas");
		model.addAllAttributes(imoxionService.mainFuction(path));
		return "main";
	}// goMain end

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String goWrite() {
		return "form";
	}// goWrite end

	@RequestMapping(value = "/update/{no}", method = RequestMethod.GET)
	public String goUpdate(@PathVariable int no, Model model, @RequestHeader String referer) {
		model.addAttribute("article", imoxionService.detailPage(no, path));
		model.addAttribute("referer", referer);
		return "form";
	}// goUpdate end

	@RequestMapping(value = "/write", method = RequestMethod.PUT)
	public String goUpdate(String referer, Article article) {
		imoxionService.updateArticle(article, path);
		return "redirect:" + referer;
	}// goUpdate end

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String toWrite(Article article, HttpServletRequest request) {
		imoxionService.writeArticle(article, path);
		return "redirect:/main";
	}// toWrite end

	@RequestMapping(value = "/detail/{no}", method = RequestMethod.GET)
	public String goDetail(@PathVariable int no, Model model) {
		model.addAttribute("article", imoxionService.detailPage(no, path));
		return "detail";
	}// goDetail end

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.DELETE)
	public String goDelete(@PathVariable int no) {
		imoxionService.deleteArticle(no, path);
		return "redirect:/main";
	}// goDelete end

}// IndexController end
