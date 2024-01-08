package ru.moore.carsale.service;

import ru.moore.carsale.dto.response.TypeDtoResponse;

import java.util.List;

public interface TypeService {

    /**
     * Метод позволяет получить все типы ТС
     */
    List<TypeDtoResponse> getAllType();

}
