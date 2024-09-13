package com.ssg.todoservice.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.swing.Spring;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoMapperTest {

  @Autowired(required = false)
  TodoMapper todoMapper;

  @Test
  void getTime() {
    log.info("current time: {}", todoMapper.getTime());
  }

  @Test
  void insert() {
    TodoVO vo = TodoVO.builder()
        .title("title")
        .writer("writer")
        .dueDate(LocalDate.of(2024, 9, 12))
        .build();
    todoMapper.insert(vo);
  }

  @Test
  void selectAll() {
    List<TodoVO> todoList = todoMapper.selectAll();
    todoList.forEach(log::info);
  }

  @Test
  void selectOne() {
    Optional<TodoVO> todoVO = todoMapper.selectOne(1L);
    TodoVO findVO = todoVO.orElseThrow(() -> new RuntimeException("존재하지 않는 todo 입니다."));
    log.info(findVO);
  }

  @Test
  void selectList() {
    List<TodoVO> todoVOList = todoMapper.selectList(
        PageRequestDTO.builder()
            .page(1)
            .size(8)
            .build()
    );
    todoVOList.forEach(vo -> log.info(vo));
  }
}