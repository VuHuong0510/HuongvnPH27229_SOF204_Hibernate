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
public class QLCuaHang {

    private UUID id;
    private String ma;
    private String ten;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
}
