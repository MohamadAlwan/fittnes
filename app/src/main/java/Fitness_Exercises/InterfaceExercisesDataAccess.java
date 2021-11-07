package Fitness_Exercises;

import java.util.List;

public interface InterfaceExercisesDataAccess {
    List<Exercises> getExercises(String level,String exerc,String status);

    String[] getExercises(); //to get data that's will fill in the ListView
    String[] getLevel();//to get data that's will fill in the Spinner
}
