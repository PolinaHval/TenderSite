package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.facade.VictoryFacade;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Tender;

@Controller
@RequestMapping("/victory")
@RequiredArgsConstructor
public class VictoryController {

  private final VictoryFacade victoryFacade;

  @PostMapping("/{tenderId}/{applicationId}")
  protected String createVictory(@PathVariable("tenderId") int tenderId,
                                 @PathVariable("applicationId") int applicationId) {
    Tender tender = victoryFacade.getTender(tenderId);
    Application application = victoryFacade.getApplication(applicationId);
    victoryFacade.createVictory(application.organizationApplication, tender);
    return "redirect:/tender/" + tenderId;
  }

  @GetMapping("/{tenderId}")
  protected String chooseWinner(@PathVariable("tenderId") int tenderId, Model model) {
    Tender tender = victoryFacade.getTender(tenderId);
    model.addAttribute("victory", tender.getVictory());
    return "/victory";
  }

}
