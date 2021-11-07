package Fitness_Exercises;

import java.util.ArrayList;
import java.util.List;

class ExercisesDataAccess implements InterfaceExercisesDataAccess {

 private ArrayList<Exercises> exercises = new ArrayList<>();

 public ExercisesDataAccess() {
  exercises.add(new Exercises("Legs","Under Weight","Hard","1. Goblet squat: 5 sets of 12 reps\n 2. Pendulum lunges: 5 sets of 12 reps on each leg\n" +
          "3. Romanian deadlifts: 5 sets of 12 reps\n 4. Step-ups: 5 sets of 12 reps on each leg"));
  exercises.add(new Exercises("Legs","Under Weight","Normal","1. Goblet squat: 3 sets of 12 reps\n 2. Pendulum lunges: 3 sets of 10 reps on each leg\n" +
          "3. Romanian deadlifts: 3 sets of 12 reps\n 4. Step-ups: 3 sets of 10 reps on each leg"));
  exercises.add(new Exercises("Chest","Under Weight","Hard","1. Regular push-ups: 5 sets of 12 reps\n 2. Incline push-ups: 5 sets of 12 reps\n" +
          "3. Decline push-ups: 5 sets of 12 reps\n 4. Time under tension push-ups: 5 sets of 12"));
  exercises.add(new Exercises("Chest","Under Weight","Normal","1. Regular push-ups: 3 sets of 12 reps\n 2. Incline push-ups: 3 sets of 10 reps\n" +
          "3. Decline push-ups: 3 sets of 11 reps\n 4. Time under tension push-ups: 3 sets of 12 reps"));
  exercises.add(new Exercises("Back With Shoulders","Under Weight","Hard","1. Bent-Over Row: 4 sets of 12 reps\n 2. Single-Arm Row: 5 sets of 14 reps\n" +
          "3. Reverse Fly: 5 sets of 13 reps\n 4. Overhead Shoulder Press: 7 sets of 12 reps"));
  exercises.add(new Exercises("Back With Shoulders","Under Weight","Normal","1. Bent-Over Row: 3 sets of 8 reps\n 2. Single-Arm Row: 5 sets of 12 reps\n" +
          "3. Reverse Fly: 5 sets of 11 reps\n 4. Overhead Shoulder Press: 5 sets of 12 reps"));

  exercises.add(new Exercises("Legs","Over Weight","Hard","1. Goblet squat: 7 sets of 10 reps\n 2. Pendulum lunges: 7 sets of 10 reps\n" +
          "3. Romanian deadlifts: 7 sets of 10 reps\n 4. Step-ups: 7 sets of 10 reps"));
  exercises.add(new Exercises("Legs","Over Weight","Normal","1. Goblet squat: 3 sets of 10 reps\n 2. Pendulum lunges: 3 sets of 10 reps" +
          "3. Romanian deadlifts: 3 sets of 10 reps\n 4. Step-ups: 3 sets of 10 reps"));
  exercises.add(new Exercises("Chest","Over Weight","Hard","1. Regular push-ups: 5 sets of 14 reps\n 2. Incline push-ups: 6 sets of 10 reps\n" +
          "3. Decline push-ups: 8 sets of 11 reps\n 4. Time under tension push-ups: 8 sets of 12 reps"));
  exercises.add(new Exercises("Chest","Over Weight","Normal","1. Regular push-ups: 4 sets of 13 reps\n 2. Incline push-ups: 7 sets of 6 reps\n" +
          "3. Decline push-ups: 4 sets of 11 reps\n 4. Time under tension push-ups: 4 sets of 12 reps"));
  exercises.add(new Exercises("Back With Shoulders","Over Weight","Hard","1. Bent-Over Row: 4 sets of 10 reps\n 2. Single-Arm Row: 5 sets of 10 reps\n" +
          "3. Reverse Fly: 5 sets of 13 reps\n 4. Overhead Shoulder Press: 5 sets of 12 reps"));
  exercises.add(new Exercises("Back With Shoulders","Over Weight","Normal","1. Bent-Over Row: 4 sets of 8 reps\n 2. Single-Arm Row: 3 sets of 14 reps\n" +
          "3. Reverse Fly: 4 sets of 11 reps\n 4. Overhead Shoulder Press: 4 sets of 10 reps"));

  exercises.add(new Exercises("Legs","Normal Weight","Hard","1. Goblet squat: 8 sets of 14 reps\n 2. Pendulum lunges: 7 sets of 14 reps on each leg\n" +
          "3. Romanian deadlifts: 8 sets of 13 reps\n 4. Step-ups: 7 sets of 11 reps on each leg"));
  exercises.add(new Exercises("Legs","Normal Weight","Normal","1. Goblet squat: 8 sets of 8 reps\n 2. Pendulum lunges: 5 sets of 13 reps on each leg\n" +
          "3. Romanian deadlifts: 4 sets of 13 reps\n 4. Step-ups: 3 sets of 14 reps on each leg"));
  exercises.add(new Exercises("Chest","Normal Weight","Hard","1. Regular push-ups: 4 sets of 15 reps\n 2. Incline push-ups: 5 sets of 12 reps\n" +
          "3. Decline push-ups: 6 sets of 10 reps\n 4. Time under tension push-ups: 4 sets of 13 reps"));
  exercises.add(new Exercises("Chest","Normal Weight","Normal","1. Regular push-ups: 3 sets of 12 reps\n 2. Incline push-ups: 4 sets of 15 reps\n" +
          "3. Decline push-ups: 4 sets of 10 reps\n 4. Time under tension push-ups: 4 sets of 11 reps"));
  exercises.add(new Exercises("Back With Shoulders","Normal Weight","Hard","1. Bent-Over Row: 4 sets of 12 reps\n 2. Single-Arm Row: 4 sets of 14 reps\n" +
          "3. Reverse Fly: 4 sets of 13 reps\n 4. Overhead Shoulder Press: 4 sets of 10 reps"));
  exercises.add(new Exercises("Back With Shoulders","Normal Weight","Normal","1. Bent-Over Row: 4 sets of 8 reps\n 2. Single-Arm Row: 3 sets of 12 reps\n" +
          "3. Reverse Fly: 4 sets of 7 reps\n 4. Overhead Shoulder Press: 3 sets of 12 reps"));
 }

 @Override
 public List<Exercises> getExercises(String level,String exerc,String status) {
  ArrayList<Exercises> data = new ArrayList<>();
  for (Exercises b : exercises) {
   if (b.getLevel().equals(level) && b.getNameOfExercises().equals(exerc) && b.getStatus().equals(status)) {
    data.add(b);
   }

  }
  return data;
 }

 @Override
 public String[] getExercises() {
  String[] cats = {"Legs", "Chest" , "Back With Shoulders"};
  return cats;
 }

 @Override
 public String[] getLevel() {
  String[] cats = {"","Normal", "Hard"};
  return cats;
 }


}
