import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {
    int x = 0, y = 0;
    JPanel mp, card, signup_p;
    Container c;
    JLabel co_nds, co_nds2, usr, psw, view, view2, usr_2, psw_2, mob,name_l;
    JTextField usr_txt,usr_txt2, psw_txt2, mob_txt2,name_txt2;
    JPasswordField psw_txt;
    JButton sin_in, singup, signin2, submit2;
    JCheckBox term;
    Font f;
    CardLayout cl;
    String name;

    public Login()         //register components here
    {
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cons();
        setPan();
        signup_p.setBackground(Color.gray);
        singup.setLayout(null);
        setMp();
        setDim();
        setSinup_p();
       // addMouseMotionListener(this);
        singup.addActionListener(this);
        signin2.addActionListener(this);
        submit2.addActionListener(this);

    }

    public void setSinup_p()//signup panel
    {

        view2.setFont(f);
        view2.setForeground(Color.WHITE);
        view2.setOpaque(true);
        view2.setBackground(Color.GRAY);
        signup_p.setLayout(null);
        signup_p.add(co_nds2);
        signup_p.add(view2);
        usr_2 = new JLabel("Enter Email Id:");
        psw_2 = new JLabel("Enter Password:");
        mob = new JLabel("Enter Mobile No:");
        usr_txt2 = new JTextField();
        psw_txt2 = new JTextField();
        mob_txt2 = new JTextField();
        signin2 = new JButton("Signin");
        signup_p.add(signin2);
        signin2.setBounds(270, 400, 100, 20);
        submit2 = new JButton("submit");
        signup_p.add(submit2);
        submit2.setBounds(180, 380, 100, 20);
        usr_2.setBounds(100, 130, 100, 20);
        usr_txt2.setBounds(250, 130, 120, 25);
        signup_p.add(usr_2);
        signup_p.add(usr_txt2);
        signup_p.add(mob);
        signup_p.add(mob_txt2);
        mob.setBounds(100, 200, 100, 20);
        mob_txt2.setBounds(250, 200, 120, 25);
        psw_2 = new JLabel("Enter password:");
        psw_txt2 = new JPasswordField();
        signup_p.add(psw_2);
        signup_p.add(psw_txt2);
        psw_2.setBounds(100, 270, 100, 20);
        psw_txt2.setBounds(250, 270, 120, 25);
        term = new JCheckBox("terms and conditiones");
        term.setSelected(true);
        signup_p.add(term);
        term.setBounds(60, 400, 150, 20);
        term.setOpaque(true);
        term.setBackground(Color.gray);
        name_l=new JLabel("Enter Name");
        signup_p.add(name_l);
        name_l.setBounds(100,340,100,20);
        name_txt2=new JTextField();
        signup_p.add(name_txt2);
        name_txt2.setBounds(250,340,120,25);
    }

    public void cons() {
        c = getContentPane();
        co_nds = new JLabel("");
        usr = new JLabel("Enter Username :");
        psw = new JLabel("Enter password :");
        view = new JLabel("Train Transport Chandigarh");
        view2 = new JLabel("Train Transport Chandigarh");
        co_nds2 = new JLabel("");
        psw_txt = new JPasswordField();
        usr_txt = new JTextField();
        sin_in = new JButton("Sigin");
        singup = new JButton("Signup");
        mp = new JPanel();
        cl = new CardLayout();
        card = new JPanel(cl);
        signup_p = new JPanel();
        f = new Font("Arial", Font.PLAIN, 30);
        sin_in.addActionListener(this);


    }

    public void setPan()//Container pan
    {
        mp.setBackground(Color.gray);
        c.add(card);
        card.add(mp, "1");
        card.add(signup_p, "2");
    }

    public void setDim()//set dimension for mp
    {
        co_nds.setBounds(10, 20, 100, 20);
        co_nds2.setBounds(10, 10, 100, 20);
        usr.setBounds(100, 130, 100, 20);
        usr_txt.setBounds(250, 130, 120, 25);
        psw.setBounds(100, 200, 100, 20);
        psw_txt.setBounds(250, 200, 120, 25);
        sin_in.setBounds(100, 330, 100, 20);
        singup.setBounds(250, 330, 100, 20);
        view.setBounds(60, 60, 385, 40);
        view2.setBounds(60, 60, 385, 40);
    }

    public void setMp() {
        view.setFont(f);
        view.setForeground(Color.WHITE);
        view.setOpaque(true);
        view.setBackground(Color.GRAY);
        mp.setLayout(null);
        mp.add(co_nds);
        mp.add(usr);
        mp.add(usr_txt);
        mp.add(psw);
        mp.add(psw_txt);
        mp.add(sin_in);
        mp.add(singup);
        mp.add(view);
    }


    public static void main(String[] args) {

        Login login = new Login();
    }

    /*@Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        String z = Integer.toString(x);
        String q = Integer.toString(y);
        co_nds.setText(z + "," + q);
        co_nds2.setText(z + " " + q);


    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == singup) {
            cl.show(card, "2");
        } else if (e.getSource() == signin2) {
            cl.show(card, "1");
        }
        if (e.getSource() == sin_in || e.getSource() == submit2 ) {
            if (e.getSource() == sin_in)
            {
                if(usr_txt.getText().length()>=0)
                {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/arun_train", "root", "root");
                    Statement st = com.createStatement();
                    ResultSet resultSet = st.executeQuery("select * from login");
                    while (resultSet.next())
                    {
                        String p1 = resultSet.getString("password");
                        String u1 = resultSet.getString("username");
                        name=resultSet.getString("name");
                        if (u1.equals(usr_txt.getText()) && p1.equals(psw_txt.getText()))
                        {

                            Ticket t = new Ticket();
                            t.name_txt.setText(name);
                            JOptionPane.showMessageDialog(null, "Login sucessfully");
                            setVisible(false);
                            break;
                        }
                        else if(!(usr_txt.getText().equals(u1))) {
                            JOptionPane.showMessageDialog(null,"Incorrect username and password");
                        }

                    }
                } catch (Exception ex) {
                    System.out.print(ex);
                }
                }
                else if (usr_txt.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null,"fill username and password");
                }

            }

            if (e.getSource() == submit2) {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arun_train", "root", "root");
                    Statement statement = connection.createStatement();
                    String u2 = usr_txt2.getText();
                    String p2 = psw_txt2.getText();
                    String pn2 = mob_txt2.getText();
                    String n2=name_txt2.getText();
                    statement.executeUpdate("insert into login values('" + u2 + "','" + p2 + "','"+n2+"','"+pn2+"')");
                    JOptionPane.showMessageDialog(null, "signup complete");
                    Ticket t = new Ticket();
                    t.name_txt.setText(n2);
                    setVisible(false);

                } catch (Exception ex)
                {
                   System.out.println(ex);
                    JOptionPane.showMessageDialog(null,"user already exist");
                }
            }

            }
        }
    }

