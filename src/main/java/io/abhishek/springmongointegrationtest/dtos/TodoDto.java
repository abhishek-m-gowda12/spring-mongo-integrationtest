package io.abhishek.springmongointegrationtest.dtos;

import io.abhishek.springmongointegrationtest.repository.collection.TodoCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {

    private Long id;

    private String title;

    private String description;

    private Date startDate;

    private boolean done;

    private boolean favorite;

    public static TodoCollection toEntity(TodoDto todoDto) {
        final TodoCollection todoCollection = new TodoCollection();
        todoCollection.setTitle(todoDto.getTitle());
        todoCollection.setDescription(todoDto.getDescription());
        todoCollection.setDone(todoDto.isDone());
        todoCollection.setFavorite(todoDto.isFavorite());
        todoCollection.setStartDate(new Date());

        return todoCollection;
    }

    public static TodoDto fromEntity(TodoCollection todoEntity) {
        return TodoDto.builder()
//                .id(todoEntity.getId())
                .title(todoEntity.getTitle())
                .description(todoEntity.getDescription())
                .startDate(todoEntity.getStartDate())
                .done(todoEntity.isDone())
                .favorite(todoEntity.isFavorite())
                .build();
    }
}
