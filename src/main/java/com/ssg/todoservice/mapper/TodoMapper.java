package com.ssg.todoservice.mapper;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.TodoDTO;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

  String getTime();

  void insert(TodoVO todo);

  List<TodoVO> selectAll();

  Optional<TodoVO> selectOne(Long tno);

  void delete(Long tno);

  void update(TodoVO todoVO);

  List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

  int getCount(PageRequestDTO pageRequestDTO);

}
