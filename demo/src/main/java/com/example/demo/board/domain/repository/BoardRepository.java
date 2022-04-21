package com.example.demo.board.domain.repository;

import com.example.demo.board.domain.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoardRepository extends CrudRepository<Board, Long> {
    Optional<Board> findBoardById(Long id);
}
