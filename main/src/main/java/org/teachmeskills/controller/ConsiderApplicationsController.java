package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Tender;
import org.teachmeskills.service.ApplicationService;
import org.teachmeskills.service.TenderService;

import java.util.List;

@Controller
@RequestMapping("/considerApplications")
@RequiredArgsConstructor
public class ConsiderApplicationsController {
  private final TenderService tenderService;
  private final ApplicationService applicationService;

  @GetMapping("/{tenderId}")
  protected String Tender(@PathVariable("tenderId") int tenderId, Model model) {
    Tender tender = tenderService.getTenderById(tenderId);
    List<Application> applications = applicationService.getListApplicationsByTender(tenderId);
    model.addAttribute("tender", tender);
    model.addAttribute("applications", applications);
    return "considerApplications";
  }

}
