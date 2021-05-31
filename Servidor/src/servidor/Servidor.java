package servidor;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Servidor extends Thread {

    @Override
    public void run() {
        final int PUERTO = 5000;
        byte[] buffer = new byte[500000];
        byte[] information = new byte[1024];
        try {
            String userName = "";
            System.out.println("Iniciado el servidor UDP");
            //Creacion del socket
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            //Siempre atendera peticiones
            while (true) {

                //Preparo la respuesta
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                //Recibo el datagrama
                socketUDP.receive(peticion);
                System.out.println("Recibo la informacion del cliente");

                //Convierto lo recibido y mostrar el mensaje
                buffer = peticion.getData();
                System.out.println("Recibido el archivo");

//                
                peticion = new DatagramPacket(information, information.length);
                //Recibo el datagrama
                socketUDP.receive(peticion);
                userName = new String(peticion.getData());
                System.out.println("Recibo el usuario " + userName);

                File directorio = new File(userName);
                directorio.mkdir();
                //Convierto los bytes en una imagen
                convertBytesInImage(buffer);

                //Obtengo el puerto y la direccion de origen
                //Sino se quiere responder, no es necesario
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                String mensaje = "¡Hola mundo desde el servidor!";
                buffer = mensaje.getBytes();

                //creo el datagrama
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                //Envio la información
                System.out.println("Envio la informacion del cliente");
                socketUDP.send(respuesta);

            }

        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
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

    public void createFolder(String userName) {
        String OrigenCarpeta = "C:\\TareaProgramada1\\Servidor\\" + userName;
        File directorio = new File(userName);
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Multiples directorios fueron creados");
            } else {
                System.out.println("Error al crear directorios");
            }
        }
    }
}
