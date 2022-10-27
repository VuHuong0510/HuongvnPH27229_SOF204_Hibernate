package ViewModels;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author VU NGUYEN HUONG
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class QLNhanVien {

    private UUID id;
    private String ma;
    private String ten;
    private String gioiTinh;
    private String diaChi;
    private String sdt;
    private CuaHang cuaHang;
    private ChucVu chucVu;
}
