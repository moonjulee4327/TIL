package ch04.dao;

import java.util.ArrayList;
import java.util.List;

import ch04.vo.ProductVO;

public class ProductRepository {
	// 싱글톤 패턴
	// ProductRepository 클래스의 기본 생성자에 대한 객체 변수 instance를 작성함
	private static ProductRepository instance = new ProductRepository();
	
	// 객체 변수 instance에 대한 Getter() 메소드
	public static ProductRepository getInstance() {
		return instance;
	}
	
	// 상품 목록을 저장하기 위한 List<ProductVO> 객체 타입의 변수
	private List<ProductVO> listOfProducts = new ArrayList<ProductVO>();
	
	// 기본생성자
	public ProductRepository() {
		// 1) Smart Phone 상품추가(1행(ProductVO) 추가)
		// String productId, String pname, int unitPrice
		ProductVO phone = new ProductVO("P1234","iPhone 14pro Max", 1750000);
		phone.setDescription("4.7-inch, 1334X750 Renina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitInStock(1000);
		phone.setCondition("New");
		
		listOfProducts.add(phone);
		
		// 2) notebook 상품추가 (1행(ProductVO) 추가)
		ProductVO notebook = new ProductVO("p1235", "MacBook Pro", 3000000);
		notebook.setDescription("133.3-inch, ips LED display");
		notebook.setCategory("Notebook");
		notebook.setManufacturer("Apple");
		notebook.setUnitInStock(1000);
		notebook.setCondition("Refurbished"); // 재생상품

		listOfProducts.add(notebook);
		
		// 3) tablet 상품 추가 (1행(ProductVO) 추가)
		ProductVO tablet = new ProductVO("P1236", "iPad 6", 1200000);
		tablet.setDescription("212.8*125.6*6.6mm, Super AMOLED display");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Apple");
		tablet.setUnitInStock(1000);
		tablet.setCondition("Old"); // 중고상품
		
		listOfProducts.add(tablet);
	}
	
	// SELECT * FROM PRODUCT
	// 객체타입의 변수 listOfProducts 에 저장된 모든 상품 목록을 가져오는 메소드
	public List<ProductVO> getAllProducts() {
		return listOfProducts;
	}
	
	// INSERT INTO PRODUCT VALUES(...)
	// 객체타입의 변수 listOfProducts에 새로운 상품 정보를 등록하는 메소드
	public void addProduct(ProductVO productVO) {
		listOfProducts.add(productVO);
	}
	
	// 상세보기
	// SELECT * FROM PRODUCT WHERE PRODUCT_ID = 'P1235'
	public ProductVO getProductById(String productId) {
		// 자바빈객체 선언
		ProductVO productById = null;
		
		// listOfProducts의 크기만큼 반복
		for(int i=0; i < listOfProducts.size(); i++) {
			ProductVO vo = listOfProducts.get(i);
			if(vo != null && vo.getProductId() != null && productId.equals(vo.getProductId())) {
				productById = vo;
				// 찾으면 빠져나옴
				break;
			}
		}
		
		return productById;
		
	}
	
	
	
}
