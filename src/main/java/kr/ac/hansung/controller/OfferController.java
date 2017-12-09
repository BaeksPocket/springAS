package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "offers"; 
	}
	@RequestMapping("/showlist")
	public String createOffers2(Model model,@RequestParam("year") int year,@RequestParam("semester")int semester) {
		
		List<Offer> offers = offerService.getDetail(year,semester);
		model.addAttribute("offers", offers);
		return "showlist"; 
	}

	
	@RequestMapping("/createoffer")
	public String createOffers(Model model) {
		
		model.addAttribute("offer", new Offer());
		return "createoffer"; 
	}
	@RequestMapping("/putin")
	public String getputin(Model model) {
		List<Offer> offers = offerService.getPutin();
		model.addAttribute("offers", offers);
		return "putin"; 
	}
	
	@RequestMapping("/getgrade")
	public String getgrades(Model model) {
		List<Offer> offers = offerService.getGradeSum();
		model.addAttribute("offers",offers);
		return "getgrade"; 
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model,@Valid Offer offer ,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createoffer";
		}
		
		offerService.insert(offer);
		
		return "offercreated"; 
	}
}
  