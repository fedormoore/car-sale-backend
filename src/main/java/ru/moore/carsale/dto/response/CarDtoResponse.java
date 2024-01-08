package ru.moore.carsale.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность для автотранспортной техникой")
public class CarDtoResponse {

    @Schema(description = "Id автотранспортной техникой")
    private UUID id;

    @Schema(description = "Марка")
    private String make;

    @Schema(description = "Модель")
    private String model;

    @Schema(description = "Категория")
    private CategoryDtoResponse category;

    @Schema(description = "Государственный номер")
    private String gosNumber;

    @Schema(description = "Тип ТС")
    private TypeDtoResponse type;

    @Schema(description = "Год выпуска")
    private int yearIssue;

    @Schema(description = "Наличие прицепа")
    private boolean trailer;

    @Schema(description = "Дата создания записи")
    private Date createdAt;

    @Schema(description = "Дата обновления записи")
    private Date updateAt;
}
