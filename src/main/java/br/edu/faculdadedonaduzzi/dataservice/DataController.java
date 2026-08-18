package br.edu.faculdadedonaduzzi.dataservice;
import br.edu.faculdadedonaduzzi.dataservice.service.PredictionService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
public class DataController {
    private final PredictionService predictionService;
    public DataController(PredictionService ps) {
        this.predictionService = ps;
    }
    @GetMapping("/predict")
    public String getPrediction(@RequestParam("id") String customerId,
                                @RequestParam("amount") double amount) {
        double score = predictionService.calculateFraudRisk(customerId, amount);
        return String.format("Risco de Fraude para %s é: %.2f%%", customerId,
                score * 100);
    }
}