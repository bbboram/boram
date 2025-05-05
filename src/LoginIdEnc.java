import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginIdEnc {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        String Key = "1023497555960596";
        String str = "20250424143000▦2085";
        String test = AES128_Encode(str, Key);
    }





    public static String AES128_Encode(String str, String Key)

            throws java.io.UnsupportedEncodingException,

            NoSuchAlgorithmException, NoSuchPaddingException,

            InvalidKeyException, InvalidAlgorithmParameterException,

            IllegalBlockSizeException, BadPaddingException {

        byte[] keyData = Key.getBytes();





        SecretKey secureKey = new SecretKeySpec(keyData, "AES");



        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        c.init(Cipher.ENCRYPT_MODE, secureKey,  new IvParameterSpec(Key.getBytes()));



        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));

        String enStr = new String(Base64.getEncoder().encodeToString(encrypted));

        System.out.println("Generated enStr Sign: " + enStr);

        return enStr;

    }
}

