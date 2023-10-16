package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.config.service.MyUser;
import org.teachmeskills.model.Tender;
import org.teachmeskills.service.TenderService;
import java.util.List;

@Controller
@RequestMapping("/myTenders")
@RequiredArgsConstructor
public class TendersUserController {
  private final TenderService tenderService;

  @GetMapping
  protected String getListTendersUser(final Model model) {
    final long organizationId = ((MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
        .getOrganization().getId();
    List<Tender> tenders = tenderService.getListTenders(organizationId);
    model.addAttribute("tenders", tenders);
    return "myTenders";
  }

  @DeleteMapping("/{tenderId}")
  protected String deleteTender(@PathVariable("tenderId") int tenderId) {
    Tender tender = tenderService.getTenderById(tenderId);
    tenderService.deleteTender(tender);
    return "redirect:/myTenders";
  }

}
