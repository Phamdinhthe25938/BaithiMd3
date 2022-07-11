package Service;

import Dao.PhongDao;
import Model.Phong;

import java.util.ArrayList;

public class PhongService {

    static PhongDao phongDao = new PhongDao();

    static ArrayList<Phong> phongs =  phongDao.getAll();

    static public Phong findPhongByName(String name){
             phongs = phongDao.getAll();
              for(int i=0;i<phongs.size();i++){
                  if(phongs.get(i).getNamePhong().trim().equals(name.trim())){
                      return phongs.get(i);
                  }
              }
              return null;

    }
}
