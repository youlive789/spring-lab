package com.example.reactivejdbcexample.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ScheduleDto {
    Long id;
    Integer year;
    Integer month;
    Integer day;
    String title;
    LocalTime startTime;
    LocalTime endTime;
    String writer;
    Integer alarm;
    String comment;

    public static ScheduleDto of(Schedule schedule) {
        return new ScheduleDto(schedule.getId(),
                schedule.getYear(),
                schedule.getMonth(),
                schedule.getDay(),
                schedule.getTitle(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getWriter(),
                schedule.getAlarm(),
                schedule.getComment());
    }
}
