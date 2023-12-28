package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import org.apache.tomcat.util.codec.binary.StringUtils;
import ru.home.moviestore.dto.DescriptDto;
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
}
