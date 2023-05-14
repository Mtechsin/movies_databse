/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package anime;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mtech
 */
public class mainview extends javax.swing.JFrame {

    heart h = new heart();

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        searchinp = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        movies = new javax.swing.JTable();
        welcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 960));
        setSize(new java.awt.Dimension(1500, 960));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Mongolian Baiti", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 120, 70));

        searchinp.setBackground(new java.awt.Color(0, 0, 0));
        searchinp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        searchinp.setForeground(new java.awt.Color(255, 255, 255));
        searchinp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 2, true));
        searchinp.setCaretColor(new java.awt.Color(255, 255, 255));
        searchinp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchinpKeyPressed(evt);
            }
        });
        getContentPane().add(searchinp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 40, 260, 40));

        movies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "title", "gener", "directorname", "disc", "writer", "Likes", "year", "Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        movies.setOpaque(false);
        movies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moviesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                moviesMouseReleased(evt);
            }
        });
        movies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                moviesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(movies);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 830, 570));

        welcome.setFont(new java.awt.Font("Mongolian Baiti", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setText("MOVIE ME");
        getContentPane().add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 530, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anime/Movies.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 960));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getmovies(movies);
        welcome.setText("Welcome to Move me " + h.name);
    }//GEN-LAST:event_formWindowOpened


    private void searchinpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchinpKeyPressed
        // TODO add your handling code here:
        searchmovie(movies, searchinp.getText());

    }//GEN-LAST:event_searchinpKeyPressed

    private void getmovies(JTable table) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String dbPassword = "";
        DefaultTableModel model = (DefaultTableModel) new DefaultTableModel(new Object[][]{},
                new String[]{
                    "id", "title", "gener", "directorname", "disc", "writer", "Likes", "year", "Duration"
                }
        );

        // SQL query to check if user and password are in the database
        String sql = "SELECT * FROM movies";

        try (java.sql.Connection conn = DriverManager.getConnection(url, user, dbPassword); java.sql.Statement statement = conn.createStatement();) {

            // Set query parameter
            // Execute the query
            java.sql.ResultSet resultSet = statement.executeQuery(sql);

            // Check if any rows are returned
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getInt("movieid"),
                    resultSet.getString("title"),
                    resultSet.getString("duration"),
                    resultSet.getString("directorname"),
                    resultSet.getString("disc"),
                    resultSet.getString("writer"),
                    resultSet.getString("disc"),
                    resultSet.getInt("likes"),
                    resultSet.getInt("release_year"),
                    resultSet.getInt("Duration")

                });
            }
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User and password not found in the database
    }

    private void searchmovie(JTable table, String movietitle) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String dbPassword = "";
        DefaultTableModel model = (DefaultTableModel) new DefaultTableModel(new Object[][]{},
                new String[]{
                    "id", "title", "gener", "directorname", "disc", "writer", "Likes", "year", "Duration"
                }
        );

        // SQL query to check if user and password are in the database
        String sql = "SELECT * FROM movies WHERE title LIKE ?";

        try (java.sql.Connection conn = DriverManager.getConnection(url, user, dbPassword); java.sql.PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "%" + movietitle + "%");

            java.sql.ResultSet resultSet = statement.executeQuery();

            // Check if any rows are returned
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getInt("movieid"),
                    resultSet.getString("title"),
                    resultSet.getString("duration"),
                    resultSet.getString("directorname"),
                    resultSet.getString("disc"),
                    resultSet.getString("writer"),
                    resultSet.getString("disc"),
                    resultSet.getInt("likes"),
                    resultSet.getInt("release_year"),
                    resultSet.getInt("Duration")

                });
            }
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User and password not found in the database
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void moviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moviesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_moviesMouseClicked

    private void moviesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moviesMouseReleased

    }//GEN-LAST:event_moviesMouseReleased

    private void moviesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moviesKeyPressed

    }//GEN-LAST:event_moviesKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable movies;
    private javax.swing.JTextField searchinp;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
