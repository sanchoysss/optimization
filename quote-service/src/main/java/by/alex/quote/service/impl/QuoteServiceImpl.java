package by.alex.quote.service.impl;

import by.alex.quote.model.Quote;
import by.alex.quote.repository.QuoteRepository;
import by.alex.quote.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;

    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }
}
