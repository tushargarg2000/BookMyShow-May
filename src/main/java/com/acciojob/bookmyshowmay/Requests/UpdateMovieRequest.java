package com.acciojob.bookmyshowmay.Requests;

import com.acciojob.bookmyshowmay.Enums.Language;
import lombok.Data;

@Data
public class UpdateMovieRequest {

    private String movieName;
    private Language newLanguage;
    private Double newRating;

}
