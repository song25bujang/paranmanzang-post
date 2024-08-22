package com.paranmanzang.post.controller;

import com.paranmanzang.post.DTO.BoardDTO;
import com.paranmanzang.post.Entity.Board;
import com.paranmanzang.post.repository.BoardRepository;
import com.paranmanzang.post.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/board/showOne/{boardId}")
    public String boardById(Model model, @PathVariable("boardId") Long boardId){
        Board board = boardService.showOneById(boardId);
        model.addAttribute("board",board);
        return "detail";
    }
    @GetMapping("/board/write")
    public String writePage(Model model){
        model.addAttribute("emptyBoard",new BoardDTO());
        return "board/write";
    }
    @PostMapping("/board/write")
    public String writeBoard(BoardDTO boardDTO){
        Long nowAddPostPK = boardService.add(boardDTO);
        return "redirect:/board/showOne/"+nowAddPostPK;
    }
//    @DeleteMapping("/board/deleteOne/{boardId}")
//    public String writeBoard(@PathVariable Long boardId){
//        boardService.deleteOne(boardId);
//        return "redirect:/";
//    }

//    @PostMapping("")
//    public String insert()
    @PostMapping("/board/deleteOne")
    public String deletePost(@RequestParam final Long boardId){
        boardService.deleteOne(boardId);
        return "redirect:/";
    }
    @GetMapping("/board/updateOne/{boardId}")
    public String updateRequestPage(@PathVariable Long boardId,Model model){
        Board boardtoupdate = boardService.showOneById(boardId);
        model.addAttribute("boardtoupdate",boardtoupdate);
        model.addAttribute("boardId",boardId);
        return "board/update";
    }
    @PostMapping("/board/updateOne/{boardId}")
    @ResponseBody
    public String updateResponsePage(@PathVariable Long boardId,
                                     @ModelAttribute BoardDTO newboard){
        //ModelAttribute 로 input
        //JPA의 update방법 - 더티체킹
        boardService.modifyBoard(boardId,newboard);
        return "redirect:/board/showOne/"+boardId;
    }

}
