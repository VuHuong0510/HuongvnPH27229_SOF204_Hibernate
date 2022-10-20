package Repositories;

import DomainModels.DongSP;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IDongSPRepository {

    List<DongSP> getAll();

    String save(DongSP dongSP);

    String delete(DongSP dsp);

    DongSP getObjByMa(String ma);
}
