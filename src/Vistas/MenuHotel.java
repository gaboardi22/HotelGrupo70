
package Vistas;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;

/**
 *
 * @author NETBOOK G5
 */
public class MenuHotel extends javax.swing.JFrame {

    /**
     * Creates new form MenuHotel
     */
    public MenuHotel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAdministracion = new javax.swing.JMenu();
        jMenuHuesped = new javax.swing.JMenuItem();
        jMenuHabitacion = new javax.swing.JMenuItem();
        jMenuTipoHabitacion = new javax.swing.JMenuItem();
        jMenuReserva = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        jMenuAdministracion.setText("ADMINISTRACION");
        jMenuAdministracion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMenuAdministracionPropertyChange(evt);
            }
        });

        jMenuHuesped.setText("HUESPED");
        jMenuHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHuespedActionPerformed(evt);
            }
        });
        jMenuAdministracion.add(jMenuHuesped);

        jMenuHabitacion.setText("HABITACION");
        jMenuHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHabitacionActionPerformed(evt);
            }
        });
        jMenuAdministracion.add(jMenuHabitacion);

        jMenuTipoHabitacion.setText("TIPO DE HABITACION");
        jMenuTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTipoHabitacionActionPerformed(evt);
            }
        });
        jMenuAdministracion.add(jMenuTipoHabitacion);

        jMenuBar1.add(jMenuAdministracion);

        jMenuReserva.setText("RESERVA");
        jMenuReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReservaActionPerformed(evt);
            }
        });

        jMenuItem3.setText("GESTION DE RESERVA");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuReserva.add(jMenuItem3);

        jMenuBar1.add(jMenuReserva);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHuespedActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaHuesped VHuesped = new VistaHuesped();
        VHuesped.setVisible(true);
        VHuesped.setLocation((escritorio.getWidth() - VHuesped.getWidth()) / 2, (escritorio.getHeight() - VHuesped.getHeight()) / 2);
        escritorio.add(VHuesped);
        escritorio.moveToFront(VHuesped);
    }//GEN-LAST:event_jMenuHuespedActionPerformed

    private void jMenuAdministracionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMenuAdministracionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuAdministracionPropertyChange

    private void jMenuTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTipoHabitacionActionPerformed
      escritorio.removeAll();
      escritorio.repaint();
      VistaTipoHabitacion VTipoHab = new VistaTipoHabitacion();
      VTipoHab.setVisible(true);
      VTipoHab.setLocation((escritorio.getWidth() - VTipoHab.getWidth()) / 2, (escritorio.getHeight() - VTipoHab.getHeight()) / 2);
      escritorio.add(VTipoHab);
      escritorio.moveToFront(VTipoHab);
    }//GEN-LAST:event_jMenuTipoHabitacionActionPerformed

    private void jMenuHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHabitacionActionPerformed
       escritorio.removeAll();
       escritorio.repaint();
       VistaHabitacion VHabitac = new VistaHabitacion();
       VHabitac.setVisible(true);
       VHabitac.setLocation((escritorio.getWidth() - VHabitac.getWidth()) / 2, (escritorio.getHeight() - VHabitac.getHeight()) / 2);
       escritorio.add(VHabitac);
       escritorio.moveToFront(VHabitac);
    }//GEN-LAST:event_jMenuHabitacionActionPerformed

    private void jMenuReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReservaActionPerformed
       
    }//GEN-LAST:event_jMenuReservaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        escritorio.removeAll();
       escritorio.repaint();
       VistaReservas VReservas = new VistaReservas();
       VReservas.setVisible(true);
       VReservas.setLocation((escritorio.getWidth() - VReservas.getWidth()) / 2, (escritorio.getHeight() - VReservas.getHeight()) / 2);
       escritorio.add(VReservas);
       escritorio.moveToFront(VReservas  );
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatGitHubDarkIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenuAdministracion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuHabitacion;
    private javax.swing.JMenuItem jMenuHuesped;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jMenuReserva;
    private javax.swing.JMenuItem jMenuTipoHabitacion;
    // End of variables declaration//GEN-END:variables
}
