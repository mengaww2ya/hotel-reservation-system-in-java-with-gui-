import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert_room extends JFrame {
    Insert_room(){

        JLabel lab1=new JLabel("room number:");
        lab1.setBounds(20,20,200,30);
        JTextField txt1=new JTextField();
        txt1.setBounds(20,20,200,30);
        JLabel lab2=new JLabel("No of person it hold:");
        lab2.setBounds(20,20,100,30);
        JTextField txt2=new JTextField();
        txt2.setBounds(20,20,200,30);
        JLabel lab3=new JLabel("enter price  ");
        JTextField txt3=new JTextField();
        JLabel lab4=new JLabel(" select status of room  ");
        Boolean[] status = {true, false};
        JComboBox<Boolean> comboBox = new JComboBox<>(status);
        lab3.setBounds(20,40,200,30);
        JLabel lab5=new JLabel("FILL THE FOLLOWING FORM ");
        lab5.setFont(new Font("serif",Font.BOLD,30));
        lab5.setForeground(Color.BLUE);
        JButton btn1=new JButton("add");
        btn1.setBackground(Color.ORANGE);
        btn1.setForeground(Color.black);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String room_number = txt1.getText();
                    String number_of_person_it_holds = txt2.getText();
                    String price_of_room_per_day = txt3.getText();
                    boolean status= (boolean) comboBox.getSelectedItem();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
                            "root","262088");
                    String insertQuery = "INSERT INTO rooms (room_number,number_of_person_it_holds, price_of_room_per_day,status) VALUES (?, ?, ?,?)";
                    PreparedStatement statement = connection.prepareStatement(insertQuery);
                    statement.setString(1, room_number);
                    statement.setString(2, number_of_person_it_holds);
                    statement.setString(3, price_of_room_per_day);
                    statement.setBoolean(4, status);
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                    JOptionPane.showMessageDialog(null, "Inserted  successfully");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
        JButton btn2=new JButton("exit");
        btn2.setBackground(Color.ORANGE);
        btn2.setForeground(Color.black);
        btn2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
            
        });
        JButton btn3=new JButton("back");
        btn3.setBackground(Color.ORANGE);
        btn3.setForeground(Color.black);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                Manager manager=new Manager();
            }
        });
        JButton btn4=new JButton("clear");
        btn4.setBackground(Color.ORANGE);
        btn4.setForeground(Color.black);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
            }
        });
        JPanel pan1=new JPanel();
        pan1.setLayout(new GridLayout(2,1));
        pan1.setBackground(Color.PINK);
        JPanel pan2=new JPanel();
        pan2.setLayout(new GridLayout(6,2));
        pan2.setBackground(Color.CYAN);
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\rooms.PNG "); // Replace with the path to your image file
        label.setIcon(icon);
        pan1.add(label);
        pan1.add(lab5);
        pan2.add(lab1);
        pan2.add(txt1);
        pan2.add(lab2);
        pan2.add(txt2);
        pan2.add(lab3);
        pan2.add(txt3) ;
        pan2.add(lab4);
        pan2.add(comboBox);
        pan2.add(btn1);
        pan2.add(btn2);
        pan2.add(btn3);
        pan2. add(btn4);
        add(pan1);
        add(pan2);
        setLayout( new GridLayout(2,1));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(5,5,600,600);
        setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        Insert_room insert_room=new Insert_room();
    }
}
