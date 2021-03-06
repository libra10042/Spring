package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 게시글 삭제");
		//1. 전달받은 파라미터 값 추출(확인)
		String seq = request.getParameter("seq");
		
		//2. 업무처리 - DB 연동작업(게시글 수정)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		//3. ModelAndView 에 뷰이름 저장후 리턴
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("getBoardList.do");
		mav.setViewName("redirect:getBoardList.do"); //뷰리졸버 적용안함(재요청처리)
		
		return mav;
	}

}
