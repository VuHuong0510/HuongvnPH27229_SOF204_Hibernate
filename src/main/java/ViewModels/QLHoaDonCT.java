package ViewModels;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.UUID;
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

public class QLHoaDonCT {
    private UUID idHoaDon;
    private UUID idChiTietSP;
    private int soLuong;
    private BigDecimal donGia;
}
