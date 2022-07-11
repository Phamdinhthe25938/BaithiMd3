package Dao;

import ConnectionMySql.ConnectionMySql;
import Model.Phong;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongDao implements ICRUD<Phong>{

     ConnectionMySql connectionMySql = new ConnectionMySql();
    @Override
    public ArrayList<Phong> getAll() {
        String sql = "select * from phong";
        ArrayList<Phong> phongs = new ArrayList<>();
        try (Connection connection = connectionMySql.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idPhong = resultSet.getInt(1);
                String namePhong = resultSet.getString(2);
                phongs.add(new Phong(idPhong, namePhong));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongs;
    }

    @Override
    public boolean create(Phong phong) {
        return false;
    }

    @Override
    public boolean edit(int id, Phong phong) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Phong findById(int id) {
        String sql = "select * from phong where id = ?";
        try (Connection connection = connectionMySql.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int idPhong = resultSet.getInt(1);
            String namePhong = resultSet.getString(2);
            Phong phong = new Phong(idPhong,namePhong);
            return phong;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
