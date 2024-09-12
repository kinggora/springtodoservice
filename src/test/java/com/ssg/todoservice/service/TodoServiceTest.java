package com.ssg.todoservice.service;

import static org.junit.jupiter.api.Assertions.*;

import com.ssg.todoservice.dto.TodoDTO;
import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoServiceTest {

  @Autowired
  TodoService todoService;

  @Test
  void register() {
    TodoDTO dto = new TodoDTO();
    dto.setTitle("test title");
    dto.setWriter("test writer");
    dto.setDueDate(LocalDate.of(2024, 9, 12));
    todoService.register(dto);
  }
}