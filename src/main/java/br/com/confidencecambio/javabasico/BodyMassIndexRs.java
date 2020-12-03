package br.com.confidencecambio.javabasico;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.BodyMassIndexService;

@RestController
@RequestMapping("/bmi")
public class BodyMassIndexRs {

	private BodyMassIndexService service;

	public BodyMassIndexRs(final BodyMassIndexService service) {
		this.service = service;
	}

	@GetMapping(value = "/calculate")
	public ResponseEntity<Float> calculateBMI(@RequestParam(value = "weight", required = true) Float weight,
			@RequestParam(value = "height", required = true) Float height) {
		Float retorno = service.calculate(weight, height);
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}
}
