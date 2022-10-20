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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;

    @Column
    private String ma;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngayThanhToan;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngayShip;

    @Column
    @Temporal(TemporalType.DATE)
    private Date ngayNhan;

    @Column
    private int tinhTrang;

    @Column
    private String tenNguoiNhan;

    @Column
    private String diaChi;

    @Column
    private String sdt;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    List<HoaDonChiTiet> listHoaDonChiTiet;

    public String getTrangThaiHD(int tt) {
        if (tt == 0) {
            return "Chờ thanh toán";
        } else if (tt == 1) {
            return "Đã thanh toán";
        } else {
            return "Đã hủy";
        }
    }
}
