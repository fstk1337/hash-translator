package tt.hashtranslator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tt.hashtranslator.service.HashTranslatorService;

@Slf4j
@RestController
@RequestMapping("/api/applications")
public class HashTranslatorController {
    private final HashTranslatorService hashTranslatorService;

    @Autowired
    public HashTranslatorController(HashTranslatorService hashTranslatorService) {
        this.hashTranslatorService = hashTranslatorService;
    }

    @GetMapping
    public String printGreeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        log.info("greeting for {}", name);
        return hashTranslatorService.makeGreetingMessageFor(name);
    }
}
