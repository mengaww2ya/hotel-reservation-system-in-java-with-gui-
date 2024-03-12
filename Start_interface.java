import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Start_interface  extends JFrame {
    Start_interface() {
        JLabel lab1=new JLabel("welcome to our hotel reservation systems");
        lab1.setBounds(30,30,200,30);
        lab1.setForeground(Color.BLUE);
        JButton btn1=new JButton("check out");
        btn1.setBounds(20,40,30,30);
        btn1.setBackground(Color.ORANGE);
        btn1.setForeground(Color.black);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Check_out checkOut=new Check_out();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton btn2=new JButton("check in");
        btn2.setBounds(20,40,30,30);
        btn2.setBackground(Color.ORANGE);
        btn2.setForeground(Color.black);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    setVisible(false);
                    Check_in check_in=new Check_in();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton btn3=new JButton("see rooms");
        btn3.setBounds(20,40,30,30);
        btn3.setBackground(Color.ORANGE);
        btn3.setForeground(Color.black);
        btn3.addActionListener(new ActionListener() {
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
                        Start_interface start_interface=new Start_interface();
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
        JButton btn4=new JButton("exit");
        btn4.setBounds(20,40,30,30);
        btn4.setBackground(Color.ORANGE);
        btn4.setForeground(Color.black);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton btn5=new JButton("update");
        btn5.setBounds(20,40,30,30);
        btn5.setBackground(Color.ORANGE);
        btn5.setForeground(Color.black);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Update_customers updateCustomers=new Update_customers();

            }
        });
        JButton btn6=new JButton("back");
        btn6.setBounds(20,40,30,30);
        btn6.setBackground(Color.ORANGE);
        btn6.setForeground(Color.black);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Sign_in sign_in =new Sign_in();
            }
            
        });
        setBounds(10,10,500,500);
        setBackground(Color.CYAN);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel start_inteface_pan1=new JPanel();
        JPanel start_inteface_pan2=new JPanel();
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\start interface.PNG "); // Replace with the path to your image file
        label.setIcon(icon);
        start_inteface_pan1.add(lab1);
        start_inteface_pan1.add(label);
        start_inteface_pan2.add(btn1);
        start_inteface_pan2.add(btn2);
        start_inteface_pan2.add(btn3);
        start_inteface_pan2.add(btn4);
        start_inteface_pan2.add(btn5);
        start_inteface_pan2.add(btn6);

        add(start_inteface_pan1);
        add(start_inteface_pan2);
        setLocationRelativeTo(null);
        LayoutManager layoutManager1=new GridLayout(2,3,10,10)   ;
        start_inteface_pan2.setLayout(layoutManager1);
        LayoutManager layoutManager2=new FlowLayout();
        start_inteface_pan1.setLayout(layoutManager2);
        LayoutManager layoutManager3=new GridLayout(2,1,10,10) ;
        setLayout(layoutManager3);
        setTitle("WELCOME!" );
        Font font1=new Font("new Roman",Font.BOLD,20);
        lab1.setFont(font1);
    }

    public static void main(String[] args) {
        Start_interface start_interface=new Start_interface();
    }
}