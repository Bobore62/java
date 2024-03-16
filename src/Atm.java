import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atm extends JFrame implements ActionListener, KeyListener {

    private JLabel withdraw;
    private JLabel deposit;
    private JLabel balance;
    private JLabel more;

    private JButton insert;
    private JButton left;
    private JButton leftLow;
    private JButton right;
    private JButton rightLow;
    private JButton reset;
    private JButton delete;
    private JButton receipt;
    private JButton print;
    private JButton okay;
    private JButton logout;
    private JButton exit = new JButton("Exit");

    private JPanel panel;
    private JTextArea textArea;
    private JTextField textField;
    private int deposite;
    private int withdrawe;
    ArrayList <Integer> withdraws = new ArrayList<>();
    ArrayList <Integer> deposits = new ArrayList<>();
    private int balancee;
    private JLabel label = new JLabel("Please insert card!!!");

    private LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String form = date.format(formatter);

    private HashMap <String,Integer> hashMap  = new HashMap<String,Integer>();
    private int counter=0;
    int sum = 0;
    int totalDeposits = 0;



    private int myDeposit(int amount) {
        deposite = amount;
        return balancee+=deposite;
    }
    private int myWithdraw(int amount) {
        withdrawe = amount;
        return balancee -=withdrawe;
    }

    private void printo(int withdrawa, int deposita) {
        textArea.setText(textArea.getText() + "\n");
        textArea.setText(textArea.getText() + "                                          BOBORE ATM                " + "\n");
        textArea.setText(textArea.getText()+ "  ***************************** ATM ****************************  " + "\n");
        textArea.setText(textArea.getText() + " Date: " + form+"                                      ID:0"+Math.round(Math.random()*100)+ "\n");
        textArea.setText(textArea.getText()+ " **************************************************************** "+ "\n" );
        textArea.setText(textArea.getText() + " Account number: 8000090" +Math.round(Math.random()*1000) + "\n\n");
        textArea.setText(textArea.getText() + " Deposit: M" +deposita+".00" + "                                 Charge: M5.00"+ "\n\n");
        textArea.setText(textArea.getText() + " Withdrawal: M" +withdrawa+ ".00"+ "                            Charge: M5.00" +"\n\n");
        textArea.setText(textArea.getText() + " Balance: " + "M" +balancee+ ".00" + "\n\n");
        textArea.setText(textArea.getText()+ " **************************************************************** " + "\n");
        textArea.setText(textArea.getText() + "                        Thank you for choosing us     "+ "\n");
        textArea.setText(textArea.getText()+ " **************************************************************** "+ "\n" );
        textArea.setText(textArea.getText() + " Contact: +26622343465" + "\n");
        textArea.setText(textArea.getText() + " Website: www.bob.com" );

    }
    private HashMap<String,Integer> hash = new HashMap<String,Integer>();

    private JPasswordField passwordField = new JPasswordField();
    private JLabel l = new JLabel(String.valueOf(deposite));

    Atm() {



        hashMap.put("1234",500);
        hashMap.put("5678",200);
        hashMap.put("0000",400);
        hashMap.put("1111",600);
        hashMap.put("2020",2300);
        hashMap.put("2000",4400);

        hash.put("John",80009090);
        hash.put("Bob",80009076);
        hash.put("Moh",80009078);

        withdraw = new JLabel("Withdraw");
        deposit = new JLabel("Deposit");
        balance = new JLabel("Balance");
        more = new JLabel("Transfer");
        okay = new JButton("OK");

        insert = new JButton("Insert Card");
        left = new JButton(">");
        leftLow = new JButton(">");
        right = new JButton("<");
        rightLow = new JButton("<");
        reset = new JButton("Reset");
        delete = new JButton("Delete");
        receipt = new JButton("Receipt");
        print = new JButton("Print");
        logout = new JButton("Remove card");

        panel = new JPanel();
        textArea = new JTextArea();
        textField = new JTextField();

        textField.setBounds(75,85,100,30);
        textField.setFont(new Font(null,Font.BOLD,15));

        passwordField.setBounds(75,85,100,30);
        passwordField.setFont(new Font(null,Font.BOLD,15));

        label.setBounds(75,50,200,30);
        label.setFont(new Font(null,Font.BOLD,15));

        withdraw.setFont(new Font(null,Font.BOLD,13));
        withdraw.setForeground(Color.BLACK);
        deposit.setFont(new Font(null,Font.BOLD,13));
        deposit.setForeground(Color.BLACK);
        balance.setFont(new Font(null,Font.BOLD,13));
        balance.setForeground(Color.BLACK);
        more.setFont(new Font(null,Font.BOLD,13));
        more.setForeground(Color.BLACK);

        withdraw.setBounds(4,5,100,30);

        left.setBounds(28,80,45,30);
        left.setFocusable(false);
        left.setBackground(Color.BLUE);
        left.setForeground(Color.black);

        balance.setBounds(4,170,100,30);

        leftLow.setBounds(28,250,45,30);
        leftLow.setFocusable(false);
        leftLow.setBackground(Color.BLUE);
        leftLow.setForeground(Color.black);

        deposit.setBounds(198,5,100,30);

        right.setBounds(337,80,45,30);
        right.setFocusable(false);
        right.setBackground(Color.BLUE);
        right.setForeground(Color.black);

        more.setBounds(190,170,100,30);

        rightLow.setBounds(337,250,45,30);
        rightLow.setFocusable(false);
        rightLow.setBackground(Color.BLUE);
        rightLow.setForeground(Color.black);
        ImageIcon icon = new ImageIcon("Capture.jpg");
        //withdraw.getVerticalTextPosition();
        //withdraw.setIcon(icon);
        textArea.add(withdraw);
        panel.setLayout(null);
        panel.setBounds(80,80,250,200);
        panel.setBackground(Color.GREEN);
        panel.add(textField);
        panel.add(withdraw);
        panel.add(balance);
        panel.add(deposit);
        panel.add(more);
        panel.add(passwordField);
        panel.add(label);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
        //panel.setBorder(BorderFactory.createTitledBorder(
                //panel.setBorder(BorderFactory.createLineBorder(Color.BLUE,3)), "Bobore ATM",5));

        insert.setBounds(155,10,100,30);
        insert.setFocusable(false);

        logout.setBounds(125,10,150,30);
        logout.setFocusable(false);
        logout.setBackground(new Color(150,0,0));
        logout.setForeground(new Color(0,0,0));

        exit.setBounds(625,10,100,30);
        exit.setFocusable(false);

        insert.setBorder(BorderFactory.createLineBorder(Color.green,2));
        left.setBorder(BorderFactory.createLineBorder(Color.green,2));
        leftLow.setBorder(BorderFactory.createLineBorder(Color.green,2));
        rightLow.setBorder(BorderFactory.createLineBorder(Color.green,2));
        right.setBorder(BorderFactory.createLineBorder(Color.green,2));
        okay.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        delete.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        reset.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        receipt.setBorder(BorderFactory.createLineBorder(Color.green,2));
        exit.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        logout.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        textField.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));

        textArea.setBounds(420,80,400,400);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font(null,Font.BOLD,15));
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        //textArea.setBackground(Color.gray);

        left.setVisible(false);
        leftLow.setVisible(false);
        right.setVisible(false);
        rightLow.setVisible(false);
        delete.setVisible(false);
        reset.setVisible(false);
        textField.setVisible(false);
        passwordField.setVisible(false);
        withdraw.setVisible(false);
        deposit.setVisible(false);
        textArea.setVisible(false);
        more.setVisible(false);
        balance.setVisible(false);
        receipt.setVisible(false);
        print.setVisible(false);
        okay.setVisible(false);
        logout.setVisible(false);
        panel.setVisible(false);

        print.setBounds(570,500,100,30);
        print.setFocusable(false);

        delete.setBounds(80,370,100,30);
        delete.setFocusable(false);
        delete.setBackground(new Color(250,70,50));
        delete.setForeground(Color.black);

        exit.setBackground(new Color(255,150,150));
        insert.setBackground(new Color(0,70,250));
        receipt.setBackground(new Color(0,70,250));

        reset.setBounds(220,370,100,30);
        reset.setFocusable(false);
        reset.setBackground(new Color(250,0,0));
        reset.setForeground(Color.black);

        okay.setBounds(155,310,70,30);
        okay.setFocusable(false);
        okay.setBackground(new Color(0,200,0));
        okay.setFont(new Font("Arial",Font.BOLD,18));
        okay.setForeground(Color.black);

        receipt.setBounds(155,430,100,30);
        receipt.setFocusable(false);

        l.setSize(120,30);
        l.setForeground(Color.BLACK);


        right.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setBounds(75,50,200,30);
                label.setFont(new Font(null,Font.BOLD,15));
                label.setText("Deposit amount:");
                label.setForeground(Color.black);
                textField.setVisible(true);
                textField.setEditable(true);
                textField.setText("");
                textField.setForeground(Color.BLACK);
                okay.setText("Deposit");
                okay.setVisible(true);

            }
        });
        //textField.addKeyListener(this);
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setBounds(75,50,200,30);
                label.setFont(new Font(null,Font.BOLD,15));
                label.setText("Withdrawal amount:");
                label.setForeground(Color.black);
                textField.setEditable(true);
                textField.setVisible(true);
                textField.setText("");
                textField.setForeground(Color.BLACK);
                okay.setVisible(true);
                okay.setText("Withdraw");
            }
        });
        insert.addActionListener(this);
        reset.addActionListener(this);
        okay.addActionListener(this);
        logout.addActionListener(this);
        leftLow.addActionListener(this);
        exit.addActionListener(this);
        print.addActionListener(this);
        delete.addActionListener(this);
        passwordField.addKeyListener(this);

        receipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int w = 0;
                int d =0;
                for (int i : withdraws) {
                    w =i;
                }
                for (int i : deposits) {
                    d=i;
                }
                if(textArea.getText().isEmpty()) {
                    textArea.setVisible(true);
                    print.setVisible(true);
                    printo(w,d);
                } else {
                    textArea.setText("");
                    printo(w,d);

                }

            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setTitle("BOBORE ATM");
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.BLACK);
        this.add(panel);
        this.add(insert);
        this.add(leftLow);
        this.add(left);
        this.add(right);
        this.add(rightLow);
        this.add(textArea);
        this.add(print);
        this.add(delete);
        this.add(okay);
        this.add(exit);
        this.add(reset);
        this.add(receipt);
        this.add(logout);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==insert) {
            label.setText("Enter Pin:");
            delete.setVisible(true);
            reset.setVisible(true);
            passwordField.setVisible(true);
            //okay.setVisible(true);
            logout.setVisible(true);
            panel.setVisible(true);
            //insert.setEnabled(false);

            insert.setVisible(false);

        }
        if(e.getSource()==reset) {


            if (balance.isVisible()==false) {
                passwordField.setText("");
            } else if (balancee<100) {
                label.setText("Balance: M"+balancee+".00");
                label.setForeground(Color.red);
                textField.setText("");
                textArea.setText("");
                textField.setVisible(false);
                textArea.setVisible(false);
            } else {
                textField.setText("");
                textArea.setText("");
                label.setText("Balance: M"+balancee+".00");
                label.setForeground(Color.BLACK);
                okay.setVisible(false);
                textField.setVisible(false);
                textArea.setVisible(false);
            }

        }
        if (e.getSource()==okay) {
             if (label.getText().equals("Deposit amount:")) {
                 deposite = Integer.parseInt(textField.getText());

                 int index=1;
                 if ((totalDeposits+deposite) <=50000 && deposite >=10) {
                     deposits.add(deposite);
                 }
                 int previous = totalDeposits;
                 totalDeposits=0;
                 for (int i : deposits) {
                     totalDeposits +=i;
//                     System.out.println("Deposit("+index+") M"+i);
//                     index++;
                 }
                 int su = previous + deposite;
                 try {
                     if(su >50000&&deposite>=10) {
                         int fo =50000-totalDeposits;
                         String se ="nothing to your balance";
                         String sean = (fo>0) ? "M"+fo+".00 or less" : se;

                         UIManager.put("OptionPane.messageForeground",Color.blue);
                         Font font = new Font("monospaced",Font.BOLD,16);
                         UIManager.put("OptionPane.messageFont",font);
                         JOptionPane.showMessageDialog(this,"<html>You have reached your limit. " +
                                 "Your Deposit limit is <span style='color:black'> M50,000.00</span> <br>" +
                                 "You can deposit <span style='color:black'> "
                                +sean
                                +"</span>"+
                                 "</html>","Denied",JOptionPane.PLAIN_MESSAGE,null);
                         setBalance();
                     }else if (Integer.parseInt(textField.getText()) <10) {
                         UIManager.put("OptionPane.messageForeground",Color.red);
                         Font font = new Font(null,Font.BOLD,16);
                         UIManager.put("OptionPane.messageFont",font);
                         JOptionPane.showMessageDialog(this,"<html>Your deposit must be at least<span style='color:black'> M10.00","Denied",JOptionPane.PLAIN_MESSAGE,null);
                         setBalance();
                     } else if (textField.getText().equals("")) {
                         textField.setText("0");
                         deposite=0;
                     }
                     else {
                         myDeposit(Integer.parseInt(textField.getText()));
                         UIManager.put("OptionPane.messageForeground",Color.green);
                         Font font = new Font(null,Font.BOLD,18);
                         UIManager.put("OptionPane.messageFont",font);
                         l.setText(String.valueOf(deposite));
                         JOptionPane.showMessageDialog(this,"<html> <span style='color:black'>M"+deposite+".00 </span>has been added to your acount</html>","Deposited",JOptionPane.PLAIN_MESSAGE,null );
                         setBalance();
                         okay.setVisible(false);

                     }
                 } catch (Exception err) {
                     System.out.println("error");
                 }


            } else if (label.getText().equals("Withdrawal amount:")) {
                okay.setVisible(false);
                int index = 0;
                 withdrawe = Integer.parseInt(textField.getText());

                 if ((sum + withdrawe) <=30000 && withdrawe>=20) {
                     if(balancee>withdrawe) {
                         withdraws.add(withdrawe);
                     }

                 }
                 int previous = sum;
                 sum =0;
                 for (int i : withdraws) {
                     sum +=i;
//                     System.out.println("withdrawal("+(index+1)+") M"+i);
//                     index++;
                 }
                 int sums =(previous + withdrawe);

                 if (Integer.parseInt(textField.getText())>balancee) {
                    UIManager.put("OptionPane.messageForeground",Color.red);
                    Font font = new Font(null,Font.BOLD,18);
                    UIManager.put("OptionPane.messageFont",font);
                    JOptionPane.showMessageDialog(this,"You can't withdraw more than you have","Denied",JOptionPane.PLAIN_MESSAGE,null);
                    setBalance();
                } else if (Integer.parseInt(textField.getText())<20) {
                    UIManager.put("OptionPane.messageForeground",Color.red);
                    Font font = new Font("monospaced",Font.BOLD,18);
                    UIManager.put("OptionPane.messageFont",font);
                    JOptionPane.showMessageDialog(this,"<html>Your withdrawal must be at least <span style='color:black'> M20.00</span></html>","Denied",JOptionPane.PLAIN_MESSAGE,null);
                    setBalance();
                } else if (sums>30000) {
                     UIManager.put("OptionPane.messageForeground",Color.red);
                     Font font = new Font("monospaced",Font.BOLD,18);
                     UIManager.put("OptionPane.messageFont",font);
                     int fo =30000-sum;
                     String se ="nothing to your balance";
                     String sean = (fo>0) ? "M"+fo+".00 or less" : se;
                     JOptionPane.showMessageDialog(this,"<html>You have reached your limit. " +
                             "Your withdrawal limit is <span style='color:black'> M30,000.00</span> <br>" +
                             "You can withdraw <span style='color:black'> "
                             +sean
                             +"</span>"+
                             "</html>","Denied",JOptionPane.PLAIN_MESSAGE,null);setBalance();
                 } else {

                    myWithdraw(Integer.parseInt(textField.getText()));
                    UIManager.put("OptionPane.messageForeground",Color.red);
                    Font font = new Font(null,Font.BOLD,18);
                    UIManager.put("OptionPane.messageFont",font);
                    JOptionPane.showMessageDialog(this,"<html> <span style='color:black'>M"+withdrawe+".00 </span>has been deducted from your account","Withdrawn",JOptionPane.PLAIN_MESSAGE,null );

                    setBalance();

                }

            }

        }
        if (e.getSource()==logout) {
            int s = JOptionPane.showConfirmDialog(this,"Are you sure you want to remove the card?","Confirm",JOptionPane.YES_NO_OPTION);
            if (s==JOptionPane.YES_OPTION) {
                left.setVisible(false);
                leftLow.setVisible(false);
                right.setVisible(false);
                rightLow.setVisible(false);
                delete.setVisible(false);
                reset.setVisible(false);
                textField.setVisible(false);
                withdraw.setVisible(false);
                deposit.setVisible(false);
                more.setVisible(false);
                textArea.setVisible(false);
                balance.setVisible(false);
                receipt.setVisible(false);
                print.setVisible(false);
                okay.setVisible(false);
                panel.setVisible(false);
                logout.setVisible(false);
                insert.setEnabled(true);
                insert.setVisible(true);
                label.setText("");
                passwordField.setText("");
                textArea.setText("");
            }


        }
        if (e.getSource()==leftLow) {
            textField.setVisible(false);
            if (balancee<100) {
                label.setBounds(50,85,200,30);
                label.setFont(new Font(null,Font.BOLD,18));
                label.setText("Balance: M"+balancee+".00");
                label.setForeground(Color.red);

            } else {
                label.setBounds(50,85,200,30);
                label.setFont(new Font(null,Font.BOLD,18));
                label.setText("Balance: M"+balancee+".00");
                label.setForeground(Color.BLACK);
            }

            textField.setEditable(false);
        }
        if (e.getSource()==exit) {
            this.dispose();
        }
        if (e.getSource()==print) {
                try {
                    textArea.print();
                }
                catch (PrinterException ex) {
                    Logger.getLogger(Atm.class.getName()).log(Level.SEVERE,null,ex);
                }

        }
        if (e.getSource()==delete) {
            String s = String.valueOf(passwordField.getPassword());
            String st = textField.getText();
            textField.setText("");
            passwordField.setText("");
            if (textField.isVisible()) {
                for (int i =0; i<st.length()-1;i++) {
                    textField.setText(textField.getText()+st.charAt(i));
                   // System.out.println(st.charAt(i));
                }
            } else if (passwordField.isVisible()) {
                for (int i =0; i<s.length()-1;i++) {
                    passwordField.setText(String.valueOf(passwordField.getPassword())+s.charAt(i));
                }
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        String s =String.valueOf(passwordField.getPassword());
        String t = textField.getText();
        if (s.length()==4) {
            passwordField.setBorder(BorderFactory.createLineBorder(Color.blue,2));
            //okay.setVisible(true);
            okay.setSize(100,30);
            okay.setText("Login");
            label.setForeground(Color.BLACK);
            String passa = String.valueOf(passwordField.getPassword());

            if (hashMap.containsKey(passa)) {
                balancee = hashMap.get(passa);
                UIManager.put("OptionPane.messageForeground",Color.green);
                Font font = new Font(null,Font.BOLD,18);
                UIManager.put("OptionPane.messageFont",font);
                passwordField.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this,"You logged in successfully!!!","SUCCESS",JOptionPane.PLAIN_MESSAGE,null);
                left.setVisible(true);
                leftLow.setVisible(true);
                right.setVisible(true);
                rightLow.setVisible(true);
                receipt.setVisible(true);
                withdraw.setVisible(true);
                deposit.setVisible(true);
                more.setVisible(true);
                passwordField.setVisible(false);
                balance.setVisible(true);
                okay.setVisible(false);
                passwordField.setText("");
                textField.setText("");
                if (balancee<100) {
                    label.setText("Balance: M"+balancee+".00");
                    label.setForeground(Color.red);
                } else {
                    label.setText("Balance: M"+balancee+".00");
                    label.setForeground(Color.BLACK);
                }

            } else {
                passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                UIManager.put("OptionPane.messageForeground",Color.red);
                Font font = new Font(null,Font.BOLD,18);
                UIManager.put("OptionPane.messageFont",font);
                UIManager.put("OptionPane.buttonFocusable",false);
                JOptionPane.showMessageDialog(null,"You entered invalid pin!!!","Denied",0,null);
                textField.setText("");
                passwordField.setText("");
                counter++;
                if (counter>4) {
                    JOptionPane.showMessageDialog(this,"Your card is captured");
                    delete.setVisible(false);
                    reset.setVisible(false);
                    passwordField.setVisible(false);
                    //okay.setVisible(true);
                    logout.setVisible(false);
                    panel.setVisible(false);
                    //insert.setEnabled(false);

                    insert.setVisible(true);
                } else if (counter<=4) {
                    JOptionPane.showMessageDialog(this,"<html><span style='color:black'>"+String.valueOf(4-counter)+"</span> times left before your card is captured.<br> Make you enter valid password","WARNING",JOptionPane.WARNING_MESSAGE);
                }

            }
        } else if (s.length()!=4){
            passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
            label.setForeground(Color.red);
        } else if (t.length()>1){
            textField.setBorder(BorderFactory.createLineBorder(Color.yellow,2));
            okay.setVisible(true);
        }
    }

    public void setBalance() {
        if (balancee<100) {
            label.setText("Balance: M"+balancee+".00");
            label.setForeground(Color.red);
        } else {
            label.setText("Balance: M"+balancee+".00");
            label.setForeground(Color.BLACK);
        }
        textField.setText("");
        textField.setVisible(false);
    }
}
