//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        // Repositories
        InMemoryUserRepository userRepository =
                new InMemoryUserRepository();

        InMemoryProblemRepository problemRepository =
                new InMemoryProblemRepository();

        InMemorySolutionRepository solutionRepository =
                new InMemorySolutionRepository();

        // Strategy
        ScoringStrategy scoringStrategy =
                new DefaultScoringStrategy();

        // Services
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

        //----------------------------
        // Register Users
        //----------------------------

        User prasun = userService.addUser(
                "Prasun",
                "Engineering"
        );

        User rahul = userService.addUser(
                "Rahul",
                "Computer Science"
        );

        //----------------------------
        // Add Problems
        //----------------------------

        Problem p1 = new Problem(
                "P1",
                "Two Sum",
                "Find two numbers",
                "Array",
                Difficulty.EASY,
                100
        );

        Problem p2 = new Problem(
                "P2",
                "Word Ladder",
                "Shortest Transformation",
                "Graph",
                Difficulty.HARD,
                300
        );

        Problem p3 = new Problem(
                "P3",
                "Coin Change",
                "Minimum Coins",
                "DP",
                Difficulty.MEDIUM,
                200
        );

        problemService.addProblem(p1);
        problemService.addProblem(p2);
        problemService.addProblem(p3);

        //----------------------------
        // Solve Problems
        //----------------------------

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

        //----------------------------
        // Fetch Solved Problems
        //----------------------------

        System.out.println("Solved by Prasun:");

        for (Problem p : contestService.fetchSolvedProblems(prasun.getId())) {

            System.out.println(
                    p.getName()
            );
        }

        //----------------------------
        // Problem Statistics
        //----------------------------

        System.out.println();

        System.out.println("Problem : " + p1.getName());

        System.out.println("Solved Count : "
                + p1.getSolvedCount());

        System.out.println("Average Time : "
                + p1.getAverageTime());

        //----------------------------
        // Leader
        //----------------------------

        User leader = contestService.getLeader();

        System.out.println();

        System.out.println("Leader");

        System.out.println(
                leader.getName()
                        + " - "
                        + leader.getDepartment()
        );

        //----------------------------
        // Top Problems
        //----------------------------

        List<Problem> topDPProblems =
                problemService.getTopNProblems("DP", 10);

        System.out.println();

        System.out.println("Top DP Problems");

        for (Problem problem : topDPProblems) {
            System.out.println(problem.getName());
        }

    }
}