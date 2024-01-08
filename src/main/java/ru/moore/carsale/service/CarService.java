package ru.moore.carsale.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import ru.moore.carsale.dto.request.CarDtoRequest;
import ru.moore.carsale.dto.response.CarDtoResponse;
import ru.moore.carsale.model.Car;

public interface CarService {

    /**
     * Метод позволяет получить всю автотранспортную технику
     */
    Page<CarDtoResponse> getAllCar(Specification<Car> spec, int page, int pageSize);


    /**
     * Метод позволяет создать автотранспортную технику
     *
     * @param carDtoRequest принимает в качестве параметра carDtoRequest
     */
    CarDtoResponse newCar(CarDtoRequest carDtoRequest);

    /**
     * Метод позволяет редактировать автотранспортную технику
     *
     * @param carDtoRequest принимает в качестве параметра carDtoRequest
     */
    CarDtoResponse editCar(CarDtoRequest carDtoRequest);

}
