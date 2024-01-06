package io.abhishek.springmongointegrationtest.repository.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todo")
public class TodoCollection  {

    private ObjectId id;

    private String title;

    private String description;

    private Date startDate;

    private boolean done;

    private boolean favorite;
}

