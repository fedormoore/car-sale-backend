package ru.moore.carsale.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.moore.carsale.model.Car;

public class CarSpecifications {

    public static Specification<Car> whereMake(String make) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("make")), "%" + make.toLowerCase() + "%");
    }

    private static Specification<Car> whereModel(String model) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + model.toLowerCase() + "%");
    }

    private static Specification<Car> whereCategory(String category) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), "%" + category.toLowerCase() + "%");
    }

    private static Specification<Car> whereGosNumber(String gosNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("gosNumber")), "%" + gosNumber.toLowerCase() + "%");
    }

    private static Specification<Car> whereType(String type) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("type")), "%" + type.toLowerCase() + "%");
    }

    private static Specification<Car> whereYearIssue(String yearIssue) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("yearIssue"), yearIssue.toLowerCase());
    }

    private static Specification<Car> whereTrailer(boolean trailer) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("trailer"), trailer);
    }

    public static Specification<Car> build(MultiValueMap<String, String> params) {
        Specification<Car> spec = Specification.where(null);
        if (params.containsKey("make") && !params.getFirst("make").isBlank()) {
            for (int i = 0; i < params.get("make").size(); i++) {
                spec = spec.and(whereMake(params.get("make").get(i)));
            }
        }
        if (params.containsKey("model") && !params.getFirst("model").isBlank()) {
            for (int i = 0; i < params.get("model").size(); i++) {
                spec = spec.and(whereModel(params.get("model").get(i)));
            }
        }
        if (params.containsKey("category") && !params.getFirst("category").isBlank()) {
            for (int i = 0; i < params.get("category").size(); i++) {
                spec = spec.and(whereCategory(params.get("category").get(i)));
            }
        }
        if (params.containsKey("gosNumber") && !params.getFirst("gosNumber").isBlank()) {
            for (int i = 0; i < params.get("gosNumber").size(); i++) {
                spec = spec.and(whereGosNumber(params.get("gosNumber").get(i)));
            }
        }
        if (params.containsKey("type") && !params.getFirst("type").isBlank()) {
            for (int i = 0; i < params.get("type").size(); i++) {
                spec = spec.and(whereType(params.get("type").get(i)));
            }
        }
        if (params.containsKey("yearIssue") && !params.getFirst("yearIssue").isBlank()) {
            for (int i = 0; i < params.get("yearIssue").size(); i++) {
                spec = spec.and(whereYearIssue(params.get("yearIssue").get(i)));
            }
        }
        if (params.containsKey("trailer") && !params.getFirst("trailer").isBlank()) {
            for (int i = 0; i < params.get("trailer").size(); i++) {
                spec = spec.and(whereTrailer(Boolean.parseBoolean(params.get("trailer").get(i))));
            }
        }
        return spec;
    }

}
