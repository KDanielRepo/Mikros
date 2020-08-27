package com.example.Ftp;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FtpRest {
    private final FtpGateway gate;

    @GetMapping("/look")
    public ResponseEntity<String> look(){
        return new ResponseEntity<>(gate.list(".").toString(),HttpStatus.OK);
    }

    @GetMapping("/send")
    public ResponseEntity responseEntity() throws IOException {
        File file = new File("text.txt");
        FileUtils.writeStringToFile(file,"test","UTF-8");
        try{
            gate.uploadFile(file);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity(HttpStatus.OK);

    }
}
