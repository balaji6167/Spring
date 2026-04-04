// 📘 Dependency Injection – Constructor Injection (Spring)
// 🚀 What is Constructor Injection?

// Constructor Injection means:

// 👉 Injecting required values into an object through its constructor
// 👉 Values are provided at the time of object creation by Spring

// This example demonstrates how Spring injects values into a class using constructors.

// We have:

// Student class with multiple constructors
// Spring XML configuration (beans.xml)
// Main class (Exam) to retrieve objects

// 📂 Code Explanation
// 🔹 1. Student Class

package com.dependancyinjection;

public class Student {

    private int id;
    private String studentName;

    public Student(int id) {
        this.id = id;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(int id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public void displayStudentNameInfo() {
        System.out.println("Student name is : " + studentName + " and the id is : " + id);
    }
}

// 👉 This class has multiple constructors, so Spring decides which one to use based on configuration.

// 🔹 2. beans.xml (Configuration)
<bean id="student" class="com.dependancyinjection.Student">
    <constructor-arg value="1"/>
    <constructor-arg value="Balaji Paramasivam"/>
</bean>

<bean id="balaji" class="com.dependancyinjection.Student">
    <constructor-arg value="1"/>
</bean>

<bean id="paramagenius" class="com.dependancyinjection.Student">
    <constructor-arg value="Shivan"/>
</bean>

// 👉 <constructor-arg> is used for constructor injection
// 👉 Values are passed in same order as constructor parameters

🔹 3. Main Class (Exam1)

package com.dependancyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam1{

    public static void main(String[] args) {

        ApplicationContext context =
            new ClassPathXmlApplicationContext("com/dependancyinjection/beans.xml");

        Student student = context.getBean("student", Student.class);
        student.displayStudentNameInfo();

        Student a = context.getBean("balaji", Student.class);
        a.displayStudentNameInfo();

        Student b = context.getBean("paramagenius", Student.class);
        b.displayStudentNameInfo();
    }
}


// ⚙️ How It Works:

// Spring reads beans.xml
// Finds <constructor-arg> values
// Matches them with constructor
// Creates object using that constructor
// Returns object when getBean() is called

// 🧪 Output:

// Student name is : Balaji Paramasivam and the id is : 1
// Student name is : null and the id is : 1
// Student name is : Shivan and the id is : 0