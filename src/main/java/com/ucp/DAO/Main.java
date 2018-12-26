package com.ucp.DAO;

import com.ucp.DAO.neuralNetwork.Neuron;
import com.ucp.DAO.neuralNetwork.charts.GraphFrame;
import com.ucp.DAO.neuralNetwork.functions.Linear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
        List<Double> exampleC = new ArrayList<Double>();
        exampleC.add(1.0);
        exampleC.add(1.0);
        exampleC.add(1.0);
        exampleC.add(1.0);
        exampleC.add(1.0);
        exampleC.add(1.0);
        exampleC.add(0.0);
        exampleC.add(0.0);
        exampleC.add(0.0);
        exampleC.add(1.0);
        exampleC.add(0.0);
        exampleC.add(0.0);
        exampleC.add(0.0);
        exampleC.add(1.0);
        exampleC.add(0.0);
        exampleC.add(0.0);
        exampleC.add(0.0);
        exampleC.add(1.0);
        exampleC.add(1.0);
        exampleC.add(1.0);
        exampleC.add(1.0);

        Neuron neuron = new Neuron(exampleC.size() +1,new Linear());
        List<Double> errors = new ArrayList<Double>();

        for (int i = 0; i < 1000; i++) {
            try {
                errors.add(neuron.train(1.0,exampleC));
                logger.trace("Error : " + errors.get(i));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       /* GraphFrame graphFrame = new GraphFrame("Neural Network evolution",errors);
        graphFrame.pack();
        RefineryUtilities.centerFrameOnScreen( graphFrame );
        graphFrame.setVisible( true );
        */
    }
}
