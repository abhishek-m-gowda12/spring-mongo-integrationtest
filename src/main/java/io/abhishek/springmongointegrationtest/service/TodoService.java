package io.abhishek.springmongointegrationtest.service;


import io.abhishek.springmongointegrationtest.dtos.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto save(TodoDto todoDto);

    List<TodoDto> findAll();

    TodoDto findById(Long id);

    void delete(Long id);

}
