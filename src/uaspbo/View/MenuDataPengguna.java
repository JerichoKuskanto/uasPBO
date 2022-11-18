package uaspbo.View;

import javax.swing.*;
import uaspbo.Controller.SQLController;
import uaspbo.Model.*;

public class MenuDataPengguna {

    JButton backMenu = new JButton("Back to menu");

    public MenuDataPengguna(String name) {
        SQLController con = new SQLController();
        JFrame frame = new JFrame();

        frame.setSize(550, 250);
        frame.setTitle("Data Pengguna");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        User user = con.getDataUser(name);
        String id = Integer.toString(user.getUserId());
        String follower = Integer.toString(user.getUserFollowers());
        String[][] data = {
            {id, user.getUserName(), user.getUserEmail(), user.getUserGender(), follower, user.getUserCategory().getCategoryName()}
        };
        String[] kolum = {
            "id", "nama", "email", "gender", "follower", "kategori"
        };
        JTable tabel = new JTable(data, kolum);
        tabel.setBounds(10, 50, 200, 300);
        frame.add(tabel);

        backMenu.setBounds(10, 10, 150, 40);
        backMenu.addActionListener(a -> {
            frame.dispose();
            new MainMenu();
        });
        frame.add(backMenu);
    }
    public static void main(String[] args) {
        new MenuDataPengguna("udin");
    }


}
