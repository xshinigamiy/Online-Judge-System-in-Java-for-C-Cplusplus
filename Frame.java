
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Frame extends javax.swing.JFrame {
    private String a = "";
    private String b = "";
    public static boolean flag = false;
    
    public Frame() {
        initComponents();
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setResizable(false);
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Label1 = new javax.swing.JLabel();
        jftf1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jftf2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        Button1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Label3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Online Judge");

        Label1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        Label1.setText("Welcome to Java Online Judge");

        jftf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftf1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jftf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftf2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        Button1.setText("Submit");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jftf2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jftf1)
                                .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jftf1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jftf2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jftf1ActionPerformed(java.awt.event.ActionEvent evt) {                                      

       a = jftf1.getText(); 
    }                                     

    private void jftf2ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        b = jftf2.getText();
    }                                     

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            a = jftf1.getText();
            b = jftf2.getText();
            flag = check(a, b);        
            if(flag){
                Label3.setText("Login Successful!");
                jftf1.setText(null);
                jftf2.setText(null);
                this.dispose(); //dispose the current window
                new Frame4().setVisible(flag); // make it visible
                
            }
            else{
                Label3.setText("Wrong Username or Passwrod, please try again ");
                a = "";
                b = "";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }                                       

    
    public boolean check(String a,String b) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		boolean choice = false;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?autoReconnect=true&useSSL=false", "root" , "root");
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select * from user");
			
			choice = false;
			while (myRs.next()) {
			        String tmp1 = myRs.getString("username");
                                String tmp2 = myRs.getString("password");
                                if(tmp1.equals(a) && tmp2.equals(b)){
                                    choice = true;
                                }
                        }
		}
		catch (Exception exc) {
			exc.printStackTrace();
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
            return choice;
	}
    
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        Frame frame1 = new Frame();
        
        java.awt.EventQueue.invokeLater(() -> {
            frame1.setVisible(!flag);
        } );    
        
    } 
    


    // Variables declaration - do not modify                     
    private javax.swing.JButton Button1;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField jftf1;
    private javax.swing.JPasswordField jftf2;
    // End of variables declaration                   

    
}
