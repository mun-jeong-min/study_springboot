package com.example.demo.domain.board.domain.repository;

import com.example.demo.domain.board.domain.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoardRepository extends CrudRepository<Board, Long> {
    Optional<Board> findBoardById(Long id);
}
