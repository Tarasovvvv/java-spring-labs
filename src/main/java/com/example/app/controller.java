package com.example.app;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class controller {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(required = false) String p) {
        if (p == null)
            return ResponseEntity.ok("Hello World");
        else return ResponseEntity.ok("Hello " + p);

    }

    @GetMapping("/about")
    public ResponseEntity<String> about() {
        return ResponseEntity.ok("about us");

    }

    @GetMapping("/options")
    public ResponseEntity<String> options(@RequestParam(required = false) String p) {
        if (p == null)
            return ResponseEntity.ok("options");
        else return ResponseEntity.ok("not an option");
    }
}
