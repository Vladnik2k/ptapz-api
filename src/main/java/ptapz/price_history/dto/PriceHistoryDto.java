package ptapz.price_history.dto;

import ptapz.detail.dto.DetailDto;
import ptapz.price_history.PriceHistory;

import java.time.LocalDate;

public class PriceHistoryDto {
    private int id;
    private DetailDto detail;
    private LocalDate changedAt;
    private int price;

    public PriceHistoryDto(PriceHistory priceHistory) {
        this.id = priceHistory.getId();
        this.detail = new DetailDto(priceHistory.getDetail());
        this.changedAt = priceHistory.getChangedAt();
        this.price = priceHistory.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DetailDto getDetail() {
        return detail;
    }

    public void setDetail(DetailDto detail) {
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
}
