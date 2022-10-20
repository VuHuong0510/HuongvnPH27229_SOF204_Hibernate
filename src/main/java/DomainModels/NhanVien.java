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
@Table(name = "NhanVien")
public class NhanVien implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "TenDem")
    private String tenDem;
    
    @Column(name = "Ho")
    private String ho;
    
    @Column(name = "GioiTinh")
    private String gioiTinh;
    
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "MatKhau")
    private String matKhau;
    
    @ManyToOne
    @JoinColumn(name = "IdCH",nullable = false)
    private CuaHang cuaHang;
    
    @ManyToOne
    @JoinColumn(name = "IdCV",nullable = false)
    private ChucVu chucVu;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @OneToMany(mappedBy = "nhanVien",fetch = FetchType.LAZY)
    List<HoaDon> listHoaDon;
}
