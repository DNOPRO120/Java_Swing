package org.example.controllers;

import org.example.entities.ClassEntity;
import org.example.interfaces.IService;
import org.example.services.ClassService;
import org.example.views.ClassView;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ClassController {
    private IService<ClassEntity> classEntityIService;
    public static ArrayList<ClassEntity> classEntities;
    private ClassView classView;
    private int rowSelectDelete;
    public ClassController(ClassView classView){
        this.classEntityIService = new ClassService();
        classEntities = this.classEntityIService.find();
        this.classView = classView;
        this.rowSelectDelete = -1;
    }
    public void reload(){
        classEntities = this.classEntityIService.find();
        DefaultTableModel defaultTableModel = this.classView.setHeaderTable();
        classEntities.forEach(classEntity -> {
            String status = classEntity.getDeleted() ? "Đã xóa" : "Tồn tại";
            defaultTableModel.addRow(new String[]{classEntity.getId()+"",classEntity.getName(),status});
        });
        this.classView.jTable.setModel(defaultTableModel);
    }
    public void delete(){
        if(this.rowSelectDelete == -1) return;
        ClassEntity classEntity = classEntities.get(rowSelectDelete);
        boolean res = this.classEntityIService.delete(classEntity.getId());
        if(res) {
            this.reload();
            this.rowSelectDelete = -1;
        }
    }
    public void setRowSelectDelete(int index){
        this.rowSelectDelete = index;
    }
}
