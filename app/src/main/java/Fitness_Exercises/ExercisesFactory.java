package Fitness_Exercises;

public class ExercisesFactory {
    public  InterfaceExercisesDataAccess getModel(){
        return new ExercisesDataAccess();
    }
}
