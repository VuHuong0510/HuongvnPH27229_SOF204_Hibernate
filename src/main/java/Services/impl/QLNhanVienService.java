package Services.impl;

import DomainModels.NhanVien;
import Repositories.IChucVuRepository;
import Repositories.ICuaHangRepository;
import Repositories.INhanVienRepository;
import Repositories.impl.ChucVuRepository;
import Repositories.impl.CuaHangRepository;
import Repositories.impl.NhanVienRepository;
import Services.IQLNhanVienService;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class QLNhanVienService implements IQLNhanVienService {
    
    private INhanVienRepository iNhanVienRepository;
    private ICuaHangRepository iCuaHangRepository;
    private IChucVuRepository iChucVuRepository;
    private List<QLNhanVien> list;
    
    public QLNhanVienService() {
        iNhanVienRepository = new NhanVienRepository();
        iCuaHangRepository = new CuaHangRepository();
        iChucVuRepository = new ChucVuRepository();
    }
    
    @Override
    public List<QLNhanVien> getAll() {
        list = new ArrayList<>();
        for (NhanVien x : iNhanVienRepository.getAll()) {
            list.add(new QLNhanVien(x.getId(), x.getMa(), x.getTen(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getCuaHang(), x.getChucVu()));
        }
        return list;
    }
    
    @Override
    public String add(QLNhanVien obj) {
        NhanVien nv = new NhanVien();
        nv.setMa(obj.getMa());
        nv.setTen(obj.getTen());
        nv.setGioiTinh(obj.getGioiTinh());
        nv.setDiaChi(obj.getDiaChi());
        nv.setSdt(obj.getSdt());
        nv.setCuaHang(obj.getCuaHang());
        nv.setChucVu(obj.getChucVu());
        return iNhanVienRepository.save(nv);
    }
    
    @Override
    public String update(QLNhanVien obj) {
        NhanVien nv = iNhanVienRepository.getObjByMa(obj.getMa());
        nv.setTen(obj.getTen());
        nv.setGioiTinh(obj.getGioiTinh());
        nv.setDiaChi(obj.getDiaChi());
        nv.setSdt(obj.getSdt());
        nv.setCuaHang(obj.getCuaHang());
        nv.setChucVu(obj.getChucVu());
        return iNhanVienRepository.save(nv);
    }
    
    @Override
    public String delete(QLNhanVien obj) {
        NhanVien nv = iNhanVienRepository.getObjByMa(obj.getMa());
        return iNhanVienRepository.delete(nv);
    }
    
    @Override
    public QLNhanVien getObjByMa(String ma) {
        NhanVien nv = iNhanVienRepository.getObjByMa(ma);
        if (nv == null) {
            return null;
        } else {
            return new QLNhanVien(nv.getId(), nv.getMa(), nv.getTen(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSdt(), nv.getCuaHang(), nv.getChucVu());
        }
    }
    
    @Override
    public List<QLNhanVien> findByName(String ten) {
        list = new ArrayList<>();
        for (NhanVien x : iNhanVienRepository.findByName(ten)) {
            list.add(new QLNhanVien(x.getId(), x.getMa(), x.getTen(), x.getGioiTinh(), x.getDiaChi(), x.getSdt(), x.getCuaHang(), x.getChucVu()));
        }
        return list;
    }
    
}
