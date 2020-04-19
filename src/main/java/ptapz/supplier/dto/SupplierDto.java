package ptapz.supplier.dto;

import ptapz.supplier.Supplier;

public class SupplierDto {
    private int id;
    private String name;
    private String address;
    private Long phoneNumber;

    public SupplierDto(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.address = supplier.getAddress();
        this.phoneNumber = supplier.getPhoneNumber();
    }

    public SupplierDto() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
