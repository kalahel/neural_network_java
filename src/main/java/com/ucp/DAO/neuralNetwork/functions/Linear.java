package com.ucp.DAO.neuralNetwork.functions;

public class Linear extends AbstractFunction{
    @Override
    public double computeDerivative(Double currentInput) {
        return currentInput;
    }

    @Override
    public double computeOutput(Double y) {
        return y;
    }
}
