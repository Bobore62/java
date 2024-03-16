import com.sun.prism.Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import static java.nio.file.Files.copy;

public class Note extends JFrame implements ActionListener {
    JTextArea textArea = new JTextArea();
    private JLabel label = new JLabel("Words: 0");
    private JLabel label2 = new JLabel("Characters: 0");
    private JLabel fontStyle = new JLabel("Font Style:");
    private JLabel sizeL = new JLabel("Size:");
    private JLabel s = new JLabel("");
    JMenu menu = new JMenu("Files  ");
    JMenu menu1 = new JMenu("Edit  ");
    JMenu menu2 = new JMenu("Format  ");
    JMenu menu3 = new JMenu("Background  ");
    JMenu menu4 = new JMenu("View  ");
    JMenu menu5 = new JMenu("Help   ");
    //JMenu color = new JMenu("Color   ");
    JMenuBar menuBar= new JMenuBar();
    JMenuItem newFile, save,copy,paste,cut,select,color,bColor,family,weigt;
    Integer[] fSize = new Integer[90];
    String bd = "Back";
    JColorChooser backgroundColor = new JColorChooser();
    JDialog dialog1;
    String fontFamily;

    void showB() {
        if (dialog1==null) {
            dialog1 =JColorChooser.createDialog(this, "Choose Color", false, backgroundColor, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setBackground(backgroundColor.getColor());
                }
            },null);
        }
        dialog1.setVisible(true);
    }
    JColorChooser foreGround=new JColorChooser();
    JDialog dialog;
    JDialog dialog12;
    int sizeF=12;
    JLabel sample;

    void showF() {
        if (dialog== null) {
            dialog = JColorChooser.createDialog(this, "Choose Text Color", false, foreGround, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setForeground(foreGround.getColor());
                }
            }, null);
        }
        dialog.setVisible(true);
    }
    String fileName;
    String fileAdd;
    void fil() {
        textArea.setText("");
        this.setTitle("New Document");
    }
    void open() {
        FileDialog file = new FileDialog(this,"Open file",FileDialog.LOAD);

        file.setVisible(true);

        if (file.getFile()!=null) {
            fileName = file.getFile();
            fileAdd = file.getDirectory();
            this.setTitle(fileName+ "-Notepad");
        }
        textArea.setText("");
       try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAdd+fileName));
            String line=null;
            while ((line= bufferedReader.readLine())!=null) {
                this.textArea.append(" "+line +"\n");
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void save1() throws IOException {
        if (fileName==null) {
            saveAs();
        } else {
            FileWriter writer = new FileWriter(fileAdd+fileName);
            writer.write(this.textArea.getText());
            this.setTitle(fileName+"-Notepad");
            writer.close();
        }
    }
    void saveAs() throws IOException {
        FileDialog fileDialog = new FileDialog(this,"Save",FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile()!="") {
            fileName = fileDialog.getFile();
            fileAdd = fileDialog.getDirectory();
            this.setTitle(fileName+ "-Notepad");
        }
        if (fileName==null) {
            this.setTitle("Untitled - Notepad");
        }
        FileWriter writer = new FileWriter(fileAdd+fileName);
        writer.write(this.textArea.getText());

        writer.close();
    }
    JComboBox comboBox1;
    JButton button;
    int fontS;
    JLabel textArea1;
    JButton button1;

    String[] fontWeigt = {"Select Font Weight","Plain","Bold","Italics","Bold + Italics"};
    JComboBox comboBox = new JComboBox<>(fontWeigt);
    Note(){
        button = new JButton("OK");
        button1 = new JButton("Cancel");



        String[] families= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        families[0] = "Select Font Family";
        comboBox1 = new JComboBox<>(families);
        //comboBox1.setSize(new Dimension(150,250));
        JScrollPane scrollPane= new JScrollPane(textArea);
        SpinnerModel model = new SpinnerNumberModel(12 ,8,72,1);
        JSpinner spinner = new JSpinner(model);
        spinner.setPreferredSize(new Dimension(50,25));
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sizeF=(Integer) spinner.getValue();
                textArea1.setFont(new Font(textArea1.getFont().getFamily(),textArea1.getFont().getStyle(),sizeF));
            }
        });
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(980,500));

        newFile = new JMenuItem("New Document");
        color = new JMenuItem("Font color");
        copy = new JMenuItem("Copy ctrl + C");
        save = new JMenuItem("Save");
        JMenu size = new JMenu("Font Size");
        paste = new JMenuItem("Paste  ctrl + V");
        cut = new JMenuItem("Cut  ctrl + X");
        select = new JMenuItem("Select All");
        bColor = new JMenuItem("Background Color");
        JMenuItem open = new JMenuItem("Open File");
        family = new JMenuItem("Font...");
        weigt = new JMenuItem("Font Weight");
        JMenuItem as = new JMenuItem("Save As");
        JMenuItem exit = new JMenuItem("Exit");
        JLabel font = new JLabel("Font:");
        font.setBounds(10,20,100,30);
        fontStyle.setBounds(170,20,130,30);
        sizeL.setBounds(320,20,50,30);
        comboBox1.setBounds(10,50,140,20);
        comboBox.setBounds(170,50,130,20);
        spinner.setBounds(320,50,50,20);
        button.setBounds(160,320,100,30);
        button.setFocusable(false);
        button1.setBounds(270,320,100,30);
        sample = new JLabel("Sample");
        textArea1 = new JLabel("\n"+"\t AaBbYyZz \t" +"\n");
        sample.setBounds(235,88,100,20);
        textArea1.setBounds(170,100,200,75);
        textArea1.setAutoscrolls(true);
        sample.setBackground(Color.GRAY);
        textArea1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                        Color.GRAY),"Sample",
                TitledBorder.CENTER,TitledBorder.TOP));
        textArea.setMargin(new Insets(510,100,10,10));
        textArea.setCaretPosition(0);


        button1.setFocusable(false);
        dialog12 = new JDialog(this,"Font",true);
        dialog12.setSize(400,400);
        dialog12.add(font);
        dialog12.setLocation(300,100);
        dialog12.add(fontStyle);
        dialog12.add(sizeL);
        dialog12.add(comboBox);
        dialog12.add(comboBox1);
        dialog12.add(spinner);
        dialog12.add(button);
        dialog12.add(button1);
        //dialog12.add(sample);
        dialog12.add(textArea1);
        dialog12.add(s);
        dialog12.setVisible(false);

        menu1.add(copy);
        menu1.add(cut);
        menu1.add(paste);
        menu1.add(select);

        menu.add(newFile);
        menu.add(open);
        menu.add(save);
        menu.add(as);
        menu.add(exit);

        menu3.add(bColor);

        //menu2.add(size);
        menu2.add(color);
        menu2.add(family);
        //menu2.add(weigt);

        menu.setFont(new Font(null,Font.BOLD,16));
        menu.setSize(120,30);

        menu1.setFont(new Font(null,Font.BOLD,16));
        menu1.setSize(120,30);

        menu2.setFont(new Font(null,Font.BOLD,16));
        menu2.setSize(120,30);


        copy.addActionListener(this);
        copy.setActionCommand("copy");

        comboBox1.setSelectedItem("Select Font Family");

        menu3.setFont(new Font(null,Font.BOLD,16));
        menu3.setSize(120,30);

        menu4.setFont(new Font(null,Font.BOLD,16));
        menu4.setSize(120,30);

        menu5.setFont(new Font(null,Font.BOLD,16));
        menu5.setSize(120,30);


        textArea.setFont(new Font("Arial",Font.PLAIN,12));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBorder(null);
        label.setBounds(150,505,120,30);
        label.setForeground(Color.black);
        label.setFont(new Font(null,Font.BOLD,15));

        label2.setBounds(10,505,120,30);
        label2.setForeground(Color.black);
        label2.setFont(new Font(null,Font.BOLD,15));

        //size.add(spinner);
        //menu.addSeparator();

        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
