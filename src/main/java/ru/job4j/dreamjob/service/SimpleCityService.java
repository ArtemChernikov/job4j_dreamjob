package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.repository.CityRepository;

import java.util.Collection;

/**
 * Класс-сервис для работы с городами {@link City} в репозитории
 *
 * @author Artem Chernikov
 * @version 1.0
 * @since 21.01.2023
 */
@Service
public class SimpleCityService implements CityService {
    /**
     * Поле хранилище городов
     */
    private final CityRepository cityRepository;

    public SimpleCityService(CityRepository sql2oCityRepository) {
        this.cityRepository = sql2oCityRepository;
    }

    @Override
    public Collection<City> findAll() {
        return cityRepository.findAll();
    }
}
