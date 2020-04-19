package ptapz.supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptapz.supplier.dto.SupplierDto;

import java.util.List;
import java.util.stream.Collectors;

import static ptapz.Constants.WEB_URL;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService detailService) {
        this.supplierService = detailService;
    }

    @GetMapping
    @CrossOrigin(origins = WEB_URL)
    public List<SupplierDto> getAll() {
        return supplierService.getAll().stream().map(SupplierDto::new).collect(Collectors.toList());
    }

    @GetMapping("{supplierId}")
    @CrossOrigin(origins = WEB_URL)
    public ResponseEntity<SupplierDto> getById(@PathVariable int supplierId) {
        try {
            return new ResponseEntity<>(new SupplierDto(supplierService.getById(supplierId)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @CrossOrigin(origins = WEB_URL)
    public SupplierDto createNew(@RequestBody SupplierDto supplierDto) {
        return supplierService.createNewDetail(supplierDto);
    }

    @PutMapping
    @CrossOrigin(origins = WEB_URL)
    public SupplierDto update(@RequestBody SupplierDto supplierDto) {
        return supplierService.updateDetail(supplierDto);
    }
}
