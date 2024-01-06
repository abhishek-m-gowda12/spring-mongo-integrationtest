package io.abhishek.springmongointegrationtest.repository;


import io.abhishek.springmongointegrationtest.repository.collection.TodoCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<TodoCollection, Long> {

}
