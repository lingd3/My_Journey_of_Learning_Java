package com.demo.loosely_coupled;

public class OutputHelper {
	IOutputGenerator outputGenerator;
	
	public void generateOutput(){
        this.outputGenerator.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator){
        this.outputGenerator = outputGenerator;
    }
}
