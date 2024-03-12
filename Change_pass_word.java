import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Change_pass_word extends JFrame {
    Change_pass_word() {
        JFrame frame = new JFrame("Fill the following fields");
        JLabel lab1 = new JLabel("            your id");
        JTextField txt1 = new JTextField();
        JLabel lab2 = new JLabel("             present_password");
        JPasswordField txt2 = new JPasswordField();
        JLabel lab3 = new JLabel("            new_password:");
        JPasswordField txt3 = new JPasswordField();
        JLabel lab4 = new JLabel("                confirm_new_password:");
        JPasswordField txt4 = new JPasswordField();
        JLabel lab5=new JLabel("   FILL THE FOLLOWING FORM TO CHANGE PASSWORD") ;
        lab5.setFont(new Font("serif",Font.BOLD,20));
        JButton btn1 = new JButton("back");
        btn1.setBackground(Color.ORANGE);
        btn1.setForeground(Color.black);
        JButton btn2 = new JButton("exit");
        btn2.setBackground(Color.ORANGE);
        btn2.setForeground(Color.black);
        JButton btn3 = new JButton("ok");
        btn3.setBackground(Color.ORANGE);
        btn3.setForeground(Color.black);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Manager manager = new Manager();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\login.PNG "); // Replace with the path to your image file
        label.setIcon(icon);
        JPanel pan1=new JPanel();
        pan1.setBackground(Color.cyan);
        pan1.setLayout(new GridLayout(2,1));
        JPanel pan2=new JPanel();
        pan2.setBackground(Color.PINK);
        pan2.setLayout(new GridLayout(7,2));
          pan1.add(lab5);
          pan1.add(label);
          pan2.add(lab1);
        pan2.add(txt1);
        pan2.add(lab2);
        pan2.add(txt2);
        pan2.add(lab3);
        pan2.add(txt3);
        pan2.add(lab4);
        pan2.add(txt4);
        pan2.add(btn1);
        pan2.add(btn2);
        pan2.add(btn3);
        add(pan1);
        add(pan2);
        setLayout(new GridLayout(2, 1));
        setBounds(10, 10, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
        frame.  setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String present_password = txt2.getText();
                String id = txt1.getText();
                String new_password = txt3.getText();
                String confirm_new_password = txt4.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "262088");

                    Statement statement = connection.createStatement();
                    String query = "SELECT present_password FROM password WHERE id = '" + id + "'";
                    ResultSet resultSet = statement.executeQuery(query);

                    if (resultSet.next()) {
                        String dbPassword = resultSet.getString("present_password");
                        if (new_password.equals(confirm_new_password) && present_password.equals(dbPassword)) {
                            String update = "UPDATE password SET present_password = '" + new_password + "' WHERE id = '" + id + "'";
                            int rowsUpdated = statement.executeUpdate(update);
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(null, "Password updated successfully");
                            } else {
                                JOptionPane.showMessageDialog(null, "Password update failed");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                    }

                    statement.close();
                    connection.close();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });

        }
    public static void main(String[] args) {
        Change_pass_word change_pass_word = new Change_pass_word();
    }
    }

