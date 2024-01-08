package ru.moore.carsale.service;

import ru.moore.carsale.dto.response.CategoryDtoResponse;

import java.util.List;

public interface CategoryService {

    /**
     * Метод позволяет получить все категории ТС
     */
    List<CategoryDtoResponse> getAllCategory();

}
