package com.ssg.todoservice.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class PagingResponseDTO<T> {

  private int page; // 현재 페이지
  private int size; // 페이지 당 데이터 수
  private int total; // 총 데이터 수
  private int start; // 첫번째 페이지 번호
  private int end; // 마지막 페이지 번호
  private boolean prev; // 이전 페이지 존재 여부
  private boolean next; // 다음 페이지 존재 여부
  private List<T> dtoList;

  @Builder(builderMethodName = "withAll")
  public PagingResponseDTO(PageRequestDTO pageRequestDTO, List<T> dtoList, int total) {
    this.page = pageRequestDTO.getPage();
    this.size = pageRequestDTO.getSize();
    this.dtoList = dtoList;
    this.total = total;

    this.end = (int) Math.ceil((this.page / 10.0)) * 10;
    this.start = this.end - 9;
    int last = (int) (Math.ceil(total / (double) size));
    this.end = Math.min(end, last);

    this.prev = this.start > 1;
    this.next = total > this.end * this.size;
  }
}
