package cliente;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Cliente extends Thread {

    String filePath = "";
    long fileSize;
    String userName;

    public Cliente(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        //buffer donde se almacenara los mensajes
//            byte[] buffer = new byte[5000000];
        //puerto del servidor
        final int PUERTO_SERVIDOR = 5000;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        filePath = fileChooser.getSelectedFile().getAbsolutePath();
//        filePath = "c:/Pics/author-image1.jpg";
        byte[] buffer = new byte[100000];
        byte[] buffer2 = new byte[100000];
        try {
            fileSize = fileSize(filePath);

            //Obtengo la localizacion de localhost
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            //Creo el socket de UDP
            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = userName;

            //Convierto el mensaje a bytes
            buffer = extractBytes(filePath);

            //Creo un datagrama
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

            //Lo envio con send
            System.out.println("El usuario " + userName + " envío el archivo");
            socketUDP.send(pregunta);
            
            buffer=mensaje.getBytes();
            pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            socketUDP.send(pregunta);

//__________Termina primer envío______________________________//
            //Preparo la respuesta
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            //Recibo la respuesta
            socketUDP.receive(peticion);
            System.out.println("Recibo la peticion");

            //Cojo los datos y lo muestro
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            //cierro el socket
            socketUDP.close();

            //Obtengo la localizacion de localhost
//            InetAddress direccionServidor = InetAddress.getByName("localhost");
//
//            //Creo el socket de UDP
//            DatagramSocket socketUDP = new DatagramSocket();
//
//            String mensaje = "¡Hola mundo desde el cliente!";
//
//            //Convierto el mensaje a bytes
//            buffer = extractBytes("c:/Pics/author-image1.jpg");
//
//            //Creo un datagrama
//            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
//
//            //Lo envio con send
//            System.out.println("Envio el datagrama");
//            socketUDP.send(pregunta);
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] extractBytes(String ImageName) throws IOException {
        File fnew = new File(ImageName);
        BufferedImage originalImage = ImageIO.read(fnew);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos);
        byte[] imageInByte = baos.toByteArray();

        return (imageInByte);
    }

    public void convertBytesInImage(byte[] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "jpg", new File("output.jpg"));
        System.out.println("image created");
    }

    public long fileSize(String ImageName) throws IOException {
        File fnew = new File(ImageName);
        long size = fnew.length();
        return size;
    }
}
