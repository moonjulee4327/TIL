package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ExamMemberVO {
	private String memId;
	private String memName;
	private String memJob;
	private String memLike;
	private String memHp;
	// MEM테이블에 없어도 사용가능
	private String userId;
	private String password;
	private List<MultipartFile> pictureList;
	private MultipartFile[] pictureArray;
//	private MultipartFile picture;
//	private MultipartFile picture2;


	public ExamMemberVO() {}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getMemJob() {
		return memJob;
	}


	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}


	public String getMemLike() {
		return memLike;
	}


	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}


	public String getMemHp() {
		return memHp;
	}


	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<MultipartFile> getPictureList() {
		return pictureList;
	}


	public void setPictureList(List<MultipartFile> pictureList) {
		this.pictureList = pictureList;
	}


	public MultipartFile[] getPictureArray() {
		return pictureArray;
	}


	public void setPictureArray(MultipartFile[] pictureArray) {
		this.pictureArray = pictureArray;
	}


	@Override
	public String toString() {
		return "ExamMemberVO [memId=" + memId + ", memName=" + memName + ", memJob=" + memJob + ", memLike=" + memLike
				+ ", memHp=" + memHp + ", userId=" + userId + ", password=" + password + ", pictureList=" + pictureList
				+ ", pictureArray=" + Arrays.toString(pictureArray) + "]";
	}

	
	
	
//	public MultipartFile getPicture() {
//		return picture;
//	}
//	
//	public void setPicture(MultipartFile picture) {
//		this.picture = picture;
//	}
//	
//	public MultipartFile getPicture2() {
//		return picture2;
//	}
//	
//	public void setPicture2(MultipartFile picture2) {
//		this.picture2 = picture2;
//	}

//	@Override
//	public String toString() {
//		return "ExamMemberVO [memId=" + memId + ", memName=" + memName + ", memJob=" + memJob + ", memLike=" + memLike
//				+ ", memHp=" + memHp + ", userId=" + userId + ", password=" + password + ", picture=" + picture
//				+ ", picture2=" + picture2 + "]";
//	}
	
	
	
}
