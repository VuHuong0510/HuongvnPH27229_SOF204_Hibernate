package Services.impl;

import DomainModels.ChiTietSP;
import Repositories.*;
import Repositories.impl.*;
import Services.IQLSanPhamService;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class QLSanPhamService implements IQLSanPhamService {

    private List<SanPhamView> list;

    private IChiTietSPRepository iChiTietSPRepository;
    private ISanPhamRepository iSanPhamRepository;
    private IDongSPRepository iDongSPRepository;
    private IMauSacRepository iMauSacRepository;
    private INsxRepository iNsxRepository;

    public QLSanPhamService() {
        iChiTietSPRepository = new ChiTietSPRepository();
        iSanPhamRepository = new SanPhamRepository();
        iDongSPRepository = new DongSPRepository();
        iMauSacRepository = new MauSacRepository();
        iNsxRepository = new NsxRepository();
        list = new ArrayList<>();
    }

    @Override
    public List<SanPhamView> getAll() {
        list = new ArrayList<>();
        for (ChiTietSP x : iChiTietSPRepository.getAll()) {
            list.add(new SanPhamView(x,
                    iSanPhamRepository.getObjByMa(x.getSanPham().getMa()),
                    iDongSPRepository.getObjByMa(x.getDongSP().getMa()),
                    iMauSacRepository.getObjByMa(x.getMauSac().getMa()),
                    iNsxRepository.getObjByMa(x.getNsx().getMa())));
        }
        return list;
    }

    @Override
    public String save(SanPhamView spv) {
        var ctsp = spv.getChiTietSP();
        iChiTietSPRepository.save(ctsp);
        return "Save";
    }

    @Override
    public String delete(SanPhamView spv) {
        var ctsp = spv.getChiTietSP();
        iChiTietSPRepository.delete(ctsp);
        return "Delete";
    }

    @Override
    public List<SanPhamView> findByName(String ten) {
        list = new ArrayList<>();
        for (ChiTietSP x : iChiTietSPRepository.findByName(ten)) {
            list.add(new SanPhamView(x,
                    iSanPhamRepository.getObjByMa(x.getSanPham().getMa()),
                    iDongSPRepository.getObjByMa(x.getDongSP().getMa()),
                    iMauSacRepository.getObjByMa(x.getMauSac().getMa()),
                    iNsxRepository.getObjByMa(x.getNsx().getMa())));
        }
        return list;
    }

    @Override
    public SanPhamView getObjById(UUID id) {
        SanPhamView spv = new SanPhamView();
        var ctsp = iChiTietSPRepository.getObjById(id);
        spv.setChiTietSP(ctsp);
        return spv;
    }

}
