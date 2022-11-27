package by.alex.bpo.dto.createquote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuoteItem {

    private UUID id;

    @Valid
    @NotNull(message = "quoteItemPrice can't be null")
    @NotEmpty(message = "quoteItemPrice can't be empty")
    private Price quoteItemPrice;

    @Valid
    @NotNull(message = "productOffering can't be null")
    @NotEmpty(message = "productOffering can't be empty")
    private ProductOffering productOffering;
}
