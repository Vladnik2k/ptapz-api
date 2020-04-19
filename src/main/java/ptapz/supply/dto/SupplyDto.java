package ptapz.supply.dto;

import ptapz.detail.dto.DetailDto;
import ptapz.supplier.dto.SupplierDto;
import ptapz.supply.Supply;

import java.time.Instant;

public class SupplyDto {
    private int id;
    private SupplierDto supplier;
    private DetailDto detail;
    private int numberOfDetails;
    private Instant createdAt;

    public SupplyDto(Supply supply) {
        this.id = supply.getId();
        this.supplier = new SupplierDto(supply.getSupplier());
        this.detail = new DetailDto(supply.getDetail());
        this.numberOfDetails = supply.getNumberOfDetails();
        this.createdAt = supply.getCreatedAt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public DetailDto getDetail() {
        return detail;
    }

    public void setDetail(DetailDto detail) {
        this.detail = detail;
    }

    public int getNumberOfDetails() {
        return numberOfDetails;
    }

    public void setNumberOfDetails(int numberOfDetails) {
        this.numberOfDetails = numberOfDetails;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}