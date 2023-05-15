package ru.dartinc.currency.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CbrCurrencyRateClient implements HttpCurrencyDateRateClient{

    public static final String DATE_PATTERN = "dd/MM/yyyy";

    @Value("${cbr.baseUrl}")
    private String baseUrl;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    @Override
    public String requestByDate(LocalDate date) {
        var client = HttpClient.newHttpClient();
        var url = buildUriRequest( baseUrl, date);

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String buildUriRequest(String baseUrl, LocalDate date) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("date_req",DATE_TIME_FORMATTER.format(date))
                .build()
                .toUriString();
    }
}
