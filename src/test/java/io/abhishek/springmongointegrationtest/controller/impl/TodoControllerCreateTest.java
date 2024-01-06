package io.abhishek.springmongointegrationtest.controller.impl;

import io.abhishek.springmongointegrationtest.SpringMongoIntegrationtestApplicationTests;
import io.abhishek.springmongointegrationtest.controller.TodoApi;
import io.abhishek.springmongointegrationtest.dtos.TodoDto;
import io.abhishek.springmongointegrationtest.repository.collection.TodoCollection;
import io.abhishek.springmongointegrationtest.utils.TestDataCreationHelper;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@RunWith(Parameterized.class)
class TodoControllerCreateTest extends SpringMongoIntegrationtestApplicationTests {
    private static final String RESOURCE = "src/test/resources/todoController/create";

    @Autowired
    TodoApi todoController;

    @ParameterizedTest(name = "Scenario = {index}: {0}")
    @ArgumentsSource(TodoControllerCreate.class)
    void createTodo(String scenario) throws IOException, JSONException {
        String inputPath = RESOURCE + File.separator + scenario + File.separator + "input";
        String outputPath = RESOURCE + File.separator + scenario + File.separator + "output";

        initData(inputPath);

        TodoDto todoDto = TestDataCreationHelper.createTodoDto(inputPath + File.separator + "request.json");

        ResponseEntity<TodoDto> responseEntity = todoController.createTodo(todoDto);

        // assert
        List<TodoCollection> todoCollections = todoRepository.findAll();
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertionUtil.assertJsonArray(outputPath + "/todo.json", todoCollections);
    }

    static class TodoControllerCreate implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("addNew")
            );
        }
    }
}
