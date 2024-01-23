package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.DescriptDto;
import ru.home.moviestore.kinopoisk.model.Film;
import ru.home.moviestore.model.Descript;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@UtilityClass
public class DescriptMapper {
    public Descript dtoToEntity(DescriptDto dto) {
        return Descript.builder()
                .id(dto.getId())
                .name(dto.getName())
                .text(dto.getText())
                .build();
    }

    public DescriptDto entityToDto(Descript entity) {
        return DescriptDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .text(entity.getText())
                .build();
    }

    public DescriptDto getDescript(Film film) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>");
        sb.append(film.getNameRu());
        Optional.ofNullable(film.getNameOriginal()).or(() -> Optional.ofNullable(film.getNameEn()))
                        .ifPresent(engName -> sb.append(String.format(" (%s)", engName)));
        sb.append("</h1>\n");
        if (film.getSlogan() != null) {
            sb.append("<h2>");
            sb.append(film.getSlogan());
            sb.append("</h2>\n");
        }
        sb.append("<p>");
        sb.append(film.getDescription());
        sb.append("</p>\n");

        return DescriptDto.builder()
                .name("Кинопоиск")
                .text(sb.toString().getBytes(StandardCharsets.UTF_8))
                .build();
    }
}
