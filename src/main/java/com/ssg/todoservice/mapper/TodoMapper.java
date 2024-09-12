package com.ssg.todoservice.mapper;

import com.ssg.todoservice.domain.TodoVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

  String getTime();
  void insert(TodoVO todo);
}
