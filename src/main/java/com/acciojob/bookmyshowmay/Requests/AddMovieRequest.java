package com.acciojob.bookmyshowmay.Requests;

import com.acciojob.bookmyshowmay.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;
    private Double duration;
    private LocalDate releaseDate;
    private Language language;
    private Double rating;

}
