//package org.teachmeskills.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.teachmeskills.model.Application;
//import org.teachmeskills.model.Tender;
//import org.teachmeskills.service.ApplicationService;
//import org.teachmeskills.service.TenderService;
//import org.teachmeskills.service.VictoryService;
//
//@Controller
//@RequestMapping("/victory")
//@RequiredArgsConstructor
//public class VictoryController {
//
//  private final TenderService tenderService;
//  private final ApplicationService applicationService;
//  private final VictoryService victoryService;
//
//  @PostMapping("/{tenderId}/{applicationId}")
//  protected String createVictory(@PathVariable("tenderId") int tenderId,
//                                 @PathVariable("applicationId") int applicationId) {
//    Tender tender = tenderService.getTenderById(tenderId);
//    Application application = applicationService.getApplicationById(applicationId);
//    victoryService.createVictory(application.organizationApplication, tender);
//    return "redirect:/tender/" + tenderId;
//  }
//
//  @GetMapping("/{tenderId}")
//  protected String chooseWinner(@PathVariable("tenderId") int tenderId, Model model) {
//    Tender tender = tenderService.getTenderById(tenderId);
//    model.addAttribute("victory", tender.getVictory());
//    return "/victory";
//  }
//
//}
