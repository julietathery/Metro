package metro;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static metro.Metro.grafoBog;
import org.graphstream.graph.Graph;
 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author julietathery
 */
import static metro.Metro.grafoCcs;
public class Ventana1 extends javax.swing.JFrame {
    //JFileChooser seleccionar  = new JFileChooser;
    File archivo;
    FileInputStream entrada; 
    FileOutputStream salida;
    private String contenidoFile;
    
    
    

    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
        initComponents();
        
    }
    FunctionsGrafo funcionesGrafo = new FunctionsGrafo();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        showCaracas = new javax.swing.JButton();
        showBogota = new javax.swing.JButton();
        addMetro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showCaracas.setText("Metro Caracas ");
        showCaracas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCaracasActionPerformed(evt);
            }
        });
        jPanel1.add(showCaracas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 200, 40));

        showBogota.setText("Metro Bogota");
        showBogota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBogotaActionPerformed(evt);
            }
        });
        jPanel1.add(showBogota, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 170, 40));

        addMetro.setText("Agregar nuevo archivo");
        addMetro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMetroActionPerformed(evt);
            }
        });
        jPanel1.add(addMetro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 190, 40));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Escoja la ciudad donde desea colocar una sucursal");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showCaracasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCaracasActionPerformed
      
       Graph dibujoGrafo = funcionesGrafo.drawGraph(grafoCcs);
       funcionesGrafo.viewGraph(dibujoGrafo);
        
    }//GEN-LAST:event_showCaracasActionPerformed

    private void addMetroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMetroActionPerformed
//        FileChooser chooser = new JFileChooser();
//        try{
//        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
//            file=chooser.getSelectedFile();
//            filePath.setText(file.getAbsolutePath());
//            read = true;
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo!", "Importante", JOptionPane.INFORMATION_MESSAGE, windowMain.auxFunc.setJOptionPaneImage("/Users/beatrizcardozo/Desktop/PROYECTO/Proyecto-1/Proyecto-1/src/proyecto/pkg1/interfaces/images/alertIcon.png"));
//            read = false;
//        }}
//        catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Error adjuntando el archivo", "Importante", JOptionPane.INFORMATION_MESSAGE, windowMain.auxFunc.setJOptionPaneImage("/Users/beatrizcardozo/Desktop/PROYECTO/Proyecto-1/Proyecto-1/src/proyecto/pkg1/interfaces/images/alertIcon.png"));
//        }
    }//GEN-LAST:event_addMetroActionPerformed

    private void showBogotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBogotaActionPerformed
        Graph dibujoGrafo = funcionesGrafo.drawGraph(grafoBog);
        funcionesGrafo.viewGraph(dibujoGrafo);
    }//GEN-LAST:event_showBogotaActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMetro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton showBogota;
    private javax.swing.JButton showCaracas;
    // End of variables declaration//GEN-END:variables
}
