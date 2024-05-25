package com.turkcell.crm.customerService.core.mernisVerification.concretes;


import com.turkcell.crm.customerService.core.mernisVerification.abstracts.MernisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MernisManager implements MernisService {

    private final WebClient webClient;

    public MernisManager(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://mernis.gov.tr/").build();
    }
    @Override
    public boolean validateCitizen(String nationalityNumber, String firstName, String lastName, LocalDate birthDate) {
      //  Mono<Boolean> response = webClient.get()
      //          .uri(uriBuilder -> uriBuilder
      //                  .path("/validate")
      //                  .queryParam("nationalityId", nationalityNumber)
      //                  .queryParam("firstName", firstName)
      //                  .queryParam("lastName", lastName)
      //                  .queryParam("birthDate", birthDate.toString())
      //                  .build())
      //          .retrieve()
      //          .bodyToMono(Boolean.class);

      //   return response.block();
        return true;
    }
}
