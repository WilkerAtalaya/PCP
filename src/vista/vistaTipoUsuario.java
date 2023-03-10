/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Calendar;
import javax.swing.ImageIcon;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;

/**
 *
 * @author OSCAR
 */
public class vistaTipoUsuario extends javax.swing.JFrame implements Runnable {

    String hora, min, seg, ampm;
    Calendar calendario;
    Thread h1;

    /**
     * Creates new form jfrLogin
     */
    public vistaTipoUsuario() {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        //setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panBotones = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panTitulo.setBackground(new java.awt.Color(255, 255, 255));
        panTitulo.setPreferredSize(new java.awt.Dimension(700, 100));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitulo.setText("Bienvenido");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Eliga su tipo de usuario");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTituloLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTituloLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(jLabel1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(panTitulo, java.awt.BorderLayout.NORTH);

        panBotones.setBackground(new java.awt.Color(255, 255, 255));
        panBotones.setPreferredSize(new java.awt.Dimension(700, 600));

        btnCliente.setText("Ingresar como cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnAdministrador.setText("Ingresar como administrador");
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBotonesLayout = new javax.swing.GroupLayout(panBotones);
        panBotones.setLayout(panBotonesLayout);
        panBotonesLayout.setHorizontalGroup(
            panBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotonesLayout.createSequentialGroup()
                .addGroup(panBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBotonesLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addGroup(panBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnAdministrador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panBotonesLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        panBotonesLayout.setVerticalGroup(
            panBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotonesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        getContentPane().add(panBotones, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void run() {
        Thread ct = Thread.currentThread();

        //Para el cron??metro//
        int tempSeg = 0;
        int tempMin = 0;
        int tempHor = 0;
        //////////////////////

        while (ct == h1) {
            calcula();

            /*
            //Para utilizar el reloj//////////////////////////////////////
            lblReloj.setText(hora + ":" + min + ":" + seg + " " + ampm);
            //////////////////////////////////////////////////////////////
             */
            //Comentar todo el cronometro y descomentar el otro 
            //Para el cron??metro//////////////////////////////////////////////////////////////////////////////////////////////////////////
            tempSeg++;
            if (tempSeg >= 60) {
                tempSeg = 0;
                tempMin++;
                if (tempMin == 60) {
                    tempMin = 0;
                    tempHor++;
                }
            }

            if (tempSeg < 10 && tempMin < 10 && tempHor < 10) {
                lblReloj.setText("Uso del sistema: 0" + String.valueOf(tempHor) + ":0" + String.valueOf(tempMin) + ":0" + String.valueOf(tempSeg));
            }
            if (tempSeg < 10 && tempMin < 10 && tempHor > 9) {
                lblReloj.setText("Uso del sistema: " + String.valueOf(tempHor) + ":0" + String.valueOf(tempMin) + ":0" + String.valueOf(tempSeg));
            }
            if (tempSeg < 10 && tempMin > 9 && tempHor < 10) {
                lblReloj.setText("Uso del sistema: 0" + String.valueOf(tempHor) + ":" + String.valueOf(tempMin) + ":0" + String.valueOf(tempSeg));
            }
            if (tempSeg < 10 && tempMin > 9 && tempHor > 9) {
                lblReloj.setText("Uso del sistema: " + String.valueOf(tempHor) + ":" + String.valueOf(tempMin) + ":0" + String.valueOf(tempSeg));
            }
            if (tempSeg > 9 && tempMin < 10 && tempHor < 10) {
                lblReloj.setText("Uso del sistema: 0" + String.valueOf(tempHor) + ":0" + String.valueOf(tempMin) + ":" + String.valueOf(tempSeg));
            }
            if (tempSeg > 9 && tempMin > 9 && tempHor < 10) {
                lblReloj.setText("Uso del sistema: 0" + String.valueOf(tempHor) + ":" + String.valueOf(tempMin) + ":" + String.valueOf(tempSeg));
            }
            if (tempSeg > 9 && tempMin < 10 && tempHor > 9) {
                lblReloj.setText("Uso del sistema: " + String.valueOf(tempHor) + ":0" + String.valueOf(tempMin) + ":" + String.valueOf(tempSeg));
            }
            if (tempSeg > 9 && tempMin > 9 && tempHor > 9) {
                lblReloj.setText("Uso del sistema: " + String.valueOf(tempHor) + ":" + String.valueOf(tempMin) + ":" + String.valueOf(tempSeg));
            }

            //lblReloj.setText("Uso del sistema: "+String.valueOf(tempHor) + ":" + String.valueOf(tempMin) + ":" + String.valueOf(tempSeg));
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {

            }
        }
    }

    private void calcula() {
        Calendar cal = new GregorianCalendar();
        Date fechaHoraactual = new Date();
        cal.setTime(fechaHoraactual);
        ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = cal.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
            if (h == 00) {
                hora = "12";
            } else {
                hora = h > 9 ? "" + h : "0" + h;
            }
        } else {
            hora = cal.get(Calendar.HOUR_OF_DAY) > 9 ? "" + cal.get(Calendar.HOUR_OF_DAY) : "0" + cal.get(Calendar.HOUR_OF_DAY);
        }
        min = cal.get(Calendar.MINUTE) > 9 ? "" + cal.get(Calendar.MINUTE) : "0" + cal.get(Calendar.MINUTE);
        seg = cal.get(Calendar.SECOND) > 9 ? "" + cal.get(Calendar.SECOND) : "0" + cal.get(Calendar.SECOND);
    }


    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdministrador;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnCliente;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblReloj;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBotones;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables
}
