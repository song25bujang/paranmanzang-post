package com.ncjh.justprac.repository;

import com.ncjh.justprac.entity.Board;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
//    Long save(Board board);
    //Board findById(Long id);
}
