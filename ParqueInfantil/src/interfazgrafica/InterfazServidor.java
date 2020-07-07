/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JTextField;
import parqueinfantil.Parque;
import parqueinfantil.Paso;

/**
 *
 * @author Darks
 */
public class InterfazServidor extends javax.swing.JFrame {

    /**
     * Creates new form IntewrfazAplicacion
     */
    private boolean sistemaDetenido = false;
    private boolean progFuncionando = true;
    private Paso paso;
    private ServerSocket servidor;
    private final ExecutorService pool = Executors.newFixedThreadPool(1);//Habra maximo una conexion
    
    private int tamañoColaTobogan;
    private int tamañoColaColumpios;
    private int tamañoColaTiovivo;

    public InterfazServidor(Paso paso) {
        initComponents();
        this.paso = paso;
        setLocationRelativeTo(null);
        
        //Inicio Capacidad de Establecer Comunicacion por Sockets
        Thread conexion = new Thread(){      
            @Override
            public void run(){
                iniciarConexion();
            }   
        };
        conexion.start();
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
        colaEsperaToboganTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        toboganTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        añosNiñoToboganTextField = new javax.swing.JTextField();
        niñosDecidiendoTextField = new javax.swing.JTextField();
        botonDetener = new javax.swing.JButton();
        botonReanudar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        colaEsperaColumpiosTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        columpiosTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        colaEsperaTiovivoTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tiovivoTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cola de espera del tobogan: ");

        jLabel2.setText("En tobogan: ");

        jLabel3.setText("de");

        botonDetener.setText("Detener");
        botonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetenerActionPerformed(evt);
            }
        });

        botonReanudar.setText("Reanudar");
        botonReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReanudarActionPerformed(evt);
            }
        });

        jLabel4.setText("Cola de espera columpios:");

        jLabel5.setText("En columpios:");

        jLabel6.setText("Cola de espera tiovivo:");

        colaEsperaTiovivoTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel7.setText("En tiovivo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(columpiosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(niñosDecidiendoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(toboganTextField)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(añosNiñoToboganTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(colaEsperaToboganTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(colaEsperaTiovivoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(colaEsperaColumpiosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonDetener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonReanudar, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tiovivoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colaEsperaToboganTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(añosNiñoToboganTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(toboganTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colaEsperaColumpiosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(columpiosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colaEsperaTiovivoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tiovivoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(niñosDecidiendoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReanudarActionPerformed
        gestionarSimulacion(false);
    }//GEN-LAST:event_botonReanudarActionPerformed

    private void botonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetenerActionPerformed
        gestionarSimulacion(true);
    }//GEN-LAST:event_botonDetenerActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InterfazServidor().setVisible(true);
            }
        });
    }
    
    public void iniciarConexion(){
        //Inicializo al Servidor
            try{
                servidor = new ServerSocket(2222,100);//Creamos un ServerSocket en el puerto 5000. Todos los clientes solicitarán conexion en el puerto 5000.
                System.out.println("Servidor Arrancado....");
                
                while(true){
                    Socket conexion = servidor.accept();// Me bloqueo en espera de una conexión. Cuando llegue la aceptaré y me desbloquearé.

                    Thread r = new Thread(){
                        @Override
                        public void run(){
                            gestionarConexion(conexion);
                        }
                    };
                    pool.execute(r);
                }
                
            } catch (IOException e) {
                System.out.println("Error en el servidor. Probablemente se haya apagado.");
            }
    }
    
    public void gestionarConexion(Socket conexion){
        try {
            DataInputStream entrada = new DataInputStream(conexion.getInputStream());//Establecemos los canales de E/S
            DataOutputStream salida  = new DataOutputStream(conexion.getOutputStream());
            salida.writeUTF("Bienvenido");  // Le damos la bienvenida.
            
            while(true){
                String mensaje = entrada.readUTF();//Leemos el mensaje del cliente
                
                //Interpretamos el comando
                if(mensaje.equals("Refrescar")){
                    salida.writeUTF(tamañoColaTobogan + "");
                    salida.writeUTF(tamañoColaColumpios + "");
                    salida.writeUTF(tamañoColaTiovivo + "");
                }
                
                if(mensaje.equals("Cerrar")){
                    progFuncionando = false;
                    System.out.println("Se ha enviado la señal de cerrar el sistema");
                }
            }
        } catch (IOException ex) {
        }
    }
    
    public void gestionarSimulacion(boolean detener) {
        if (detener) {
            if (!sistemaDetenido) {//Si no estaba detenido, es que estaba funcionando
                String mensaje = "Detener sistema";
                sistemaDetenido = true;
                paso.cerrar(0);//Cerramos el paso para que el sistema se detenga. Indice 0 = Sistema
            } else {
                String mensaje = "Ya estaba detenido";
            }
        } else {

            if (sistemaDetenido) {//Si ya estaba detenido, puedo reanudar el sistema
                String mensaje = "Reanudar sistema";
                sistemaDetenido = false;
                paso.abrir(0);//Abrimos el paso para que el sistema siga trabajando; Indice 0 = Sistema
            } else {
                String mensaje = "Ya estaba reanudado";
            }
        }
    }

    public JTextField getColaEsperaToboganTextField() {
        return colaEsperaToboganTextField;
    }

    public JTextField getAñosNiñoToboganTextField() {
        return añosNiñoToboganTextField;
    }

    public JTextField getToboganTextField() {
        return toboganTextField;
    }

    public JTextField getNiñosDecidiendoTextField() {
        return niñosDecidiendoTextField;
    }

    public JTextField getColaEsperaColumpiosTextField() {
        return colaEsperaColumpiosTextField;
    }

    public JTextField getColumpiosTextField() {
        return columpiosTextField;
    }

    public JTextField getColaEsperaTiovivoTextField() {
        return colaEsperaTiovivoTextField;
    }

    public JTextField getTiovivoTextField() {
        return tiovivoTextField;
    }

    public int getTamañoColaTobogan() {
        return tamañoColaTobogan;
    }

    public void setTamañoColaTobogan(int tamañoColaTobogan) {
        this.tamañoColaTobogan = tamañoColaTobogan;
    }

    public int getTamañoColaColumpios() {
        return tamañoColaColumpios;
    }

    public void setTamañoColaColumpios(int tamañoColaColumpios) {
        this.tamañoColaColumpios = tamañoColaColumpios;
    }

    public int getTamañoColaTiovivo() {
        return tamañoColaTiovivo;
    }

    public void setTamañoColaTiovivo(int tamañoColaTiovivo) {
        this.tamañoColaTiovivo = tamañoColaTiovivo;
    }

    public boolean isProgFuncionando() {
        return progFuncionando;
    }

    public void setProgFuncionando(boolean progFuncionando) {
        this.progFuncionando = progFuncionando;
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField añosNiñoToboganTextField;
    private javax.swing.JButton botonDetener;
    private javax.swing.JButton botonReanudar;
    private javax.swing.JTextField colaEsperaColumpiosTextField;
    private javax.swing.JTextField colaEsperaTiovivoTextField;
    private javax.swing.JTextField colaEsperaToboganTextField;
    private javax.swing.JTextField columpiosTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField niñosDecidiendoTextField;
    private javax.swing.JTextField tiovivoTextField;
    private javax.swing.JTextField toboganTextField;
    // End of variables declaration//GEN-END:variables
}
