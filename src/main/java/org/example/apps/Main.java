package org.example.apps;


import org.example.views.App;

import javax.swing.*;

class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new App();
        } catch (Exception e){
            e.getSuppressed();
        }
    }
}