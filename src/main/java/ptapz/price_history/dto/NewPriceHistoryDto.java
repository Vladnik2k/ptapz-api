package ptapz.price_history.dto;

import java.time.LocalDate;

public class NewPriceHistoryDto {
    private int detailId;
    private LocalDate changedAt;
    private int price;

    public NewPriceHistoryDto(int detailId, LocalDate changedAt, int price) {
        this.detailId = detailId;
        this.changedAt = changedAt;
        this.price = price;
    }

    public NewPriceHistoryDto() {
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
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
