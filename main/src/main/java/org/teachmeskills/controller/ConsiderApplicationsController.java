package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.facade.ApplicationFacade;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Tender;

import java.util.List;

@Controller
@RequestMapping("/considerApplications")
@RequiredArgsConstructor
public class ConsiderApplicationsController {

  private final ApplicationFacade applicationFacade;

  @GetMapping("/{tenderId}")
  protected String Tender(@PathVariable("tenderId") int tenderId, Model model) {
    Tender tender = applicationFacade.getTender(tenderId);
    List<Application> applications = applicationFacade.getApplications(tenderId);
    model.addAttribute("tender", tender);
    model.addAttribute("applications", applications);
    return "considerApplications";
  }

}
