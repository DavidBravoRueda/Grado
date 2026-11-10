package server;

import java.security.MessageDigest;

// Clase para manejar la seguridad, como el hashing de contraseñas
public class Seguridad {
    public static String generarHash(String password) {
        try {
            // Utiliza SHA-256 para generar un hash de la contraseña
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
