package br.edu.faculdadedonaduzzi.dataservice;

import br.edu.faculdadedonaduzzi.dataservice.dto.MathResponse;
import br.edu.faculdadedonaduzzi.dataservice.dto.PredictionResponse;
import br.edu.faculdadedonaduzzi.dataservice.service.MathService;
import br.edu.faculdadedonaduzzi.dataservice.service.PredictionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class DataController {
    private PredictionService predictionService;

    public DataController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }


    @GetMapping("status")
    public String checkStatus() {
        return "Microsserviço de Dados operando com sucesso!" +
                "Servidor ativo: " + LocalDateTime.now().toString();
    }


    @GetMapping("/predict")
    public PredictionResponse getPrediction(
        @RequestParam("id") String customerId,
        @RequestParam("amount") double amount) {
        double score =
    predictionService.calculateFraudRisk(customerId, amount);
        return new PredictionResponse(customerId, score);
    }


    @GetMapping("/math/normalize")
    public MathResponse intNormalize(
        @RequestParam("val1") double number1,
        @RequestParam("val2") double number2,
        @RequestParam("val3") double number3) {
        double[] normalizedNumber = MathService.normalize(number1, number2, number3);
        return new MathResponse(normalizedNumber);
    }
}