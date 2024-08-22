package com.paranmanzang.post.repository;

import com.paranmanzang.post.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findAll(); //전체 글
    Board getBoardById(Long id);//글id로 get
    List<Board> getBoardByWriterId(Long id);//글쓴이 id가 쓴 글


}
