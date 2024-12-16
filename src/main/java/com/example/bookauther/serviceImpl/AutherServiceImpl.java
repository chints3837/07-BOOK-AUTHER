package com.example.bookauther.serviceImpl;

import com.example.bookauther.entity.Auther;
import com.example.bookauther.repository.AutherRepository;
import com.example.bookauther.service.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutherServiceImpl implements AutherService {

    @Autowired
    private AutherRepository autherRepository;


    public Auther saveAuther(Auther auther){
        Auther autherResult=autherRepository.save(auther);
        return autherResult;
    }

    public Auther getAutherById(Integer autherId){
        Optional<Auther> autherResult=autherRepository.findById(autherId);

        return autherResult.get();
    }

    public Integer getCount(Integer authId,String year){
        Integer result=autherRepository.countBooksByAuthorAndYear(authId,year);
        return result;
    }
}
