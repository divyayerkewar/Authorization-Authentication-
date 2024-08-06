import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;
import java.net.HttpURLConnection;

public class BasicAuth {

    public static void main(String[] args) {
        try {
            // set url and username and password
            String APIurl = "http://httpbin.org/basic-auth/divya/123";
            String Username = "divya";
            String Password = "123";

            // creates a url object
            URL url = new URL(APIurl);

            // opens a connection to the specified URl
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String auth = Username + ":" + Password;

            // set request methid is "GET"
            connection.setRequestMethod("GET");

            // Set authorization header to the request with the value basic and encodedAuth
            connection.setRequestProperty("Authorization", "Basic ZGl2eWE6MTIz");

            // get response code and print the response code to the console
            int responseCode = connection.getResponseCode();
            System.out.println("ResponseCode" + "  " + responseCode);

            // inputStreamReader to readtext from input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // readlines of the reponse and store in a string builder
            String line;
            StringBuilder response = new StringBuilder();

            // readlines and append each line to the string builder
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            // print the response body to the console
            System.out.println("Response Body" + " " + response);

        }
        // prints any exception that occurs

        catch (Exception e) {

            e.printStackTrace();
        }

    }

}