package uaspbo.View;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import uaspbo.Controller.SQLController;
import java.util.ArrayList;
import uaspbo.Model.*;

public class MenuRegister {

    JButton backMenu = new JButton("Back to menu");
    static String gender = "";
    static String inpCategory = "";

    public MenuRegister() {
        SQLController con = new SQLController();
        JFrame frame = new JFrame();

        frame.setSize(550, 550);
        frame.setTitle("Data Pengguna");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labEmail = new JLabel("Email: ");
        labEmail.setBounds(10, 65, 100, 25);
        JTextField inpEmail = new JTextField();
        inpEmail.setBounds(120, 65, 100, 25);
        JLabel labName = new JLabel("UserName: ");
        labName.setBounds(10, 95, 100, 25);
        JTextField inpName = new JTextField();
        inpName.setBounds(120, 95, 100, 25);
        JLabel labGender = new JLabel("Gemder: ");
        labGender.setBounds(10, 125, 100, 25);
        JRadioButton male = new JRadioButton("male");
        male.setBounds(10, 155, 100, 25);
        JRadioButton female = new JRadioButton("female");
        female.setBounds(120, 155, 100, 25);

        if (male.isSelected()) {
            gender = "male";
        }
        if (female.isSelected()) {
            gender = "female";
        }
        ArrayList<CategoryUser> listKategori = con.getAllCategory();
        String[] categoryList = new String[3];
        for (int i = 0; i < listKategori.size(); i++) {
            categoryList[i] = listKategori.get(i).getCategoryName();
        }
        JLabel labCategory = new JLabel("category:");
        labCategory.setBounds(10, 185, 100, 25);
        JComboBox category = new JComboBox(categoryList);
        category.setBounds(120, 185, 100, 25);
        JLabel labPassword = new JLabel("Email: ");
        labPassword.setBounds(10, 215, 100, 25);
        JTextField inpPassword = new JTextField();
        inpEmail.setBounds(120, 215, 100, 25);
        frame.add(labEmail);
        frame.add(inpEmail);
        frame.add(labName);
        frame.add(inpName);
        frame.add(labGender);
        frame.add(male);
        frame.add(female);
        frame.add(labCategory);
        frame.add(category);
        frame.add(labPassword);
        frame.add(inpPassword);
        JButton register = new JButton("register");
        register.setBounds(10, 245, 100, 25);
        frame.add(register);
        String kategori = (String) category.getItemAt(category.getSelectedIndex());
        register.addActionListener(b -> {
            if (!inpEmail.getText().equals("") && !inpName.getText().equals("") && !gender.equals("") && !inpPassword.equals("")) {
                User user = new User(0, inpName.getText(), inpPassword.getText(), inpEmail.getText(), gender, con.getCategoryName(kategori),0);
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
        new MenuRegister();
    }
}
