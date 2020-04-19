package ptapz.detail;

import ptapz.detail.dto.DetailDto;
import ptapz.shared.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class Detail extends IdEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "note")
    private String note;

    public Detail() {}

    public Detail(String name, String vendorCode, String note) {
        this.name = name;
        this.vendorCode = vendorCode;
        this.note = note;
    }

    public Detail(DetailDto detailDto) {
        this.name = detailDto.getName();
        this.vendorCode = detailDto.getVendorCode();
        this.note = detailDto.getNote();
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

    @Override
    public String toString() {
        return "Detail{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
