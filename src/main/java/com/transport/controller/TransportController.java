package com.transport.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/transport")
public class TransportController {

	@GetMapping("/ui")
    public String getUser() {
        return "HelloWorld";
    }
}
