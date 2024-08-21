package com.paranmanzang.post.controller;

import com.paranmanzang.post.DTO.BoardDTO;
import com.paranmanzang.post.Entity.Board;
import com.paranmanzang.post.repository.BoardRepository;
import com.paranmanzang.post.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        List<Board> boardList = boardService.showAll();
        model.addAttribute("boardList",boardList);
        return "index";
    }
    @GetMapping("/writer/{writerId}")
    public String boardBywriterId(Model model, @PathVariable("writerId") Long writerId){
        List<Board> boardlist = boardService.showOneByWriter(writerId);
        model.addAttribute("boardlist",boardlist);
        return "index";
    }
    @GetMapping("/{boardId}")
    public String boardById(Model model, @PathVariable("boardId") Long boardId){
        Board board = boardService.showOneById(boardId);
        model.addAttribute("board",board);
        return "detail";
    }
//    @PostMapping("")
//    public String insert()



}
