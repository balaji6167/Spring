// 📘 Dependency Injection (DI) Setter Injection – Spring Example
// 🚀 What is Dependency Injection?

// Dependency Injection (DI) means:

// 👉 Providing required values (dependencies) to an object from outside
// 👉 Instead of creating or setting them inside the class

// In Spring:

// Dependencies are injected using XML / Annotations
// No need to manually set values in code

// You created a Student class where:

// id and studentName are dependencies
// These values are injected using Spring XML

📂 Code Explanation
🔹 1. Student Class

package com.dependancyinjection;

import java.security.Key;

import javax.swing.Spring;

public class Student {

    private int id;
    private String studentName;

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void displayStudentNameInfo() {
        System.out.println("Student name is : " + studentName + " and the id is : " + id);
    }
}

// 👉 Key Point:
// No constructor used
// Values are set using setter methods
// That’s why it's called Setter Injection

// 🔹 2. beans.xml (Configuration)
<bean id="student" class="com.dependancyinjection.Student">
    <property name="studentName" value="Balaji Paramasivam"/>
    <property name="id" value="1"/>
</bean>

<bean id="ashish" class="com.dependancyinjection.Student">
    <property name="studentName" value="Balaji P"/>
    <property name="id" value="2"/>
</bean>

// 👉 Key Point:

// <property> is used for setter injection
// Spring internally calls:
// setStudentName()
// setId()

// 🔹 3. Main Class (Exam)

package com.dependancyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {

    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("com/dependancyinjection/beans.xml");

        Student balaji = context.getBean("student", Student.class);
        balaji.displayStudentNameInfo();

        Student ashish = context.getBean("ashish", Student.class);
        ashish.displayStudentNameInfo();
    }
}

// ⚙️ How It Works :

// Spring reads beans.xml
// Creates Student objects
// Injects values using setter methods
// Returns objects when getBean() is called

// 🧪 Output :
// Student name is : Balaji Paramasivam and the id is : 1
// Student name is : Balaji P and the id is : 2