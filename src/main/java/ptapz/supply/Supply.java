package ptapz.supply;

import ptapz.detail.Detail;
import ptapz.shared.IdEntity;
import ptapz.supplier.Supplier;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "supply")
public class Supply extends IdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id")
    private Detail detail;

    @Column(name = "number_of_details")
    private int numberOfDetails;

    @Column(name = "created_at")
    private Instant createdAt;

    public Supply() {}

    public Supply(Supplier supplier, Detail detail, int numberOfDetails, Instant createdAt) {
        this.supplier = supplier;
        this.detail = detail;
        this.numberOfDetails = numberOfDetails;
        this.createdAt = createdAt;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
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

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + getId() +
                ", supplier=" + supplier +
                ", detail=" + detail +
                ", numberOfDetails=" + numberOfDetails +
                ", createdAt=" + createdAt +
                '}';
    }
}
