package by.alex.bpo.dto.createquote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

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
