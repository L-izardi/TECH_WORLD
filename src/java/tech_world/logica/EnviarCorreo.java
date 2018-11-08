/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_world.logica;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tech_world.utils.HibernateUtil;

/**
 *
 * @author soporte
 */
public class EnviarCorreo {
    
    public void enviarCorreo(String username,String password,String smtphost,String port, String recipientes, 
                                    String copias, String copiasOcultas, String asunto,String texto,String adjunto)
    {       

        Properties props = System.getProperties();
        props.put("mail.smtp.host", smtphost);  //El servidor SMTP de Google
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.clave", password);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", port); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(username));
            message.setSubject(asunto, "utf-8");
            
            String[] recipientesArray = recipientes.split(",");
            for(String recipiente : recipientesArray)
            {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipiente));
            }
            if(!copias.equals("")){
                String[] copiasArray = copias.split(",");
                for(String copia : copiasArray)
                {
                    message.addRecipient(Message.RecipientType.CC, new InternetAddress(copia));
                }
            }
            if(!copiasOcultas.equals("")){
                String[] copiasOcultasArray = copiasOcultas.split(",");
                for(String copiaOculta : copiasOcultasArray)
                {
                    message.addRecipient(Message.RecipientType.BCC, new InternetAddress(copiaOculta));
                }
            }
            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(texto);
            messageBodyPart.setContent(texto, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            if(!adjunto.equals("")){
                String[] adjuntoArray = adjunto.split(",");
                for(String adj : adjuntoArray)
                {
                    messageBodyPart = new MimeBodyPart();
                    String filename = adj;
                    File f = new File(filename);
                    if(f.exists() && !f.isDirectory()) { 
                        DataSource source = new FileDataSource(filename);
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(source.getName());
                        multipart.addBodyPart(messageBodyPart);
                    }
                    else{
                        if(f.isDirectory())
                        {
                            /*JOptionPane.showMessageDialog(new JFrame(), 
                                "El archivo " + f.getName() + " es un directorio.", 
                                "Error al adjuntar archivo",                                 
                                JOptionPane.ERROR_MESSAGE);*/
                        }
                        else if(!f.exists()){
                            /*JOptionPane.showMessageDialog(new JFrame(),  
                                "El archivo " + f.getName() + " no existe.", 
                                "Error al adjuntar archivo.",
                                JOptionPane.ERROR_MESSAGE);*/
                        }
                        
                        System.exit(0);
                    }
                    
                }                
            }

            // Send the complete message parts
            message.setContent(multipart, "text/html; charset=utf-8");
            
            Transport transport = session.getTransport("smtp");
            transport.connect(smtphost, username, password);
            transport.sendMessage(message, message.getAllRecipients());
            /*JOptionPane.showMessageDialog(new JFrame(), 
                    "El mensaje se ha enviado correctamente.", 
                    "Envío de Correo", 
                    JOptionPane.INFORMATION_MESSAGE);*/
        }
        catch (MessagingException me) {
            me.printStackTrace();
            /*JOptionPane.showMessageDialog(new JFrame(), 
                    me.getMessage(), 
                    "Error al enviar el correo", 
                    JOptionPane.ERROR_MESSAGE);*/
            System.exit(0);
        }
    }
}
