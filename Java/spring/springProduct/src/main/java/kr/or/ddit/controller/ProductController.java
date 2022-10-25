package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// 상품 목록
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView products(ModelAndView mav, @RequestParam(value = "keyword", required = false) String keyword) {
		
		// Model
		List<ProductVO> data = this.productService.list(keyword);
		mav.addObject("data", data);
		mav.addObject("productId", data.get(0).getProductId());
		// View
		mav.setViewName("product/products");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("product/addProduct");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProductPost(ModelAndView mav, @ModelAttribute ProductVO productVO) {
		log.info("ProductVO : " + productVO.toString());
		int result = this.productService.insertProduct(productVO);
		
		log.info("result : " + result);
		
		if(result > 0) {
			mav.setViewName("redirect:/product?productId=" + productVO.getProductId());
		}else {
			mav.setViewName("redirect:/addproduct");
		}
		
		return mav;
		
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav, ProductVO productVO) {
		log.info("detail");
		
		log.info("vo : " + productVO.toString());

		ProductVO data = this.productService.detail(productVO); 
		
		mav.setViewName("product/product");
		mav.addObject("data", data);
		mav.addObject("productId", data.getProductId());
		
		return mav;
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(ModelAndView mav, ProductVO productVO) {
		
		ProductVO data = this.productService.detail(productVO); 
		
		mav.addObject("data", data);
		
		mav.setViewName("product/update");			
		
		return mav;
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(ModelAndView mav, ProductVO productVO) {
		log.info("updatePost => productVO : " + productVO.toString());
		
		int result = this.productService.update(productVO); 
		
		if(result > 0) {
			mav.setViewName("redirect:/product?productId=" + productVO.getProductId());						
		}else {
			mav.setViewName("redirect:/update?productId=" + productVO.getProductId());
		}
		
		return mav;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, String productId) {
		log.info("productId : " + productId);
		
		int result = this.productService.delete(productId);
		
		// redirect => detail 메소드를 다시 실행함
		if(result > 0) { // 삭제 성공	
			mav.setViewName("redirect:/products");
		}else {
			mav.setViewName("redirect:/product?productId=" + productId);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public String addCart(Model model, String productId) {
		log.info("addCart : " + productId);
		
		ProductVO data = productService.cartSelect(productId);
		
		model.addAttribute("name", data);
		
		return "product/addCart";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart() {
		log.info("cart");
		
		return "product/cart";
	}
}
