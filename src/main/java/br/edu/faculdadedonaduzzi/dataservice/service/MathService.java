package br.edu.faculdadedonaduzzi.dataservice.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public static double[] normalize(double number1, double number2, double number3) {
        double min = Math.min(Math.min(number1, number2), number3);
        double max = Math.max(Math.max(number1, number2), number3);
        double result1 = ((number1 - min) / (max - min));
        double result2 = ((number2 - min) / (max - min));
        double result3 = ((number3 - min) / (max - min));
        double resultFinal[] = {result1, result2, result3};
        return resultFinal;
    }
}
