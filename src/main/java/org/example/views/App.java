package org.example.views;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public App(){
        this.configs();
        this.init();
        this.setVisible(true);
    }
    private void init(){
        JPanel classView = new ClassView();
        JPanel studentView = new StudentView();

        JPanel jPanelClassStudent = new JPanel();
        jPanelClassStudent.setLayout(new CardLayout());
        jPanelClassStudent.add("class", classView);
        jPanelClassStudent.add("student",studentView);

        JMenuBar jMenuBar = new Menu(jPanelClassStudent);

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,jPanelClassStudent);
        this.add(BorderLayout.NORTH,jMenuBar);
    }
    private void configs(){
        this.setTitle("Swing MVC");
        this.setSize(1200,800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
