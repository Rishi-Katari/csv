package com.docmosis.docmosis.service;

import com.docmosis.docmosis.Model.Main_data;
import com.docmosis.docmosis.Model.Temp_data;
import com.docmosis.docmosis.Repository.Main_Repo;
import com.docmosis.docmosis.Repository.temp_Repo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import Transactional

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DataTransferService {

    private final Main_Repo mainRepo;
    private final temp_Repo tempRepo;


    public void transferData() {
        List<Temp_data> tempDataList = tempRepo.findAll();

        List<Main_data> mainDataList = tempDataList.stream()
                .map(tempData -> {
                    Main_data mainData = new Main_data();
                    mainData.setName(tempData.getName());
                    mainData.setAge(tempData.getAge());
                    mainData.setGender(tempData.getGender());
                    mainData.setPhoneNo(tempData.getPhoneNo());
                    mainData.setEmail(tempData.getEmail());
                    return mainData;
                })
                .collect(Collectors.toList());

        mainRepo.saveAll(mainDataList);

    }
}