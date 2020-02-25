package com.felipe.library.controller.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDTO {

    private String name;
    private Double edition;
    private String publicationYear;
    private List<Integer> authorsId = new ArrayList<>();

}



