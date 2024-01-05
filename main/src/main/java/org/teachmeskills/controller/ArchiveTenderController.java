package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.model.Tender;
import org.teachmeskills.service.TenderService;

import java.util.List;

@Controller
@RequestMapping("/archiveTenders")
@RequiredArgsConstructor
public class ArchiveTenderController {
  private final TenderService tenderService;

  @GetMapping()
  protected String getListTenderArchive(final Model model) {
    List<Tender> listTenderArchive = tenderService.getListArchiveTender();
    model.addAttribute("listTenderArchive", listTenderArchive);
    return "archiveTenders";
  }
}
