package Vistas;

import AccesoDatos.ConsultaData;
import Entidades.DetalleReserva;
import Entidades.Estado;
import Entidades.Reserva;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class VistaAdminReserva extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloReserva = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private DefaultTableModel modeloDetalleReserva = new DefaultTableModel() {
        //No permitir edicion de columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaAdminReserva() {
        initComponents();
        cargarIcono();
        armarCabeceras();
        capturarClikEnTablaReserva();
        cargarReservas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcCalendario = new com.toedter.calendar.JCalendar();
        label1 = new java.awt.Label();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jmcMes = new com.toedter.calendar.JMonthChooser();
        jycAño = new com.toedter.calendar.JYearChooser();
        jcbMesAño = new javax.swing.JCheckBox();
        jlCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReservasActivas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDetalleReservas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbAnularReserva = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setTitle("Administración de Reservas");
        setMaximumSize(new java.awt.Dimension(865, 500));
        setMinimumSize(new java.awt.Dimension(865, 500));
        setPreferredSize(new java.awt.Dimension(865, 500));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Administración de Reservas");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setText("Apellido:");

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyReleased(evt);
            }
        });

        jLabel2.setText("DNI:");

        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDniKeyReleased(evt);
            }
        });

        jmcMes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jmcMesPropertyChange(evt);
            }
        });

        jycAño.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycAñoPropertyChange(evt);
            }
        });

        jcbMesAño.setText("Filtro Mes/Año");
        jcbMesAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesAñoActionPerformed(evt);
            }
        });

        jlCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfApellido)
                    .addComponent(jtfDni, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jmcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jycAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbMesAño))
                    .addComponent(jlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jmcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMesAño)
                    .addComponent(jycAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtReservasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Entrada", "Salida", "Estadía", "Personas", "Costo"
            }
        ));
        jtReservasActivas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtReservasActivasPropertyChange(evt);
            }
        });
        jtReservasActivas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtReservasActivasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtReservasActivas);

        jtDetalleReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Número", "Piso", "Codigo", "Capacidad", "Cantidad Camas", "Tipo Camas", "Precio Noche"
            }
        ));
        jScrollPane2.setViewportView(jtDetalleReservas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Reservas");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Detalles");

        jbAnularReserva.setText("Anular");
        jbAnularReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularReservaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jcCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(222, 222, 222))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jbAnularReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcCalendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAnularReserva)
                    .addComponent(jbSalir))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtfApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyReleased
        jlCliente.setText("");
        cargarReservas();
    }//GEN-LAST:event_jtfApellidoKeyReleased

    private void jtfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyReleased
        jlCliente.setText("");
        cargarReservas();
    }//GEN-LAST:event_jtfDniKeyReleased

    private void jmcMesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmcMesPropertyChange
        if (jcbMesAño.isSelected()) {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));
            cargarReservas();
        } else {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));
        }
    }//GEN-LAST:event_jmcMesPropertyChange

    private void jycAñoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycAñoPropertyChange
        if (jcbMesAño.isSelected()) {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));
            cargarReservas();
        } else {
            LocalDate nuevaFecha = LocalDate.of(jycAño.getYear(), jmcMes.getMonth() + 1, 1);
            jcCalendario.setDate(Date.valueOf(nuevaFecha));
        }
    }//GEN-LAST:event_jycAñoPropertyChange

    private void jtReservasActivasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtReservasActivasPropertyChange

    }//GEN-LAST:event_jtReservasActivasPropertyChange

    private void jtReservasActivasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtReservasActivasKeyReleased
        cargarDetallesReserva();
    }//GEN-LAST:event_jtReservasActivasKeyReleased

    private void jcbMesAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesAñoActionPerformed
        jlCliente.setText("");
        cargarReservas();
    }//GEN-LAST:event_jcbMesAñoActionPerformed

    private void jbAnularReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularReservaActionPerformed
        if (jtReservasActivas.getSelectedRow() != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere anular la Reserva?", "Confirmar Reserva", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                ConsultaData eliminarReserva = new ConsultaData();
                eliminarReserva.eliminarReserva((int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0));
                borrarFilasDetalleReservas();
                cargarReservas();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una reserva a anular.");
        }
    }//GEN-LAST:event_jbAnularReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAnularReserva;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JCalendar jcCalendario;
    private javax.swing.JCheckBox jcbMesAño;
    private javax.swing.JLabel jlCliente;
    private com.toedter.calendar.JMonthChooser jmcMes;
    private javax.swing.JTable jtDetalleReservas;
    private javax.swing.JTable jtReservasActivas;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDni;
    private com.toedter.calendar.JYearChooser jycAño;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceras() {
        // Establecer columnas de tablas
        modeloReserva.addColumn("ID");
        modeloReserva.addColumn("Entrada");
        modeloReserva.addColumn("Salida");
        modeloReserva.addColumn("Estadia");
        modeloReserva.addColumn("Personas");
        modeloReserva.addColumn("Costo");
        jtReservasActivas.setModel(modeloReserva);

        modeloDetalleReserva.addColumn("Número");
        modeloDetalleReserva.addColumn("Piso");
        modeloDetalleReserva.addColumn("Código");
        modeloDetalleReserva.addColumn("Capacidad");
        modeloDetalleReserva.addColumn("Camas");
        modeloDetalleReserva.addColumn("Tipo Camas");
        modeloDetalleReserva.addColumn("Precio Noche");
        jtDetalleReservas.setModel(modeloDetalleReserva);

        //Establecer ancho de columnas
        jtReservasActivas.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtReservasActivas.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtReservasActivas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtReservasActivas.getColumnModel().getColumn(3).setPreferredWidth(75);
        jtReservasActivas.getColumnModel().getColumn(4).setPreferredWidth(75);
        jtReservasActivas.getColumnModel().getColumn(5).setPreferredWidth(100);

        jtDetalleReservas.getColumnModel().getColumn(0).setPreferredWidth(75);
        jtDetalleReservas.getColumnModel().getColumn(1).setPreferredWidth(75);
        jtDetalleReservas.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtDetalleReservas.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtDetalleReservas.getColumnModel().getColumn(4).setPreferredWidth(75);
        jtDetalleReservas.getColumnModel().getColumn(5).setPreferredWidth(150);
        jtDetalleReservas.getColumnModel().getColumn(6).setPreferredWidth(125);

        // Crear un renderizador de celdas para centrar el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i <= 5; i++) {
            jtReservasActivas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i <= 6; i++) {
            jtDetalleReservas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void cargarIcono() {
        ImageIcon icono = new ImageIcon("image/reserva.png");
        Image scaledImage = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setFrameIcon(scaledIcon);
    }

    private void capturarClikEnTablaReserva() {
        //Capturar clik en tabla Huesped
        jtReservasActivas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDetallesReserva();
            }
        });
    }

    private void borrarFilasReserva() {
        int f = jtReservasActivas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloReserva.removeRow(f);
        }
    }

    private void borrarFilasDetalleReservas() {
        int f = jtDetalleReservas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modeloDetalleReserva.removeRow(f);
        }
    }

    public void cargarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        ConsultaData listarReservas = new ConsultaData();
        reservas = listarReservas.listarReservas();
        borrarFilasReserva();
        for (Reserva reserva : reservas) {
            if (!jcbMesAño.isSelected()) {
                if (reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().startsWith(jtfDni.getText())) {
                    modeloReserva.addRow(new Object[]{
                        reserva.getIdReserva(),
                        reserva.getFechaEntrada(),
                        reserva.getFechaSalida(),
                        reserva.getCantidadDias(),
                        reserva.getCantidadPersonas(),
                        reserva.getMontoEstadia()
                    });
                }
            } else {
                if (reserva.getFechaEntrada().getMonthValue() == (jmcMes.getMonth() + 1) && reserva.getFechaEntrada().getYear() == reserva.getFechaEntrada().getYear() && reserva.getEstado() == Estado.Activa && reserva.getHuesped().getApellido().toLowerCase().startsWith(jtfApellido.getText().toLowerCase()) && reserva.getHuesped().getDni().startsWith(jtfDni.getText())) {
                    modeloReserva.addRow(new Object[]{
                        reserva.getIdReserva(),
                        reserva.getFechaEntrada(),
                        reserva.getFechaSalida(),
                        reserva.getCantidadDias(),
                        reserva.getCantidadPersonas(),
                        reserva.getMontoEstadia()
                    });
                }
            }
        }
    }

    public void cargarDetallesReserva() {
        List<DetalleReserva> detallesReserva = new ArrayList<>();
        Reserva reserva = new Reserva();
        ConsultaData listarDetallesReserva = new ConsultaData();
        detallesReserva = listarDetallesReserva.listarDetalleReserva();
        reserva = listarDetallesReserva.reservaPorIdReserva((int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0));
        jlCliente.setText(reserva.getHuesped().getApellido() + ", " + reserva.getHuesped().getNombre() + " - DNI: " + reserva.getHuesped().getDni());
        borrarFilasDetalleReservas();
        for (DetalleReserva detalleReserva : detallesReserva) {
            if (detalleReserva.getReserva().getIdReserva() == (int) modeloReserva.getValueAt(jtReservasActivas.getSelectedRow(), 0)) {
                modeloDetalleReserva.addRow(new Object[]{
                    detalleReserva.getHabitacion().getNumero(),
                    detalleReserva.getHabitacion().getPiso(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getCodigo(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getCapacidad(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getCantidadCamas(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getTipoCamas(),
                    detalleReserva.getHabitacion().getTipoHabitacion().getPrecioNoche()
                });
            }
        }

    }
}
