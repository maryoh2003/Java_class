package kr.hs.dgsw.c2.d0513;

public class Student implements Runnable {
    private Teacher teacher;
    private String name;

    public Student(Teacher teacher, String name) {
        this.teacher = teacher;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " 학생 스레드가 시작합니다.");
        while (true) {
            System.out.println("학생 스레드가 선생님의 문제 출제를 기다립니다.");
            // 선생님이 문제를 출제할 때 까지 기다린다.
            synchronized (teacher) {
                try {
                    teacher.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + " 학생 스레드가 선생님의 문제를 받았습니다.");

            int value = this.teacher.getValue();
            if (value <= 0) {
                break;
            }
            long answer = calculateFactorial(value);
            System.out.println(String.format("%s: %d! = %d", name, value, answer));
        }
        System.out.println(name + " 학생 스레드가 종료됩니다.");
    }

    private long calculateFactorial (int value) {
        long result = 1;

        for (int i = value; i > 1; i--) {
            result *= (long)i;
        }
        return result;
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        new Thread(teacher).start();

        Student student1 = new Student(teacher, "이원제");
        new Thread(student1).start();

        Student student2 = new Student(teacher, "조민서");
        new Thread(student2).start();

        Student student3 = new Student(teacher, "김진호");
        new Thread(student3).start();

    }
}