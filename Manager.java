import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Manager extends  JFrame {
    Manager(){
        Font font1=new Font("serif",Font.BOLD,20);

        JLabel lab1=new JLabel("what do you want to change?");
         lab1.setFont(font1);
        JButton btn1=new JButton("add customer");
        btn1.setBounds(20,40,30,30);
        btn1.setBackground(Color.ORANGE);
        btn1.setForeground(Color.black);
        JButton btn2=new JButton("add room");
        btn2.setBounds(20,40,30,30);
        btn2.setBackground(Color.ORANGE);
        btn2.setForeground(Color.black);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Insert_room insert_room= new Insert_room();
            }
        });
        JButton btn3=new JButton("see customers");
        btn3.setBounds(20,40,30,30);
        btn3.setBackground(Color.ORANGE);
        btn3.setForeground(Color.black);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame1=new JFrame("the are all customers");
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setBounds(5,5,600,600);
                setLocationRelativeTo(null);
                JButton btn15=new JButton("back");
                btn15.setBounds(20,40,30,30);
                btn15.setBackground(Color.cyan);
                btn15.setForeground(Color.black);
                btn15 .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.setVisible(false);
                        Manager manager=new Manager();
                    }
                });
                JButton btn16=new JButton("exit");
                btn16.setBounds(20,40,30,30);
                btn16.setBackground(Color.CYAN);
                btn16.setForeground(Color.black);
                btn16.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                JLabel label = new JLabel();
                ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\all customer.PNG");
                label.setIcon(icon);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
                            "root","262088");
                    Statement statement1=connection.createStatement();
                    ResultSet resultSet1=statement1.executeQuery("select * from customurs");
                    String[] columnNames = {"email", "Fname", "Lname","password","phone_number","gender","ID_no"};
                    Object[][] data = new Object[100][8];

                    int i = 0;
                    while (resultSet1.next()) {

                        data[i][0] = resultSet1.getString("email");
                        data[i][1] = resultSet1.getString("Fname");
                        data[i][2] = resultSet1.getString("Lname");
                        data[i][3] = resultSet1.getString("password");
                        data[i][4] = resultSet1.getString("phone_number");
                        data[i][5] = resultSet1.getString("gender");
                        data[i][6] = resultSet1.getString("ID_no");
                        i++;
                    }
                    JPanel pan1=new JPanel();
                    pan1.setLayout(new GridLayout(2,2));
                    JPanel pan2=new JPanel();
                    setLayout( new GridLayout(1, 1));
                    JTable table = new JTable(data, columnNames);
                    table.setSize(400, 400);
                    table.setVisible(true);
                    pan2.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
                    frame1.setVisible(true);
                    frame1.setLocationRelativeTo(null);
                    pan1.add(label);
                    pan1.add(btn15);
                    pan1.add(btn16) ;
                    frame1.add(pan1);
                    frame1.add(pan2);
                    frame1.setLayout(new GridLayout(2,1));
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        JButton btn4=new JButton("see rooms");
        btn4.setBounds(20,40,30,30);
        btn4.setBackground(Color.ORANGE);
        btn4.setForeground(Color.black);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame1=new JFrame("the are all rooms");
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setBounds(5,5,600,600);
                setLocationRelativeTo(null);
                JButton btn14=new JButton("back");
                btn14.setBounds(20,40,30,30);
                btn14.setBackground(Color.cyan);
                btn14.setForeground(Color.black);
                btn14 .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.setVisible(false);
                        Manager manager=new Manager();
                    }
                });
                JButton btn13=new JButton("exit");
                btn13.setBounds(20,40,30,30);
                btn13.setBackground(Color.CYAN);
                btn13.setForeground(Color.black);
                btn13.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                JLabel label = new JLabel();
                ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\seeroom2.PNG");
                label.setIcon(icon);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
                            "root","262088");
                    Statement statement1=connection.createStatement();
                    ResultSet resultSet1=statement1.executeQuery("select * from rooms");
                    String[] columnNames = {"room_number", "number_of_person_it_holds", "price_of_room_per_day","status"};
                    Object[][] data = new Object[100][4];
