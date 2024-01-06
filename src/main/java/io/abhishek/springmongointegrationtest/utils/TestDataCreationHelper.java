package io.abhishek.springmongointegrationtest.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import io.abhishek.springmongointegrationtest.dtos.TodoDto;
import io.abhishek.springmongointegrationtest.repository.TodoRepository;
import io.abhishek.springmongointegrationtest.repository.collection.TodoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class TestDataCreationHelper {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoCollection> saveTodoCollection(String srcDir) throws IOException {
        List<TodoCollection> todoCollections = TestUtils.readFromJson(srcDir, new TypeReference<List<TodoCollection>>() {
        });
        if (CollectionUtils.isEmpty(todoCollections)) {
            return Collections.emptyList();
        }
        return todoRepository.saveAll(todoCollections);
    }

    public static TodoDto createTodoDto(String srcDir) throws IOException {
        return TestUtils.readFromJson(srcDir, new TypeReference<TodoDto>() {
        });
    }
}
