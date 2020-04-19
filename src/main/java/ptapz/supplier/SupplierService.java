package ptapz.supplier;

import org.springframework.stereotype.Service;
import ptapz.supplier.dto.SupplierDto;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository detailRepository) {
        this.supplierRepository = detailRepository;
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public SupplierDto createNewDetail(SupplierDto supplierDto) {
        Supplier supplier = new Supplier(supplierDto);
        supplierRepository.save(supplier);

        return new SupplierDto(supplier);
    }

    public SupplierDto updateDetail(SupplierDto supplierDto) {
        Supplier supplier = new Supplier(supplierDto);
        supplier.setId(supplierDto.getId());
        supplierRepository.save(supplier);

        return new SupplierDto(supplier);
    }

    public Supplier getById(int supplierId) throws Exception {
        return supplierRepository.findById(supplierId).orElseThrow(() -> new Exception("No supplier found"));
    }
}
