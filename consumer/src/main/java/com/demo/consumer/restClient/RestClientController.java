package com.demo.consumer.restClient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-client")
@RequiredArgsConstructor
public class RestClientController {

    private final ProviderRestClient providerRestClient;

    @GetMapping("/instance")
    public String getInstance(){
        return providerRestClient.getInstanceInfo();
    }

}
