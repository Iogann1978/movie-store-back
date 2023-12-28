package ru.home.moviestore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DescriptDto {
    private Long id;
    private String name;
    private String text;
}
