import com.sun.jdi.PathSearchingVirtualMachine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class Log_in extends JFrame {
    Log_in (){

        JLabel lab1=new JLabel("WELCOME THIS IS UNITY HOTEL LOGIN PAGE");
        lab1.setBackground(Color.CYAN);
        lab1.setForeground(Color.BLACK);
        JLabel lab2=new JLabel("enter our hotel id") ;
        lab2.setBackground(Color.BLACK);
        lab2.setForeground(Color.BLACK);
        JTextField txt1=new JTextField();
        txt1.setBackground(Color.CYAN);
        txt1.setForeground(Color.BLACK);
        JLabel lab3=new JLabel("enter hotel  password");
        lab3.setBounds(20,20,100,20);
        lab3.setBackground(Color.CYAN);
        lab3.setForeground(Color.BLACK);
        JPasswordField txt2=new JPasswordField();
        txt2.setBackground(Color.CYAN);
        txt2.setForeground(Color.BLACK);
        JLabel lab5=new JLabel("Fill the following form to login");
        lab5.setFont(new Font("serif",Font.BOLD,20));
        JButton btn1= new JButton("log in");
        btn1.setSize(30,30);
        btn1.setBackground(Color.CYAN);
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txt1.getText();
                String passwordpre = txt2.getText();

                try {
                    if (isValid(id, passwordpre)) {
                        setVisible(false);
                        choose_roll choose_roll = new choose_roll();
                        choose_roll.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

            private boolean isValid(String id, String password) throws SQLException, ClassNotFoundException {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                Connection connection = DriverManager.getConnection(jdbcUrl, "root", "262088");
                Statement statement = connection.createStatement();
                String query = "SELECT present_password FROM password WHERE id = '" + id + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    String dbPassword = resultSet.getString("present_password");
                    return password.equals(dbPassword);
                }

                return false;
            }
        });
        JButton btn2= new JButton("exit");
        btn2.setSize(30,30);
        btn2.setBackground(Color.CYAN);
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton btn3=new JButton("back");
        btn3.setBounds(20,40,30,30);
        btn3.setBackground(Color.cyan);
        btn3.setForeground(Color.black);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                   System.exit(0);
            }
        });
        JButton btn4=new JButton("help");
        btn4.setBackground(Color.cyan);
        btn4.setForeground(Color.black);
        btn4.setBounds(10,10,5,5);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Help help=new Help();
            }
        });
        JPanel Log_inpane1=new JPanel();
        JPanel Log_inpane2=new JPanel();
        JPanel Log_inpane3=new JPanel();
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\login.PNG "); // Replace with the path to your image file
        label.setIcon(icon);

        LayoutManager layoutManager1=new GridLayout(6,1,10,10);
        Log_inpane2.setLayout(layoutManager1);
        Log_inpane1.setLayout(new GridLayout(3,1));
        Log_inpane3.setLayout(new GridLayout(5,2));
        Log_inpane3.setBackground(Color.cyan);
        Font font1=new Font("new Roman",Font.BOLD,20);
        lab1.setFont(font1);
        lab1.setForeground(Color.BLUE);

        Log_inpane1.add(lab1);
        Log_inpane1.add(label)  ;
        Log_inpane1.add(lab5);
        Log_inpane3.add(lab2);
        Log_inpane3.add(txt1);
        Log_inpane3.add(lab3);
        Log_inpane3.add(txt2);
        Log_inpane3.add(btn1);
        Log_inpane3.add(btn2);
        Log_inpane3.add(btn3) ;
          Log_inpane3.add(btn4);
        add(Log_inpane1);
        add(Log_inpane3);
        setLayout(new GridLayout(2,1));

        setVisible(true);
        setBounds(10,10,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LOG IN");
        setLocationRelativeTo(null);
        Log_inpane1.setBackground(Color.lightGray);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        

    }

    public static void main(String[] args) {
        Log_in logIn= new Log_in();
    }

}
