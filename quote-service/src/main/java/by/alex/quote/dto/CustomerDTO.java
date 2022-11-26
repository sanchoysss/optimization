package by.alex.quote.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

    private UUID id;

    @Valid
    @NotNull(message = "firstName can't be null")
    @NotBlank(message = "firstName can't be empty")
    private String firstName;

    @Valid
    @NotNull(message = "lastName can't be null")
    @NotBlank(message = "lastName can't be empty")
    private String lastName;

    @Valid
    @NotNull(message = "identificationNumber can't be null")
    @NotBlank(message = "identificationNumber can't be empty")
    private String identificationNumber;

    @Valid
    @NotNull(message = "gender can't be null")
    @NotBlank(message = "gender can't be empty")
    private String gender;

    private LocalDate birthDate;

    @Valid
    @NotNull(message = "address can't be null")
    @NotEmpty(message = "address can't be empty")
    private AddressDTO address;
}
