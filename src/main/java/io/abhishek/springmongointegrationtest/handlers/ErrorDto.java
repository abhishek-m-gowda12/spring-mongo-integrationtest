package io.abhishek.springmongointegrationtest.handlers;

import io.abhishek.springmongointegrationtest.exception.ErrorCodes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Holds error code, error message and related error messages of an error")
public class ErrorDto {

    @Schema(description = "The error code.")
    private Integer httpCode;

    @Schema(description = "The error code.")
    private ErrorCodes code;

    @Schema(description = "A detailed error message.")
    private String message;

    @Builder.Default
    @Schema(description = "The input fields related to the error, if any.")
    List<String> errors = new ArrayList<>();
}
