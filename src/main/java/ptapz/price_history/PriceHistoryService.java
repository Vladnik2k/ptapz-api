package ptapz.price_history;

import org.springframework.stereotype.Service;
import ptapz.detail.DetailService;
import ptapz.price_history.dto.NewPriceHistoryDto;
import ptapz.price_history.dto.PriceHistoryDto;

import java.time.Instant;
import java.util.List;

@Service
public class PriceHistoryService {
    private final PriceHistoryRepository priceHistoryRepository;
    private final DetailService detailService;

    public PriceHistoryService(PriceHistoryRepository detailRepository, DetailService detailService) {
        this.priceHistoryRepository = detailRepository;
        this.detailService = detailService;
    }

    public List<PriceHistory> getAll() {
        return priceHistoryRepository.findAll();
    }

    public PriceHistoryDto createNewPriceHistory(NewPriceHistoryDto newPriceHistoryDto) throws Exception {
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setChangedAt(newPriceHistoryDto.getChangedAt());
        priceHistory.setPrice(newPriceHistoryDto.getPrice());
        priceHistory.setDetail(detailService.getById(newPriceHistoryDto.getDetailId()));
        priceHistoryRepository.save(priceHistory);

        return new PriceHistoryDto(priceHistory);
    }
}
