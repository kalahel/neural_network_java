package com.ucp.DAO.neuralNetwork.functions;

import com.ucp.DAO.neuralNetwork.Neuron;

import java.util.List;

public abstract class AbstractFunction {

    /**
     * Compute sum of inputs
     *
     * @param inputs List of inputs
     * @return Y, the sum
     */
    public double computeY(List<Double> inputs, Neuron neuron) throws Exception {
        if (inputs.size() + 1 != neuron.getWeights().size())
            throw new Exception("Size miss match");

        double sum = 0.0;
        int i;
        for (i = 0; i < inputs.size(); i++) {
            sum += inputs.get(i) * neuron.getWeights().get(i);
        }
        // Accounting for bias
        sum += neuron.getWeights().get(i);

        return sum;
    }

    public abstract double computeDerivative(Double currentInput);

    public abstract double computeOutput(Double y);
}
