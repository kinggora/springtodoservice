package com.ssg.todoservice.controller.formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 * 날짜 형식으로 전달된 파라미터 문자열을 날짜 객체 타입(LocalDate)으로 변환하는 클래스
 */
public class LocalDateFormatter implements Formatter<LocalDate> {

  @Override
  public LocalDate parse(String text, Locale locale) throws ParseException {
    return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  @Override
  public String print(LocalDate object, Locale locale) {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
  }
}
