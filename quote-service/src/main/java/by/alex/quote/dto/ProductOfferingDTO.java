package by.alex.quote.dto;

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
public class ProductOfferingDTO {

    @Valid
    @NotNull(message = "productId can't be null")
    @NotBlank(message = "productId can't be empty")
    private UUID productId;

    @Valid
    @NotNull(message = "product offering name can't be null")
    @NotBlank(message = "product offering name can't be empty")
    private String name;
}
