package uaspbo.View;

import javax.swing.*;
import java.util.ArrayList;
import uaspbo.Model.*;

public class MainMenu {

    public MainMenu() {
        JFrame frame = new JFrame();

        frame.setSize(260, 100);
        frame.setTitle("Main Menu");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton menu1 = new JButton("Login");
        menu1.setBounds(10, 10, 100, 25);
        frame.add(menu1);

        menu1.addActionListener(a -> {
            frame.dispose();
            new MenuLogin();
        });
        JButton menu2 = new JButton("Register");
        menu2.setBounds(130, 10, 100, 25);
        frame.add(menu2);

        menu2.addActionListener(a -> {
            frame.dispose();
            new MenuRegister();
        });
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
