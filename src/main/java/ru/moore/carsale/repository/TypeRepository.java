package ru.moore.carsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.moore.carsale.model.Type;

import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID>, JpaSpecificationExecutor<Type>, QuerydslPredicateExecutor<Type> {
}
