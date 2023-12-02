package org.example.services;

import org.example.configs.DatabaseConfig;
import org.example.entities.ClassEntity;
import org.example.entities.StudentEntity;
import org.example.interfaces.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService implements IService<StudentEntity> {
    @Override
    public boolean save(StudentEntity studentEntity) {
        return false;
    }

    @Override
    public ArrayList<StudentEntity> find() {
        ArrayList<StudentEntity> studentEntities= new ArrayList<>();
        try {
            String query = "SELECT s.id, s.name, s.age, s.address, s.phone_number, s.local_current, c.id AS class_id, c.name AS class_name, c.deleted as class_deleted " +
                    "FROM students s " +
                    "JOIN classes c ON s.class_id = c.id;";
            PreparedStatement preparedStatement = DatabaseConfig.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ClassEntity classEntity = new ClassEntity(
                        resultSet.getInt("class_id"),
                        resultSet.getString("class_name"),
                        resultSet.getBoolean("class_deleted")
                );
                studentEntities.add(new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("local_current"),
                        resultSet.getInt("age"),
                        classEntity
                ));
            }
        } catch (SQLException ex) {
            ex.getSuppressed();
        } finally {
            DatabaseConfig.closeConnection();
        }
        return studentEntities;
    }

    @Override
    public StudentEntity findById(int id) {
        StudentEntity studentEntity = null;
        try {
            String query = "SELECT s.id, s.name, s.age, s.address, s.phone_number, s.local_current, c.id AS class_id, c.name AS class_name, c.deleted as class_deleted " +
                    "FROM students s " +
                    "JOIN classes c ON s.class_id = c.id where s.id=?;";
            PreparedStatement preparedStatement = DatabaseConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ClassEntity classEntity = new ClassEntity(
                        resultSet.getInt("class_id"),
                        resultSet.getString("class_name"),
                        resultSet.getBoolean("class_deleted")
                );
                studentEntity = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("local_current"),
                        resultSet.getInt("age"),
                        classEntity
                );
            }
        } catch (SQLException e) {
            e.getSuppressed();
        } finally {
            DatabaseConfig.closeConnection();
        }
        return studentEntity;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(StudentEntity old, StudentEntity update) {
        return false;
    }
}
