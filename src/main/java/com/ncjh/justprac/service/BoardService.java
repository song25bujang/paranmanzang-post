package com.ncjh.justprac.service;

import com.ncjh.justprac.entity.Board;
import com.ncjh.justprac.model.BoardDTO;
import com.ncjh.justprac.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public List<Board> selectAll(){
        return boardRepository.findAll();
    }
    public Long insert(BoardDTO boardDTO){
        Board board = boardDTO.toEntity();
        return boardRepository.save(board).getId();

    }
    public Board selectOne(Long boardId){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isPresent()){
            return optionalBoard.get();
        }else{
            throw new NoSuchElementException();
        }
    }
    public Board updateOne(Long boardId,BoardDTO boardDTO){
        Board modifiedOne = boardDTO.toEntity();
        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            throw new IllegalArgumentException("해당하는 게시글 없음");
        });
        board.setTitle(modifiedOne.getTitle());
        board.setContent(modifiedOne.getContent());
        return boardRepository.save(board);
    }
    public void deleteOne(Long boardId){
        boardRepository.deleteById(boardId);
    }
}
