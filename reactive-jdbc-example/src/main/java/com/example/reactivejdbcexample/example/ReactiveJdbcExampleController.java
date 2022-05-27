package com.example.reactivejdbcexample.example;

import com.example.reactivejdbcexample.example.domain.Schedule;
import com.example.reactivejdbcexample.example.service.ReactiveJdbcExampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReactiveJdbcExampleController {
    private final ReactiveJdbcExampleService reactiveJdbcExampleService;

    @GetMapping("/r2dbc/example1/{year}")
    public Flux<Schedule> r2dbcExample1(@PathVariable("year") int year) {
        return reactiveJdbcExampleService.getSchedulesReactive(year);
    }

    @GetMapping("/jdbc/example1/{year}")
    public List<Schedule> jdbcExample1(@PathVariable("year") int year) {
        return reactiveJdbcExampleService.getSchedules(year);
    }
}
