package example;

public class Test {
    public static void main(String[] args) {
        Employee boss = new Employee("Boss", null);
        Employee a = new Employee("A", boss);
        Employee b = new Employee("B", a);
        Employee c = new Employee("C", b);
        Employee emp = new Employee("D", c);
        if (emp.supervisor == null) {
            System.out.println(emp.name + " is the boss!");
        } else {
            Employee runner; // For "running" up the chain of command.
            runner = emp.supervisor;
            if (runner.supervisor == null) {
                System.out.println(emp.name + " reports directly to the boss.");
            } else {
                int count = 0;
                while (runner.supervisor != null) {
                    count++; // Count the supervisor on this level.
                    runner = runner.supervisor; // Move up to the next level.
                }
                System.out.println("There are " + count
                        + " supervisors between " + emp.name
                        + " and the boss.");
            }
        }
    }

    static class Employee {
        private String name;
        public Employee supervisor;

        public Employee(String name, Employee supervisor) {
            this.name = name;
            this.supervisor = supervisor;
        }
    }
}
