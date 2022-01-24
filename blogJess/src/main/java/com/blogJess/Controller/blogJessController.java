package com.blogJess.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Classe responsavel por receber requisiçoes Web
public class blogJessController {
		
	@GetMapping("/ola") // Caminho usado
	@ResponseBody  // Mostra a resposta no body
	public String ola() {
		return "Eu troquei para olá e adicionei algumas coias";
	}
}
