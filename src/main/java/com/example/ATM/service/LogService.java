package com.example.ATM.service;

import com.example.ATM.model.TextLogModel;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class LogService {

    List<TextLogModel> logDb = new ArrayList<>();

    public void save( String operation, LocalDateTime now){
        logDb.add(new TextLogModel(operation,now));
    }
}
