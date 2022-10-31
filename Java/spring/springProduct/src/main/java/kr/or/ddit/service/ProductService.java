package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.ProductVO;

public interface ProductService {
	
	public int insertProduct(ProductVO productVO);

	public List<ProductVO> list(String keyword);

	public ProductVO detail(ProductVO productVO);

	public int update(ProductVO productVO);

	public int delete(String productId);

	public ProductVO cartSelect(String productId);

	public List<ProductVO> listAll();

	public int thankCustomer(CartVO cartVO);

	public int insertAttach(List<AttachVO> attachVOList);

	public String getProductId();
	
}
