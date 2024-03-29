package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
// 위의 것 두개를 동시에 가능하게 하는 것은 @Data
// PoJo(Plain Orient Java Object)
//@Data
public class CartVO {
	
	// 멤버 변수
	private String cartId;
	private String name;
	private String shippingDate;
	private String country;
	private String zipCode;
	private String addressName;
	private String addressDetail;
	private Date registDt;
	
	// 장바구니 상세(장바구니 : 장바구니 = 1 : N)
	private List<CartDetVO> cartDetVOList;
	

	// 기본 생성자
	public CartVO() {}
	
	// Getter/Setter
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Date getRegistDt() {
		return registDt;
	}
	public void setRegistDt(Date registDt) {
		this.registDt = registDt;
	}
	
	public List<CartDetVO> getCartDetVOList() {
		return cartDetVOList;
	}
	
	public void setCartDetVOList(List<CartDetVO> cartDetVOList) {
		this.cartDetVOList = cartDetVOList;
	}

	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", name=" + name + ", shippingDate=" + shippingDate + ", country=" + country
				+ ", zipCode=" + zipCode + ", addressName=" + addressName + ", addressDetail=" + addressDetail
				+ ", registDt=" + registDt + ", cartDetVOList=" + cartDetVOList + "]";
	}

}
