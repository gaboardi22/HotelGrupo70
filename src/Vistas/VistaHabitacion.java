/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoDatos.HabitacionData;
import AccesoDatos.TipoHabitacionData;
import Entidades.Habitacion;
import Entidades.TipoHabitacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NETBOOK G5
 */
public class VistaHabitacion extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public VistaHabitacion() {
        initComponents();
        armarCabecera();
        cargarHabitacion();
        cargarComboBoxTipoHabitacion();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTNumeroHabitacion = new javax.swing.JTextField();
        jLNumeroHabitacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTPiso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCTipoHabitacion = new javax.swing.JComboBox<>();
        jBAgregarHabitacion = new javax.swing.JButton();
        jBModiificarHabitacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHabitaciones = new javax.swing.JTable();
        jBSalirH = new javax.swing.JButton();

        jLabel1.setText("GESTION DE HABITACIONES");

        jLNumeroHabitacion.setText("NUMERO HABITACION");

        jLabel2.setText("PISO");

        jTPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPisoActionPerformed(evt);
            }
        });

        jLabel3.setText("TIPO HABITACION");

        jBAgregarHabitacion.setText("AGREGAR");
        jBAgregarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarHabitacionActionPerformed(evt);
            }
        });

        jBModiificarHabitacion.setText("MODIFICAR");

        jTHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTHabitaciones);

        jBSalirH.setText("SALIR");
        jBSalirH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLNumeroHabitacion))
                            .addComponent(jLTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
<<<<<<< Updated upstream
                            .addComponent(jCEstado, 0, 224, Short.MAX_VALUE)
                            .addComponent(jCTipoHabitacion, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTNumeroHabitacion)
                            .addComponent(jTPiso))
                        .addGap(147, 147, 147))
=======
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLNumeroHabitacion)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTPiso)
                                    .addComponent(jTNumeroHabitacion)
                                    .addComponent(jCTipoHabitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAgregarHabitacion)
                                .addGap(78, 78, 78)
                                .addComponent(jBModiificarHabitacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBSalirH)
                                .addGap(9, 9, 9))))
>>>>>>> Stashed changes
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAgregarHabitacion)
                        .addGap(225, 225, 225)
                        .addComponent(jBModiificarHabitacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalirH)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNumeroHabitacion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
<<<<<<< Updated upstream
                    .addComponent(jTPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTipoHabitacion)
                    .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarHabitacion)
                    .addComponent(jBModiificarHabitacion)
                    .addComponent(jBSalirH))
                .addGap(19, 19, 19))
=======
                    .addComponent(jLabel3)
                    .addComponent(jCTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 22, Short.MAX_VALUE)
                        .addComponent(jBAgregarHabitacion)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBModiificarHabitacion)
                            .addComponent(jBSalirH))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
>>>>>>> Stashed changes
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPisoActionPerformed

    private void jBSalirHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirHActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirHActionPerformed

    private void jBAgregarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarHabitacionActionPerformed
        Habitacion habitacion = new Habitacion();
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        TipoHabitacionData tipoHabitacionD = new TipoHabitacionData();
        List<String> listaAtributos = new ArrayList<>();
        listaAtributos = jCTipoHabitacion.getSelectedItem().toString().trim().split(",",0)();
        int id = jCTipoHabitacion.getS
        tipoHabitacionD.buscarTipoHabitacionXid();
        HabitacionData habitacionD = new HabitacionData();
        habitacion.setPiso(Integer.parseInt(jTPiso.getText()));
        habitacion.setNumeroHabitacion(Integer.parseInt(jTNumeroHabitacion.getText()));
        habitacion.setTipoHabitacion(jCTipoHabitacion.getSelectedItem());
        
    }//GEN-LAST:event_jBAgregarHabitacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarHabitacion;
    private javax.swing.JButton jBModiificarHabitacion;
    private javax.swing.JButton jBSalirH;
    private javax.swing.JComboBox<String> jCTipoHabitacion;
    private javax.swing.JLabel jLNumeroHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTHabitaciones;
    private javax.swing.JTextField jTNumeroHabitacion;
    private javax.swing.JTextField jTPiso;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("NUMERO");
        modelo.addColumn("PISO");
        modelo.addColumn("TIPO HABITACION");
        modelo.addColumn("ESTADO");
        jTHabitaciones.setModel(modelo);
        jTHabitaciones.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTHabitaciones.getColumnModel().getColumn(1).setPreferredWidth(40);
        jTHabitaciones.getColumnModel().getColumn(0).setPreferredWidth(60);
    }

    private void eliminarFilas() {
        int f = jTHabitaciones.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void cargarHabitacion() {
    List<Habitacion> habitaciones = new ArrayList<>();
        HabitacionData consultaHabitaciones = new HabitacionData();
        habitaciones = consultaHabitaciones.listarHabitacion();
        eliminarFilas();
        for(Habitacion habitacion:habitaciones   ){
            modelo.addRow(new Object[]{
         habitacion.getNumeroHabitacion(),
         habitacion.getPiso(),
         habitacion.getTipoHabitacion().getTipoCamas(),
         habitacion.isEstado()
                 });
        }
        
    
    }

    

    private void cargarComboBoxTipoHabitacion() {
        List<TipoHabitacion>listaTipoHabitacion = new ArrayList<>();
        TipoHabitacionData tipoHabitacionD = new TipoHabitacionData();
        listaTipoHabitacion = tipoHabitacionD.consultaTipoHabitacion();
        List<String> listaTipoHabitacionString = new ArrayList<>();
        for(TipoHabitacion tipohabitacion:listaTipoHabitacion){
            listaTipoHabitacionString.add(tipohabitacion.toString());
            
        }
        for(String tipoHabitacionString:listaTipoHabitacionString){
            jCTipoHabitacion.addItem(tipoHabitacionString);
        }
    }
}