//                    txta1.append("room no"+"\t"+"No ofperson "+"\t"+"price \n");
                    int i = 0;
                    while (resultSet1.next()) {

                        data[i][0] = resultSet1.getString("room_number");
                        data[i][1] = resultSet1.getDouble("number_of_person_it_holds");
                        data[i][2] = resultSet1.getInt("price_of_room_per_day");
                        data[i][3]=resultSet1.getString("status");
                        i++;
                    }
                    JPanel pan1=new JPanel();
                    pan1.setLayout(new GridLayout(2,2));
                    JPanel pan2=new JPanel();
                    setLayout( new GridLayout(1, 1));

                    JTable table = new JTable(data, columnNames);
                    table.setSize(400, 400);
                    table.setVisible(true);
                    pan2.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
                    frame1.setVisible(true);
                    frame1.setLocationRelativeTo(null);
                        pan1.add(label);
                        pan1.add(btn13);
                        pan1.add(btn14) ;
                      frame1.add(pan1);
                     frame1.add(pan2);
                      frame1.setLayout(new GridLayout(2,1));
//
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton btn5=new JButton("see check in");
        btn5.setBounds(20,40,30,30);
        btn5.setBackground(Color.ORANGE);
        btn5.setForeground(Color.black);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame1=new JFrame("these are all check in customers");
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setBounds(5,5,600,600);
                setLocationRelativeTo(null);
                JButton btn11=new JButton("back");
                btn11.setBounds(20,40,30,30);
                btn11.setBackground(Color.cyan);
                btn11.setForeground(Color.black);
                btn11 .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.setVisible(false);
                        Manager manager=new Manager();
                    }
                });
                JButton btn12=new JButton("exit");
                btn12.setBounds(20,40,30,30);
                btn12.setBackground(Color.CYAN);
                btn12.setForeground(Color.black);
                   btn12.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           System.exit(0);
                       }
                   });

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
                            "root","262088");
                    Statement statement1=connection.createStatement();
                    ResultSet resultSet1=statement1.executeQuery("select * from check_in_customer");
                    String[] columnNames = {"Fname", "Lname", "phone","room_no","ID_no","check_in_data","check_out_date"};
                    Object[][] data = new Object[100][8];

                    int i = 0;
                    while (resultSet1.next()) {

                        data[i][0] = resultSet1.getString("Fname");
                        data[i][1] = resultSet1.getString("Lname");
                        data[i][2] = resultSet1.getString("phone");
                        data[i][3] = resultSet1.getString("room_no");
                        data[i][4] = resultSet1.getString("ID_no");
                        data[i][5] = resultSet1.getString("check_in_data");
                        data[i][6] = resultSet1.getString("check_out_date");
                        i++;

                    }
                    JLabel label = new JLabel();
                    ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\checkin customer .PNG");
                    label.setIcon(icon);

                    JTable table = new JTable(data, columnNames);
                    JPanel pan1=new JPanel();
                    pan1.setLayout(new GridLayout(2,2));
                    JPanel pan2 =new JPanel();
                       pan2.setLayout(new GridLayout(1,1));
                    table.setSize(400, 400);
                    table.setVisible(true);
                    pan1.add(label);
                    pan1.add(btn11);
                    pan1.add(btn12);
                    pan2.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
                    frame1.add(pan1) ;
                    frame1.add(pan2);
                    frame1.setLayout(new GridLayout(2,1));
                    frame1.setVisible(true);
                    frame1.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton btn6=new JButton("chang password");
        btn6.setBounds(20,40,30,30);
        btn6.setBackground(Color.ORANGE);
        btn6.setForeground(Color.black);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Change_pass_word change_pass_word=new Change_pass_word();

            }
        });
        JButton btn9=new JButton("add customer");
        btn9.setBounds(20,40,30,30);
        btn9.setBackground(Color.ORANGE);
        btn9.setForeground(Color.black);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Sign_up_from_manager  sign_up_from_manager=new Sign_up_from_manager();
            }
        });
        JButton btn10=new JButton("back");
        btn10.setBounds(20,40,30,30);
        btn10.setBackground(Color.ORANGE);
        btn10.setForeground(Color.black);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                choose_roll choose_roll=new choose_roll();
            }
        });
        JButton btn11=new JButton("search customers");
        btn11.setBounds(20,40,30,30);
        btn11.setBackground(Color.ORANGE);
        btn11.setForeground(Color.black);
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String email = JOptionPane.showInputDialog(null, "Enter customer's email to search", "Search Customers", JOptionPane.QUESTION_MESSAGE);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";
                    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                        String query = "SELECT * FROM customurs WHERE email = ?";
                        PreparedStatement statement = connection.prepareStatement(query);
                        statement.setString(1, email);
                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            StringBuilder message = new StringBuilder();
                            message.append("Email: ").append(resultSet.getString("email")).append("\n");
                            message.append("First Name: ").append(resultSet.getString("Fname")).append("\n");
                            message.append("Last Name: ").append(resultSet.getString("Lname")).append("\n");
                            message.append("Phone Number: ").append(resultSet.getString("phone_number")).append("\n");
                            message.append("Gender: ").append(resultSet.getString("gender")).append("\n");
                            message.append("ID Number: ").append(resultSet.getString("ID_no")).append("\n");
                            JOptionPane.showMessageDialog(null, message.toString(), "Customer Details", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No customer found with the specified email.", "Customer Details", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException("Failed to load MySQL JDBC driver.", ex);
                } catch (SQLException ex) {
                    throw new RuntimeException("Database connection error.", ex);
                }
            }
        });
        JButton btn12 = new JButton("Delete customer");
        btn12.setBackground(Color.ORANGE);
        btn12.setForeground(Color.black);
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String email = JOptionPane.showInputDialog("Enter the email to delete:");

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "262088");

                    String sql = "DELETE FROM customurs WHERE email=?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, email);
                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null,"Record deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null,"No record found to delete.");
                    }

                    statement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton btn13=new JButton("delete room");
        btn13.setBackground(Color.ORANGE);
        btn13.setForeground(Color.black);
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Establish a connection to the database
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                    String username = "root";
                    String password = "262088";
                    Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

                    // Prompt the user to enter the room number
                    String roomNumber = JOptionPane.showInputDialog("Enter the room number to delete:");

                    // Create a statement and execute the deletion query
                    Statement statement = connection.createStatement();
                    String sql = "DELETE FROM rooms WHERE room_number = '" + roomNumber + "'";
                    int rowsAffected = statement.executeUpdate(sql);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null,"Record deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null,"No record found to delete.");
                    }

                    statement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton btn15=new JButton("exit");
        btn15.setBackground(Color.ORANGE);
        btn15.setForeground(Color.black);
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton btn16=new JButton("check in customers");
        btn16.setBounds(20,40,30,30);
        btn16.setBackground(Color.ORANGE);
        btn16.setForeground(Color.black);
        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    setVisible(false);
                    Check_in_from_manager check_in_from_manager = new Check_in_from_manager();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }   });
        JButton btn17=new JButton("check out customers");
        btn17.setBounds(20,40,30,30);
        btn17.setBackground(Color.ORANGE);
        btn17.setForeground(Color.black);
        btn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    Check_out_from_manager check_out_from_manager=new Check_out_from_manager();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10,10,600,600);
        setLocationRelativeTo(null);
        setTitle("THESE ALL ARE MANAGERS ROLL");
        setVisible(true);
        JPanel pan1=new JPanel();
        JPanel pan2=new JPanel();
        pan1.setLayout(new GridLayout(2,1));
        pan2.setLayout(new GridLayout(7,2));
        pan1.setBackground(Color.cyan);
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\hotel.PNG");
        label.setIcon(icon);
        pan1.add(lab1);
        pan1.add(label);
        pan2.add(btn2);
        pan2.add(btn3);
        pan2.add(btn4);
        pan2. add(btn5);
        pan2.add(btn6);
        pan2.add(btn9);
        pan2. add(btn10);
        pan2. add(btn11);
        pan2.add(btn12);
        pan2.add(btn13);
        pan2.add(btn15);
        pan2.add(btn16);
        pan2.add(btn17);

        add(pan1);
        add(pan2);
    }
    public static void main(String[] args) {
        Log_in_asmangaer log_in_asmangaer=new Log_in_asmangaer();
    }
}
