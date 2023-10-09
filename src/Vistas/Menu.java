
package Vistas;

import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import javax.swing.ImageIcon;

public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
        // Asignar icono de ventana
        ImageIcon icono = new ImageIcon("image/hotel.png");
        this.setIconImage(icono.getImage());
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmReservas = new javax.swing.JMenuItem();
        jmHuesped = new javax.swing.JMenuItem();
        jmHabitación = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jMenu1.setText("Consulta");

        jmReservas.setText("Reservas");
        jMenu1.add(jmReservas);

        jmHuesped.setText("Huesped");
        jmHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHuespedActionPerformed(evt);
            }
        });
        jMenu1.add(jmHuesped);

        jmHabitación.setText("Habitación");
        jmHabitación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHabitaciónActionPerformed(evt);
            }
        });
        jMenu1.add(jmHabitación);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        jmCerrar.setText("Cerrar");
        jmCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarActionPerformed(evt);
            }
        });
        jMenu2.add(jmCerrar);

        jMenuBar1.add(jMenu2);

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

    private void jmCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmCerrarActionPerformed

    private void jmHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHuespedActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaHuesped vh = new VistaHuesped();
        vh.setLocation((escritorio.getWidth() - vh.getWidth()) / 2, (escritorio.getHeight() - vh.getHeight()) / 2);
        vh.setVisible(true);
        escritorio.add(vh);
        escritorio.moveToFront(vh);
        vh.setMaximizable(true);
        vh.setClosable(true);
    }//GEN-LAST:event_jmHuespedActionPerformed

    private void jmHabitaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHabitaciónActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaHabitacion vhab = new VistaHabitacion();
        vhab.setLocation((escritorio.getWidth() - vhab.getWidth()) / 2, (escritorio.getHeight() - vhab.getHeight()) / 2);
        vhab.setVisible(true);
        escritorio.add(vhab);
        escritorio.moveToFront(vhab);
        vhab.setMaximizable(true);
        vhab.setClosable(true);
    }//GEN-LAST:event_jmHabitaciónActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatVuesionIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmCerrar;
    private javax.swing.JMenuItem jmHabitación;
    private javax.swing.JMenuItem jmHuesped;
    private javax.swing.JMenuItem jmReservas;
    // End of variables declaration//GEN-END:variables
}
