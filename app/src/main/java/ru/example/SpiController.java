package ru.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.example.api.SomeService;

@RestController
@RequestMapping("spi")
public class SpiController {

    private final SomeService service;

    public SpiController(SomeService service) {
        this.service = service;
    }

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET
    )
    public String get() {
        return service.get();
    }
}
