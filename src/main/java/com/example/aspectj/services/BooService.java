package com.example.aspectj.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class BooService {
  @Transactional
  public void m3() {
    log.info("m3: called");
  }
}
