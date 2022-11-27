package by.alex.bpo.service.impl;

import by.alex.bpo.dto.createquote.Price;
import by.alex.bpo.dto.createquote.Quote;
import by.alex.bpo.feign.QuoteClient;
import by.alex.bpo.service.QuoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private QuoteClient quoteClient;

    @Override
    public Quote createQuote(Quote quote) {
        setQuoteTotalPrice(quote);
        ResponseEntity<Quote> responseEntity = quoteClient.createQuote(quote);
        return responseEntity.getBody();
    }

    private void setQuoteTotalPrice(Quote quote) {
        AtomicReference<Double> valueExcludingVAT = new AtomicReference<>(0d);
        AtomicReference<Double> valueIncludingVAT = new AtomicReference<>(0d);
        calculateValues(quote, valueExcludingVAT, valueIncludingVAT);
        quote.setTotalPrice(
                Price.builder()
                        .valueExcludingVAT(valueExcludingVAT.toString())
                        .valueIncludingVAT(valueIncludingVAT.toString())
                        .build()
        );
    }

    private void calculateValues(Quote quote, AtomicReference<Double> valueExcludingVAT, AtomicReference<Double> valueIncludingVAT) {
        quote.getQuoteItems().forEach(quoteItem -> {
            valueExcludingVAT.updateAndGet(v -> v + Double.parseDouble(quoteItem.getQuoteItemPrice().getValueExcludingVAT()));
            valueIncludingVAT.updateAndGet(v -> v + Double.parseDouble(quoteItem.getQuoteItemPrice().getValueIncludingVAT()));
        });
    }
}
