package com.docmosis.docmosis.Repository;

import com.docmosis.docmosis.Model.Main_data;
import com.docmosis.docmosis.Model.Temp_data;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Main_Repo extends JpaRepository<Main_data, Long>{

}