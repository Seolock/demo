package com.example.demo.controller;

import com.example.demo.dto.PracticeBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PracticeController {

    @PostMapping("/requestBody")
    public ResponseEntity<PracticeBody> postRequestBody(@RequestBody PracticeBody practiceBody){
        return ResponseEntity.ok().body(practiceBody);
        //return ResponseEntity.status(400).body(practiceBody);
    }

    @PostMapping("/requestParam")
    public ResponseEntity<String> postRequestParam(@RequestParam("name") String name){
        return ResponseEntity.ok().body(name);
    }

    @PostMapping("/pathVariable/{id}")
    public ResponseEntity<Long> postRequestParam(@PathVariable Long id){
        return ResponseEntity.ok().body(id);
    }

    @PostMapping("/requestPart")
    public ResponseEntity<String> postRequestParam(@RequestPart("file") MultipartFile file){
        return ResponseEntity.ok().body(file.getOriginalFilename());
    }

}
