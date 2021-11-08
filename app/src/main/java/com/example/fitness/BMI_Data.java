package com.example.fitness;

public class BMI_Data {
    private String status;
    private String bmiResult ;
    private int weight ;
    private int height ;
    private boolean flag;
    private boolean flagBMI;

    public BMI_Data() {
    }

    public BMI_Data(String status, String bmiResult, int weight, int height, boolean flag, boolean flagBMI) {
        this.status = status;
        this.bmiResult = bmiResult;
        this.weight = weight;
        this.height = height;
        this.flag = flag;
        this.flagBMI = flagBMI;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBmiResult() {
        return bmiResult;
    }

    public void setBmiResult(String bmiResult) {
        this.bmiResult = bmiResult;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlagBMI() {
        return flagBMI;
    }

    public void setFlagBMI(boolean flagBMI) {
        this.flagBMI = flagBMI;
    }
}
