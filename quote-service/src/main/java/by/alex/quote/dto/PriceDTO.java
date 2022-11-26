package by.alex.quote.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDTO {

    private UUID id;

    @Valid
    @NotNull(message = "valueIncludingVAT can't be null")
    @NotBlank(message = "valueIncludingVAT can't be empty")
    private String valueIncludingVAT;

    @Valid
    @NotNull(message = "valueExcludingVAT can't be null")
    @NotBlank(message = "valueExcludingVAT can't be empty")
    private String valueExcludingVAT;
}
