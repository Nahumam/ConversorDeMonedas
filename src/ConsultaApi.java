import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

        public ExchangeRate moneda (String base_code){
            URI direccion = URI.create(
                    "https://v6.exchangerate-api.com/v6/2f3f7074e790b88a53c6c7c9/latest/"+base_code);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            try {
                HttpResponse<String> response = null;
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                Gson gson = new Gson();
                ExchangeRate exchangeRate = gson.fromJson(json, ExchangeRate.class);
                return exchangeRate;
            } catch (Exception e) {
                throw new RuntimeException("No encontré esa moneda");
            }
        }
}
