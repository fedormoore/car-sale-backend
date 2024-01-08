package ru.moore.carsale.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.moore.carsale.dto.response.CategoryDtoResponse;
import ru.moore.carsale.dto.response.TypeDtoResponse;
import ru.moore.carsale.repository.CategoryRepository;
import ru.moore.carsale.service.CategoryService;
import ru.moore.carsale.utils.MapperUtils;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final MapperUtils mapperUtils;

    /**
     * Метод позволяет получить все категории ТС
     */
    @Override
    public List<CategoryDtoResponse> getAllCategory() {
        log.info("Все категории ТС отправлены");
        return mapperUtils.mapAll(categoryRepository.findAll(), CategoryDtoResponse.class);
    }

}
