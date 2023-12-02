package org.example.controllers.HandlesActionListener;

import org.example.controllers.ClassController;
import org.example.views.ClassView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableClassViewAL implements MouseListener {
    private ClassView classView;
    private ClassController classController;

    public TableClassViewAL(ClassView classView,ClassController classController) {
        this.classView = classView;
        this.classController = classController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int index = this.classView.jTable.getSelectedRow();
        this.classController.setRowSelectDelete(index);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
