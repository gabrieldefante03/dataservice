package br.edu.faculdadedonaduzzi.dataservice.dto;

public class MathResponse {
    private double[] normalizedNumber;

    public MathResponse(double[] normalizedNumber) {
        this.normalizedNumber = normalizedNumber;
    }

    public double[] getResultFinal() { return normalizedNumber; }
}