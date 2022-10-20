package DomainModels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Vũ Nguyên Hướng
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String ma;

    @Column
    private String ten;

    @Column
    private String tenDem;

    @Column
    private String ho;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column
    private String sdt;

    @Column
    private String diaChi;

    @Column
    private String thanhPho;

    @Column
    private String quocGia;

    @Column
    private String matKhau;
    
    @OneToMany(mappedBy = "khachHang",fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon;

    @Override
    public String toString() {
        return ma + " - " + ten;
    }

}
