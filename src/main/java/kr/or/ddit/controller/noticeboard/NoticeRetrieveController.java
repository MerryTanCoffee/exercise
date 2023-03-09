package kr.or.ddit.controller.noticeboard;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {

	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping(value="/list.do")
	public String noticeList(@RequestParam(name="page", required=false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue="title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model) {
		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<NoticeVO>();
		
		// searchWord가 공백이 아니면 검색을 한 상태
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType",searchType);
			model.addAttribute("searchWord",searchWord);
		}
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = noticeService.selectNoticeCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<NoticeVO> noticeList = noticeService.selectNoticeList(pagingVO);
		pagingVO.setDataList(noticeList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "notice/list";
		
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String noticeDetail(int boNo, Model model) {
		
		NoticeVO notice = noticeService.selectNotice(boNo);
		model.addAttribute("notice", notice);
		return "notice/detail";
	}
}
