package ru.home.moviestore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private String originTitle;
    private Integer externalRating;
    private Integer internalRating;
    private Integer year;
    private String state;
    private Integer duration;
    private Boolean serial;
    private Set<String> tags;
    private Set<String> countries;
    private Set<DescriptDto> descripts;
}
