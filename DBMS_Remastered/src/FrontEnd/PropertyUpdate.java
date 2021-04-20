package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class PropertyUpdate extends JFrame {

    private JPanel contentPane;
    private JTextField textField_hid;
    private JTextField textField_type;
    private JTextField textField_bhk;
    private JTextField textField_salerent;
    private JTextField textField_carpet;
    private JTextField textField_surface;
    private JTextField textField_status;
    private JTextField textField_furnishing;
    private JTextField textField_builder;
    private JTextField textField_price;
    private JTextField textField_possession;
    private JTextField textField_parking;
    private JTextField textField_housenum;
    private JTextField textField_city;
    private JTextField textField_street;
    private JTextField textField_district;
    private JTextField textField_locality;
    private JTextField textField_state;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PropertyUpdate frame = new PropertyUpdate();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    String getQuoted(String input) {
        return "'" + input + "'";
    }

    /**
     * Create the frame.
     */
    public PropertyUpdate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 153, 255));

        JLabel lblNewLabel_1 = new JLabel("Enter Details");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblAddProperty = new JLabel("Add Property");
        lblAddProperty.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddProperty.setFont(new Font("Tahoma", Font.BOLD, 24));

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin admin = new Admin();
                dispose();
                admin.setVisible(true);
            }
        });

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = "insert into Property values (" + Integer.parseInt(textField_hid.getText()) + ","
                        + getQuoted(textField_type.getText()) + "," + 0 + "," + getQuoted(textField_salerent.getText())
                        + ",";
                query += Integer.parseInt(textField_price.getText()) + ","
                        + Integer.parseInt(textField_carpet.getText()) + ","
                        + Integer.parseInt(textField_surface.getText()) + "," + getQuoted(textField_status.getText())
                        + ",";
                query += getQuoted(textField_furnishing.getText()) + "," + textField_possession.getText() + ","
                        + getQuoted(textField_builder.getText()) + "," + Integer.parseInt(textField_bhk.getText())
                        + ",";
                query += "null," + Integer.parseInt(textField_parking.getText()) + ","
                        + getQuoted(textField_housenum.getText()) + "," + getQuoted(textField_street.getText()) + ","
                        + getQuoted(textField_locality.getText()) + ",";
                query += getQuoted(textField_city.getText()) + "," + getQuoted(textField_district.getText()) + ","
                        + getQuoted(textField_state.getText()) + ")";
                JDBCUpdate update = new JDBCUpdate(query);
                update.run();
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                .createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE).addGap(18)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(84).addComponent(lblAddProperty,
                                GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(167)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addGap(73)
                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                .addContainerGap()));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addGap(7)
                        .addComponent(lblAddProperty, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE).addGap(30)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
                                .addComponent(btnBack))
                        .addGap(25))
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(153, 255, 255));
        scrollPane.setViewportView(panel_1);

        JLabel lblNewLabel = new JLabel("House ID");

        JLabel lblType = new JLabel("Type");

        JLabel lblSoldOrNot = new JLabel("BHK");

        JLabel lblSalerent = new JLabel("Sale/Rent");

        JLabel lblCarpetArea = new JLabel("Carpet Area");

        JLabel lblSurfaceArea = new JLabel("Surface Area");

        JLabel lblStatus = new JLabel("Status");

        textField_hid = new JTextField();
        textField_hid.setColumns(10);

        textField_type = new JTextField();
        textField_type.setColumns(10);

        textField_bhk = new JTextField();
        textField_bhk.setColumns(10);

        textField_salerent = new JTextField();
        textField_salerent.setColumns(10);

        textField_carpet = new JTextField();
        textField_carpet.setColumns(10);

        textField_surface = new JTextField();
        textField_surface.setColumns(10);

        textField_status = new JTextField();
        textField_status.setColumns(10);

        JLabel lblNewLabel_7_1 = new JLabel("Furnishing");

        JLabel lblNewLabel_7_2 = new JLabel("Builder");

        JLabel lblNewLabel_7_3 = new JLabel("Price");

        JLabel lblNewLabel_7_4 = new JLabel("Possession Date");

        JLabel lblNewLabel_7_5 = new JLabel("Parking Space");

        textField_furnishing = new JTextField();
        textField_furnishing.setColumns(10);

        textField_builder = new JTextField();
        textField_builder.setColumns(10);

        textField_price = new JTextField();
        textField_price.setColumns(10);

        textField_possession = new JTextField();
        textField_possession.setColumns(10);

        textField_parking = new JTextField();
        textField_parking.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("House No.");

        textField_housenum = new JTextField();
        textField_housenum.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("City");

        textField_city = new JTextField();
        textField_city.setColumns(10);

        JLabel lblNewLabel_2_2 = new JLabel("Street");

        JLabel lblNewLabel_2_3 = new JLabel("District");

        textField_street = new JTextField();
        textField_street.setColumns(10);

        textField_district = new JTextField();
        textField_district.setColumns(10);

        JLabel lblNewLabel_2_3_1 = new JLabel("Locality");

        JLabel lblNewLabel_2_3_2 = new JLabel("State");

        textField_locality = new JTextField();
        textField_locality.setColumns(10);

        textField_state = new JTextField();
        textField_state.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
                .createSequentialGroup().addGap(35)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panel_1
                        .createSequentialGroup()
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_hid,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblType, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_type,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblSoldOrNot, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_bhk,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblSalerent, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_salerent,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblCarpetArea, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_carpet,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblSurfaceArea, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_surface,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)))
                        .addGap(42)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblNewLabel_7_5, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_parking,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblNewLabel_7_4, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_possession,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_price,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblNewLabel_7_2, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(textField_builder, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_furnishing,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                        .addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 111,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_status,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 58,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addComponent(textField_city, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_2)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(textField_housenum, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 58,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(textField_district, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(lblNewLabel_2_3_2, GroupLayout.PREFERRED_SIZE, 58,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 58,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(textField_street, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .addComponent(lblNewLabel_2_3_1, GroupLayout.PREFERRED_SIZE, 58,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(textField_locality, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_state, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
                .createSequentialGroup().addGap(37)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_hid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
                        .createSequentialGroup()
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblType, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblSoldOrNot, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_bhk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblSalerent, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_salerent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblCarpetArea, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_carpet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblSurfaceArea, GroupLayout.PREFERRED_SIZE, 31,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_surface, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 31,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_furnishing, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_7_2, GroupLayout.PREFERRED_SIZE, 31,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_builder, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 31,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_price, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_7_4, GroupLayout.PREFERRED_SIZE, 31,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_possession, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_7_5, GroupLayout.PREFERRED_SIZE, 31,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_parking, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGap(66)
                .addGroup(
                        gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(textField_housenum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNewLabel_2).addComponent(lblNewLabel_2_2)
                                .addComponent(textField_street, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNewLabel_2_3_1).addComponent(textField_locality,
                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(
                        ComponentPlacement.RELATED)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_2_1)
                        .addComponent(textField_district, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_2_3).addComponent(lblNewLabel_2_3_2).addComponent(textField_state,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap()));
        panel_1.setLayout(gl_panel_1);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(88)
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)));
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(104)
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)));
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
}
