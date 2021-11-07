package Fitness_Exercises;

public class Exercises {

    private String nameOfExercises;
    private String howToPlay;
    private String level;
    private String status;

    public Exercises() {
    }


    public Exercises(String nameOfExercises,String status, String level, String howToPlay ) {
        this.nameOfExercises = nameOfExercises;
        this.howToPlay = howToPlay;
        this.status=status;
        this.level = level;
    }

    public String getNameOfExercises() {
        return nameOfExercises;
    }

    public void setNameOfExercises(String nameOfExercises) {
        this.nameOfExercises = nameOfExercises;
    }

    public String getHowToPlay() {
        return howToPlay;
    }

    public void setHowToPlay(String howToPlay) {
        this.howToPlay = howToPlay;
    }



    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}