//        menuBar.add(comboBox1);
//        menuBar.add(comboBox);

        bColor.addActionListener(this);
        bColor.setActionCommand("bc");

        family.addActionListener(this);
        family.setActionCommand("f");

        weigt.addActionListener(this);
        weigt.setActionCommand("w");
        //comboBox.setVisible(false);

        newFile.addActionListener(this);
        newFile.setActionCommand("New");

        open.addActionListener(this);
        open.setActionCommand("open");

        color.addActionListener(this);
        color.setActionCommand("color");

        save.addActionListener(this);
        save.setActionCommand("save");

        as.addActionListener(this);
        as.setActionCommand("saveAs");

        comboBox1.addActionListener(this);
        comboBox.addActionListener(this);
        comboBox.setActionCommand(String.valueOf(comboBox));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font(fontFamily,textArea.getFont().getStyle(),textArea.getFont().getSize()));
                textArea.setFont(new Font(textArea.getFont().getFamily(),textArea.getFont().getStyle(),sizeF));
                textArea.setFont(new Font(textArea.getFont().getFamily(),fontS,textArea.getFont().getSize()));
                dialog12.dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),
                        textArea.getFont().getStyle(),
                        textArea.getFont().getSize()));
                dialog12.dispose();
            }
        });
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String s = textArea.getText().trim();
                int count = s.length();
                String[] t= s.split(" ");

                int c = t.length;
                if (s.equals("")) {
                    c = 0;
                }else if (s==null) {
                    c = 0;
                }

                label.setText("Words: "+ c);
                label2.setText("Characters: "+ count);

            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Untitled - Notepad");
        this.setSize(1050,605);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        //this.getContentPane().setBackground(Color.BLACK);
        this.add(scrollPane);
        this.add(label);
        this.add(label2);

        this.setJMenuBar(menuBar);
        //this.add(menuBar);
        this.setVisible(true);
        //bColor.addKeyEvent

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String string = e.getActionCommand();
        if (string.equals("bc")) {
            showB();
        } else if (string.equals("New")) {
            fil();
        }else if (string.equals("f")) {
            comboBox1.setVisible(true);
            comboBox.setVisible(true);
            button.setVisible(true);
            button1.setVisible(true);
            dialog12.setVisible(true);
        }else if (string.equals("open")) {
            open();
        }else if (e.getSource()==comboBox1) {
            fontFamily=(String) comboBox1.getSelectedItem();
            textArea1.setFont(new Font(fontFamily,textArea1.getFont().getStyle(),textArea1.getFont().getSize()));
        }
        else if (string.equals("color")) {
            showF();
        } else if (e.getSource()==comboBox) {
            if (comboBox.getSelectedItem().equals("Bold")) {
                fontS = Font.BOLD;
                textArea1.setFont(new Font(textArea1.getFont().getFamily(),fontS,textArea1.getFont().getSize()));
            }else if (comboBox.getSelectedItem().equals("Plain")) {
                fontS=Font.PLAIN;
                textArea1.setFont(new Font(textArea1.getFont().getFamily(),fontS,textArea1.getFont().getSize()));
            } else if (comboBox.getSelectedItem().equals("Italics")) {
                fontS = Font.ITALIC;
                textArea1.setFont(new Font(textArea1.getFont().getFamily(),fontS,textArea1.getFont().getSize()));
            } else if (comboBox.getSelectedItem().equals("Bold + Italics")) {
                fontS = Font.BOLD+Font.ITALIC;
                textArea1.setFont(new Font(textArea1.getFont().getFamily(),fontS,textArea1.getFont().getSize()));
            }
        }
        else if (string.equals("copy")) {
            textArea.copy();
        }else if (string.equals("saveAs")) {
            try {
                saveAs();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else if (string.equals("save")) {
            try {
                save1();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
