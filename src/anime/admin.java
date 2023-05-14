/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package anime;

import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mtech
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
    }

    private void getusers(JTable table) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String dbPassword = "";
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // SQL query to check if user and password are in the database
        String sql = "SELECT * FROM users";

        try (java.sql.Connection conn = DriverManager.getConnection(url, user, dbPassword); java.sql.Statement statement = conn.createStatement();) {

            // Set query parameter
            // Execute the query
            java.sql.ResultSet resultSet = statement.executeQuery(sql);

            // Check if any rows are returned
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getInt("userid"),
                    resultSet.getString("name"),
                    resultSet.getString("username"),
                    resultSet.getBoolean("is_admin")
                });
            }
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User and password not found in the database
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        users_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        adduser = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        movies = new javax.swing.JTable();
        gener = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        disc = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        movie_image = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        writer = new javax.swing.JTextField();
        duration = new javax.swing.JTextField();
        year = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dcname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        users_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "userid", "name", "username", "is_admin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        users_table.setColumnSelectionAllowed(true);
        users_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                users_tableMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                users_tableMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                users_tableMousePressed(evt);
            }
        });
        users_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                users_tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(users_table);
        users_table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel1.setText("Edit user information");

        jLabel2.setText("userid");

        userid.setEditable(false);

        jLabel3.setText("name");

        jLabel4.setText("username");

        adduser.setText("Add");
        adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduserActionPerformed(evt);
            }
        });

        jLabel10.setText("password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addComponent(password))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(adduser, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(adduser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Users", jPanel1);

        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        if (movies.getColumnModel().getColumnCount() > 0) {
            movies.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 620, 550));

        gener.setBorder(null);
        jPanel2.add(gener, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 140, 50));

        title.setBorder(null);
        jPanel2.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 50));

        disc.setBorder(null);
        jPanel2.add(disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 160, 50));

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 120, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Image");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Title");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, 160, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Duration");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 140, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("writer");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, 30));
        jPanel2.add(movie_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 260, 360));

        jButton3.setBackground(new java.awt.Color(32, 32, 32));
        jButton3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Choose image");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 140, 50));

        writer.setBorder(null);
        jPanel2.add(writer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 140, 50));

        duration.setBorder(null);
        jPanel2.add(duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 140, 50));

        year.setBorder(null);
        jPanel2.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 160, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gener");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Disc");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 160, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("year");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 160, 30));

        dcname.setBorder(null);
        jPanel2.add(dcname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 160, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Dirctorname");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 160, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anime/72397.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 700));

        jTabbedPane1.addTab("Movies", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        getusers(users_table);
    }//GEN-LAST:event_formWindowOpened
    private void saveChangesuser(JTable table, String id) {
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String password = "";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            for (int row = 0; row < table.getRowCount(); row++) {
                String username = (String) table.getValueAt(row, 2);
                String name = (String) table.getValueAt(row, 1);
                boolean is_admin = (boolean) table.getValueAt(row, 3);

                try (java.sql.PreparedStatement statement = connection.prepareStatement(
                        "UPDATE users SET name =  ?, username =  ?, is_admin = ? WHERE  userid = "
                        + id + ";"
                )) {
                    statement.setString(1, name);
                    statement.setString(2, username);
                    statement.setBoolean(3, is_admin);

                    statement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void users_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_tableMouseClicked
        // TODO add your handling code here:
        int row = users_table.getSelectedRow();
        int col = users_table.getSelectedColumn();
        Object value = users_table.getValueAt(row, col);
        System.out.println(users_table.getColumnName(col));
        System.out.println("Selected value: " + value);

    }//GEN-LAST:event_users_tableMouseClicked
    public File imageurl;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:JFileChooser fileChooser = new JFileChooser();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("../"));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            imageurl = selectedFile;
            try {
                ImageIcon ic = new ImageIcon(selectedFile.getAbsolutePath());
                movie_image.setIcon(ic);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e + "There is and error ");
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        try {
            String url = "jdbc:mysql://localhost:3306/movies";
            String user = "root";
            String password = "";
            java.sql.Connection connection = DriverManager.getConnection(url, user, password);

            String title = this.title.getText();
            String gener = this.gener.getText();

            String dirctor = this.dcname.getText();
            String writer = this.writer.getText();
            String disc = this.disc.getText();
            int duration = Integer.valueOf(this.duration.getText());
            byte[] imageBytes = Files.readAllBytes(imageurl.toPath());
            int releaseYear = Integer.valueOf(year.getText());

            String sql = "INSERT INTO movies (title, genre, directorname, writer, disc, duration, image, release_year) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, gener);
            statement.setString(3, dirctor);
            statement.setString(4, writer);
            statement.setString(5, disc);
            statement.setInt(6, duration);
            statement.setBytes(7, imageBytes);
            statement.setInt(8, releaseYear);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();

            System.out.println("Movie inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        getmovies(movies);
    }//GEN-LAST:event_addActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        getmovies(movies);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void deletemovie(String id) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String dbPassword = "";

        // SQL query to check if user and password are in the database
        String sql = "delete FROM movies where movieid = " + id;

        try (java.sql.Connection conn = DriverManager.getConnection(url, user, dbPassword); java.sql.Statement statement = conn.createStatement();) {

            // Set query parameter
            // Execute the query
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Movie with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No movie found with ID " + id + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void deleteuser(String id) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String dbPassword = "";

        // SQL query to check if user and password are in the database
        String sql = "delete FROM users where userid = " + id;

        try (java.sql.Connection conn = DriverManager.getConnection(url, user, dbPassword); java.sql.Statement statement = conn.createStatement();) {

            // Set query parameter
            // Execute the query
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Movie with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No movie found with ID " + id + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void moviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moviesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_moviesMouseClicked
    private void saveChangesmovies(JTable table, String id) {
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String password = "";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            for (int row = 0; row < table.getRowCount(); row++) {
                String title = (String) table.getValueAt(row, 1);
                String gener = (String) table.getValueAt(row, 2);
                String dirctor = (String) table.getValueAt(row, 3);
                String writer = (String) table.getValueAt(row, 5);
                String disc = (String) table.getValueAt(row, 5);
                int duration = (int) table.getValueAt(row, 6);

                int releaseYear = (int) table.getValueAt(row, 7);
                try (java.sql.PreparedStatement statement = connection.prepareStatement(
                        "UPDATE movies SET title = ?, genre = ?, director = ?, writer = ?, description = ?, duration = ?, image = ?, release_year = ? WHERE movie_id ="
                        + id + ";"
                )) {
                    statement.setString(1, title);
                    statement.setString(2, gener);
                    statement.setString(3, dirctor);
                    statement.setString(4, writer);
                    statement.setString(5, disc);
                    statement.setInt(6, duration);
                    statement.setInt(7, releaseYear);
                    statement.executeUpdate();
                }
            }

            System.out.println("Changes saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void moviesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moviesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            int selectedRowIndex = movies.getSelectedRow();
            String id = movies.getValueAt(selectedRowIndex, 0).toString();
            deletemovie(id);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("From movies keypressed");
            int selectedRowIndex = movies.getSelectedRow();
            String id = movies.getValueAt(selectedRowIndex, 0).toString();
            saveChangesmovies(movies, id);
        }

    }//GEN-LAST:event_moviesKeyPressed

    private void moviesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moviesMouseReleased


    }//GEN-LAST:event_moviesMouseReleased

    private void users_tableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_tableMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_users_tableMouseExited

    private void users_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_tableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_users_tableMousePressed

    private void users_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_users_tableKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            int selectedRowIndex = users_table.getSelectedRow();
            String id = users_table.getValueAt(selectedRowIndex, 0).toString();
            deleteuser(id);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("From movies keypressed");
            int selectedRowIndex = users_table.getSelectedRow();
            String id = users_table.getValueAt(selectedRowIndex, 0).toString();
            saveChangesuser(users_table, id);
        }
    }//GEN-LAST:event_users_tableKeyPressed

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained
        // TODO add your handling code here:
        this.userid.setText(String.valueOf(users_table.getRowCount()));

    }//GEN-LAST:event_jPanel2FocusGained

    private void adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduserActionPerformed
        // TODO add your handling code here:
        try {
            String url = "jdbc:mysql://localhost:3306/movies";
            String user = "root";
            String password = "";
            java.sql.Connection connection = DriverManager.getConnection(url, user, password);

            String name = this.name.getText();
            String username = this.username.getText();
            String password2 = this.password.getText();

            String sql = "INSERT INTO users (name, username, password, is_admin) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, password2);
            statement.setBoolean(4, false);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();

            System.out.println("Movie inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        getusers(users_table);
        this.userid.setText(String.valueOf(users_table.getRowCount() + 1));
    }//GEN-LAST:event_adduserActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
        this.userid.setText(String.valueOf(users_table.getRowCount() + 1));
    }//GEN-LAST:event_jTabbedPane1FocusGained

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton adduser;
    private javax.swing.JTextField dcname;
    private javax.swing.JTextField disc;
    private javax.swing.JTextField duration;
    private javax.swing.JTextField gener;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel movie_image;
    private javax.swing.JTable movies;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JTextField title;
    private javax.swing.JTextField userid;
    private javax.swing.JTextField username;
    private javax.swing.JTable users_table;
    private javax.swing.JTextField writer;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}