package com.mcs.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.mcs.company.domain.Company;
import com.mcs.product.domin.Files;
import com.mcs.product.domin.Product;
import com.mcs.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	// 1.�긽�뭹�벑濡앺럹�씠吏�
	@GetMapping("/addproductForm")
	public String addProductView(@AuthenticationPrincipal Company comp, Model model) {
		model.addAttribute("comp",comp.getCompany_name());
		return "/product/addProduct";
	}
	
	// 1-1.�긽�뭹�벑濡�
	@PostMapping("/addproduct")
	public String addProduct(@AuthenticationPrincipal Company comp, @ModelAttribute("product") Product product, @RequestPart MultipartFile filesinfo) throws Exception {
		Files file = productService.saveFile(filesinfo, null); //�뙆�씪���옣
		product.setFiles(file); //���옣�맂�뙆�씪 踰덊샇 媛��졇�샂	
		product.setCompany(comp.getCompany()); //濡쒓렇�씤�븳 湲곗뾽 �븘�씠�뵒 媛��졇�샂
		productService.saveProduct(product); //�긽�뭹�벑濡�
		return "redirect:/compProductList";
	}
	
	// 2.�쉶�썝�쟾�슜 �긽�뭹由ъ뒪�듃 �럹�씠吏�
	@GetMapping("/productList")
	public String productlist(Model model) {
		List<Product> productList = productService.productlist();
		model.addAttribute("product",productList);
		return "/product/productList";
	}
	
	// 2-1.�쉶�썝�쟾�슜 �긽�뭹�긽�꽭 �럹�씠吏�
	@GetMapping("/productInfo")
	public String productInfo(@RequestParam("pronum") int pronum, Model model) {
		Product productInfo = productService.productInfo(pronum);
		model.addAttribute("product",productInfo);
		return "/product/productInfo";
	}
	
	// 3.湲곗뾽�쟾�슜 �긽�뭹由ъ뒪�듃 �럹�씠吏� (�긽�뭹�꽑�깮�떆 �닔�젙,�궘�젣)
	@GetMapping("/compProductList")
	public String updateProductView(@AuthenticationPrincipal Company comp, Model model) {
		List compProductList = productService.compProductList(comp.getCompany());
		model.addAttribute("product",compProductList);
		return "/product/compProductList";
	}
	
	// 3.�긽�뭹�닔�젙�럹�씠吏�
	@GetMapping("/compProductUpdate")
	public String compProductUpdateView(@AuthenticationPrincipal Company comp, Model model, @RequestParam("pronum") int pronum) {
		Product productInfo = productService.productInfo(pronum);
		model.addAttribute("product",productInfo);		
		return "/product/compProductUpdate";
	}
	
	// 3.�긽�뭹�닔�젙 and �뙆�씪�닔�젙
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product,@RequestParam("filenum") Integer filenum, @RequestPart MultipartFile filesinfo) throws Exception {	
		Files file = productService.saveFile(filesinfo, filenum); //�뙆�씪���옣(�닔�젙 filenum媛�)	
		product.setFiles(file); //���옣�맂�뙆�씪 媛��졇�샂	
		productService.saveProduct(product); //�긽�뭹�벑濡�
		return "redirect:/compProductList";
	}
	
	// 3-1.�긽�뭹�궘�젣
	@Transactional
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("pronum") Integer pronum) {
		productService.deleteProduct(pronum);
		return "redirect:/compProductList";
	}
	
	// 4.湲곗뾽�쟾�슜 �썝猷뚰럹�씠吏�
	@GetMapping("/compProductIngredients")
	public String compProductIngredients(@AuthenticationPrincipal Company comp, Model model) {
		List compProductList = productService.compProductList(comp.getCompany());
		model.addAttribute("product",compProductList);
		return "/product/compProductIngredients";
	}
	
}
