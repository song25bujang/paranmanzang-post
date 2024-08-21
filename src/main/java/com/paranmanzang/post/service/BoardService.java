package com.paranmanzang.post.service;

import com.paranmanzang.post.DTO.BoardDTO;
import com.paranmanzang.post.Entity.Board;
import com.paranmanzang.post.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> showAll(){
        List<Board> boardlist = boardRepository.findAll();
        return boardlist;
    }
    public Board showOneById(Long boardid){
        Board board = boardRepository.getBoardById(boardid);
        return board;
    }

    public List<Board> showOneByWriter(Long writerId){
        List<Board> boardbywriter = boardRepository.getBoardByWriterId(writerId);
        return boardbywriter;
    }

    public void add(Board b) {
        boardRepository.save(b);
    }
    public void deleteOne(Long boardid) {
        boardRepository.deleteById(boardid);
    }

}
