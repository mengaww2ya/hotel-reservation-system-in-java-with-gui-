import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update_customers extends  JFrame {
    Update_customers(){

                JLabel lab1=new JLabel("enter your first name:");
                lab1.setBounds(20,20,200,30);
                JTextField txt1=new JTextField();
                txt1.setBounds(20,20,200,30);
                JLabel lab2=new JLabel("enter your last name:");
                lab2.setBounds(20,20,100,30);
                JTextField txt2=new JTextField();
                txt2.setBounds(20,20,200,30);
                JLabel lab3=new JLabel("enter your email");
                lab2.setBounds(20,20,100,15);
                JTextField txt3=new JTextField();
                txt3.setBounds(20,20,200,10);
                JLabel lab4=new JLabel("enter phone number");
                JTextField txt4=new JTextField();
                lab4.setBounds(20,40,200,30);
                JLabel lab5=new JLabel("Create new password:");
                lab5.setBounds(20,40,200,30);
                JPasswordField txt5=new JPasswordField();
                txt5.setBounds(20,40,200,30);
                JLabel lab6=new JLabel("confirm password:");
                lab6.setBounds(20,40,200,30);
                JPasswordField txt6=new JPasswordField();
                txt6.setBounds(220,40,200,30);
                JLabel lab7=new JLabel("select gender:");
                lab7.setBounds(20,20,200,30);
                JPasswordField txt7=new JPasswordField();
                txt7.setBounds(220,40,200,30);
                JButton btn1=new JButton("Update_customers");
                btn1.setBounds(20,60,30,30);
        btn1.setBackground(Color.ORANGE);
        btn1.setForeground(Color.black);
                JLabel lab8=new JLabel("FILL THE FOLLOWING FORMS ");
                lab8.setFont(new Font("serif",Font.BOLD,28));
                lab8.setBounds(10,10,300,20);
                JLabel lab9=new JLabel("enter your id number:");
                lab9.setBounds(20,20,200,30);
                lab8.setForeground(Color.blue);
                String gender[] = {"Male", "Female"};
                JComboBox<String> comboBox1 = new JComboBox<>(gender);
                comboBox1.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        String selectedGender = (String) comboBox1.getSelectedItem();
                        if (selectedGender.equals("Male")) {
                            // Perform actions for Male selection
                            System.out.println("Male selected");
                        } else if (selectedGender.equals("Female")) {
                            // Perform actions for Female selection
                            System.out.println("Female selected");
                        }
                        System.out.println("Selected gender: " + selectedGender);
                    }
                });

                btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String Fname = txt1.getText();
                            String Lname = txt2.getText();
                            String email = txt3.getText();
                            String phone_number = txt4.getText();
                            String new_password = new String(txt5.getPassword());
                            String confirm_password = new String(txt6.getPassword());
                            String gender = (String) comboBox1.getSelectedItem();
                            String ID_no = txt7.getText();
                            String password = null;
                            if (new_password.equals(confirm_password)) {
                                password = new_password;
                            }
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "262088");
                            String sql = "UPDATE customurs SET email='" + email + "', Fname='" + Fname + "', Lname='" + Lname + "', password='" +
                                    password + "', phone_number='" + phone_number + "', gender='" + gender + "', ID_no='" +
                                    ID_no + "' WHERE email='" + txt3.getText() + "'";
                            PreparedStatement statement = connection.prepareStatement(sql);
                            int rowsupdated= statement.executeUpdate(sql);
                            if(rowsupdated>0){
                                JOptionPane.showMessageDialog(null, "updated");
                            }else{
                                JOptionPane.showMessageDialog(null, JOptionPane.INFORMATION_MESSAGE);}


                            statement.setString(1, email);
                            statement.setString(2, Fname);
                            statement.setString(3, Lname);
                            statement.setString(4, password);
                            statement.setString(5, phone_number);
                            statement.setString(6, gender);
                            statement.setString(7, ID_no);
                            statement.executeUpdate();
                            statement.close();
                            connection.close();
                            JOptionPane.showMessageDialog(null, "Sign up successful");
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
                btn3.setBounds(20,40,30,30);
                btn3.setBackground(Color.ORANGE);
                btn3.setForeground(Color.black);
                btn3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        Start_interface start_interface=new Start_interface();
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
                                txt4.setText("");
                                txt5.setText("");
                                txt6.setText("");
                                txt7.setText("");
                                comboBox1.setSelectedIndex(0);
                            }
                });
                JPanel sign_up=new JPanel();
                JPanel pan2=new JPanel();
                btn2.setBounds(50,60,30,30);
                pan2.setBounds(5,5,100,10);
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\menga\\OneDrive\\Pictures\\Screenshots\\start interface.PNG "); // Replace with the path to your image file
        label.setIcon(icon);
                pan2.add(lab8);
                sign_up.add(lab1);
                sign_up.add(txt1);
                sign_up.add(lab2);
                sign_up.add(txt2);
                sign_up.add(lab3);
                sign_up.add(txt3);
                sign_up.add(lab4);
                sign_up.add(txt4);
                sign_up.add(lab5);
                sign_up.add(txt5);
                sign_up.add(lab6);
                sign_up.add(txt6);
                sign_up.add(lab9);
                sign_up.add(txt7);
                sign_up.add(lab7);
                sign_up.add(lab7);
                sign_up.add(comboBox1);
                sign_up.add(btn1);
                sign_up.add(btn2);
                sign_up.add(btn3);
                sign_up.add(btn4) ;
                sign_up.setBackground(Color.cyan);
                add(pan2);
                add(sign_up);
//                add(label);

            setTitle("Sign up");
                setLayout( new FlowLayout());
                sign_up.setBounds(20,20,500,500);
                setBounds(10,10,500,500);
                setVisible(true);
                setBackground(Color.BLUE);
                sign_up.setLayout(new GridLayout(10,2,10,10));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
           try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\menga\\OneDrive\\Pictures\\hotel reservations\\download (1).jpg"));
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

            }

            public static void main(String[] args) {
                Update_customers updateCustomers=new Update_customers();

            }

    }
