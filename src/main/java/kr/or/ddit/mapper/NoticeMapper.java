package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface NoticeMapper {

	public int selectNotice(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public void incrementHit(int boNo);

	public NoticeVO selectNotice(int boNo);

}
