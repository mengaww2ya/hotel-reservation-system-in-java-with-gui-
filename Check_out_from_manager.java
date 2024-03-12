import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import  java.sql.*;

public class Check_out_from_manager extends JFrame {
    Check_out_from_manager() throws ClassNotFoundException, SQLException {
        JLabel lab1=new JLabel("enter your first name:");
        lab1.setBounds(20,20,100,30);
        JTextField txt1=new JTextField();
        txt1.setBounds(220,20,100,30);
        JLabel lab2=new JLabel("enter your last name:");
        lab2.setBounds(20,20,100,30);
        JTextField txt2=new JTextField();
        txt2.setBounds(220,20,100,30);
        JLabel lab3=new JLabel("enter phone number :");
        lab3.setBounds(20,40,100,30);
        JTextField txt3=new JTextField();
        txt3.setBounds(220,40,100,30);
        JLabel lab4=new JLabel("select room number :");
        lab4.setBounds(20,40,100,30);
        JComboBox comboBox1=new JComboBox<>();
        JLabel lab5=new JLabel("FILL THE FOLLOWING FORM") ;
        lab5.setFont(new Font("serif",Font.BOLD,15));
        lab5.setForeground(Color.BLUE);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
        String username = "root";
        String password = "262088";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root","262088");
        Statement statement=connection.createStatement();
        String select_query = "select room_number from rooms";
        ResultSet resultSet =statement.executeQuery(select_query);
        while(resultSet.next()){
            resultSet.getString(1);
            comboBox1.addItem( resultSet.getString(1));
        }
        statement.close();
        connection.close();
        JButton btn1 = new JButton("check out");
        btn1.setBounds(20, 60, 10, 10);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "262088");

                    String deleteQuery = "DELETE FROM check_in_customer WHERE room_no = ?";
                    PreparedStatement statement = connection.prepareStatement(deleteQuery);
                    statement.setString(1, (String) comboBox1.getSelectedItem());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected>0) {
                        String updateQuery = "UPDATE rooms SET status = true WHERE room_number = ?";
                        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                        updateStatement.setString(1, (String) comboBox1.getSelectedItem());
                        int rowsUpdated = updateStatement.executeUpdate();

                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "Check-out is successfully performed");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update room status");
                        }

                        updateStatement.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "No rows deleted");
                    }

                    statement.close();
                    connection.close();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
        JButton btn2=new JButton("exit");
        btn2.setBounds(50,60,10,10);
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
                Manager manager =new Manager();
            }
        });
        JLabel label = new JLabel("                       ");
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\CHECKOUT.PNG "); // Replace with the path to your image file
        label.setIcon(icon);
        JPanel Check_outpan1=new JPanel();
        Check_outpan1.  setBackground(Color.white);
        JPanel pan2=new JPanel();
        pan2.setLayout(new GridLayout(2,2,3,3));
        pan2.setBackground(Color.CYAN);
        JPanel pan3=new JPanel();
        pan3.setLayout(new GridLayout(4,2,3,3));
        pan3.setBackground(Color.PINK);
        Check_outpan1.add(label);
        Check_outpan1.add(pan2);
        Check_outpan1.add(lab5);
        pan3.add(lab1);
        pan3.add(txt1);
        pan3.add(lab2);
        pan3.add(txt2);
        pan3.add(lab3);
        pan3.add(txt3);
        pan3.add(lab4);
        pan3.add(comboBox1);
        pan2.add(btn1);
        pan2.add(btn2);
        pan2.add(btn3)  ;
        add(Check_outpan1);
        add(pan3);

        setLayout(new GridLayout(2,1,3,3));
        setTitle("Check_out");
        setBounds(10,10,500,500);
        setVisible(true);
        setBackground(Color.BLUE);
        Check_outpan1.setLayout(new GridLayout(2,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Check_out_from_manager check_out_from_manager=new Check_out_from_manager();
    }

}
