package ru.moore.carsale.service.impl;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.moore.carsale.dto.request.CarDtoRequest;
import ru.moore.carsale.dto.response.CarDtoResponse;
import ru.moore.carsale.exception.ErrorTemplate;
import ru.moore.carsale.model.Car;
import ru.moore.carsale.model.Category;
import ru.moore.carsale.model.QCar;
import ru.moore.carsale.model.Type;
import ru.moore.carsale.repository.CarRepository;
import ru.moore.carsale.service.CarService;
import ru.moore.carsale.utils.MapperUtils;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final MapperUtils mapperUtils;

    /**
     * Метод позволяет получить всю автотранспортную технику
     */
    @Override
    public Page<CarDtoResponse> getAllCar(Specification<Car> spec, int page, int pageSize) {
        log.info("Вся автотранспортная техника отправлены");
        return carRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(res -> mapperUtils.map(res, CarDtoResponse.class));
    }

    /**
     * Метод позволяет создать автотранспортную технику
     *
     * @param carDtoRequest принимает в качестве параметра taskDto
     */
    @Override
    public CarDtoResponse newCar(CarDtoRequest carDtoRequest) {
        findGosNumber(carDtoRequest.getGosNumber());
        Car newCar = mapperUtils.map(carDtoRequest, Car.class);
        carRepository.save(newCar);
        return mapperUtils.map(newCar, CarDtoResponse.class);
    }

    /**
     * Метод позволяет редактировать автотранспортную технику
     *
     * @param carDtoRequest принимает в качестве параметра carDtoRequest
     */
    @Override
    public CarDtoResponse editCar(CarDtoRequest carDtoRequest) {
        findGosNumber(carDtoRequest.getId(), carDtoRequest.getGosNumber());
        Optional<Car> findCar = carRepository.findById(carDtoRequest.getId());
        if (findCar.isPresent()) {
            findCar.get().setMake(carDtoRequest.getMake());
            findCar.get().setModel(carDtoRequest.getModel());
            findCar.get().setCategory(mapperUtils.map(carDtoRequest.getCategory(), Category.class));
            findCar.get().setGosNumber(carDtoRequest.getGosNumber());
            findCar.get().setType(mapperUtils.map(carDtoRequest.getType(), Type.class));
            findCar.get().setYearIssue(carDtoRequest.getYearIssue());
            findCar.get().setTrailer(Boolean.valueOf(carDtoRequest.getTrailer()));
            carRepository.save(findCar.get());
            return mapperUtils.map(findCar.get(), CarDtoResponse.class);
        }
        throw new ErrorTemplate(HttpStatus.NOT_FOUND, "Автотранспортная техника по id " + carDtoRequest.getId() + " не найдена");
    }

    /**
     * Метод позволяет проверить на уникальность государственный номер
     *
     * @param gosNumber принимает в качестве параметра государственный номер
     */
    public void findGosNumber(String gosNumber) {
        Predicate predicate = QCar.car.gosNumber.equalsIgnoreCase(gosNumber);
        Optional<Car> findCar = carRepository.findOne(predicate);
        if (findCar.isPresent()) {
            throw new ErrorTemplate(HttpStatus.NOT_FOUND, "Государственный номер " + gosNumber + " уже существует");
        }
    }

    /**
     * Метод позволяет проверить на уникальность государственный номер
     *
     * @param id        принимает в качестве параметра id записи
     * @param gosNumber принимает в качестве параметра государственный номер
     */
    public void findGosNumber(UUID id, String gosNumber) {
        Predicate predicate = QCar.car.gosNumber.equalsIgnoreCase(gosNumber).and(QCar.car.id.notIn(id));
        Optional<Car> findCar = carRepository.findOne(predicate);
        if (findCar.isPresent()) {
            throw new ErrorTemplate(HttpStatus.NOT_FOUND, "Государственный номер " + gosNumber + " уже существует");
        }
    }
}
