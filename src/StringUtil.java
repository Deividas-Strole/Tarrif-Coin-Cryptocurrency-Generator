import java.security.*;
import java.util.Base64;

// Applies Sha256 to a string and returns the result.
public class StringUtil {

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash)
                hexString.append(String.format("%02x", b));
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Applies RSA Signature and returns the result (as bytes)
    public static byte[] applyRSASig(PrivateKey privateKey, String input) {
        try {
            Signature rsa = Signature.getInstance("SHA256withRSA");
            rsa.initSign(privateKey);
            rsa.update(input.getBytes());
            return rsa.sign();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Verifies a String signature using RSA
    public static boolean verifyRSASig(PublicKey publicKey, String data, byte[] signature) {
        try {
            Signature rsaVerify = Signature.getInstance("SHA256withRSA");
            rsaVerify.initVerify(publicKey);
            rsaVerify.update(data.getBytes());
            return rsaVerify.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Converts a key into a string using Base64
    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}
