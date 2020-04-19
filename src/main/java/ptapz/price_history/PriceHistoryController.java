package ptapz.price_history;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptapz.price_history.dto.NewPriceHistoryDto;
import ptapz.price_history.dto.PriceHistoryDto;

import java.util.List;
import java.util.stream.Collectors;

import static ptapz.Constants.WEB_URL;

@RestController
@RequestMapping("/api/price-history")
public class PriceHistoryController {
    private final PriceHistoryService priceHistoryService;

    public PriceHistoryController(PriceHistoryService detailService) {
        this.priceHistoryService = detailService;
    }

    @GetMapping
    @CrossOrigin(origins = WEB_URL)
    public List<PriceHistoryDto> getAll() {
        return priceHistoryService.getAll().stream().map(PriceHistoryDto::new).collect(Collectors.toList());
    }

    @PostMapping
    @CrossOrigin(origins = WEB_URL)
    public ResponseEntity<PriceHistoryDto> createNew(@RequestBody NewPriceHistoryDto newPriceHistoryDto) {
        try {
            return new ResponseEntity<>(priceHistoryService.createNewPriceHistory(newPriceHistoryDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
