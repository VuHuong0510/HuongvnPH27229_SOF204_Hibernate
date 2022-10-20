package Services;

import Repositories.*;
import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IMauSacService {

    List<MauSac> getAll();

    String save(MauSac ms);

    String delete(MauSac ms);

    MauSac getObjByMa(String ma);
}
