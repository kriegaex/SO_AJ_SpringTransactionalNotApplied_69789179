package com.example.aspectj.services;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BooService {

    @Transactional
    public void m3() {
        log.info("m3 : called");
    }


}
