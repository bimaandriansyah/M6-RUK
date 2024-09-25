class Course {
    String courseName;
    Teacher teacher;

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Taught by: " + teacher.name);
    }
}