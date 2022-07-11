package Dao;

import ConnectionMySql.ConnectionMySql;
import Model.Phong;
import Model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDao implements ICRUD<Staff>{
     ConnectionMySql connectionMySql = new ConnectionMySql();

     PhongDao phongDao = new PhongDao();
    @Override
    public List<Staff> getAll() {
        String sql = "select * from student";
        List<Staff> students = new ArrayList<>();
        try (Connection connection = connectionMySql.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("idStaff");
                String name = resultSet.getString("nameStaff");
                Date date = resultSet.getDate("dateStaff");
                String address = resultSet.getString("addressStaff");
                String email = resultSet.getString("emailStaff");
                String phoneNumber = resultSet.getString("phoneNumber");
                Phong phong = phongDao.findById(resultSet.getInt("idPhong"));
                students.add(new Staff(id, name, date, address, email, phoneNumber, phong));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean create(Staff staff) {
        String sql = "insert into Staff value (?,?,?,?,?,?,?)";
        try (Connection connection = connectionMySql.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, staff.getId());
            preparedStatement.setString(2, staff.getName());
            preparedStatement.setString(3, String.valueOf(staff.getDateOfBirth()));
            preparedStatement.setString(4, staff.getAddress());
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setString(6, staff.getPhoneNumber());
            preparedStatement.setInt(7, staff.getPhong().getIdPhong());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(int id, Staff staff) {
        String sql = "UPDATE Staff SET nameStaff = ?,dateStaff = ?, " +
                "addressStaff = ?,emailStaff = ?,phoneNumber = ?, idPhong=? WHERE (idStaff = ?)";
        try (Connection connection = connectionMySql.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(7, staff.getId());
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, String.valueOf(staff.getDateOfBirth()));
            preparedStatement.setString(3, staff.getAddress());
            preparedStatement.setString(4, staff.getEmail());
            preparedStatement.setString(5, staff.getPhoneNumber());
            preparedStatement.setInt(6, staff.getPhong().getIdPhong());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from Staff WHERE idStaff = ?";
        try (Connection connection = connectionMySql.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public Staff findById(int id) {
        String sql = "select * from Staff where idStaff = " + id;
        try (Connection connection = connectionMySql.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            int idS = resultSet.getInt("idStaff");
            String name = resultSet.getString("nameStaff");
            Date dateOfBirth = resultSet.getDate("dateStaff");
            String address = resultSet.getString("addressStaff");
            String email = resultSet.getString("emailStaff");
            String phoneNumber = resultSet.getString("phoneNumber");
            Phong phong = phongDao.findById(resultSet.getInt("idPhong"));

            return new Staff(idS, name, dateOfBirth, address, email, phoneNumber, phong);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
