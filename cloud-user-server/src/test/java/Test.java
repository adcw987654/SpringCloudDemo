import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 生成 HMAC-SHA256 簽名金鑰
        SecretKey secretKey = generateHmacSha256Key();

        System.out.println("HMAC-SHA256 簽名金鑰: " + new String(Base64.getEncoder().encode(secretKey.getEncoded())));
    }

    private static SecretKey generateHmacSha256Key() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        return keyGenerator.generateKey();
    }

}
