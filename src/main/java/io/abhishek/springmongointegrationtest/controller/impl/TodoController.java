package io.abhishek.springmongointegrationtest.controller.impl;

import io.abhishek.springmongointegrationtest.controller.TodoApi;
import io.abhishek.springmongointegrationtest.dtos.TodoDto;
import io.abhishek.springmongointegrationtest.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.abhishek.springmongointegrationtest.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@AllArgsConstructor
public class TodoController implements TodoApi {

    private final TodoService todoService;

    public ResponseEntity<TodoDto> createTodo(TodoDto userDto) {
        return new ResponseEntity<>(todoService.save(userDto), HttpStatus.CREATED);
    }

    public ResponseEntity<TodoDto> updateTodo(TodoDto todoDto) {
        return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
    }

    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<TodoDto> getTodo(Long todoId) {
        return new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteTodo(Long id) {
        return null;
    }
}
