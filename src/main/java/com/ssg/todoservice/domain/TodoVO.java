package com.ssg.todoservice.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {

  private Long tno;
  private String title;
  private LocalDate dueDate;
  private String writer;
  private boolean finished;

}
