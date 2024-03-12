import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Sign_in extends JFrame {
    Sign_in(){
        JLabel lab4=new JLabel("WELCOME THIS IS UNITY HOTEL SIGN IN PAGE");
        lab4.setFont(new Font("serif",Font.BOLD,20));

        JLabel lab5=new JLabel("Fill the following form to login");
        lab5.setFont(new Font("serif",Font.BOLD,20));
        JLabel lab1=new JLabel("\t\t enter your user name:");
        lab1.setBounds(20,20,100,10);
        JTextField txt1=new JTextField();
        txt1.setBounds(220,20,100,10);
        JLabel lab2=new JLabel("\t\t enter your email");
        lab2.setBounds(20,20,100,15);
        JTextField txt2=new JTextField();
        txt2.setBounds(220,20,100,10);
        JLabel lab3=new JLabel("\t\tEnter your password:");
        lab3.setBounds(20,40,100,10);
        JPasswordField txt3=new JPasswordField();
        txt3.setBounds(220,40,100,10);
        JButton btn1=new JButton("sign in");
        btn1.setBounds(20,60,30,10);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernamepre = txt1.getText();
                String emailpre = txt2.getText();
                String passwordpre = new String(txt3.getPassword());

                // Perform validation or further processing with the entered values
                try {
                    if (isValid(usernamepre, emailpre, passwordpre)) {
                        setVisible(false);
                        Start_interface start_interface = new Start_interface();
                        start_interface.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            private boolean isValid(String username, String email, String password) throws SQLException, ClassNotFoundException {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                Connection connection = DriverManager.getConnection(jdbcUrl, "root", "262088");
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM customurs WHERE email='" + email + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    String dbUsername = resultSet.getString("Fname");
                    String dbEmail = resultSet.getString("email");
                    String dbPassword = resultSet.getString("password");
                    return username.equals(dbUsername) && email.equals(dbEmail) && password.equals(dbPassword);
                }

                return false;
            }
        });


        JButton btn2=new JButton("exit");
        btn2.setBounds(50,60,30,10);
        btn2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        JButton btn3=new JButton("back");
        btn3.setBounds(20,40,30,30);
        btn3.setBackground(Color.ORANGE);
        btn3.setForeground(Color.black);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Welcome welcome=new Welcome();

            }
        });
        JPanel Sign_in1=new JPanel();
        Sign_in1.setBackground(Color.cyan);
        Sign_in1.setLayout(new GridLayout(3,1));
        JPanel Sign_in2=new JPanel();
        Sign_in2.setBackground(Color.PINK);
        Sign_in2.setSize(300,300);
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\login.PNG "); // Replace with the path to your image file
        label.setIcon(icon);

        Sign_in1.add(lab4);
        Sign_in1.add(label);
        Sign_in1.add(lab5);
        Sign_in2.add(lab1);
        Sign_in2.add(txt1);
        Sign_in2.add(lab2);
        Sign_in2.add(txt2);
        Sign_in2.add(lab3);
        Sign_in2.add(txt3) ;
        Sign_in2.add(btn1);
        Sign_in2.add(btn2);
        Sign_in2.add(btn3);
        setTitle("Sign in");
        add(Sign_in1);
        add(Sign_in2);
        setLayout(new GridLayout(2,1,20,20));
        setBounds(10,10,500,500);
        setVisible(true);
        setBackground(Color.BLUE);
        Sign_in2.setLayout(new GridLayout(6,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Sign_in Sign_in=new Sign_in();

    }
}
