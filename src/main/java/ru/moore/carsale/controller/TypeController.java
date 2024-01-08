package ru.moore.carsale.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.moore.carsale.dto.response.TypeDtoResponse;
import ru.moore.carsale.service.TypeService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/type")
@RequiredArgsConstructor
@Validated
@Slf4j
@Tag(name = "Название контроллера: type", description = "Контроллер служит для получения записей типа ТС")
public class TypeController {

    private final TypeService typeService;

    @Operation(
            summary = "Получение всех типов ТС",
            description = "Позволяет получить все типы ТС"
    )
    @GetMapping(value = "/get_all")
    @ResponseStatus(HttpStatus.OK)
    public List<TypeDtoResponse> getAllType() {
        log.info("GET/Получение всех типов ТС");
        return typeService.getAllType();
    }

}
