package org.example.controllers.HandlesActionListener;

import org.example.controllers.ClassController;
import org.example.entities.ClassEntity;
import org.example.views.ClassView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClassViewAL implements ActionListener {
    private ClassView classView;
    private ClassController classController;

    public ClassViewAL(ClassView classView,ClassController classController) {
        this.classView = classView;
        this.classController = classController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        switch (src){
            case "Reload" -> {
                System.out.println("Đã reload");
                this.classController.reload();
            }
            case "Delete" -> {
                this.classController.delete();
            }
            default -> System.out.println("Error");
        }
    }
}

