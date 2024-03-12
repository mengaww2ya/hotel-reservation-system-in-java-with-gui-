import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Check_in extends JFrame {
    Check_in() throws SQLException, ClassNotFoundException {

    JLabel lab1=new JLabel("   enter your first name:");
            lab1.setBounds(20,20,100,30);
    JTextField txt1=new JTextField();
            txt1.setBounds(220,20,100,30);
    JLabel lab2=new JLabel("  enter your last name:");
            lab2.setBounds(20,20,100,30);
    JTextField txt2=new JTextField();
            txt2.setBounds(220,20,100,30);

    JLabel lab3=new JLabel("   enter phone number :");
            lab3.setBounds(20,40,100,30);
    JTextField txt3=new JTextField();
            txt3.setBounds(220,40,100,30);
        JLabel lab4=new JLabel("  select room number :");
        lab4.setBounds(20,40,100,30);
        JComboBox comboBox1=new JComboBox<>();
        JLabel lab5=new JLabel("  enter check in date");
        JTextField txt4=new JTextField();
        JLabel lab6=new JLabel("   enter check out date");
        JTextField txt5=new JTextField();
        JLabel lab7=new JLabel("   enter your ID no");
        JTextField txt6=new JTextField();
        JLabel lab8=new JLabel("   enter your email");
        JTextField txt7=new JTextField();
        JLabel lab9=new JLabel("FILL THE FOLLOWING FORM TO CHECK IN");
        lab9.setFont(new Font("serif",Font.BOLD,15));
        lab9.setForeground(Color.BLUE);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
        String username = "root";
        String password = "262088";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root","262088");
        Statement statement=connection.createStatement();
        String select_query = "   select room_number from rooms";
        ResultSet resultSet =statement.executeQuery(select_query);
        while(resultSet.next()){
            resultSet.getString(1);
            comboBox1.addItem( resultSet.getString(1));
        }
        statement.close();
        connection.close();

        JButton btn4=new JButton("see check in status");
        btn4.setBounds(20,40,30,30);
        btn4.setForeground(Color.BLUE);
        btn4.setBackground(Color.cyan);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String phone = JOptionPane.showInputDialog(null, "Enter your phone to search", "view check in status", JOptionPane.QUESTION_MESSAGE);

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";

                    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                        String query = "SELECT * FROM check_in_customer where phone = ?";
                        PreparedStatement statement = connection.prepareStatement(query);
                        statement.setString(1, phone);
                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            StringBuilder message = new StringBuilder();
                            message.append("Fname: ").append(resultSet.getString("Fname")).append("\n");
                            message.append("Lname : ").append(resultSet.getString("Lname")).append("\n");
                            message.append("phone: ").append(resultSet.getString("phone")).append("\n");
                            message.append("ID_no: ").append(resultSet.getString("ID_no")).append("\n");
                            message.append("room_no: ").append(resultSet.getString("room_no")).append("\n");
                            message.append("check_in_data: ").append(resultSet.getString("check_in_data")).append("\n");
                            message.append("check_out_date: ").append(resultSet.getString("check_out_date")).append("\n");
                            JOptionPane.showMessageDialog(null, message.toString(), "Customer Details", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No check_in_customer found with the specified email.", "Customer Details", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException("Failed to load MySQL JDBC driver.", ex);
                } catch (SQLException ex) {
                    throw new RuntimeException("Database connection error.", ex);
                }
            }
        });
        JButton btn1 = new JButton("CHECK IN");
        btn1.setForeground(Color.BLUE);
        btn1.setBackground(Color.CYAN);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String Fname = txt1.getText();
                    String Lname = txt2.getText();
                    String email = txt7.getText();
                    String phone = txt3.getText();
                    String room_no = (String) comboBox1.getSelectedItem();
                    String ID_no = txt6.getText();
                    String check_in_data = txt4.getText();
                    String check_out_date = txt5.getText();

                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";

                    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                        String roomQuery = "SELECT status FROM rooms WHERE room_number = ?";
             try (PreparedStatement roomStatement = connection.prepareStatement(roomQuery)) {
       roomStatement.setString(1, room_no);
           try (ResultSet roomResultSet = roomStatement.executeQuery()) {
         if (roomResultSet.next()) {
                                    int roomStatus = roomResultSet.getInt("status");
         if (roomStatus == 1) {
               String customerQuery = "SELECT * FROM customurs WHERE email = ?";
                  try (PreparedStatement customerStatement = connection.prepareStatement(customerQuery)) {
                customerStatement.setString(1, email);
                                            try (ResultSet customerResultSet = customerStatement.executeQuery()) {
                 if (customerResultSet.next()
                                                        && email.equals(customerResultSet.getString("email"))
                                           && Fname.equals(customerResultSet.getString("Fname"))
                                                        && Lname.equals(customerResultSet.getString("Lname"))
                                  && phone.equals(customerResultSet.getString("phone_number"))
                                                        && ID_no.equals(customerResultSet.getString("ID_no"))) {
                     String insertQuery = "INSERT INTO check_in_customer (Fname, Lname, phone, ID_no, room_no, check_in_data, check_out_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
                     try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                         statement.setString(1, Fname);
                         statement.setString(2, Lname);
                         statement.setString(3, phone);
                         statement.setString(4, ID_no);
                         statement.setString(5, room_no);
                         statement.setString(6, check_in_data);
                         statement.setString(7, check_out_date);
                         int rowsInserted = statement.executeUpdate();
                         if (rowsInserted > 0) {
                             String updateQuery = "UPDATE rooms SET status = 0 WHERE room_number = ?";
                                        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                                  updateStatement.setString(1, room_no);
                                                                int rowsUpdated = updateStatement.executeUpdate();
                           if (rowsUpdated > 0) {
                                       JOptionPane.showMessageDialog(null, "Room status updated");
                                   } else {
                                       JOptionPane.showMessageDialog(null, "Failed to update room status");
                                   }}
                              } else {
                             JOptionPane.showMessageDialog(null, "Failed to perform check-in");
                         }
                     }
                     JOptionPane.showMessageDialog(null, "Your check-in is successfully performed");
                     btn4.doClick();
                 } else {
                               JOptionPane.showMessageDialog(null, "Invalid customer details");
                                }
                             }
                             }
                        } else {
                                        JOptionPane.showMessageDialog(null, "The room is currently unavailable for check-in");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid room number");
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });

    JButton btn2=new JButton("exit");
        btn2.setForeground(Color.BLUE);
        btn2.setBackground(Color.cyan);

        btn2.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
        JButton btn3=new JButton("back");
        btn3.setForeground(Color.BLUE);
        btn3.setBackground(Color.cyan);

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Start_interface start_interface=new Start_interface();
            }
        });
        JButton btn5=new JButton("clear");
        btn5.setForeground(Color.BLUE);
        btn5.setBackground(Color.cyan);

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                txt5.setText("");
                txt6.setText("");
                txt7.setText("");
                comboBox1.setSelectedIndex(0);
            }
        });
        JLabel label = new JLabel("                       ");
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\room.PNG "); // Replace with the path to your image file
        label.setIcon(icon);
        JPanel pan1=new JPanel();
        pan1.setLayout(new GridLayout(2,2,1,1));
        pan1.setBackground(Color.PINK);
        JPanel pan2=new JPanel();
        pan2.setLayout(new GridLayout(8,2,1,1));
        pan2.setBackground(Color.cyan);
        JPanel pan3=new JPanel();
        pan3.setLayout(new GridLayout(3,2,1,1));
        pan3.setBackground(Color.CYAN);
        pan3.add(btn1);
        pan3.add(btn2);
        pan3.add(btn3);
        pan3.add(btn4);
        pan3.add(btn5);
        pan1.add(label);
        pan1.add(pan3) ;
        pan1.add(lab9);
        pan2.add(lab1);
        pan2.add(txt1);
        pan2.add(lab2);
        pan2.add(txt2);
        pan2.add(lab8);
        pan2.add(txt7);
        pan2.add(lab3);
        pan2.add(txt3);
        pan2.add(lab7);
        pan2.add(txt6);
        pan2.add(lab4);
        pan2.add(comboBox1);
        pan2.add(lab5);
        pan2.add(txt4) ;
        pan2.add(lab6);
        pan2.add(txt5);
        add(pan1);
        add(pan2);
        setTitle("check in");
    setBounds(10,10,700,700);
    setVisible(true);
    setBackground(Color.BLUE);
    setLayout(new GridLayout(2,1,3,3));
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
        Check_in check_in=new Check_in();
    }
}
