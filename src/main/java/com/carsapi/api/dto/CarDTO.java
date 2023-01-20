package com.carsapi.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record CarDTO(
        @NotBlank String modelo,

        @NotBlank String fabricante,

        @Past Date dataFabricacao,

        // * Regex: valid year from 1900 to 2099.
        @Pattern(regexp = "^(19|20)\\d{2}$") @NotNull int anoModelo) {
}
