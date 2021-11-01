package com.example.aspectj.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FooService {


    @Autowired
    private BooService booService;

    public void m1() {
        log.info("m1 : called");
        booService.m3();
        this.m2();
    }

    @Transactional
    public void m2() {
        log.info("m2 : called");
    }
}
