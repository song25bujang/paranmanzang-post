package com.ncjh.justprac.controller;

import com.ncjh.justprac.entity.Board;
import com.ncjh.justprac.model.BoardDTO;
import com.ncjh.justprac.repository.BoardRepository;
import com.ncjh.justprac.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        List<Board> boardList = boardService.selectAll();
        model.addAttribute("boardList",boardList);
        System.out.println("총 board 개수:"+boardList.size());
        return "index";
    }
    @GetMapping("/writeBoard")
    public String writeBoard(Model model){
        model.addAttribute("emptyBoardDTO",new BoardDTO());
        return "writeBoard";
    }
    @PostMapping("/writeBoard")
    public String writeEnterBoard(BoardDTO newBoard){
        Long newId = boardService.insert(newBoard);//save -> int
        return "redirect:/detail/"+newId;
    }

    @GetMapping("/detail/{boardId}")
    public String OnePage(@PathVariable("boardId") Long boardId, Model model){
        Board boardOne = boardService.selectOne(boardId);
        model.addAttribute("boardOne",boardOne);
        return "details";
    }
    @GetMapping("/updateBoard/{boardId}")
    public String updateBoard(@PathVariable("boardId") Long boardId, Model model){
        Board boardOne = boardService.selectOne(boardId);
        model.addAttribute("boardOne",boardOne);
        return "updateBoard";
    }
    @PostMapping("/updateBoard/{boardId}")
    public String updateBoard(@PathVariable("boardId") Long boardId,BoardDTO updatedBoard){
        Long newId = boardService.updateOne(boardId,updatedBoard).getId();
        return "redirect:/detail/"+newId;
    }
    @GetMapping("/deleteBoard/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId){
        boardService.deleteOne(boardId);
        return "redirect:/";
    }

}
