package com.example.multidatasourceexample.example;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExampleService {
    private final JdbcTemplate firstJdbcTemplate;
    private final JdbcTemplate secondJdbcTemplate;

    public ExampleResponse getExampleQueryResults() {
        String sql = "SELECT * FROM example";
        String firstResult = firstJdbcTemplate.queryForObject(sql, String.class);
        String secondResult = secondJdbcTemplate.queryForObject(sql, String.class);

        ExampleResponse response = new ExampleResponse();
        response.setFirstDatabaseResult(firstResult);
        response.setSecondDatabaseResult(secondResult);
        return response;
    }

}