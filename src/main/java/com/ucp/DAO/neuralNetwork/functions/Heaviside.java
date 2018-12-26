package com.ucp.DAO.neuralNetwork.functions;

public class Heaviside extends AbstractFunction {
    private final static double threshold = 0.5;

    @Override
    public double computeDerivative(Double currentInput) {
        return currentInput;
    }

    @Override
    public double computeOutput(Double y) {
        if (y < Heaviside.threshold)
            return 0.0;
        else
            return 1.0;
    }
}
