package org.example.views;

import org.example.controllers.ClassController;
import org.example.controllers.HandlesActionListener.ClassViewAL;
import org.example.controllers.HandlesActionListener.TableClassViewAL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ClassView extends JPanel {
    private ClassController classController;
    public JTable jTable;
    private DefaultTableModel defaultTableModel;
    private ActionListener classViewAL;
    private MouseListener tableClassViewAL;
    public ClassView(){
        this.classController = new ClassController(this);
        this.classViewAL = new ClassViewAL(this,this.classController);
        this.tableClassViewAL = new TableClassViewAL(this,this.classController);
        this.init();
    }
    private void init(){
        this.jTable = new JTable(this.setHeaderTable());
        this.jTable.addMouseListener(this.tableClassViewAL);
        this.jTable.setFont(new Font("Arial",Font.PLAIN,15));
        this.jTable.setRowHeight(50);
        this.classController.reload();
        JTableHeader jTableHeader = this.jTable.getTableHeader();
        jTableHeader.setFont(new Font("Arial", Font.BOLD, 20));
        JScrollPane jScrollPaneTable = new JScrollPane(this.jTable);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,jScrollPaneTable);
        this.add(BorderLayout.SOUTH,this.buttonsAction());
    }
    private JPanel buttonsAction(){
        JButton jButtonReload =new JButton("Reload");
        jButtonReload.setFont(new Font("Arial",Font.BOLD,20));
        jButtonReload.addActionListener(this.classViewAL);

        JButton jButtonDelete =new JButton("Delete");
        jButtonDelete.setFont(new Font("Arial",Font.BOLD,20));
        jButtonDelete.addActionListener(this.classViewAL);

        JPanel jPanelButtonsAction = new JPanel();
        jPanelButtonsAction.setLayout(new FlowLayout());
        jPanelButtonsAction.add(jButtonReload);
        jPanelButtonsAction.add(jButtonDelete);
        return jPanelButtonsAction;
    }
    public DefaultTableModel setHeaderTable(){
        this.defaultTableModel = new DefaultTableModel();
        this.defaultTableModel.addColumn("ID");
        this.defaultTableModel.addColumn("Name");
        this.defaultTableModel.addColumn("Status");
        return this.defaultTableModel;
    }
}
