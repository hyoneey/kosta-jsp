package kosta.mapper;

import java.util.List;

import kosta.model.Board;
import kosta.model.Search;

//메서드 호출해주는 역할
public interface BoardMapper {
	int insertBoard(Board board);
	List<Board> listBoard(Search search);
	Board detailBoard(String seq);
	int updateBoard(Board board);
	int deleteBoard(Board board);
}
