package uaspbo.View;

import java.awt.Image;
import javax.swing.*;
import uaspbo.Controller.SQLController;
import java.util.ArrayList;
import uaspbo.Model.*;

public class MenuLogin {

    JButton backMenu = new JButton("Back to menu");

    public MenuLogin() {
        SQLController con = new SQLController();
        JFrame frame = new JFrame();

        frame.setSize(550, 250);
        frame.setTitle("Main Menu");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String logo = "C:\\Users\\limtu\\Downloads\\logo.png";
        ImageIcon iconLogo = new ImageIcon(new ImageIcon(logo).getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));

        JLabel pasLogo = new JLabel();
        pasLogo.setIcon(iconLogo);
        pasLogo.setBounds(300, 50, 200, 100);
        frame.add(pasLogo);
        JLabel labUserName = new JLabel("Username:");
        JTextField inpName = new JTextField();
        JLabel labPassword = new JLabel("Password:");
        JTextField inpPass = new JTextField();

        labUserName.setBounds(10, 65, 100, 25);
        inpName.setBounds(120, 65, 100, 25);
        labPassword.setBounds(10, 95, 100, 25);
        inpPass.setBounds(120, 95, 100, 25);
        frame.add(labUserName);
        frame.add(inpName);
        frame.add(labPassword);
        frame.add(inpPass);

        JButton submit = new JButton("Submit");
        submit.setBounds(10, 125, 100, 45);
        frame.add(submit);
        submit.addActionListener(b -> {
            String userName = con.cekLogin(inpName.getText(), inpPass.getText());
            if (inpName.equals(userName)) {
                new MenuDataPengguna(userName);
            } else {
                JOptionPane.showMessageDialog(null, "gagal login");
            }

        });

        backMenu.setBounds(10, 10, 150, 40);
        backMenu.addActionListener(a -> {
            frame.dispose();
            new MainMenu();
        });
        frame.add(backMenu);
    }

    public static void main(String[] args) {
        new MenuLogin();
    }
}
