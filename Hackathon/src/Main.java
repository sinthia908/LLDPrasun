import com.interview.practice.model.Difficulty;
import com.interview.practice.model.Problem;
import com.interview.practice.model.User;
import com.interview.practice.repository.ProblemRepository;
import com.interview.practice.repository.SolutionRepository;
import com.interview.practice.repository.UserRepository;
import com.interview.practice.service.ContestService;
import com.interview.practice.service.ProblemService;
import com.interview.practice.service.UserService;
import com.interview.practice.statergy.DefaultScoringStatergy;
import com.interview.practice.statergy.ScoringStatergy;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //----------------------------------
        // Repositories
        //----------------------------------

        UserRepository userRepository = new UserRepository();
        ProblemRepository problemRepository = new ProblemRepository();
        SolutionRepository solutionRepository = new SolutionRepository();

        //----------------------------------
        // Strategy
        //----------------------------------

        ScoringStatergy scoringStrategy =
                new DefaultScoringStatergy();

        //----------------------------------
        // Services
        //----------------------------------

        UserService userService =
                new UserService(userRepository);

        ProblemService problemService =
                new ProblemService(problemRepository);

        ContestService contestService =
                new ContestService(
                        userRepository,
                        problemRepository,
                        solutionRepository,
                        scoringStrategy
                );

        //----------------------------------
        // Register Users
        //----------------------------------

        User prasun =
                userService.addUser(
                        "Prasun",
                        "Engineering"
                );

        User rahul =
                userService.addUser(
                        "Rahul",
                        "Computer Science"
                );

        //----------------------------------
        // Add Problems
        //----------------------------------

        Problem p1 = new Problem(
                "Two Sum",
                "Find two numbers whose sum equals target",
                "Array",
                Difficulty.EASY,
                100
        );

        Problem p2 = new Problem(
                "Word Ladder",
                "Shortest transformation sequence",
                "Graph",
                Difficulty.HARD,
                300
        );

        Problem p3 = new Problem(
                "Coin Change",
                "Minimum number of coins",
                "DP",
                Difficulty.MEDIUM,
                200
        );

        problemService.addProblem(p1);
        problemService.addProblem(p2);
        problemService.addProblem(p3);

        //----------------------------------
        // Solve Problems
        //----------------------------------

        contestService.solve(
                prasun.getId(),
                p1.getId(),
                120
        );

        contestService.solve(
                prasun.getId(),
                p3.getId(),
                300
        );

        contestService.solve(
                rahul.getId(),
                p1.getId(),
                180
        );

        //----------------------------------
        // Fetch Solved Problems
        //----------------------------------

        System.out.println("Problems solved by Prasun:");

        List<Problem> solvedProblems =
                contestService.fetchSolvedProblems(prasun.getId());

        for (Problem problem : solvedProblems) {
            System.out.println(problem.getName());
        }

        //----------------------------------
        // Problem Statistics
        //----------------------------------

        System.out.println();
        System.out.println("Problem Statistics");
        System.out.println("------------------");

        System.out.println("Problem       : " + p1.getName());
        System.out.println("Solved Count  : " + p1.getSolvedCount());
        System.out.println("Average Time  : " + p1.getAverageTime());

        //----------------------------------
        // Leader
        //----------------------------------

        User leader = contestService.getLeader();

        System.out.println();
        System.out.println("Current Leader");
        System.out.println("--------------");

        System.out.println(
                leader.getName() +
                        " (" +
                        leader.getDepartment() +
                        ")"
        );

        //----------------------------------
        // Top Problems
        //----------------------------------

        System.out.println();
        System.out.println("Top DP Problems");

        List<Problem> topProblems =
                problemService.getTopNProblems("DP", 10);

        for (Problem problem : topProblems) {
            System.out.println(problem.getName());
        }
    }
}