package tienda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller   
@RequestMapping(path="/user")
public class MainController {
	
	@CrossOrigin
	@GetMapping(path="/login")
	@ResponseBody
	public ResponseEntity<?> addNewUser () {
		return new ResponseEntity(HttpStatus.OK);
	}

}
