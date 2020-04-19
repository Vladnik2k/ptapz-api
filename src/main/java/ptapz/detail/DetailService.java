package ptapz.detail;

import org.springframework.stereotype.Service;
import ptapz.detail.dto.DetailDto;
import ptapz.price_history.PriceHistory;
import ptapz.price_history.PriceHistoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailService {
    private final DetailRepository detailRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    public DetailService(DetailRepository detailRepository, PriceHistoryRepository priceHistoryRepository) {
        this.detailRepository = detailRepository;
        this.priceHistoryRepository = priceHistoryRepository;
    }

    public List<DetailDto> getAll() {
        return detailRepository.findAll()
                .stream()
                .map(detail -> {
                    List<PriceHistory> priceHistories = priceHistoryRepository.findAllByDetail(detail)
                            .stream()
                            .filter(priceHistory -> !priceHistory.getChangedAt().isAfter(LocalDate.now()))
                            .collect(Collectors.toList());
                    int price = !priceHistories.isEmpty() ? priceHistories.get(priceHistories.size() - 1).getPrice() : 0;
                    return new DetailDto(detail, price);
                })
                .collect(Collectors.toList());
    }

    public DetailDto createNewDetail(DetailDto detailDto) {
        Detail detail = new Detail(detailDto);
        detailRepository.save(detail);

        return new DetailDto(detail);
    }

    public DetailDto updateDetail(DetailDto detailDto) {
        Detail detail = new Detail(detailDto);
        detail.setId(detailDto.getId());
        detailRepository.save(detail);

        return new DetailDto(detail);
    }

    public Detail getById(int detailId) throws Exception {
        return detailRepository.findById(detailId).orElseThrow(() -> new Exception("No detail found"));
    }
}
