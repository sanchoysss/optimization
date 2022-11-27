package by.alex.bpo.dto.createquote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

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
    private Address address;
}
