package com.example.reactivejdbcexample.example.domain;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {
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

    public static Schedule of(ScheduleDto scheduleDto) {
        return new Schedule(scheduleDto.getId(),
                scheduleDto.getYear(),
                scheduleDto.getMonth(),
                scheduleDto.getDay(),
                scheduleDto.getTitle(),
                scheduleDto.getStartTime(),
                scheduleDto.getEndTime(),
                scheduleDto.getWriter(),
                scheduleDto.getAlarm(),
                scheduleDto.getComment());
    }
}