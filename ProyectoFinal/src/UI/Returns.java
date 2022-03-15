package UI;

import static UI.Dashboard.content;
import java.awt.Color;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import dataaccess.*;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author a
 */
public class Returns extends javax.swing.JPanel {
    
    private static final String DB_URL = 
        "jdbc:mysql://localhost:3306/biblioteca";
    
    private static final String DB_USERNAME = "root";
    
    private static final String DB_PASSWORD = "root";
    Lendings Inter;
    /**
     * Creates new form Principal
     */
    public Returns() {
        initComponents();
        Inter = new Lendings();
        refrescarTabla();
    }
    
     public void refrescarTabla(){
        try (Connection connection = getConnection()) {
            
            int matricula;
                
            String sqlBuscarPorMatricula = 
                "SELECT libro_titulo, fecha_debe_devolver, libro_isbn, alumno_matricula FROM prestamos_v "
                + "WHERE (fecha_devuelto IS NULL)";
            PreparedStatement stmtBuscarPorMatricula = connection.prepareStatement(sqlBuscarPorMatricula);
            ResultSet rBuscarPorMatricula = stmtBuscarPorMatricula.executeQuery();
            if(!rBuscarPorMatricula.next()) {
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while(model.getRowCount() > 0) {
                
                model.removeRow(0);
            }
            String titulo = rBuscarPorMatricula.getString("libro_titulo");
            String fechaDebeDevolver = rBuscarPorMatricula.getString("fecha_debe_devolver");
            String isbn = rBuscarPorMatricula.getString("libro_isbn");
            matricula = rBuscarPorMatricula.getInt("alumno_matricula");
            model.addRow(new Object[] {titulo, fechaDebeDevolver, isbn, matricula});
            while (rBuscarPorMatricula.next()) {
            
                titulo = rBuscarPorMatricula.getString("libro_titulo");
                fechaDebeDevolver = rBuscarPorMatricula.getString("fecha_debe_devolver");
                isbn = rBuscarPorMatricula.getString("libro_isbn");
                matricula = rBuscarPorMatricula.getInt("alumno_matricula");
                model.addRow(new Object[] {titulo, fechaDebeDevolver, isbn, matricula});

            }

            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        button1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        Text1 = new javax.swing.JLabel();
        Text2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        book_id = new javax.swing.JTextField();
        folio = new javax.swing.JTextField();
        button = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 430));
        setPreferredSize(new java.awt.Dimension(750, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        button1.setBackground(new java.awt.Color(16, 152, 173));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button1MousePressed(evt);
            }
        });
        button1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buscar");
        button1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, -1));

        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 80, 30));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Devolución de Libro");
        add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Text1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text1.setText("ISBN");
        add(Text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        Text2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text2.setText("Matricula de Estudiante");
        add(Text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(34, 184, 207));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 260, 10));

        jSeparator2.setForeground(new java.awt.Color(34, 184, 207));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 10));

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 10, 350));

        book_id.setForeground(new java.awt.Color(102, 102, 102));
        book_id.setText("Ingrese el ISBN del Libro a devolver");
        book_id.setBorder(null);
        book_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                book_idMousePressed(evt);
            }
        });
        book_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_idActionPerformed(evt);
            }
        });
        add(book_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 260, 30));

        folio.setForeground(new java.awt.Color(102, 102, 102));
        folio.setText("Ingrese la matricula ");
        folio.setBorder(null);
        folio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                folioMousePressed(evt);
            }
        });
        folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folioActionPerformed(evt);
            }
        });
        add(folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 180, 30));

        button.setBackground(new java.awt.Color(16, 152, 173));
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonMousePressed(evt);
            }
        });
        button.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Devolver");
        button.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 260, 50));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Fecha de devolución", "ISBN", "matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 560, 300));
    }// </editor-fold>//GEN-END:initComponents

    private void book_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_idActionPerformed

    private void folioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_folioMousePressed
       if(folio.getText().equals("Ingrese la matricula "))
        folio.setText("");
       if(book_id.getText().equals("") || book_id.getText() == null || book_id.getText().equals(" "))
        book_id.setText("Ingrese el ISBN del Libro a devolver");
    }//GEN-LAST:event_folioMousePressed

    private void book_idMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_idMousePressed
        if(book_id.getText().equals("Ingrese el ISBN del Libro a devolver"))
            book_id.setText("");
        if(folio.getText().equals("") || folio.getText() == null || folio.getText().equals(" "))
            folio.setText("Ingrese la matricula ");
    }//GEN-LAST:event_book_idMousePressed

    private void buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseEntered
        setColor(button);
    }//GEN-LAST:event_buttonMouseEntered

    private void buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseExited
        resetColor(button);
    }//GEN-LAST:event_buttonMouseExited

    private void buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMousePressed
        DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRow() != -1){
            String isbn = (String) tblModel.getValueAt(jTable1.getSelectedRow(), 2);
            int matricula = (int) tblModel.getValueAt(jTable1.getSelectedRow(), 3);
            System.out.println(isbn);
            System.out.println(matricula);
            try(Connection connection = getConnection()){
                String book = isbn;
                String sqlLibroId = 
                    "SELECT id FROM libros_v WHERE isbn = ?";
                PreparedStatement stmtLibroId = connection.prepareStatement(sqlLibroId);
                stmtLibroId.setString(1, book);
                ResultSet rLibroId = stmtLibroId.executeQuery();
                rLibroId.next();
            
                String sqlPrestamo =
                    "SELECT * FROM prestamos_v WHERE libro_isbn = ? AND alumno_matricula = ? AND fecha_devuelto IS NULL";
                PreparedStatement stmtPrestamo = connection.prepareStatement(sqlPrestamo);
                stmtPrestamo.setString(1, book);
                stmtPrestamo.setInt(2, matricula);
                ResultSet rPrestamo = stmtPrestamo.executeQuery();
                if(!rPrestamo.next()) {
                    JOptionPane.showMessageDialog(this, "No se encontro ningun registro, introduzca datos validos");
                    return;
                }
            
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String fechaStr = formatoFecha.format(LocalDateTime.now());
                LocalDateTime fechaHoy = LocalDateTime.parse(fechaStr, formatoFecha);

                PrestamoDao prestamoDao = new PrestamoDbDao(connection);
            
                Prestamo prestamo = new Prestamo();
                prestamo = prestamoDao.getById(rPrestamo.getInt("id"));
                prestamo.setFechaDevuelto(fechaHoy);
                prestamoDao.update(prestamo);
            
                String sqlIdInv =
                    "SELECT id FROM libros_inventario WHERE (libro_id = ?) AND (disponible = 0) "
                    + "ORDER BY libro_id LIMIT 1";
                PreparedStatement stmtIdLibro = connection.prepareStatement(sqlIdInv);
                stmtIdLibro.setInt(1, rPrestamo.getInt("libro_inventario_id"));
                ResultSet rIdLibro = stmtIdLibro.executeQuery();
                rIdLibro.next();
            
                String sqlLibroPrestado =
                    "UPDATE libros_inventario SET disponible = 1 WHERE id = ?";
                PreparedStatement stmtLibroPrestado = connection.prepareStatement(sqlLibroPrestado);
                stmtLibroPrestado.setInt(1, rIdLibro.getInt("id"));
                stmtLibroPrestado.execute();            
                jTable1.repaint();
                this.refrescarTabla();
                System.out.println("devolver");
                JOptionPane.showMessageDialog(this, "Libro devuelto exitosamente a dia " + fechaHoy);
                Returns p1 = new Returns();
                p1.setSize(750, 430);
                p1.setLocation(0, 0);
                content.removeAll();
                content.add(p1, BorderLayout.CENTER);
                content.revalidate();
                content.repaint();
                
                System.out.println("devolver");
            }
            catch(Exception e){
            }
            }else{
                try (Connection connection = getConnection()) {
                    
                String book = book_id.getText();
                int matricula = 0;
            
                try {
                    matricula = Integer.parseInt(folio.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Matricula Invalida");
                    return;
                }
            

            
                String sqlLibroId = 
                    "SELECT id FROM libros_v WHERE isbn = ?";
                PreparedStatement stmtLibroId = connection.prepareStatement(sqlLibroId);
                stmtLibroId.setString(1, book);
                ResultSet rLibroId = stmtLibroId.executeQuery();
                rLibroId.next();
            
                String sqlPrestamo =
                    "SELECT * FROM prestamos_v WHERE libro_isbn = ? AND alumno_matricula = ? AND fecha_devuelto IS NULL";
                PreparedStatement stmtPrestamo = connection.prepareStatement(sqlPrestamo);
                stmtPrestamo.setString(1, book);
                stmtPrestamo.setInt(2, matricula);
                ResultSet rPrestamo = stmtPrestamo.executeQuery();
                if(!rPrestamo.next()) {
                    JOptionPane.showMessageDialog(this, "No se encontro ningun registro, introduzca datos validos");
                    return;
                }
            
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String fechaStr = formatoFecha.format(LocalDateTime.now());
                LocalDateTime fechaHoy = LocalDateTime.parse(fechaStr, formatoFecha);

                PrestamoDao prestamoDao = new PrestamoDbDao(connection);
            
                Prestamo prestamo = new Prestamo();
                prestamo = prestamoDao.getById(rPrestamo.getInt("id"));
                prestamo.setFechaDevuelto(fechaHoy);
                prestamoDao.update(prestamo);
            
                String sqlIdInv =
                    "SELECT id FROM libros_inventario WHERE (libro_id = ?) AND (disponible = 0) "
                    + "ORDER BY libro_id LIMIT 1";
                PreparedStatement stmtIdLibro = connection.prepareStatement(sqlIdInv);
                stmtIdLibro.setInt(1, rPrestamo.getInt("libro_inventario_id"));
                ResultSet rIdLibro = stmtIdLibro.executeQuery();
                rIdLibro.next();
            
                String sqlLibroPrestado =
                    "UPDATE libros_inventario SET disponible = 1 WHERE id = ?";
                PreparedStatement stmtLibroPrestado = connection.prepareStatement(sqlLibroPrestado);
                stmtLibroPrestado.setInt(1, rIdLibro.getInt("id"));
                stmtLibroPrestado.execute();
                this.refrescarTabla();
                System.out.println("devolver");
                JOptionPane.showMessageDialog(this, "Libro devuelto exitosamente a dia " + fechaHoy);
                Returns p1 = new Returns();
                p1.setSize(750, 430);
                p1.setLocation(0, 0);
                content.removeAll();
                content.add(p1, BorderLayout.CENTER);
                content.revalidate();
                content.repaint();
            
            }
            catch (SQLException ex) {
                System.out.println("Error SQL: " + ex.getMessage());
            }
            catch (Exception ex) {
                System.out.println("ERROR " + ex.getMessage());
            }
        }
        /*
        try (Connection connection = getConnection()) {
            
            String book = book_id.getText();
            int matricula = 0;
            
            try {
                matricula = Integer.parseInt(folio.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Matricula Invalida");
                return;
            }
            

            
            String sqlLibroId = 
                    "SELECT id FROM libros_v WHERE isbn = ?";
            PreparedStatement stmtLibroId = connection.prepareStatement(sqlLibroId);
            stmtLibroId.setString(1, book);
            ResultSet rLibroId = stmtLibroId.executeQuery();
            rLibroId.next();
            
            String sqlPrestamo =
                    "SELECT * FROM prestamos_v WHERE libro_isbn = ? AND alumno_matricula = ? AND fecha_devuelto IS NULL";
            PreparedStatement stmtPrestamo = connection.prepareStatement(sqlPrestamo);
            stmtPrestamo.setString(1, book);
            stmtPrestamo.setInt(2, matricula);
            ResultSet rPrestamo = stmtPrestamo.executeQuery();
            if(!rPrestamo.next()) {
                JOptionPane.showMessageDialog(this, "No se encontro ningun registro, introduzca datos validos");
                return;
            }
            
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String fechaStr = formatoFecha.format(LocalDateTime.now());
            LocalDateTime fechaHoy = LocalDateTime.parse(fechaStr, formatoFecha);

            PrestamoDao prestamoDao = new PrestamoDbDao(connection);
            
            Prestamo prestamo = new Prestamo();
            prestamo = prestamoDao.getById(rPrestamo.getInt("id"));
            prestamo.setFechaDevuelto(fechaHoy);
            prestamoDao.update(prestamo);
            
            String sqlIdInv =
                    "SELECT id FROM libros_inventario WHERE (libro_id = ?) AND (disponible = 0) "
                    + "ORDER BY libro_id LIMIT 1";
            PreparedStatement stmtIdLibro = connection.prepareStatement(sqlIdInv);
            stmtIdLibro.setInt(1, rPrestamo.getInt("libro_inventario_id"));
            ResultSet rIdLibro = stmtIdLibro.executeQuery();
            rIdLibro.next();
            
            String sqlLibroPrestado =
                    "UPDATE libros_inventario SET disponible = 1 WHERE id = ?";
            PreparedStatement stmtLibroPrestado = connection.prepareStatement(sqlLibroPrestado);
            stmtLibroPrestado.setInt(1, rIdLibro.getInt("id"));
            stmtLibroPrestado.execute();            
            
            JOptionPane.showMessageDialog(this, "Libro devuelto exitosamente a dia " + fechaHoy);
            Returns p1 = new Returns();
            p1.setSize(750, 430);
            p1.setLocation(0, 0);
            content.removeAll();
            content.add(p1, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        }
        catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("ERROR " + ex.getMessage());
        }*/
        
        
    }//GEN-LAST:event_buttonMousePressed

    private void button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseEntered
        setColor(button);
    }//GEN-LAST:event_button1MouseEntered

    private void button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseExited
        resetColor(button);
    }//GEN-LAST:event_button1MouseExited

    private void button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MousePressed

        try (Connection connection = getConnection()) {
            
            int matricula = 0;
        
            try {
                matricula = Integer.parseInt(folio.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Matricula Invalida");
                return;
            }
        
            String sqlBuscarPorMatricula = 
                "SELECT libro_titulo, fecha_debe_devolver, libro_isbn FROM prestamos_v "
                + "WHERE (alumno_matricula = ?) AND (fecha_devuelto IS NULL)";
            PreparedStatement stmtBuscarPorMatricula = connection.prepareStatement(sqlBuscarPorMatricula);     
            stmtBuscarPorMatricula.setInt(1, matricula);
            ResultSet rBuscarPorMatricula = stmtBuscarPorMatricula.executeQuery();
            if(!rBuscarPorMatricula.next()) {
                JOptionPane.showMessageDialog(this, "No se encontro ningun prestamo pendiente con la matricula introducida.");
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while(model.getRowCount() > 0) {
                model.removeRow(0);
            }
            String titulo = rBuscarPorMatricula.getString("libro_titulo");
            String fechaDebeDevolver = rBuscarPorMatricula.getString("fecha_debe_devolver");
            String isbn = rBuscarPorMatricula.getString("libro_isbn");
            matricula = rBuscarPorMatricula.getInt("alumno_matricula");
            model.addRow(new Object[] {titulo, fechaDebeDevolver, isbn});
            while (rBuscarPorMatricula.next()) {
            
                titulo = rBuscarPorMatricula.getString("libro_titulo");
                fechaDebeDevolver = rBuscarPorMatricula.getString("fecha_debe_devolver");
                isbn = rBuscarPorMatricula.getString("libro_isbn");
                matricula = rBuscarPorMatricula.getInt("alumno_matricula");
                model.addRow(new Object[] {titulo, fechaDebeDevolver, isbn});

            }

            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
        
        
    }//GEN-LAST:event_button1MousePressed
    
    private void folioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_folioActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed

    }//GEN-LAST:event_jTable1MousePressed

    void setColor(JPanel panel){
        panel.setBackground(new Color(21,170,191));
    }
    void resetColor(JPanel panel){
        panel.setBackground(new Color(16,152,173));
    }

    private static Connection getConnection() throws SQLException {
        //DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text2;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel body;
    private javax.swing.JTextField book_id;
    private javax.swing.JPanel button;
    private javax.swing.JPanel button1;
    private javax.swing.JTextField folio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}