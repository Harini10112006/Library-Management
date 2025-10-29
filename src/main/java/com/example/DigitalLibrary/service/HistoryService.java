package com.example.DigitalLibrary.service;

import com.example.DigitalLibrary.entities.History;
import java.util.List;
    public interface HistoryService {
    List<History> getAllHistory();
    History saveHistory(History history);
    
}
