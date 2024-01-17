package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import org.apache.tomcat.util.codec.binary.StringUtils;
import ru.home.moviestore.dto.DescriptDto;
import ru.home.moviestore.kinopoisk.model.Film;
import ru.home.moviestore.model.Descript;

import java.nio.charset.StandardCharsets;

@UtilityClass
public class DescriptMapper {
    public Descript dtoToEntity(DescriptDto dto) {
        return Descript.builder()
                .id(dto.getId())
                .name(dto.getName())
                .text(dto.getText().getBytes(StandardCharsets.UTF_8))
                .build();
    }

    public DescriptDto entityToDto(Descript entity) {
        return DescriptDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .text(StringUtils.newStringUtf8(entity.getText()))
                .build();
    }

    public DescriptDto getDescript(Film film) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>");
        sb.append(film.getSlogan());
        sb.append("</h1>\n");
        sb.append("<p>");
        sb.append(film.getShortFilm());
        sb.append("</p>\n");
        sb.append("<p>");
        sb.append(film.getDescription());
        sb.append("</p>\n");

        return DescriptDto.builder()
                .name("Кинопоиск")
                .text(sb.toString())
                .build();
    }
}
