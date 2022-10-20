package Services.impl;

import DomainModels.CuaHang;
import Repositories.ICuaHangRepository;
import Repositories.impl.CuaHangRepository;
import Services.IQLCuaHangService;
import ViewModels.QLCuaHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class QLCuaHangService implements IQLCuaHangService{
    
    private ICuaHangRepository iCuaHangRepository;
    private List<QLCuaHang> list;

    public QLCuaHangService() {
    iCuaHangRepository = new CuaHangRepository();
    list = new ArrayList<>();
    }

    @Override
    public List<QLCuaHang> getAll() {
   list = new ArrayList<>();
        for (CuaHang x : iCuaHangRepository.getAll()) {
            list.add(new QLCuaHang(x.getId(), x.getMa(), x.getTen(), x.getDiaChi(), x.getThanhPho(), x.getQuocGia()));
        }
    return list;}

    @Override
    public String add(QLCuaHang obj) {
   CuaHang ch = new CuaHang();
    ch.setMa(obj.getMa());
    ch.setTen(obj.getTen());
    ch.setDiaChi(obj.getDiaChi());
    ch.setThanhPho(obj.getThanhPho());
    ch.setQuocGia(obj.getQuocGia());
    iCuaHangRepository.save(ch);
    return "Add";
    }

    @Override
    public String update(QLCuaHang obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(QLCuaHang obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public QLCuaHang getObjByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<QLCuaHang> findByName(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
