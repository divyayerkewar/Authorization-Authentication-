import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class deleterequestwithtoken {

    public static void main(String[] args) {
        try {

            String APIurl = "https://httpbin.org/bearer";
            String token = "643ac461-f5de-40cd-8980-af36c7effc53";

            URL url = new URL(APIurl);

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Authorization", "Bearer" + token);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code" + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Respone body" + responseCode);

        }

        catch (Exception e)

        {
            e.printStackTrace();

        }
    }

}
