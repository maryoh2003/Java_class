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
        System.out.println(name + " �л� �����尡 �����մϴ�.");
        while (true) {
            System.out.println("�л� �����尡 �������� ���� ������ ��ٸ��ϴ�.");
            // �������� ������ ������ �� ���� ��ٸ���.
            synchronized (teacher) {
                try {
                    teacher.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + " �л� �����尡 �������� ������ �޾ҽ��ϴ�.");

            int value = this.teacher.getValue();
            if (value <= 0) {
                break;
            }
            long answer = calculateFactorial(value);
            System.out.println(String.format("%s: %d! = %d", name, value, answer));
        }
        System.out.println(name + " �л� �����尡 ����˴ϴ�.");
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

        Student student1 = new Student(teacher, "�̿���");
        new Thread(student1).start();

        Student student2 = new Student(teacher, "���μ�");
        new Thread(student2).start();

        Student student3 = new Student(teacher, "����ȣ");
        new Thread(student3).start();

    }
}