package com.jgaap.classifiers;

import weka.classifiers.Classifier;

public class WEKAJ48DecisionTree extends WEKAAnalysis {

	@Override
	public String displayName() {
		return "WEKA J48 Decision Tree Classifier";
	}

	@Override
	public String tooltipText() {
		return "J48 Decision Tree Classifier, Courtesy of WEKA";
	}

	@Override
	public boolean showInGUI() {
		return false;
	}
	
	public Classifier getClassifier() {
		return (Classifier)(new weka.classifiers.trees.J48());
	}

}
