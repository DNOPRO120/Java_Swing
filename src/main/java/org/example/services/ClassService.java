package org.example.services;

import org.example.configs.DatabaseConfig;
import org.example.entities.ClassEntity;
import org.example.interfaces.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassService implements IService<ClassEntity> {
    @Override
    public boolean save(ClassEntity classEntity) {
        return false;
    }

    @Override
    public ArrayList<ClassEntity> find() {
        ArrayList<ClassEntity> classEntities = new ArrayList<>();
        try {
            String sql = "select * from classes";
            PreparedStatement preparedStatement = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                classEntities.add(new ClassEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("deleted")
                ));
            }
        } catch (SQLException ex){
            ex.getSuppressed();
        } finally {
            DatabaseConfig.closeConnection();
        }
        return classEntities;
    }

    @Override
    public ClassEntity findById(int id) {
        ClassEntity classEntity = null;
        try {
            String sql = "select * from classes where id=?";
            PreparedStatement preparedStatement = DatabaseConfig.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                classEntity =new ClassEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("deleted")
                );
            }
        } catch (SQLException e) {
            e.getSuppressed();
        } finally {
            DatabaseConfig.closeConnection();
        }
        return classEntity;
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "update classes set deleted=true where id=?";
            PreparedStatement preparedStatement = DatabaseConfig.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e){
            e.getSuppressed();
            return false;
        } finally {
            DatabaseConfig.closeConnection();
        }
        return true;
    }

    @Override
    public boolean update(ClassEntity old, ClassEntity update) {
        return false;
    }
}
