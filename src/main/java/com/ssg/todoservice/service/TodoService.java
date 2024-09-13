package com.ssg.todoservice.service;

import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PagingResponseDTO;
import com.ssg.todoservice.dto.TodoDTO;
import java.util.List;

public interface TodoService {
  void register(TodoDTO todoDTO);

//  List<TodoDTO> getAll();

  TodoDTO getOne(Long tno);

  void remove(Long tno);

  void modify(TodoDTO todoDTO);

  PagingResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
