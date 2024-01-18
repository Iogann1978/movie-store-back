package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.model.Country;
import ru.home.moviestore.repository.CountryRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public void saveAll(Set<Country> countries) {
        countryRepository.saveAll(countries);
    }
}
