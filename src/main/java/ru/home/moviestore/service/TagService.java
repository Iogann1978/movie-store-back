package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.model.Tag;
import ru.home.moviestore.repository.TagRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public void saveAll(Set<Tag> tags) {
        tagRepository.saveAll(tags);
    }
}
