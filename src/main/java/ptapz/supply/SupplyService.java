package ptapz.supply;

import org.springframework.stereotype.Service;
import ptapz.detail.DetailService;
import ptapz.supplier.SupplierService;
import ptapz.supply.dto.NewSupplyDto;
import ptapz.supply.dto.SupplyDto;

import java.time.Instant;
import java.util.List;

@Service
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final DetailService detailService;
    private final SupplierService supplierService;

    public SupplyService(SupplyRepository detailRepository, DetailService detailService, SupplierService supplierService) {
        this.supplyRepository = detailRepository;
        this.detailService = detailService;
        this.supplierService = supplierService;
    }

    public List<Supply> getAll() {
        return supplyRepository.findAll();
    }

    public SupplyDto createNewSupply(NewSupplyDto newSupplyDto) throws Exception {
        Supply supply = new Supply();
        supply.setCreatedAt(Instant.now());
        supply.setDetail(detailService.getById(newSupplyDto.getDetailId()));
        supply.setSupplier(supplierService.getById(newSupplyDto.getSupplierId()));
        supply.setNumberOfDetails(newSupplyDto.getNumberOfDetails());
        supplyRepository.save(supply);

        return new SupplyDto(supply);
    }

}
