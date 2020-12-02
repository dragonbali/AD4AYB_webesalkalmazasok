package hu.ad4ayb.web.rep;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import hu.ad4ayb.web.dto.StudentDto;
import hu.ad4ayb.web.dto.TaskDto;
import hu.ad4ayb.web.dto.TeacherDto;
import lombok.Getter;

@Repository
public class ListingRepository implements InterfaceListingRepository {

    public Boolean notOrLate(Date deadline, Date receiptTime) {
        if (receiptTime == null) return false;
        return deadline.compareTo(receiptTime) > 0;
    }

    public List < Boolean > isOkList(List < StudentDto > students) {
        List < Boolean > result = new ArrayList < Boolean > ();

        for (StudentDto student: students) {
            int notReadyCounter = 0;
            for (TaskDto task: student.getTasks()) {
                if ((task.getReceiptTime() == null) || (task.getDeadline().compareTo(task.getReceiptTime()) < 0)) {
                    notReadyCounter++;
                }
            }
            if (notReadyCounter > 0) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }


    @PostConstruct
    public void setDB() {
        fakeDBSet();
    }

    @SuppressWarnings("deprecation")
    Date deadline1 = new Date(2020 - 1900, 5, 20);

    @SuppressWarnings("deprecation")
    Date receiptTime1 = new Date(2020 - 1900, 5, 12);

    @SuppressWarnings("deprecation")
    Date deadline2 = new Date(2020 - 1900, 6, 20);

    @SuppressWarnings("deprecation")
    Date receiptTime2 = new Date(2020 - 1900, 6, 22);

    @SuppressWarnings("deprecation")
    Date deadline3 = new Date(2020 - 1900, 5, 10);

    @SuppressWarnings("deprecation")
    Date receiptTime3 = new Date(2020 - 1900, 5, 8);

    @Getter
    List < StudentDto > students = new ArrayList < StudentDto > ();
    List < TeacherDto > teachers = new ArrayList < TeacherDto > ();
    List < TaskDto > tasks1 = new ArrayList < TaskDto > ();
    List < TaskDto > tasks2 = new ArrayList < TaskDto > ();

    TaskDto testTask = new TaskDto("Töri ZH", deadline1, receiptTime1, "negyedik világháború régen lesz. Mindent le tudok róla írni.", "nagyon jo megoldas!");
    TaskDto testTask2 = new TaskDto("Töri Vizsga", deadline2, receiptTime2, "honfoglalás 896-ban volt, de nem tudom kik csinálták.", "ez nagyon rossz volt!");
    TaskDto testTask3 = new TaskDto("Közös Testnevelés", deadline3, receiptTime3, "konditerem (10 alkalmat teljesítette)", "Nagyon izmos lettél!");
    TaskDto testTask4 = new TaskDto("Honvédelmi ismeretek", deadline3, null, "-", "Nem adtál be semmit...");

    TeacherDto testTeacher = new TeacherDto("Anna Néni", students);
    TeacherDto testTeacher2 = new TeacherDto("Feri Bácsi", students);

    StudentDto testStud = new StudentDto("Aladár", teachers, tasks1);
    StudentDto testStud2 = new StudentDto("Béla", teachers, tasks2);

    public void fakeDBSet() {
        students.add(testStud);
        students.add(testStud2);
        teachers.add(testTeacher);
        teachers.add(testTeacher2);
        tasks1.add(testTask);
        tasks2.add(testTask2);
        tasks2.add(testTask3);
        tasks2.add(testTask4);
    }
}