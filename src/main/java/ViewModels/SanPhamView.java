package ViewModels;

import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
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

public class SanPhamView {

    private ChiTietSP chiTietSP;
    private SanPham sanPham;
    private DongSP dongSP;
    private MauSac mauSac;
    private NSX nsx;
}
