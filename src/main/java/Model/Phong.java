package Model;

public class Phong {

    private int idPhong;

    private  String namePhong;

    public Phong(int idPhong, String namePhong) {
        this.idPhong = idPhong;
        this.namePhong = namePhong;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public String getNamePhong() {
        return namePhong;
    }

    public void setNamePhong(String namePhong) {
        this.namePhong = namePhong;
    }
}
