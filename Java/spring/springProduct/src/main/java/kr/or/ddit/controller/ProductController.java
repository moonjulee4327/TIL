package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView products(ModelAndView mav) {
		// Model
		List<ProductVO> data = this.productService.list();
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
		System.out.println("여기는 옴");
		int result = this.productService.insertProduct(productVO);
		
		log.info("result : " + result);
		
		if(result > 0) {
			mav.setViewName("redirect:/deltail?productId=" + productVO.getProductId());
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
}
