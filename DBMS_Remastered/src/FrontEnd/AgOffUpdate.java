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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class AgOffUpdate extends JFrame {

    private JPanel contentPane;
    private JTextField agentID;
    private JTextField phone;
    private JTextField email;
    private JTextField rating;

    String getQuoted(String input) {
        return "'" + input + "'";
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgOffUpdate frame = new AgOffUpdate();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AgOffUpdate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 153, 255));

        JLabel lblNewLabel = new JLabel("Update Agent Info");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        agentID = new JTextField();
        agentID.setColumns(10);

        phone = new JTextField();
        phone.setColumns(10);

        email = new JTextField();
        email.setColumns(10);

        rating = new JTextField();
        rating.setColumns(10);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgentOffice AO = new AgentOffice();
                dispose();
                AO.setVisible(true);
            }
        });

        JButton updateRatingButton = new JButton("Update Rating");
        updateRatingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textCommand = "update Agent set rating=" + rating.getText() + " where id=" + agentID.getText();
                JDBCUpdate command = new JDBCUpdate(textCommand);
                command.run();
                System.out.println("Update complete");
            }
        });

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = "";
                JDBCUpdate update;
                if(!agentID.getText().isEmpty()){
                    int agentid = Integer.parseInt(agentID.getText());
                    System.out.println(agentid);
                    if(!rating.getText().isEmpty()){
                        int rating_val = Math.max(0, Integer.parseInt(rating.getText()));
                        System.out.println(rating_val);
                        query = "insert into Agent(id, rating) values (" + agentid + "," + rating_val + ")";
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    if(!(phone.getText().isEmpty())){
                        long phonenum = Long.parseLong(phone.getText());
                        System.out.println(phonenum);
                        query = "insert into Agent_phone values (" + agentid + "," + phonenum + ")";
                        System.out.println(query);
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    if(!email.getText().isEmpty()){
                        String mail = getQuoted(email.getText());
                        System.out.println(mail);
                        query = "insert into Agent_email values (" + agentid + "," + mail + ")";
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    email.setText(null);
                    phone.setText(null);
                    agentID.setText(null);
                    rating.setText(null);
                }
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!agentID.getText().isEmpty()){
                    int agentid = Integer.parseInt(agentID.getText());
                    JDBCUpdate update;
                    String query;
                    if(!(phone.getText().isEmpty())){
                        long phonenum = Long.parseLong(phone.getText());
                        query = "delete from Agent_phone where Agent_id = " + agentid + " and phone = " + phonenum;
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    if(!email.getText().isEmpty()){
                        String mail = getQuoted(email.getText());
                        query = "delete from Agent_email where Agent_id = " + agentid + " and email = " + mail;
                        update = new JDBCUpdate(query);
                        update.run();

                    }
                    if(!rating.getText().isEmpty()){
                        int rating_val = Math.max(0, Integer.parseInt(rating.getText()));
                        System.out.println(rating_val);
                        query = "delete from Agent_property where Agent_id = " + agentid;
                        update = new JDBCUpdate(query);
                        update.run();
                        query = "delete from Agent where id = " + agentid;
                        update = new JDBCUpdate(query);
                        update.run();
                    }
                    email.setText(null);
                    phone.setText(null);
                    agentID.setText(null);
                    rating.setText(null);
                }
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                .createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                .addGroup(Alignment.LEADING,
                                        gl_contentPane.createSequentialGroup().addGap(76)
                                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 294,
                                                        Short.MAX_VALUE)
                                                .addGap(270))
                                .addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
                                        .createParallelGroup(Alignment.TRAILING)
                                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(53)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(agentID, GroupLayout.PREFERRED_SIZE, 154,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 154,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(phone, GroupLayout.PREFERRED_SIZE, 154,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(rating, GroupLayout.PREFERRED_SIZE, 154,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 254,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(updateRatingButton))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(insertButton)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(deleteButton)))
                                        .addGap(50)))
                        .addGap(16))
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(backButton).addGap(196)))));
        gl_contentPane
                .setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGap(0))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(24)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(59)
                                .addComponent(agentID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(70)
                                .addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(31)
                                .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(97)
                                .addComponent(rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(backButton).addGap(32))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(261)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(insertButton).addComponent(deleteButton))
                                .addGap(130).addComponent(updateRatingButton).addContainerGap(102, Short.MAX_VALUE)));

        JLabel lblNewLabel_1 = new JLabel("Agent ID");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1 = new JLabel("Phone");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1_1 = new JLabel("Email");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Rating");
        lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
                .createSequentialGroup().addContainerGap(102, Short.MAX_VALUE)
                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                .addGap(35)));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
                .createSequentialGroup().addGap(135)
                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(34)
                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(67)
                .addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE)));
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
}
