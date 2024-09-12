package com.ssg.todoservice.controller;

import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.service.TodoService;
import javax.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
  public void list(Model model) {
    log.info("todo list.....");
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

}
