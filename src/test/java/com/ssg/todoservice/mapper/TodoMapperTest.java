package com.ssg.todoservice.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.ssg.todoservice.domain.TodoVO;
import java.time.LocalDate;
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

}