package ptapz.price_history;

import ptapz.detail.Detail;
import ptapz.shared.IdEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "price_history")
public class PriceHistory extends IdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id")
    private Detail detail;

    @Column(name = "changed_at")
    private LocalDate changedAt;

    @Column(name = "price")
    private int price;

    public PriceHistory() {}

    public PriceHistory(Detail detail, LocalDate changedAt, int price) {
        this.detail = detail;
        this.changedAt = changedAt;
        this.price = price;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public LocalDate getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDate changedAt) {
        this.changedAt = changedAt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceHistory{" +
                "id=" + getId() +
                ", detail=" + detail +
                ", changedAt=" + changedAt +
                ", price=" + price +
                '}';
    }
}
