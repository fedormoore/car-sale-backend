package ru.moore.carsale.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.moore.carsale.dto.response.TypeDtoResponse;
import ru.moore.carsale.repository.TypeRepository;
import ru.moore.carsale.service.TypeService;
import ru.moore.carsale.utils.MapperUtils;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    private final MapperUtils mapperUtils;

    /**
     * Метод позволяет получить все типы ТС
     */
    @Override
    public List<TypeDtoResponse> getAllType() {
        log.info("Все типы ТС отправлены");
        return mapperUtils.mapAll(typeRepository.findAll(), TypeDtoResponse.class);
    }

}
