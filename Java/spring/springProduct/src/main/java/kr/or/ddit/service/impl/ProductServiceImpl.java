package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.ProductDao;
import kr.or.ddit.service.ProductService;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	FileUploadUtil fileUploadUtil;
	
	@Override
	public int insertProduct(ProductVO productVO) {	
		// PRODUCT 테이블에 insert
		int result = this.productDao.insertProduct(productVO);
		// ATTACH 테이블에 다중 insert
		if(result > 0) { // insert 성공 시
			// 파일 업로드 및 insert 수행
			// 밑에 방법은 왜 안되고, 그 밑에 방법은 왜 되는지 알아보기
//			FileUploadUtil.FileUploadUtil(productVO.getProductImage(), productVO.getProductId());
			fileUploadUtil.fileUploadUtil(productVO.getProductImage(), productVO.getProductId());
			
		}
		
		return result;
	}
	
	@Override
	public List<ProductVO> list(String keyword) {
		return this.productDao.list(keyword);
	}
	
	@Override
	public List<ProductVO> listAll() {
		return this.productDao.listAll();
	}
	
	@Override
	public ProductVO detail(ProductVO productVO) {
		return this.productDao.detail(productVO);
	}
	
	@Override
	public ProductVO cartSelect(String productId) {
		return this.productDao.cartSelect(productId);
	}
	
	@Override
	public int update(ProductVO productVO) {
		return productDao.update(productVO);
	}
	
	@Override
	public int delete(String productId) {
		return productDao.delete(productId);
	}

	@Override
	public int thankCustomer(CartVO cartVO) {
		// 1. CART 테이블에 insert
		int cartInCnt = this.productDao.insertCart(cartVO);
		log.info("cartInCnt : " + cartInCnt);
		
		// 2. CART_DET 테이블에 insert
		
		return 0;
	}
	
	// ATTACH 테이블 다중 INSERT
	@Override
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.productDao.insertAttach(attachVOList);
	}
	
	@Override
	public String getProductId() {
		return this.productDao.getProductId();
	}
	
}
