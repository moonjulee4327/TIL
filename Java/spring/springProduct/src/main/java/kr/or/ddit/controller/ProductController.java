package kr.or.ddit.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	// 요청 URI : /addCart
	// 요청 파라미터 : {"productId":"P1235"}
	// 장바구니(=세션(cartlist))에 해당 상품을 넣음
	// spring에서 요청파라미터를 매개변수로 받을 수 있다.
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public String addCart(HttpServletRequest req, @RequestParam String productId, @ModelAttribute ProductVO productVO) {
		log.info("addCart : " + productId);
		
		// 장바구니에 넣을 상품이 없다면
		if(productId == null) {
			return "redirect:/product?productId=" + productId;
		}
		
		// 장바구니에 넣을 상품을 검색
		ProductVO vo = this.productService.detail(productVO);
		log.info("vo : " + vo);
		
		if(vo == null) {
			return "redirect:/exceptionNoProdcutId";
		}

		// 장바구니(세션) => 세션명 : cartlist
		HttpSession session = req.getSession();
		
		// 세션에 cartlist가 있는가
		ArrayList<ProductVO> list = (ArrayList<ProductVO>)session.getAttribute("cartlist");
		
		// 장바구니가 없다면 생성
		if(list == null) {
			// list는 null 이므로 여기서 리스트를 생성해줘야 함
			list = new ArrayList<ProductVO>();
			// cartlist라는 세션명으로 생성
			session.setAttribute("cartlist", list);
		}
		
		// 장바구니가 있으면 다음을 실행
		int cnt = 0; // 장바구니에 상품이 담긴 개수
		
		for(int i=0; i<list.size(); i++) {
			// list는 session의 장바구니(P1234,P1235,P1236)
			if(list.get(i).getProductId().equals(productId)) {
				cnt++;
				// 장바구니에 상픔이 이미 들어있다면 장바구니에 담은 개수만 1 증가
				list.get(i).setQuantity(list.get(i).getQuantity() + 1);
			}
		}
		
		// 장바구니에 해당 상품이 없다면
		if(cnt == 0) {
			vo.setQuantity(1);
			// 장바구니에 상품 추가
			list.add(vo);
		}
		
		for(ProductVO pv : list) {
			log.info("pv : " + pv.toString());
		}
		
//		return "product/addCart";
		return "redirect:/product?productId=" + productId;
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart() {
		log.info("cart");
		
		return "product/cart";
	}
	
	@RequestMapping(value = "/deleteCart", method = RequestMethod.GET)
	public String deleteCart(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/removeCart", method = RequestMethod.GET)
	public String removeCart(HttpServletRequest req, @RequestParam String productId) {
		HttpSession session = req.getSession();
		
//		log.info(session.getAttribute("cartlist").toString());
		
		ArrayList<ProductVO> cartlist = (ArrayList<ProductVO>)session.getAttribute("cartlist");
		
		for(int i=0; i < cartlist.size(); i++) {
			if(cartlist.get(i).getProductId().equals(productId)) {
				cartlist.remove(cartlist.get(i));
			}
		}
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/shippingInfo", method = RequestMethod.GET)
	public String shippingInfo() {

		return "product/shippingInfo";
	}
	
	@RequestMapping(value = "/processShippingInfo", method = RequestMethod.POST)
	public String processShippingInfo() throws Exception {
		
		return "product/processShippingInfo";
	}
	
	@RequestMapping(value = "/checkOutCancelled", method = RequestMethod.GET)
	public String checkOutCancelled() {

		return "product/checkOutCancelled";
	}
	
	@RequestMapping(value = "/thankCustomer", method = RequestMethod.GET)
	public String thankCustomer() {

		return "product/thankCustomer";
	}
	
	
	@RequestMapping(value = "/orderConfirmation", method = RequestMethod.GET)
	public String orderConfirmation() {

		return "product/orderConfirmation";
	}
	
}
