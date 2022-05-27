package com.example.reactivejdbcexample.example.service;

import com.example.reactivejdbcexample.example.domain.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReactiveJdbcExampleService {

    private final JdbcTemplate jdbcTemplate;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    public List<Schedule> getSchedules(int year) {
        return jdbcTemplate.query("select * from schedule where year = ?", new BeanPropertyRowMapper<>(Schedule.class), year);
    }

    public Flux<Schedule> getSchedulesReactive(int year) {
        return r2dbcEntityTemplate.select(Query.query(Criteria.where("year").is(year)), Schedule.class);
    }
}
