
/**
 *
 * @author ajaykumar
 */


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public final class Frame4 extends javax.swing.JFrame {
    public Frame4() throws SQLException {
        initComponents();
        setSize(600,400);
        setResizable(false);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                int x = e.getX();
                int y = e.getY();
                
            }
        });
        setTitle("select a problem to solve");
        addMouseListener(new MouseAdapterImpl());
        read(null,null);
    }
    
    
    public void read(String a,String b) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/problemset?autoReconnect=true&useSSL=false", "root" , "root");
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from problems");
			while (myRs.next()) {
				System.out.println(myRs.getString("problem_id") + ", " + myRs.getString("problem_code"));
                                String tmp1 = myRs.getString("problem_id");
                                String tmp2 = myRs.getString("problem_code");
                                String tmp3 = myRs.getString("problem_statement");
                                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                                model.addRow(new Object[]{tmp1, tmp2});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "problem id", "problem code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Select a problem to solve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int selectedindex = jTable1.getSelectedRow();
        selectedindex++;
        Frame3 frame3 = new Frame3();
        try {
            
            frame3.draw(selectedindex);
        
        } catch (SQLException ex) {
            Logger.getLogger(Frame4.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame3.setVisible(true);
        frame3.setSize(600,400);    
        this.dispose();
    }                                        

    public void setupFrame(){
        JTextArea jta1 = new JTextArea(null,600,300);
        getContentPane().add(jta1);
        
    
    }
    
    public void clearFrame(){
        getContentPane().removeAll();
        getContentPane().repaint();
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
            java.util.logging.Logger.getLogger(Frame4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Frame4().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Frame4.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   

    private static class MouseAdapterImpl extends MouseAdapter {

        public MouseAdapterImpl() {
        }

        @Override
        public void mouseClicked(MouseEvent e){
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            System.out.println("clicked : " + x + " , " + y);
        }
    }
}
