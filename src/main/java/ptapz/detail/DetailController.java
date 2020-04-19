package ptapz.detail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptapz.detail.dto.DetailDto;

import java.util.List;

import static ptapz.Constants.WEB_URL;

@RestController
@RequestMapping("/api/detail")
public class DetailController {
    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping
    @CrossOrigin(origins = WEB_URL)
    public List<DetailDto> getAll() {
        return detailService.getAll();
    }

    @GetMapping("{detailId}")
    @CrossOrigin(origins = WEB_URL)
    public ResponseEntity<DetailDto> getById(@PathVariable int detailId) {
        try {
            return new ResponseEntity<>(new DetailDto(detailService.getById(detailId)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @CrossOrigin(origins = WEB_URL)
    public DetailDto createNew(@RequestBody DetailDto detailDto) {
        return detailService.createNewDetail(detailDto);
    }

    @PutMapping
    @CrossOrigin(origins = WEB_URL)
    public DetailDto update(@RequestBody DetailDto detailDto) {
        return detailService.updateDetail(detailDto);
    }
}
