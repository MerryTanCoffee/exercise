package kr.or.ddit.vo;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeVO {

	private int boNo;
	private String boTitle;
	private String boContent;
	private String boWriter;
	private String boDate;
	private String boHit;

	// 파일 데이터가 세팅되는 공간
	// 서버의 용량 관리를 위해 삭제 번호를 부여하고 비동기로 삭제 동작을 하면 배열에 그 값들을 모아 서버로 보내고 싶어서 만든 변수
	private Integer[] delNoticeNo;
	
	private MultipartFile[] boFile;
	
	//private List<NoticeFileVO> noticeFileList;
	
	
}
