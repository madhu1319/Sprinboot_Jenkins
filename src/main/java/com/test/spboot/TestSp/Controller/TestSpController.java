package com.test.spboot.TestSp.Controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestSpController {

	


	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> syncMetadataFromMP() throws IOException {

		return new ResponseEntity<>("Hello! This is test Springboot appliation-Somi J.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello(@RequestParam String name) throws IOException {

		return new ResponseEntity<>("Hello  "+name+" , Welcome to Springboot Application.", HttpStatus.OK);
	}


}
