package com.ucp.DAO.neuralNetwork;

import com.ucp.DAO.neuralNetwork.functions.AbstractFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Neuron {
    private final static double learningRate = 0.01;
    private List<Double> weights;
    private AbstractFunction activationFunction;

    public Neuron(int weightsNumber, AbstractFunction activationFunction) {
        this.activationFunction = activationFunction;
        this.initWeights(weightsNumber);
    }

    /**
     * Generate random weights for the neuron
     * Take in account the bias
     * So weightsNumber must be equal to number of inputs + 1
     *
     * @param weightsNumber number of weights to generate, take bias in account
     */
    private void initWeights(int weightsNumber) {
        this.weights = new ArrayList<Double>();
        for (int i = 0; i < weightsNumber; i++) {
            this.weights.add(new Random().nextDouble());
        }
    }

    public double computeOutput(List<Double> inputs) throws Exception {
        return this.activationFunction.computeOutput(this.activationFunction.computeY(inputs, this));
    }

    public double train(double expectedValue, List<Double> inputs) throws Exception {
        if (inputs.size() + 1 != this.getWeights().size())
            throw new Exception("Size miss match");

        int i;
        double deltaError = expectedValue - this.computeOutput(inputs);
        for (i = 0; i < inputs.size(); i++) {
            this.weights.set(i, this.weights.get(i) + deltaError * Neuron.learningRate * this.activationFunction.computeDerivative(inputs.get(i)));
        }
        // Bias
        this.weights.set(i, this.weights.get(i) + deltaError * Neuron.learningRate * this.activationFunction.computeDerivative(1.0));

        return deltaError;
    }

    public List<Double> getWeights() {
        return weights;
    }
}
