
package tw.brian.winbuilder;

import java.awt.EventQueue;

import tw.brian.winbuilder.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Canvas;
import java.awt.Choice;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelListener;
import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.awt.event.MouseWheelEvent;


public class Builder1 {

    private JFrame frame;
    public Canvas canvas = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Builder1 window = new Builder1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Builder1() {
        initialize();
    }

    public static String fetchOpendata() {
        try {
//			URL url = new URL("file:///C:/Users/user/eclipse-eeit36/eeit36_java/projJSON/Weatherforproject.json");
            URL url = new URL("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-83EC0C28-612B-408E-ADFC-693681B9C8D5&sort=time");

			URLConnection connection = url.openConnection();
            connection.connect();

            BufferedInputStream bin = new BufferedInputStream(connection.getInputStream());

            byte[] buf = new byte[1024 * 1024];
            int len;
            StringBuffer sb = new StringBuffer();

            while ((len = bin.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }

            bin.close();

            return sb.toString();

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }


    //  contents of the frame.

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("????????????");
        frame.setBounds(100, 100, 588, 496);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("???????????????");
        lblNewLabel.setForeground(UIManager.getColor("Button.background"));
        lblNewLabel.setFont(new Font("????????????", Font.BOLD, 15));
        lblNewLabel.setBounds(0, 10, 89, 28);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("???????????????");
        lblNewLabel_2.setForeground(UIManager.getColor("Button.background"));
        lblNewLabel_2.setFont(new Font("????????????", Font.BOLD, 15));
        lblNewLabel_2.setBounds(0, 58, 89, 28);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setForeground(UIManager.getColor("Button.background"));
        lblNewLabel_1.setFont(new Font("????????????", Font.BOLD, 15));
        lblNewLabel_1.setBounds(0, 90, 572, 15);
        lblNewLabel_1.setOpaque(true);
        frame.getContentPane().add(lblNewLabel_1);


        JComboBox DtcomboBox = new JComboBox();
        DtcomboBox.setFont(new Font("?????????", Font.PLAIN, 16));
        DtcomboBox.setEditable(true);
        DtcomboBox.setModel(new DefaultComboBoxModel(new String[]{"?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????"}));
        DtcomboBox.setBounds(99, 10, 98, 23);
        frame.getContentPane().add(DtcomboBox);

        JRadioButton rdbtnf = new JRadioButton("??F");
        rdbtnf.setBounds(150, 61, 47, 23);
        rdbtnf.setOpaque(false);
        frame.getContentPane().add(rdbtnf);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        panel.setBounds(0, 0, 572, 457);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JRadioButton rdbtnc = new JRadioButton("??C\r\n");
        rdbtnc.setBounds(100, 61, 49, 23);
        rdbtnc.setOpaque(false);
        panel.add(rdbtnc);

        JButton closeButton = new JButton("??????");
        closeButton.setFont(new Font("?????????", Font.PLAIN, 16));
        closeButton.setBounds(475, 412, 87, 35);
        panel.add(closeButton);


        JButton confirmButton_1 = new JButton("??????");
        confirmButton_1.setFont(new Font("?????????", Font.PLAIN, 16));
        confirmButton_1.setBounds(349, 412, 87, 35);
        panel.add(confirmButton_1);


        JLabel lblNewLabel_4 = new JLabel("????????????????????????");
        lblNewLabel_4.setBounds(0, 110, 288, 28);
        panel.add(lblNewLabel_4);
        lblNewLabel_4.setForeground(UIManager.getColor("Button.background"));
        lblNewLabel_4.setFont(new Font("????????????", Font.BOLD, 15));

        JLabel MaxtempNewLabel_2_1 = new JLabel("???????????????");
        MaxtempNewLabel_2_1.setForeground(SystemColor.menu);
        MaxtempNewLabel_2_1.setFont(new Font("????????????", Font.BOLD, 15));
        MaxtempNewLabel_2_1.setBounds(0, 158, 116, 28);
        panel.add(MaxtempNewLabel_2_1);


        JLabel MintempNewLabel_2_1_2 = new JLabel("???????????????");
        MintempNewLabel_2_1_2.setForeground(SystemColor.menu);
        MintempNewLabel_2_1_2.setFont(new Font("????????????", Font.BOLD, 15));
        MintempNewLabel_2_1_2.setBounds(0, 206, 116, 28);
        panel.add(MintempNewLabel_2_1_2);

        JLabel rainnyNewLabel_3 = new JLabel("???????????????\r\n");
        rainnyNewLabel_3.setBounds(0, 354, 221, 28);
        panel.add(rainnyNewLabel_3);
        rainnyNewLabel_3.setForeground(UIManager.getColor("Button.background"));
        rainnyNewLabel_3.setFont(new Font("????????????", Font.BOLD, 15));

        JLabel lblNewLabel_6 = new JLabel("Time???");
        lblNewLabel_6.setFont(new Font("?????????", Font.BOLD, 18));
        lblNewLabel_6.setBounds(325, 0, 70, 25);
        panel.add(lblNewLabel_6);

//		DateFormat dateFormat = new SimpleDateFormat("yyyy???MM???dd??? HH:mm:ss");
//		Calendar now = Calendar.getInstance();
//		String nowtime = dateFormat.format(now.getTime());
        JLabel lblNewLabel_5 = new JLabel();
        lblNewLabel_5.setFont(new Font("?????????", Font.BOLD, 16));
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat Formater = new SimpleDateFormat("yyyy???MM???dd??? HH:mm:ss");
                Calendar now = Calendar.getInstance();
                lblNewLabel_5.setText(Formater.format(now.getTime()));
            }
        }).start();
        lblNewLabel_5.setBounds(325, 35, 247, 45);
        panel.add(lblNewLabel_5);


        JLabel comfortableLabel_2_1_2_1 = new JLabel("????????????");
        comfortableLabel_2_1_2_1.setForeground(SystemColor.menu);
        comfortableLabel_2_1_2_1.setFont(new Font("????????????", Font.BOLD, 15));
        comfortableLabel_2_1_2_1.setBounds(0, 255, 221, 28);
        panel.add(comfortableLabel_2_1_2_1);

        JLabel IconLabel_7 = new JLabel("New label");
        IconLabel_7.setIcon(new ImageIcon(Builder1.class.getResource("/tw/brian/myproject/Taiwanview.jpg")));
        IconLabel_7.setBounds(349, 168, 184, 157);
        panel.add(IconLabel_7);

        JLabel ClickNewLabel_8 = new JLabel(">>>?????????????????????");
        ClickNewLabel_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jslider1 app = new Jslider1();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setContentPane(app.getGui());
                app.setImage(app.image);

                frame.getContentPane().add(app.getControl(), "Last");
                frame.setSize(1920, 1080);
                frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                ClickNewLabel_8.setForeground(Color.RED);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                ClickNewLabel_8.setForeground(Color.BLACK);

            }
        });
        ClickNewLabel_8.setFont(new Font("?????????", Font.PLAIN, 15));
        ClickNewLabel_8.setBounds(349, 335, 184, 15);
        panel.add(ClickNewLabel_8);

        JLabel showweatherNewLabel_3_1 = new JLabel("???????????????");
        showweatherNewLabel_3_1.setForeground(SystemColor.menu);
        showweatherNewLabel_3_1.setFont(new Font("????????????", Font.BOLD, 15));
        showweatherNewLabel_3_1.setBounds(0, 300, 221, 28);
        panel.add(showweatherNewLabel_3_1);


        confirmButton_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                String opdata = fetchOpendata();
                JSONArray root = new JSONArray(opdata);


                String data = "";


                int dtcombobox = DtcomboBox.getSelectedIndex();
                if (rdbtnc.isSelected() && rdbtnf.isSelected()) {

                    JOptionPane.showMessageDialog(null, "?????????????????????!!");

                } else if (DtcomboBox.getSelectedIndex() != -1 && rdbtnf.isSelected()) {
                    double c = 1.0f;
                    double f = c * (1.8) + 32;
                    int transformtemp = (int) f;

                    data = "????????????????????????"
                            + DtcomboBox.getItemAt
                            (DtcomboBox.getSelectedIndex());
                    lblNewLabel_4.setText(data);

                    int comboBox2 = DtcomboBox.getSelectedIndex();
                    JSONObject row3 = root.getJSONObject(comboBox2);

                    String maxtemp2 = row3.getString("MaxT1");
                    String mintemp2 = row3.getString("MinT1");
                    int Intmaxtemp2 = Integer.parseInt(maxtemp2);
                    int Intmintemp2 = Integer.parseInt(mintemp2);

                    String cfortable2 = row3.getString("C1");
                    String rainny2 = row3.getString("Pop1");
                    String shweather = row3.getString("Weather1");

                    MaxtempNewLabel_2_1.setText("???????????????" + (transformtemp + Intmintemp2) + "??F");
                    MintempNewLabel_2_1_2.setText("???????????????" + (transformtemp + Intmaxtemp2) + "??F");
                    comfortableLabel_2_1_2_1.setText("????????????" + cfortable2);
                    rainnyNewLabel_3.setText("???????????????" + rainny2);
                    showweatherNewLabel_3_1.setText("???????????????" + shweather);


                } else if (DtcomboBox.getSelectedIndex() != -1 && rdbtnc.isSelected()) {
                    int comboBox = DtcomboBox.getSelectedIndex();
                    String data1 = "????????????????????????";
                    String data2 = "";
                    String data3 = "??????????????? ";

                    data2 = data1
                            + DtcomboBox.getItemAt
                            (DtcomboBox.getSelectedIndex());

                    lblNewLabel_4.setText(data2);
                    JSONObject row3 = root.getJSONObject(comboBox);

                    String maxtemp = row3.getString("MaxT1");
                    String mintemp = row3.getString("MinT1");
                    String cfortable = row3.getString("C1");
                    String rainny = row3.getString("Pop1");
                    String shweather = row3.getString("Weather1");

                    MaxtempNewLabel_2_1.setText("???????????????" + maxtemp + "??C");
                    MintempNewLabel_2_1_2.setText("???????????????" + mintemp + "??C");
                    comfortableLabel_2_1_2_1.setText("????????????" + cfortable);
                    rainnyNewLabel_3.setText("???????????????" + rainny);
                    showweatherNewLabel_3_1.setText("???????????????" + shweather);

                } else {
                    JOptionPane.showMessageDialog(null, "??????????????????????????????!!");

                }


            }
        });

        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub


                frame.dispose();
            }
        });


    }


}	
