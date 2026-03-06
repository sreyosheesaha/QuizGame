import java.util.*;

public class QuizGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String playAgain;

        do {

            System.out.println("===== SMART QUIZ GAME =====");
            System.out.println("Select Difficulty Level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            int level = sc.nextInt();
            sc.nextLine();

            String[] questions;
            String[][] options;
            String[] answers;

            if(level == 1) {

                questions = new String[]{
                        "2 + 2 = ?",
                        "Capital of India?",
                        "Sun rises in the?"
                };

                options = new String[][]{
                        {"a) 3","b) 4","c) 5"},
                        {"a) Delhi","b) Mumbai","c) Chennai"},
                        {"a) West","b) East","c) North"}
                };

                answers = new String[]{"b","a","b"};

            } 
            else if(level == 2) {

                questions = new String[]{
                        "Who invented Java?",
                        "Which planet is Red Planet?",
                        "5 * 6 = ?"
                };

                options = new String[][]{
                        {"a) James Gosling","b) Bill Gates","c) Elon Musk"},
                        {"a) Mars","b) Jupiter","c) Earth"},
                        {"a) 20","b) 30","c) 25"}
                };

                answers = new String[]{"a","a","b"};

            } 
            else {

                questions = new String[]{
                        "Which keyword is used to inherit class in Java?",
                        "Which data structure uses FIFO?",
                        "Which company developed Java?"
                };

                options = new String[][]{
                        {"a) extends","b) implement","c) inherit"},
                        {"a) Stack","b) Queue","c) Tree"},
                        {"a) Sun Microsystems","b) Microsoft","c) Google"}
                };

                answers = new String[]{"a","b","a"};
            }

            int score = 0;
            boolean lifelineUsed = false;

            List<Integer> order = new ArrayList<>();
            for(int i=0;i<questions.length;i++)
                order.add(i);

            Collections.shuffle(order);

            System.out.println("\nType a, b, or c to answer.");
            System.out.println("Type '50' to use 50-50 lifeline (once only)\n");

            for(int index : order) {

                System.out.println("Question: " + questions[index]);

                for(String op : options[index])
                    System.out.println(op);

                System.out.print("Your answer: ");
                String userAnswer = sc.nextLine();

                if(userAnswer.equals("50") && !lifelineUsed) {

                    lifelineUsed = true;
                    System.out.println("50-50 Lifeline Used!");

                    if(answers[index].equals("a")) {
                        System.out.println(options[index][0]);
                        System.out.println(options[index][1]);
                    }
                    else if(answers[index].equals("b")) {
                        System.out.println(options[index][1]);
                        System.out.println(options[index][2]);
                    }
                    else {
                        System.out.println(options[index][0]);
                        System.out.println(options[index][2]);
                    }

                    System.out.print("Choose again: ");
                    userAnswer = sc.nextLine();
                }

                if(userAnswer.equalsIgnoreCase(answers[index])) {
                    System.out.println("Correct!\n");
                    score++;
                }
                else {
                    System.out.println("Wrong!");
                    System.out.println("Correct Answer: " + answers[index] + "\n");
                }
            }

            int percentage = (score * 100) / questions.length;

            System.out.println("===== QUIZ RESULT =====");
            System.out.println("Score: " + score + "/" + questions.length);
            System.out.println("Percentage: " + percentage + "%");

            if(percentage == 100)
                System.out.println("Performance: Quiz Champion!");
            else if(percentage >= 60)
                System.out.println("Performance: Good Knowledge!");
            else
                System.out.println("Performance: Needs Improvement!");

            System.out.println("\nPlay again? (yes/no)");
            playAgain = sc.nextLine();

        } while(playAgain.equalsIgnoreCase("yes"));

        sc.close();
    }
}