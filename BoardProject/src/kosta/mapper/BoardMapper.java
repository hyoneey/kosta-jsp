package kosta.mapper;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.session.RowBounds;

import kosta.model.Board;
import kosta.model.Reply;
import kosta.model.Search;

//메서드 호출해주는 역할
public interface BoardMapper {
	public Integer selectB_id();
	public int insertBoard(Board board);
	public List<Board> listBoard(RowBounds row, Search search);
	public Board selectBoard(int b_id);
	public int updateStep(HashMap<String, Integer> map);
	public int hitCount(int b_id);
	public int countBoard(Search search);
	public int updateBoard(Board board);
	public int replyInsert(Reply reply);
	public List<Reply> selectReply(int b_id);

}
