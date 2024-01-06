package io.abhishek.springmongointegrationtest.controller;

import io.abhishek.springmongointegrationtest.dtos.TodoDto;
import io.abhishek.springmongointegrationtest.handlers.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "/todos")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface TodoApi {

    @PostMapping(value = "/todos/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Create To do", summary = "Creates a new to do ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "The newly created To do.")
            })
    ResponseEntity<TodoDto> createTodo(
            @Parameter(name = "Todo DTO", required = true) @RequestBody TodoDto todoDto);

    @PutMapping(value = "/todos/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Update Todo", summary = "Updates an existing Todo ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "The newly created Todo.")
            })
    ResponseEntity<TodoDto> updateTodo(
            @Parameter(name = "Todo DTO", required = true) @RequestBody TodoDto user);

    @GetMapping(value = "/todos/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Todo Details", summary = "Returns the list of the Todos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of the Todos")
            })
    ResponseEntity<List<TodoDto>> getAllTodos();

    @GetMapping(value = "/todos/{todoId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Todo Details", summary = "Returns the Todo by ID", responses = {
            @ApiResponse(responseCode = "200", description = "The Todo"),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = {
                    @Content(schema = @Schema(implementation = ErrorDto.class))})
    })
    ResponseEntity<TodoDto> getTodo(
            @Parameter(name = "todoId", description = "The Todo id", required = true) @PathParam(value = "todoId") Long todoId
    );

    @DeleteMapping(value = "/todos/delete/{id:.+}")
    @Operation(description = "Delete Todo", summary = "Deletes a Todo by ID", responses = {
            @ApiResponse(responseCode = "200", description = "The Todo deleted"),
            @ApiResponse(responseCode = "404", description = "Todo not found", content = {
                    @Content(schema = @Schema(implementation = ErrorDto.class))})
    })
    ResponseEntity<Void> deleteTodo(
            @Parameter(name = "id", description = "The Todo id", required = true) Long id
    );
}
