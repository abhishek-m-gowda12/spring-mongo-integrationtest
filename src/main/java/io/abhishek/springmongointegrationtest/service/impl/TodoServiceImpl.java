package io.abhishek.springmongointegrationtest.service.impl;

import io.abhishek.springmongointegrationtest.dtos.TodoDto;
import io.abhishek.springmongointegrationtest.exception.ErrorCodes;
import io.abhishek.springmongointegrationtest.exception.InvalidEntityException;
import io.abhishek.springmongointegrationtest.repository.TodoRepository;
import io.abhishek.springmongointegrationtest.service.TodoService;
import io.abhishek.springmongointegrationtest.validators.TodoValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDto save(TodoDto todoDto) {
    List<String> errors = TodoValidator.validateTodo(todoDto);
        if (!errors.isEmpty()) {
            log.error("Todo is not valid {}", todoDto);
            throw new InvalidEntityException("Todo is not valid", ErrorCodes.TODO_NOT_VALID, errors);
        }
        return TodoDto.fromEntity(todoRepository.save(TodoDto.toEntity(todoDto)));
    }

    @Override
    public List<TodoDto> findAll() {
        return todoRepository.findAll().stream()
                .map(TodoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
