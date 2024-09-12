package com.ssg.todoservice.dto;

import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

// Spring MVC에서는 파라미터 검증 작업을 컨트롤러에서 진행한다.
// @Value 와 BindingResult 객체를 이용하여 처리한다.
// hibernate-
@Data
public class TodoDTO {

  private Long tno;
  @NotEmpty
  private String title;
  @Future
  private LocalDate dueDate;
  @NotEmpty
  private String writer;
  private boolean finished;

}
