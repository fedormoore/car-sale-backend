package ru.moore.carsale.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для категории ТС")
public class CategoryDtoResponse {

    @Schema(description = "Id категории ТС")
    private UUID id;

    @Schema(description = "Наименование")
    private String name;
}
