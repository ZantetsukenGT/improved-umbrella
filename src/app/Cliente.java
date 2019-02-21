package app;

import gu.language.*;
import app.tree.*;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author ozmarescobar
 */
public class Cliente extends javax.swing.JFrame{

    /**
     * Creates new form Cliente
     */
    String textoOriginal;
    public Cliente() 
    {
        initComponents();
        setTitle("Practica 1 201602988 - Untitled.gu");
        textoOriginal = "";
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaCodigo = new javax.swing.JTextArea();
        bAnalizar = new javax.swing.JButton();
        labelFila = new javax.swing.JLabel();
        labelColumna = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bMenuArchivo = new javax.swing.JMenu();
        bMenuNuevo = new javax.swing.JMenuItem();
        bMenuAbrir = new javax.swing.JMenuItem();
        bMenuGuardar = new javax.swing.JMenuItem();
        bMenuCerrar = new javax.swing.JMenuItem();
        bMenuSalir = new javax.swing.JMenuItem();
        bMenuReporte = new javax.swing.JMenu();
        bMenuRErrores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[OLC1]Proyecto1");

        textAreaCodigo.setColumns(20);
        textAreaCodigo.setFont(new java.awt.Font("Ubuntu Mono", 0, 24)); // NOI18N
        textAreaCodigo.setRows(5);
        textAreaCodigo.setTabSize(4);
        jScrollPane1.setViewportView(textAreaCodigo);

        bAnalizar.setText("Analizar");
        bAnalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAnalizarMouseClicked(evt);
            }
        });

        labelFila.setText("Fila:");

        labelColumna.setText("Columna:");

        bMenuArchivo.setText("Archivo");

        bMenuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        bMenuNuevo.setText("Nuevo");
        bMenuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuNuevoActionPerformed(evt);
            }
        });
        bMenuArchivo.add(bMenuNuevo);

        bMenuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        bMenuAbrir.setText("Abrir");
        bMenuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuAbrirActionPerformed(evt);
            }
        });
        bMenuArchivo.add(bMenuAbrir);

        bMenuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        bMenuGuardar.setText("Guardar");
        bMenuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuGuardarActionPerformed(evt);
            }
        });
        bMenuArchivo.add(bMenuGuardar);

        bMenuCerrar.setText("Cerrar");
        bMenuArchivo.add(bMenuCerrar);

        bMenuSalir.setText("Salir");
        bMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuSalirActionPerformed(evt);
            }
        });
        bMenuArchivo.add(bMenuSalir);

        jMenuBar1.add(bMenuArchivo);

        bMenuReporte.setText("Reportes");

        bMenuRErrores.setText("Reporte de Errores");
        bMenuRErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuRErroresActionPerformed(evt);
            }
        });
        bMenuReporte.add(bMenuRErrores);

        jMenuBar1.add(bMenuReporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(labelFila)
                        .addGap(60, 60, 60)
                        .addComponent(labelColumna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFila)
                    .addComponent(labelColumna))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuSalirActionPerformed
        String text = textAreaCodigo.getText();
        
        if(!textoOriginal.equals(text))
        {
            int code = JOptionPane.showConfirmDialog(null, "Desea guardar los cambios?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
            if(code == JOptionPane.NO_OPTION)
            {
                System.exit(0);
            }
            else if(code == JOptionPane.YES_OPTION)
            {
                JFileChooser jfile = new JFileChooser("./Desktop");
                FileNameExtensionFilter filtroGu = new FileNameExtensionFilter("gu Language File","gu");
                jfile.setFileFilter(filtroGu);
                jfile.setDialogTitle("Guardar archivo.");

                int opcion = jfile.showSaveDialog(null);
                
                if(opcion == JFileChooser.APPROVE_OPTION)
                {
                    String path = jfile.getSelectedFile().getAbsolutePath().replace(".gu","")+".gu";

                    try 
                    {
                        Tool.crearArchivo(text, path);
                        System.exit(0);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else
        {
            System.exit(0);
        }
    }//GEN-LAST:event_bMenuSalirActionPerformed

    private void bMenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuNuevoActionPerformed
        String text = textAreaCodigo.getText();
        
        if(!textoOriginal.equals(text))
        {
            int code = JOptionPane.showConfirmDialog(null, "Desea guardar los cambios?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
            if(code == JOptionPane.NO_OPTION)
            {
                textAreaCodigo.setText("");
                textoOriginal = "";
                setTitle("Practica 1 201602988 - Untitled.gu");
            }
            else if(code == JOptionPane.YES_OPTION)
            {
                JFileChooser jfile = new JFileChooser("./Desktop");
                FileNameExtensionFilter filtroGu = new FileNameExtensionFilter("gu Language File","gu");
                jfile.setFileFilter(filtroGu);
                jfile.setDialogTitle("Guardar archivo.");

                int opcion = jfile.showSaveDialog(null);
                
                if(opcion == JFileChooser.APPROVE_OPTION)
                {
                    String path = jfile.getSelectedFile().getAbsolutePath().replace(".gu","")+".gu";

                    try 
                    {
                        Tool.crearArchivo(text, path);
                        textAreaCodigo.setText("");
                        textoOriginal = "";
                        setTitle("Practica 1 201602988 - Untitled.gu");
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else
        {
            textAreaCodigo.setText("");
            textoOriginal = "";
            setTitle("Practica 1 201602988 - Untitled.gu");
        }
    }//GEN-LAST:event_bMenuNuevoActionPerformed

    private void bMenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuAbrirActionPerformed
        String text = textAreaCodigo.getText();
        
        if(!textoOriginal.equals(text))
        {
            int code = JOptionPane.showConfirmDialog(null, "Desea guardar los cambios?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
           
            if(code == JOptionPane.CANCEL_OPTION)
            {
                return;
            }
            else if(code == JOptionPane.YES_OPTION)
            {
                JFileChooser jfile = new JFileChooser("./Desktop");
                FileNameExtensionFilter filtroGu = new FileNameExtensionFilter("gu Language File","gu");
                jfile.setFileFilter(filtroGu);
                jfile.setDialogTitle("Guardar archivo.");

                int opcion = jfile.showSaveDialog(null);
                
                if(opcion == JFileChooser.APPROVE_OPTION)
                {
                    String path = jfile.getSelectedFile().getAbsolutePath().replace(".gu","")+".gu";

                    try 
                    {
                        Tool.crearArchivo(text, path);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        JFileChooser jfile = new JFileChooser("./Desktop");
        FileNameExtensionFilter filtroGu = new FileNameExtensionFilter("gu Language File","gu");
        jfile.setFileFilter(filtroGu);
        jfile.setDialogTitle("Seleccionar archivo.");

        
        int opcion = jfile.showOpenDialog(null);
        
        if(opcion == JFileChooser.APPROVE_OPTION)
        {
            File file = jfile.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) 
            {
                text = "";
                while(br.ready())
                {
                    text += br.readLine() + "\n";
                }
                textAreaCodigo.setText(text);
                textoOriginal = new String(text);
                setTitle("Practica 1 201602988" + file.getName());
            } 
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bMenuAbrirActionPerformed

    private void bMenuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuGuardarActionPerformed
        String text = textAreaCodigo.getText();
        JFileChooser jfile = new JFileChooser("./Desktop");
        FileNameExtensionFilter filtroGu = new FileNameExtensionFilter("gu Language File","gu");
        jfile.setFileFilter(filtroGu);
        jfile.setDialogTitle("Guardar archivo.");

        int opcion = jfile.showSaveDialog(null);

        if(opcion == JFileChooser.APPROVE_OPTION)
        {

            File file = jfile.getSelectedFile();
            String path = file.getAbsolutePath().replace(".gu","")+".gu";

            try 
            {
                Tool.crearArchivo(text, path);
                textoOriginal = new String(text);
                setTitle("Practica 1 201602988" + file.getName());
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bMenuGuardarActionPerformed

    private void bMenuRErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuRErroresActionPerformed
        File file = new File("./Reportes/errores.html");
        Desktop d = Desktop.getDesktop();
        try 
        {
            d.open(file);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bMenuRErroresActionPerformed

    private void bAnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAnalizarMouseClicked
        
        String text = textAreaCodigo.getText().replaceAll("”","\"").replaceAll("“","\"").replaceAll("\r","").replaceAll("\f","");
        textAreaCodigo.setText(text);
        if(text.isEmpty()){
            JOptionPane.showMessageDialog(null, "Entrada vacia.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Lexico scanner = new Lexico(new StringReader(text));
        Sintactico parser = new Sintactico(scanner);

        try {
            //System.out.println("----------------- Analisis");
            parser.parse();
            //System.out.println("----------------- Fin Analisis\n\n");
            ejecutar(scanner, parser);
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_bAnalizarMouseClicked

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }
    
    private void ejecutar(Lexico scanner, Sintactico parser){
        //System.out.println("s:" + scanner.errores.size() + ", p:" + parser.errores.size());
        if(scanner.errores.size() > 0 || parser.errores.size() > 0)
        {
            String css = ""
                    + "table, th, td\n"
                    + "{\n" 
                    + "\tborder: 1px solid black;\n" 
                    + "}\n" 
                    + "\n"
                    + "body\n"
                    + "{\n" 
                    + "\tbackground-color:#d9d9d9;\n"
                    + "}";
            
            String document = ""
                    + "<!DOCTYPE html>\n"
                    + "<hml>\n"
                    + "\t<head>\n"
                    + "\t\t<meta charset=\"UTF-8\">\n"
                    + "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n"
                    + "\t</head>\n";
            
            String body = ""
                    + "\t<body>\n"
                    + "\t\t<center>\n";
            
            body += "\t\t\t<h1>Errores Léxicos</h1>\n";
            if(!scanner.errores.isEmpty())
            {
                body += "\t\t\t<table border=\"1\">\n";
                body += "\t\t\t\t<tr>\n";
                body += "\t\t\t\t\t<th>Tipo</th>\n";
                body += "\t\t\t\t\t<th>Token</th>\n";
                body += "\t\t\t\t\t<th>Fila</th>\n";
                body += "\t\t\t\t\t<th>Columna</th>\n";
                body += "\t\t\t\t\t<th>Descripción</th>\n";
                body += "\t\t\t\t</tr>\n";
                for (ErrorAnalisis e : scanner.errores) {
                    body += "\t\t\t\t<tr>\n";
                    body += e.toString();
                    body += "\t\t\t\t</tr>\n";
                }
                body += "\t\t\t</table>\n";
            }
            else
            {
                body += "\t\t\t\tNo hay errores\n";
            }
            
            body += "\t\t\t<hr>\n";
            
            body += "\t\t\t<h1>Errores Sintácticos</h1>\n";
            if(!parser.errores.isEmpty())
            {
                body += "\t\t\t<table border=\"1\">\n";
                body += "\t\t\t\t<tr>\n";
                body += "\t\t\t\t\t<th>Tipo</th>\n";
                body += "\t\t\t\t\t<th>Token</th>\n";
                body += "\t\t\t\t\t<th>Fila</th>\n";
                body += "\t\t\t\t\t<th>Columna</th>\n";
                body += "\t\t\t\t\t<th>Descripción</th>\n";
                body += "\t\t\t\t</tr>\n";
                for (ErrorAnalisis e : parser.errores) {
                    body += "\t\t\t\t<tr>\n";
                    body += e.toString();
                    body += "\t\t\t\t</tr>\n";
                }
                body += "\t\t\t</table>\n";
            }
            else
            {
                body += "\t\t\t\tNo hay errores\n";
            }
            body += ""
                    + "\t\t</center>\n"
                    + "\t</body>\n";
            document += body + "</html>";
            
            try
            {
                Tool.crearArchivo(document, "./Reportes/errores.html");
                Tool.crearArchivo(css, "./Reportes/style.css");
                JOptionPane.showMessageDialog(null, "Errores léxicos o sintácticos", "Advertencia", JOptionPane.OK_OPTION);                                         
                File file = new File("./Reportes/errores.html");
                Desktop d = Desktop.getDesktop();
                d.open(file);
            }
            catch(IOException e)
            {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else
        {
            boolean errorSemantico = false;
            //System.out.println("Variables Globales -----------------");
            for (Declaracion e : parser.globales) {
                //System.out.println(e.toString());
                errorSemantico = e.ejecutar();
                if(errorSemantico)
                    break;
            }
            //System.out.println("Fin Variables Globales -----------------\n\n");
            if(!errorSemantico)
            {
                //System.out.println("Graficas -----------------");
                for (Grafica e : parser.graficas) {
                    //System.out.println(e.toString());
                    errorSemantico = e.ejecutar(parser.globales);
                    if(errorSemantico)
                        break;
                }
                //System.out.println("Fin Graficas -----------------\n\n");
                if(!errorSemantico)
                {
                    //System.out.println("Galerias -----------------");
                    for (Galeria e : parser.galerias) {
                        //System.out.println(e.toString());
                        errorSemantico = e.ejecutar(parser.globales,parser.graficas);
                        if(errorSemantico)
                            break;
                    }
                    //System.out.println("Fin Galerias -----------------");
                    if(errorSemantico)
                    {
                        JOptionPane.showMessageDialog(null, "Error semántico en sección de galerías", "Advertencia", JOptionPane.OK_OPTION);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Generación correcta", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error semántico en sección de gráficas", "Advertencia", JOptionPane.OK_OPTION);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error semántico en sección de variables globales", "Advertencia", JOptionPane.OK_OPTION);
            }
            
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnalizar;
    private javax.swing.JMenuItem bMenuAbrir;
    private javax.swing.JMenu bMenuArchivo;
    private javax.swing.JMenuItem bMenuCerrar;
    private javax.swing.JMenuItem bMenuGuardar;
    private javax.swing.JMenuItem bMenuNuevo;
    private javax.swing.JMenuItem bMenuRErrores;
    private javax.swing.JMenu bMenuReporte;
    private javax.swing.JMenuItem bMenuSalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelColumna;
    private javax.swing.JLabel labelFila;
    private javax.swing.JTextArea textAreaCodigo;
    // End of variables declaration//GEN-END:variables
}