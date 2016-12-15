
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JScrollPane;

public class Frame3 extends javax.swing.JFrame {    
    JScrollPane jsp = new JScrollPane();
    
    public Frame3() {
        initComponents();
        setResizable(false);
        jTextArea1.append("Stack overflow");
        jTextArea1.setEditable(false);
        jTextArea1.setFont(jTextArea1.getFont().deriveFont(16f));
        setTitle("Read problem carefully and solve it");
        setSize(600,400);
    }
   
    public void draw(int selectedindex) throws SQLException{
        
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
	try { 
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/problemset?autoReconnect=true&useSSL=false", "root" , "root");
            myStmt = myConn.createStatement(); 
            String query = "select * from problems;";
            System.out.println("Query :: " + query );
            myRs = myStmt.executeQuery(query);
            String p;
            while (myRs.next()){             
                String tmp1 = myRs.getString("problem_statement");
                String tmp2 = myRs.getString("problem_id");
                if(tmp2.equals(""+selectedindex)){
                    String tmp="";
                    tmp += "Problem";
                    tmp += "\n-----------------------------------------------------------------------"
                            + "---------------------\n\n";
                    tmp += tmp1;        
                    jTextArea1.setText(tmp);
                    break;
                } 
            }	
        }
        catch (SQLException exc) {
        }
        finally {
            if (myRs != null) {
                myRs.close();	
            }
            if (myStmt != null) {
                myStmt.close();	
            }
            if (myConn != null) {
                myConn.close();           
            }	
        }
    }
    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollBar2 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Abyssinica SIL", 0, 18)); // NOI18N
        setForeground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(600, 600));

        jTextArea1.setColumns(14);
        jTextArea1.setLineWrap(false);
        jTextArea1.setRows(4);
        jTextArea1.setTabSize(7);
        JScrollPane talkPane = new JScrollPane(jTextArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(talkPane);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Submit Code");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Frame5 frame = new Frame5();
        frame.setVisible(true);
        this.dispose();
    }                                        


    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>


        java.awt.EventQueue.invokeLater(() -> {
            new Frame3().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
