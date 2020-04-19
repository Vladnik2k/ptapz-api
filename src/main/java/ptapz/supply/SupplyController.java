package ptapz.supply;

import org.springframework.web.bind.annotation.*;
import ptapz.supply.dto.NewSupplyDto;
import ptapz.supply.dto.SupplyDto;

import java.util.List;
import java.util.stream.Collectors;

import static ptapz.Constants.WEB_URL;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {
    private final SupplyService supplyService;

    public SupplyController(SupplyService detailService) {
        this.supplyService = detailService;
    }

    @GetMapping
    @CrossOrigin(origins = WEB_URL)
    public List<SupplyDto> getAll() {
        return supplyService.getAll().stream().map(SupplyDto::new).collect(Collectors.toList());
    }

    @PostMapping
    @CrossOrigin(origins = WEB_URL)
    public SupplyDto createNew(@RequestBody NewSupplyDto newSupplyDto) throws Exception {
        return supplyService.createNewSupply(newSupplyDto);
    }

}
