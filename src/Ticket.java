import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

public class Ticket extends  JFrame implements ActionListener
{
    private  String choice[]={"DESTINATION","AMRITSAR","DELHI","KURUKSHETRA","LUDHIANA","UNA"};
    private Container c;
    private CardLayout cl;
    private JPanel card,mp,ticket_view;
    private JLabel train,total,tax,sub_total,class_l,ticket_l,adult_l,child_l,from_l,to_l,date_l,time_l,ticket_no,price;
    private Font f;
    private JSeparator sep1,sep2,sep3,sep_v,sep_v2,separator;
    private JRadioButton gen,ac_2,ac_3,cc,sl;
    private ButtonGroup group1;
    private JComboBox combo,adult_combo,child_combo;
    private JTextField total_l,sub_total_l,tax_l,class_t,adult_t,child_t,ticket_t,from_t,to_t,date_t,time_t,ticket_no_t,price_t;
    private JButton total_b,reset_b,exit_b,next;
    private String date,time;
    private int total_int=0, i=0,j=0,fare=0;
    private double gst=0,total_price=0;
    private  JLabel name,clss,total_ticket,ticket_nos,price_total,ticket_dekho,clss_txt,total_ticket_txt,ticket_nos_txt,price_total_txt;
    private JButton back,exit;
    Random random;
    JLabel name_txt,from_to,from_to_txt;
    String from="MOHALI",to="";
    public Ticket()
    {
        setVisible(true);
        setSize(1300,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        f=new Font("Arial",Font.PLAIN,50);
        cl=new CardLayout();
        c=getContentPane();
        card=new JPanel(cl);
        c.add(card);
        mp=new JPanel(null);
        card.add(mp,"1");
        train=new JLabel("Travalling ticket System");
        train.setBounds(365,0,600,200);
        mp.add(train);
        train.setFont(f);
        sep1=new JSeparator();
        mp.add(sep1);
        sep1.setBackground(Color.BLACK);
        sep1.setBounds(8,181,1366,2);
        gen=new JRadioButton("Genral");
        ac_2=new JRadioButton("2-Ac");
        ac_3=new JRadioButton("3-Ac");
        cc=new JRadioButton("cc");
        sl=new JRadioButton("sl");
        group1 =new ButtonGroup();
        String s[]={"Adult","0","1","2","3","4","5"};
        String s1[]={"Child","0","1","2","3","4","5"};
        adult_combo=new JComboBox(s);
        child_combo=new JComboBox(s1);
        group1.add(gen);
        group1.add(ac_2);
        group1.add(ac_3);
        group1.add(cc);
        group1.add(sl);
        mp.add(gen);
        mp.add(ac_2);
        mp.add(ac_3);
        mp.add(cc);
        mp.add(sl);
        gen.setBounds(14,225,80,20);
        ac_2.setBounds(14,255,80,20);
        ac_3.setBounds(14,285,80,20);
        cc.setBounds(14,315,50,20);
        sl.setBounds(14,345,80,20);
        mp.add(adult_combo);
        mp.add(child_combo);
        adult_combo.setBounds(200,225,80,20);
        child_combo.setBounds(200,255,80,20);
        combo=new JComboBox(choice);
        mp.add(combo);
        combo.setBounds(200,300,120,30);
        sep2=new JSeparator();
        mp.add(sep2);
        sep2.setBounds(8,380,893,10);
        sep2.setBackground(Color.BLACK);
        total=new JLabel("Total for 1");
        sub_total=new JLabel("Sub Total for 1");
        tax=new JLabel("Gst For 1");
        mp.add(tax);
        tax.setBounds(20,420,100,20);
        mp.add(sub_total);
        sub_total.setBounds(20,460,100,20);
        mp.add(total);
        total.setBounds(20,500,100,20);
        tax_l=new JTextField();
        mp.add(tax_l);
        tax_l.setBounds(150,420,100,20);
        sub_total_l=new JTextField();
        mp.add(sub_total_l);
        sub_total_l.setBounds(150,460,100,20);
        total_l=new JTextField();
        mp.add(total_l);
        total_l.setBounds(150,500,100,20);
        sep3=new JSeparator();
        mp.add(sep3);
        sep3.setBounds(8,540,350,10);
        sep3.setBackground(Color.BLACK);
        total_b=new JButton("Total");
        mp.add(total_b);
        total_b.setBounds(10,580,100,20);
        reset_b=new JButton("Reset");
        mp.add(reset_b);
        reset_b.setBounds(120,580,100,20);
        exit_b=new JButton("Exit");
        mp.add(exit_b);
        exit_b.setBounds(230,580,100,20);
        sep_v=new JSeparator(JSeparator.VERTICAL);
        mp.add(sep_v);
        sep_v.setBounds(360,180,10,500);
        sep_v.setBackground(Color.BLACK);
        ticket_l=new JLabel("Ticket");
        class_l=new JLabel("Class");
        adult_l=new JLabel("Adult");
        child_l=new JLabel("Child");
        mp.add(class_l);
        class_l.setBounds(410,250,120,20);
        mp.add(ticket_l);
        ticket_l.setBounds(510,250,120,20);
        mp.add(adult_l);
        adult_l.setBounds(610,250,120,20);
        mp.add(child_l);
        child_l.setBounds(710,250,100,20);
        class_t=new JTextField("");
        ticket_t=new JTextField("");
        adult_t=new JTextField("");
        child_t=new JTextField("");
        mp.add(class_t);
        mp.add(ticket_t);
        mp.add(adult_t);
        mp.add(child_t);
        class_t.setBounds(410,300,80,20);
        ticket_t.setBounds(510,300,80,20);
        adult_t.setBounds(610,300,80,20);
        child_t.setBounds(710,300,80,20);
        sep_v2=new JSeparator(JSeparator.VERTICAL );
        mp.add(sep_v2);
        sep_v2.setBounds(900,180,10,500);
        sep_v2.setBackground(Color.BLACK);
        from_l=new JLabel("From");
        to_l=new JLabel("To");
        date_l=new JLabel("Date");
        time_l=new JLabel("Time");
        mp.add(from_l);
        mp.add(to_l);
        mp.add(date_l);
        mp.add(time_l);
        from_l.setBounds(480,415,100,20);
        to_l.setBounds(480,465,100,20);
        date_l.setBounds(480,515,100,20);
        time_l.setBounds(480,565,100,20);
        from_t=new JTextField();
        to_t=new JTextField();
        date_t=new JTextField();
        time_t=new JTextField();
        mp.add(from_t);
        mp.add(to_t);
        mp.add(date_t);
        mp.add(time_t);
        from_t.setBounds(580,415,100,20);
        to_t.setBounds(580,465,100,20);
        date_t.setBounds(580,515,100,20);
        time_t.setBounds(580,565,100,20);
        ticket_no=new JLabel("Ticket No.");
        price=new JLabel("Price");
        mp.add(ticket_no);
        mp.add(price);
        ticket_no.setBounds(1000,260,100,20);
        price.setBounds(1000,310,100,20);
        price_t=new JTextField();
        ticket_no_t=new JTextField();
        mp.add(ticket_no_t);
        mp.add(price_t);
        ticket_no_t.setBounds(1100,260,100,20);
        price_t.setBounds(1100,310,100,20);
        next=new JButton("Ticket Details");
        mp.add(next);
        Date today=new Date();
        Date timecom=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yy");
        SimpleDateFormat timeFormat=new SimpleDateFormat("hh:mm");
        date=dateFormat.format(today);
        time=timeFormat.format(timecom);
        total_b.addActionListener(this);
        gen.addActionListener(this);
        exit_b.addActionListener(this);
        reset_b.addActionListener(this);
        random=new Random();
        gen.addActionListener(this);
        ac_2.addActionListener(this);
        ac_3.addActionListener(this);
        cc.addActionListener(this);
        sl.addActionListener(this);
        next.addActionListener(this);
        ticket_view=new JPanel();
        ticket_view.setLayout(null);
        card.add(ticket_view,"2");
        name=new JLabel("Name");
        clss=new JLabel("Class");
        total_ticket=new JLabel("Total No. of ticket");
        ticket_nos=new JLabel("Ticket No.");
        price_total=new JLabel("Total Price");
        ticket_dekho=new JLabel("Ticket    View");
        ticket_view.add(ticket_dekho);
        ticket_dekho.setBounds(550,120,200,40);
        ticket_dekho.setFont(f);
        separator=new JSeparator();
        ticket_view.add(separator);
        separator.setBounds(325,180,600,10);
        separator.setBackground(Color.BLACK);
        exit=new JButton("Exit");
        ticket_view.add(exit);
        exit.setBounds(650,570,100,20);
        back=new JButton("Back");
        ticket_view.add(back);
        back.setBounds(510,570,100,20);
        ticket_view.add(name);
        name.setBounds(500,240,100,20);
        clss.setBounds(500,300,100,20);
        ticket_view.add(clss);
        total_ticket.setBounds(500,360,100,20);
        ticket_view.add(total_ticket);
        ticket_nos.setBounds(500,420,100,20);
        ticket_view.add(ticket_nos);
        price_total.setBounds(500,540,100,20);
        ticket_view.add(price_total);
        clss_txt=new JLabel("");
        clss_txt.setBounds(700,300,100,20);
        ticket_view.add(clss_txt);
        price_total_txt=new JLabel("");
        ticket_view.add(price_total_txt);
        price_total_txt.setBounds(700,540,100,20);
        ticket_nos_txt=new JLabel("");
        ticket_view.add(ticket_nos_txt);
        ticket_nos_txt.setBounds(700,420,100,20);
        back.addActionListener(this);
        exit.addActionListener(this);
        total_ticket_txt=new JLabel("");
        ticket_view.add(total_ticket_txt);
        total_ticket_txt.setBounds(700,360,100,20);
        name_txt=new JLabel("");
        ticket_view.add(name_txt);
        name_txt.setBounds(700,240,100,20);
        from_to=new JLabel("From To");
        ticket_view.add(from_to);
        from_to.setBounds(500,480,100,20);
        from_to_txt=new JLabel("");
        ticket_view.add(from_to_txt);
        from_to_txt.setBounds(700,480,300,20);
    }

    public static void main(String[] args)
    {
        Ticket ticket=new Ticket();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==total_b)
        {
            from_t.setText("MOHALI");
            date_t.setText(date);
            time_t.setText(time);
            combo.getSelectedItem();
            to_t.setText(combo.getSelectedItem().toString());
            to=combo.getSelectedItem().toString();
            adult_t.setText(adult_combo.getSelectedItem().toString());
            child_t.setText(child_combo.getSelectedItem().toString());
             i=Integer.parseInt(adult_combo.getSelectedItem().toString());
             j=Integer.parseInt(child_combo.getSelectedItem().toString());
            String k=Integer.toString(i+j);
            ticket_t.setText(k);
            total_ticket_txt.setText(k);
            Enumeration<AbstractButton> allRadioButton=group1.getElements();
            JRadioButton temp;
            while(allRadioButton.hasMoreElements())
            {
                 temp=(JRadioButton)allRadioButton.nextElement();
                if (temp.isSelected())
                {
                    class_t.setText(temp.getText());
                    clss_txt.setText(temp.getText());
                }
            }
            if (i+j>1)
            {
                int no = random.nextInt(5000);
                ticket_nos_txt.setText(Integer.toString(no)+" to "+Integer.toString(no+i+j-1));
                ticket_no_t.setText(Integer.toString(no)+" to "+Integer.toString(no+i+j-1));
            }
            else
            {
                int no = random.nextInt(5000);
                ticket_no_t.setText(Integer.toString(no));
                ticket_nos_txt.setText(Integer.toString(no));
            }
            //FOR PRICE AND GST
            if(combo.getSelectedItem().toString().equals("AMRITSAR"))
            {
                fare=100;
            }
            else if (combo.getSelectedItem().toString().equals("DELHI"))
            {
                fare=150;
            }
            else if (combo.getSelectedItem().toString().equals("KURUKSHETRA"))
            {
                fare=80;
            }

            else if (combo.getSelectedItem().toString().equals("LUDHIANA"))
            {
                fare=110;
            }

            else if(combo.getSelectedItem().toString().equals("UNA"))
            {
                fare=125;
            }
            gst=fare*.05;
            tax_l.setText(Double.toString(gst)+" Rs");
            sub_total_l.setText(Integer.toString(fare)+" Rs");
            total_l.setText(Double.toString(fare+gst)+" Rs");
            total_price=(gst+fare)*(i+j);
            price_t.setText(Double.toString(total_price)+" Rs");
            price_total_txt.setText(Double.toString(total_price)+" Rs");
            next.setBounds(1030,400,200,20);
            next.setVisible(true);
            from_to_txt.setText(from+" TO "+to);
        }
        if(e.getSource()==exit_b)
        {
           setVisible(false);
        }
        if (e.getSource()==reset_b)
        {
            class_t.setText(null);
            ticket_t.setText(null);
            adult_t.setText(null);
            child_t.setText(null);
            from_t.setText(null);
            to_t.setText(null);
            date_t.setText(null);
            from_t.setText(null);
            adult_combo.setSelectedIndex(0);
            child_combo.setSelectedIndex(0);
            combo.setSelectedIndex(0);
            time_t.setText(null);
            group1.clearSelection();
            ticket_no_t.setText(null);
            price_t.setText(null);
            tax_l.setText(null);
            sub_total_l.setText(null);
            total_l.setText(null);
            next.setVisible(false);
        }
        if (e.getSource()==next)
        {
            cl.show(card,"2");
        }
        if (e.getSource()==exit)
        {
            setVisible(false);
        }
        if (e.getSource()==back)
        {
            cl.show(card,"1");
        }
    }
}
