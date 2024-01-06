package io.abhishek.springmongointegrationtest;

import io.abhishek.springmongointegrationtest.config.IntegrationTestConfig;
import io.abhishek.springmongointegrationtest.repository.TodoRepository;
import io.abhishek.springmongointegrationtest.util.AssertionUtil;
import io.abhishek.springmongointegrationtest.utils.TestDataCreationHelper;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.io.IOException;

@ContextConfiguration(classes = IntegrationTestConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringMongoIntegrationtestApplicationTests {

    @Autowired
    protected TodoRepository todoRepository;
    @Autowired
    protected AssertionUtil assertionUtil;
    @Autowired
    private TestDataCreationHelper testDataCreationHelper;

    protected void initData(String resource) throws IOException {
        testDataCreationHelper.saveTodoCollection(resource + File.separator + "todo.json");
    }

    @AfterEach
    void tearDown() {
        todoRepository.deleteAll();
    }

}
