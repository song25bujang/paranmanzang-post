package com.paranmanzang.post.service;

import com.paranmanzang.post.DTO.BoardDTO;
import com.paranmanzang.post.Entity.Board;
import com.paranmanzang.post.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


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

    public Long add(BoardDTO boardDTO) {
        Board boardEntity = boardDTO.toEntity();
        return boardRepository.save(boardEntity).getId();
    }
    public void deleteOne(Long boardid) {
        boardRepository.deleteById(boardid);
    }
    @Transactional
    public Board modifyBoard(Long boardId,BoardDTO boardDTO){
        Board newBoard = boardRepository.findById(boardId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 보드가 없음.");
                });

        newBoard.setTitle(boardDTO.getTitle());
        newBoard.setContent(boardDTO.getContent());
        return newBoard;
    }

}
