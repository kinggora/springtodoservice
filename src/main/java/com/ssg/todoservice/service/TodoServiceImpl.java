package com.ssg.todoservice.service;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PagingResponseDTO;
import com.ssg.todoservice.dto.PagingResponseDTO.PagingResponseDTOBuilder;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.mapper.TodoMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

  private final TodoMapper todoMapper;
  private final ModelMapper modelMapper;

  @Override
  public void register(TodoDTO todoDTO) {
    log.info("dto={}", todoDTO);
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    log.info("vo={}", todoVO);
    todoMapper.insert(todoVO);
  }

//  @Override
//  public List<TodoDTO> getAll() {
//    List<TodoVO> todoVOList = todoMapper.selectAll();
//    return todoVOList.stream()
//        .map(vo -> modelMapper.map(vo, TodoDTO.class))
//        .toList();
//  }

  @Override
  public TodoDTO getOne(Long tno) {
    Optional<TodoVO> todoVO = todoMapper.selectOne(tno);
    TodoVO vo = todoVO.orElseThrow(() -> new RuntimeException("존재하지 않는 todo 입니다."));
    return modelMapper.map(vo, TodoDTO.class);
  }

  @Override
  public void remove(Long tno) {
    todoMapper.delete(tno);
  }

  @Override
  public void modify(TodoDTO todoDTO) {
    TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.update(vo);
  }

  @Override
  public PagingResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
    List<TodoVO> todoVOList = todoMapper.selectList(pageRequestDTO);
    List<TodoDTO> dtoList = todoVOList.stream()
        .map(vo -> modelMapper.map(vo, TodoDTO.class))
        .toList();
    int total = todoMapper.getCount(pageRequestDTO);
    return PagingResponseDTO.<TodoDTO>withAll()
        .pageRequestDTO(pageRequestDTO)
        .dtoList(dtoList)
        .total(total)
        .build();
  }
}
