//package org.teachmeskills.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.teachmeskills.model.Tender;
//import org.teachmeskills.service.TenderService;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/search")
//@RequiredArgsConstructor
//public class SearchController {
//
//  private final TenderService tenderService;
//
//  @GetMapping()
//  protected String getListTenders(@RequestParam(defaultValue = "1", name = "page", required = false) Integer pageNo,
//                                  @RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize,
//                                  Model model) {
//    final Page<Tender> page = tenderService.findPaginatedAllTenders(pageNo, pageSize);
//    List<Tender> listTender = page.getContent();
//    model.addAttribute("tenders", listTender);
//    model.addAttribute("currentPage", pageNo);
//    model.addAttribute("pageSize", pageSize);
//    model.addAttribute("totalPages", page.getTotalPages());
//    model.addAttribute("totalItems", page.getTotalElements());
//    return "search";
//  }
//}
