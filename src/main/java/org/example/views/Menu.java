package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    private JPanel jPanelCardLayout;
    private ActionListener menuManageAL;
    private ActionListener menuFindAL;
    public Menu(JPanel jPanelClassStudent) {
        this.jPanelCardLayout = jPanelClassStudent;
        this.menuManageAL = new MenuManageAL(this.jPanelCardLayout);
        this.menuFindAL = new MenuFindAL();
        this.init();
    }

    private void init() {
        JMenu jMenuManage = new JMenu("Quản lý");

        JMenuItem jMenuItemManage_class = new JMenuItem("Lớp");
        jMenuManage.add(jMenuItemManage_class);
        jMenuItemManage_class.addActionListener(this.menuManageAL);

        JMenuItem jMenuItemManage_student = new JMenuItem("Sinh viên");
        jMenuManage.add(jMenuItemManage_student);
        jMenuItemManage_student.addActionListener(this.menuManageAL);

        JMenu jMenuFind = new JMenu("Tìm kiếm");

        JMenuItem jMenuItemFind_class = new JMenuItem("Lớp");
        jMenuFind.add(jMenuItemFind_class);
        jMenuItemFind_class.addActionListener(menuFindAL);

        JMenuItem jMenuItemFind_student = new JMenuItem("Sinh viên");
        jMenuFind.add(jMenuItemFind_student);
        jMenuItemFind_student.addActionListener(menuFindAL);

        this.add(jMenuManage);
        this.add(jMenuFind);
    }
}

class MenuManageAL implements ActionListener {
    private JPanel jPanelCardLayout;

    public MenuManageAL(JPanel jPanelCardLayout) {
        this.jPanelCardLayout = jPanelCardLayout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        String panel = null;
        switch (src) {
            case "Lớp" -> {
                panel = "class";
            }
            case "Sinh viên" -> {
                panel = "student";
            }
        }
        CardLayout cardLayout = (CardLayout) this.jPanelCardLayout.getLayout();
        cardLayout.show(this.jPanelCardLayout, panel);
    }
}
class MenuFindAL implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
    }
}