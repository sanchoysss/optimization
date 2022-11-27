package by.alex.quote.service.impl;

import by.alex.quote.model.Quote;
import by.alex.quote.repository.QuoteRepository;
import by.alex.quote.service.QuoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;

    @Override
    public Quote createQuote(Quote quote) {
        Quote createdQuote = quoteRepository.save(quote);
        log.info("createQuote: created quote with id {}", quote.getId());
        return createdQuote;
    }
}
