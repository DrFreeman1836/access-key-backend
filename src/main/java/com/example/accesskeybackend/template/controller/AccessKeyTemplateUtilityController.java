package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.UtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/web")
@RequiredArgsConstructor
public class AccessKeyTemplateUtilityController {

  private UtilityService utilityService;

  @GetMapping("/checkIpv6Support")
  public ResponseEntity<Boolean> checkIpv6(@RequestParam final String siteUrl) {
    return ResponseEntity.ok(utilityService.checkIpv6(siteUrl));
  }

}
