package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.facade.TenderFacade;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Tender;

import java.util.List;

@Controller
@RequestMapping("/tender")
@RequiredArgsConstructor
public class TenderController {

  private final TenderFacade tenderFacade;

  @GetMapping("/{tenderId}")
  protected String getTender(@PathVariable("tenderId") int tenderId, Model model) {
    Tender tender = tenderFacade.getTender(tenderId);
    List<Application> applications = tenderFacade.getApplications(tenderId);
    int countApplication = tenderFacade.getCountApplications(tender);
    model.addAttribute("tender", tender);
    model.addAttribute("applications", applications);
    model.addAttribute("count", countApplication);
    return "/tender";
  }

}
