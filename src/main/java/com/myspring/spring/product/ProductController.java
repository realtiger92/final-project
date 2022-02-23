package com.myspring.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// 상품 리스트 조회
	@GetMapping(value = "/getProductList")
	public ResponseEntity<?> getProductListByType(@RequestParam("page") int page, @RequestParam("perPage") int perPage,
			@RequestParam("type1") String type1, @RequestParam("type2") String type2) {
		return productService.getProductListByType(page, perPage, type1, type2);
	}

	// 전체 개수 가져오기
	@GetMapping("/getProductCount")
	public ResponseEntity<?> getProductCountByType(@RequestParam("type1") String type1,
			@RequestParam("type2") String type2) {
		return productService.getProductCountByType(type1, type2);
	}

	// 많이 팔린 상품 조회
	@GetMapping(value = "/getBestProductList")
	public ResponseEntity<?> getBestProductListByType(@RequestParam("type1") String type1,
			@RequestParam("type2") String type2) {
		return productService.getBestProductListByType(type1, type2);
	}

	// 상품 정보 조회
	@GetMapping(value = "/getProduct/{productNo}")
	public ResponseEntity<?> getProductByNo(@PathVariable("productNo") int productNo) {
		return productService.getProductByNo(productNo);
	}

}