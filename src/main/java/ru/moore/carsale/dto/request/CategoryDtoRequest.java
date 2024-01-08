package ru.moore.carsale.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.carsale.dto.utils.OnSave;
import ru.moore.carsale.dto.utils.OnUpdate;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для категории ТС")
public class CategoryDtoRequest {

    @NotNull(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'id' не может быть пустым")
    @Schema(description = "Id категории ТС")
    private UUID id;

    @NotBlank(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'name' не может быть пустым")
    @Schema(description = "Наименование")
    private String name;
}
