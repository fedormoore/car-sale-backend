package ru.moore.carsale.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.moore.carsale.dto.response.CategoryDtoResponse;
import ru.moore.carsale.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Validated
@Slf4j
@Tag(name = "Название контроллера: category", description = "Контроллер служит для получения записей категорий ТС")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(
            summary = "Получение всех категорий ТС",
            description = "Позволяет получить все категории ТС"
    )
    @GetMapping(value = "/get_all")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDtoResponse> getAllCategory() {
        log.info("GET/Получение всех категорий ТС");
        return categoryService.getAllCategory();
    }

}
