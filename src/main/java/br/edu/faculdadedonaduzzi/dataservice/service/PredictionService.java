package br.edu.faculdadedonaduzzi.dataservice.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service // Essencial para registrar o Bean
public class PredictionService {
    //metodo de predição, ele recebe uma customerId e o montate da transação
    public double calculateFraudRisk(String customerId,
                                     double transactionAmount) {
        System.out.println("Processando dados do cliente: " + customerId);
        double riskScore = (transactionAmount / 10000.0)
                + new Random().nextDouble(0.5);
        return Math.min(riskScore, 1.0);
    }
}