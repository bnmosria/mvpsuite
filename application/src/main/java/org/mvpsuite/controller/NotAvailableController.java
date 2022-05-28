package org.mvpsuite.controller;

import org.mvpsuite.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotAvailableController {
    @RequestMapping(value = "/")
    public String home(@PathVariable String path) {
        throw new ResourceNotFoundException();
    }

    @RequestMapping(value = "/**/{path:[^\\.]*}")
    public String any(@PathVariable String path) {
        throw new ResourceNotFoundException();
    }
}