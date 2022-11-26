package by.alex.quote.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
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
public class QuoteItemDTO {

    private UUID id;

    @Valid
    @NotNull(message = "quoteItemPrice can't be null")
    @NotEmpty(message = "quoteItemPrice can't be empty")
    private PriceDTO quoteItemPrice;

    @Valid
    @NotNull(message = "productOffering can't be null")
    @NotEmpty(message = "productOffering can't be empty")
    private ProductOfferingDTO productOffering;
}
