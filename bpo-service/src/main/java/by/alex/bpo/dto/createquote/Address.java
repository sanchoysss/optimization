package by.alex.bpo.dto.createquote;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private UUID id;

    @Valid
    @NotNull(message = "country can't be null")
    @NotBlank(message = "country can't be empty")
    private String country;

    @Valid
    @NotNull(message = "city can't be null")
    @NotBlank(message = "country can't be empty")
    private String city;

    @Valid
    @NotNull(message = "street can't be null")
    @NotBlank(message = "street can't be empty")
    private String street;

    @Valid
    @NotNull(message = "houseNumber can't be null")
    @NotBlank(message = "houseNumber can't be empty")
    private String houseNumber;

    private String houseNumberExtension;

    private String flatNumber;

    @Valid
    @NotNull(message = "postCode can't be null")
    @NotBlank(message = "postCode can't be empty")
    private String postCode;
}
