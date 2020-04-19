package ptapz.detail.dto;

import ptapz.detail.Detail;

public class DetailDto {
    private int id;
    private String name;
    private String vendorCode;
    private String note;
    private int price;

    public DetailDto(Detail detail) {
        this.id = detail.getId();
        this.name = detail.getName();
        this.vendorCode = detail.getVendorCode();
        this.note = detail.getNote();
        this.price = 0;
    }

    public DetailDto(Detail detail, int price) {
        this.id = detail.getId();
        this.name = detail.getName();
        this.vendorCode = detail.getVendorCode();
        this.note = detail.getNote();
        this.price = price;
    }

    public DetailDto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
