package ru.moore.carsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.moore.carsale.model.Car;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID>, JpaSpecificationExecutor<Car>, QuerydslPredicateExecutor<Car> {
}
