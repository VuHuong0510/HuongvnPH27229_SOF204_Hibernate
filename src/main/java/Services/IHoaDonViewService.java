package Services;

import ViewModels.QLHoaDonCT;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IHoaDonViewService {
    List<QLHoaDonCT> getAll();
    String add(QLHoaDonCT hdv);
}
