package library;

public class StudentRecord {
    public String surname;
    public String name;
    public int studentNo;
    public float averageMark;

   //setAverageMark method defined below 
    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString(){
        String str = "Full Name: " + surname + " " + name + '\n' +
                     "Student Number: " + studentNo +  '\n' +
                     "Average Mark: " + averageMark +  '\n';
        return str;
    }


    public StudentRecord(String surname, String name, int studentNo){
        this.surname = surname;
        this.name = name;
        this.studentNo = studentNo;
        this.averageMark = 0;
    }

    public StudentRecord(String surname, String name, int studentNo, float mark){
        this.surname = surname;
        this.name = name;
        this.studentNo = studentNo;
        this.averageMark = mark;
    }

}
