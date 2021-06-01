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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
                byte[] userNameArray = new byte[peticion.getLength()];
                userNameArray = peticion.getData();
                userName = new String(userNameArray);
                String usuario = deleteEmptyBytes(userName);
                System.out.println("Recibo del usuario " + usuario + " " + usuario.length());
                
                String ruta = usuario+"/";
                String imageName = JOptionPane.showInputDialog("Ingrese el nombre de la imagen");
                ruta += imageName+"‪.";
                String formato =JOptionPane.showInputDialog("Ingrese el formato de la imagen");
                ruta += formato;
                //Convierto los bytes en una imagen
                convertBytesInImage(buffer, formato, ruta);
                //Obtengo el puerto y la direccion de origen
                //Sino se quiere responder, no es necesario
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                String mensaje = "Imagen recibida!";
                buffer = mensaje.getBytes();

                //creo el datagrama
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                //Envio la información
                System.out.println("Envío la confirmación al cliente");
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

    public void convertBytesInImage(byte[] data, String formato, String ruta) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, formato, new File(ruta));
        System.out.println("Imagen creada");
    }

    public void createFolder(String userName) {
        File directorio = new File(userName);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    public String deleteEmptyBytes(String userName) {
        String result = "";
        int size = 0;
        byte[] user = userName.getBytes();

        for (int n = 0; n < user.length; n++) {
            if (user[n] != 0) {
                size += 1;
            }
        }
        byte[] salida = new byte[size];
        for (int n = 0; n < size; n++) {
            salida[n] = user[n];
        }
        result = new String(salida);
        return result;
    }
}
