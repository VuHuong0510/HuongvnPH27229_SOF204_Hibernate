package Services;

import DomainModels.DongSP;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IDongSPService {
    List<DongSP> getAll();

    String save(DongSP sp);

    String delete(DongSP dsp);

    DongSP getObjByMa(String ma);
}
