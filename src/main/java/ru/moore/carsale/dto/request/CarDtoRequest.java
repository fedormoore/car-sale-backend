package ru.moore.carsale.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.carsale.dto.utils.OnSave;
import ru.moore.carsale.dto.utils.OnUpdate;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для автотранспортной техникой")
public class CarDtoRequest {

    @NotNull(groups = OnUpdate.class, message = "Значение 'id' не может быть пустым")
    @Schema(description = "Id автотранспортной техникой")
    private UUID id;

    @NotBlank(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'make' не может быть пустым")
    @Schema(description = "Марка")
    private String make;

    @NotBlank(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'model' не может быть пустым")
    @Schema(description = "Модель")
    private String model;

    @NotNull(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'category' не может быть пустым")
    @Schema(description = "Категория")
    private @Valid CategoryDtoRequest category;

    @NotBlank(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'gosNumber' не может быть пустым")
    @Schema(description = "Государственный номер")
    private String gosNumber;

    @NotNull(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'type' не может быть пустым")
    @Schema(description = "Тип ТС")
    private @Valid TypeDtoRequest type;

    @NotNull(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'yearIssue' не может быть пустым")
    @Schema(description = "Год выпуска")
    private Integer yearIssue;

    @AssertTrue(groups = {OnSave.class, OnUpdate.class}, message = "Значение 'yearIssue' должен быть больше 0 и меньше или равняться текущему году")
    private boolean isYearIssue() {
        return yearIssue != null && yearIssue > 0 && yearIssue <= LocalDate.now().getYear();
    }

    @Pattern(regexp = "^(true|false)$", message = "Значение 'trailer' должно принимать значение 'true' или 'false'")
    @Schema(description = "Наличие прицепа")
    private String trailer;

}
