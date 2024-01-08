package ru.moore.carsale.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.moore.carsale.dto.request.CarDtoRequest;
import ru.moore.carsale.dto.response.CarDtoResponse;
import ru.moore.carsale.dto.utils.OnSave;
import ru.moore.carsale.dto.utils.OnUpdate;
import ru.moore.carsale.service.CarService;
import ru.moore.carsale.specification.CarSpecifications;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
@Validated
@Slf4j
@Tag(name = "Название контроллера: car", description = "Контроллер служит для создания, редактирования, получения записей автотранспортной техникой")
public class CarController {

    private final CarService carService;

    @Operation(
            summary = "Получение всей автотранспортной техники",
            description = "Позволяет получить всю автотранспортную технику"
    )
    @GetMapping(value = "/get_all")
    @ResponseStatus(HttpStatus.OK)
    public Page<CarDtoResponse> getAllCar(@RequestParam MultiValueMap<String, String> params, @RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "20") int limit) {
        log.info("GET/Получение всей автотранспортной техники");
        if (page < 1) {
            page = 1;
        }
        return carService.getAllCar(CarSpecifications.build(params), page, limit);
    }

    @Operation(
            summary = "Создание автотранспортной техники",
            description = "Позволяет создать автотранспортную технику"
    )
    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Validated(OnSave.class)
    public ResponseEntity<CarDtoResponse> newCar(@Parameter(description = "Сущность для автотранспортной техники") @RequestBody @Valid CarDtoRequest carDtoRequest) {
        log.info("POST/Создание автотранспортной техники dto " + carDtoRequest);
        return ResponseEntity.ok(carService.newCar(carDtoRequest));
    }

    @Operation(
            summary = "Редактирование автотранспортной техники",
            description = "Позволяет редактировать автотранспортную технику"
    )
    @PutMapping(value = "/edit")
    @ResponseStatus(HttpStatus.OK)
    @Validated(OnUpdate.class)
    public ResponseEntity<CarDtoResponse> editCar(@Parameter(description = "Сущность для автотранспортной техники") @RequestBody @Valid CarDtoRequest carDtoRequest) {
        log.info("PUT/Редактирование автотранспортной техники dto " + carDtoRequest);
        return ResponseEntity.ok(carService.editCar(carDtoRequest));
    }

}
