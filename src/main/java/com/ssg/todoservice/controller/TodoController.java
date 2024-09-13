package com.ssg.todoservice.controller;

import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PagingResponseDTO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.service.TodoService;
import java.util.List;
import javax.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @RequestMapping("/list")
  public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
    log.info(pageRequestDTO);
    if(bindingResult.hasErrors()) {
      pageRequestDTO = PageRequestDTO.builder().build();
    }
    model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
  }

  @GetMapping("/register")
  public void registerGET() {
    log.info("GET todo register.....");
  }

  // 요청 처리 후 redirect 할 페이지 지정
  @PostMapping("/register")
  public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if(bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());
      return "redirect:/todo/register";
    }
    todoService.register(todoDTO);
    return "redirect:/todo/list";
  }

  @GetMapping({"/read", "/modify"})
  public void read(Long tno, Model model) {
    TodoDTO dto = todoService.getOne(tno);
    log.info(dto);
    model.addAttribute("dto", dto);
  }

  @PostMapping("/remove")
  public String remove(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
    todoService.remove(tno);
    redirectAttributes.addAttribute("page", 1);
    redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
    return "redirect:/todo/list";
  }

  @PostMapping("/modify")
  public String modify(@Valid TodoDTO todoDTO, PageRequestDTO pageRequestDTO,  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if(bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "redirect:/todo/modify";
    }
    todoService.modify(todoDTO);
    redirectAttributes.addAttribute("tno", todoDTO.getTno());
    redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
    redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
    return "redirect:/todo/read";
  }
}
