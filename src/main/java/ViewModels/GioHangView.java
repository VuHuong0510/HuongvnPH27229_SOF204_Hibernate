package ViewModels;

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

public class GioHangView {
    private UUID idCTSP;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private Double donGia;
    
    public Double thanhTien(int soLuong,Double donGia){
        return soLuong*donGia;
    }
}
