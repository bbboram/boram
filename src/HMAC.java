import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class HMAC {

    public static void main(String[] args) {
//        String accessToken = "wB3h2iOdBlIJCcIV9b5UamNtG5uvXD";
//        String hashKey = "90464726071106135653572815993097455656846831";
//        String transactionId = "a4b8j1k9l2z7w3n5d0t6m0r4v2xgfe";
//        String timeStamp = "1712654530";
//        String url = "/apiproxy/api99u01A01";

        
        //이건 테스트 하는중
        String accessToken = "gcmsAmaranth34008|2085|wITIRwhQTkLBPLXlnLEZb4yw4dH2L5";
        String hashKey = "27780528922021237497284876318994801543812214";
        String transactionId = "a4b8j1k9l2z7w3n5d0t6m0r4v2xgfe";
        String timeStamp = "1712654530";
        String url = "/gw/gw016A01";

        // Generate the HMAC (Wehago Sign)
        String wehagoSign = hmac(hashKey, accessToken + transactionId + timeStamp + url);

        if (wehagoSign != null) {
            System.out.println("Generated Wehago Sign: " + wehagoSign);
        }
    }

    public static String hmac(String key, String value) {
        try {
            // Prepare the secret key for the HMAC algorithm
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

            // Initialize the MAC instance with the HMAC-SHA256 algorithm
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(keySpec);

            // Perform the HMAC operation
            byte[] encrypted = mac.doFinal(value.getBytes(StandardCharsets.UTF_8));

            // Convert the encrypted result into a Base64 encoded string
            return DatatypeConverter.printBase64Binary(encrypted);
        } catch (Exception e) {
            // Proper error handling
            System.out.println("Error in HMAC: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

