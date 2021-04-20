package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AdminAgentUpdate extends JFrame {

    private JPanel contentPane;
    private JTextField textField_agentid;
    private JTextField textField_phone;
    private JTextField textField_email;
    private JTextField textField_propertyid;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField textField_rating;
    private JTextField textField_name;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminAgentUpdate frame = new AdminAgentUpdate();
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
    public AdminAgentUpdate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 153, 255));

        JLabel lblNewLabel = new JLabel("Agent Info Master-Contol");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JRadioButton rdbtn_sold = new JRadioButton("Sold");
        rdbtn_sold.setOpaque(false);
        buttonGroup.add(rdbtn_sold);

        JRadioButton rdbtn_notsold = new JRadioButton("Up for Sale");
        rdbtn_notsold.setOpaque(false);
        buttonGroup.add(rdbtn_notsold);

        textField_agentid = new JTextField();
        textField_agentid.setColumns(10);

        textField_phone = new JTextField();
        textField_phone.setColumns(10);

        textField_email = new JTextField();
        textField_email.setColumns(10);

        textField_propertyid = new JTextField();
        textField_propertyid.setColumns(10);

        textField_rating = new JTextField();
        textField_rating.setColumns(10);

        JButton btnNewButton = new JButton("Update Property Status");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int agentid = Integer.parseInt(textField_agentid.getText());
                int propertyid = Integer.parseInt(textField_propertyid.getText());
                String query = "select * from Agent_property where Agent_id = " + agentid;
                query += " and property = " + propertyid;
                JDBCView view = new JDBCView(query);
                String output = view.run();

                if (!output.isEmpty() && output.split("\n").length > 1) {
                    int soldStatus;
                    if (rdbtn_sold.isSelected()) {
                        soldStatus = 1;
                    } else {
                        soldStatus = 0;
                    }
                    query = "update Property set sold = " + soldStatus + " where id = " + propertyid;
                    JDBCUpdate update = new JDBCUpdate(query);
                    update.run();
                }

                textField_agentid.setText(null);
                textField_propertyid.setText(null);
            }
        });

        JButton btnModify = new JButton("Update Rating");
        btnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int agentid = Integer.parseInt(textField_agentid.getText());
                int rating = Integer.parseInt(textField_rating.getText());
                if (rating >= 0 && rating <= 10) {
                    String query = "update Agent set rating = " + rating + " where id = " + agentid;
                    JDBCUpdate update = new JDBCUpdate(query);
                    update.run();
                }
                textField_agentid.setText(null);
                textField_rating.setText(null);
            }
        });

        JButton btnInsert = new JButton("Insert");
        btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "";
				JDBCUpdate update;
				if(!textField_agentid.getText().isEmpty()){
					int agentid = Integer.parseInt(textField_agentid.getText());
					if(!textField_rating.getText().isEmpty() && !textField_name.getText().isEmpty()){
						int rating = Integer.parseInt(textField_rating.getText());
						String name = getQuoted(textField_name.getText());
						query = "insert into Agent values (" + agentid + "," + name + "," + rating + ")";
						update = new JDBCUpdate(query);
						update.run();
					}
					if(!textField_propertyid.getText().isEmpty()){
						int propertyid = Integer.parseInt(textField_propertyid.getText());
						query = "select * from Agent_property where property = " + propertyid;
						JDBCView view = new JDBCView(query);
						String output = view.run();
						if(output.split("\n").length == 1){
							query = "insert into Agent_property values (" + agentid + "," + propertyid + ")";
							update = new JDBCUpdate(query);
							update.run();
							// default -> on sale
							int sold = 0;
							if(rdbtn_sold.isSelected()){
								sold = 1;
							}
							query = "update Property set sold = " + sold + " where id = " + propertyid;
							update = new JDBCUpdate(query);
							update.run();
						}
						else{
							System.out.println("Property already assigned to agent " + output.split("\n")[1].split("\t\t")[0]);
						}
					}
					if(!textField_phone.getText().isEmpty()){
						long phone = Long.parseLong(textField_phone.getText());
						query = "insert into Agent_phone values (" + agentid + "," + phone + ")";
						update = new JDBCUpdate(query);
						update.run();
					}
					if(!textField_email.getText().isEmpty()){
						String email = getQuoted(textField_email.getText());
						query = "insert into Agent_email values (" + agentid + "," + email + ")";
						update = new JDBCUpdate(query);
						update.run();
					}
					textField_agentid.setText(null);
					textField_propertyid.setText(null);
					textField_phone.setText(null);
					textField_email.setText(null);
					textField_rating.setText(null);
				}
			}
        });

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = "";
                JDBCUpdate update;
                if (!textField_agentid.getText().isEmpty()) {
                    int agentid = Integer.parseInt(textField_agentid.getText());
                    if (!textField_propertyid.getText().isEmpty()) {
                        int propertyid = Integer.parseInt(textField_propertyid.getText());
                        query = "delete from Agent_property where Agent_id = " + agentid + " and property = "
                                + propertyid;
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    if (!textField_phone.getText().isEmpty()) {
                        long phone = Long.parseLong(textField_phone.getText());
                        query = "delete from Agent_phone where Agent_id = " + agentid + " and phone = " + phone;
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    if (!textField_email.getText().isEmpty()) {
                        String email = getQuoted(textField_email.getText());
                        query = "delete from Agent_email where Agent_id = " + agentid + " and email = " + email;
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    if (!textField_rating.getText().isEmpty()) {
                        query = "delete from Agent where id = " + agentid;
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    textField_agentid.setText(null);
                    textField_propertyid.setText(null);
                    textField_phone.setText(null);
                    textField_email.setText(null);
                    textField_rating.setText(null);
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin admin = new Admin();
                dispose();
                admin.setVisible(true);
            }
        });

        textField_name = new JTextField();
        textField_name.setColumns(10);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane
                .setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                                .createSequentialGroup().addGap(49).addGroup(gl_contentPane
                                                        .createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                                                .createSequentialGroup().addPreferredGap(
                                                                        ComponentPlacement.RELATED)
                                                                .addComponent(rdbtn_sold).addGap(18)
                                                                .addComponent(rdbtn_notsold))
                                                        .addComponent(
                                                                textField_phone, GroupLayout.PREFERRED_SIZE, 154,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane
                                                                        .createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(textField_propertyid,
                                                                                GroupLayout.PREFERRED_SIZE, 154,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(textField_rating,
                                                                                GroupLayout.PREFERRED_SIZE, 154,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(textField_agentid,
                                                                                GroupLayout.PREFERRED_SIZE, 154,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(textField_name,
                                                                                GroupLayout.PREFERRED_SIZE, 154,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGap(246).addComponent(btnDelete)))
                                                                .addPreferredGap(ComponentPlacement.RELATED, 23,
                                                                        Short.MAX_VALUE)
                                                                .addGroup(gl_contentPane
                                                                        .createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(btnModify,
                                                                                GroupLayout.PREFERRED_SIZE, 176,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnNewButton,
                                                                                GroupLayout.PREFERRED_SIZE, 176,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnBack, Alignment.TRAILING)))
                                                        .addComponent(textField_email, GroupLayout.PREFERRED_SIZE, 154,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGap(61))
                                        .addGroup(gl_contentPane.createSequentialGroup().addGap(92)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 352,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()))
                                        .addGroup(gl_contentPane.createSequentialGroup().addGap(119)
                                                .addComponent(btnInsert).addGap(440)))));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
                .createSequentialGroup()
                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
                        .createSequentialGroup().addContainerGap()
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(31)
                        .addComponent(textField_agentid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(28)
                        .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(41)
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.TRAILING,
                                        false)
                                .addGroup(
                                        gl_contentPane.createSequentialGroup()
                                                .addComponent(textField_propertyid, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(rdbtn_sold).addComponent(rdbtn_notsold))
                                                .addGap(50)
                                                .addComponent(textField_phone, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(9))
                                .addGroup(
                                        gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addGap(119)))
                        .addGap(29)
                        .addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(41)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(textField_rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModify))
                        .addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnInsert)
                                .addComponent(btnBack).addComponent(btnDelete)))
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
                .addGap(0)));

        JLabel lblNewLabel_1 = new JLabel("Agent ID");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1 = new JLabel("Phone");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1_1 = new JLabel("Email");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1_2 = new JLabel("Property ID");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1textField_propertyid = new JLabel("Rating");
        lblNewLabel_1_1textField_propertyid.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1textField_propertyid.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_2 = new JLabel("Name");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
                .createSequentialGroup().addContainerGap(102, Short.MAX_VALUE)
                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1_1textField_propertyid, GroupLayout.PREFERRED_SIZE, 111,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                .addGap(35)));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
                .createSequentialGroup().addGap(90)
                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(3)
                .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(62)
                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(13)
                .addComponent(lblNewLabel_1_1textField_propertyid, GroupLayout.PREFERRED_SIZE, 49,
                        GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE)));
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
}
