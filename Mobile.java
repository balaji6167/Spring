// 📘 Spring IOC (Inversion of Control) – Basic Example
// 🚀 What is Spring IOC?

// Inversion of Control (IOC) is a concept in Spring where the framework takes control of object creation.

// 👉 Instead of creating objects using new,
// 👉 Spring container creates and manages objects for us.

// This helps in:

// Reducing tight coupling
// Making code flexible
// Easy to switch implementations

// how Spring IOC works using a simple example of a Mobile with different SIM providers.

// We have:

// An interface Sim
// Multiple implementations (Airtel, Jio, Vodaphone)
// Spring XML configuration to decide which implementation to use

// 📂 Code Explanation
// 🔹 1. Sim Interface

// Defines common behavior for all SIM providers.

package com.spring.ioc;

public interface Sim {
    void calling();
    void data();
}

// 🔹 2. Airtel Class

// Implements Sim interface.

package com.spring.ioc; 

public class Airtel implements Sim {
    public Airtel() {
        System.out.println("airtel constructor called");
    }

    @Override
    public void calling() {
        System.out.println("calling using airtel mobile");
    }

    @Override
    public void data() {
        System.out.println("Browsing internet using airtel sim");
    }
}

// 🔹 3. Jio Class
package com.spring.ioc;

public class Jio implements Sim {
    public void calling() {
        System.out.println("calling using jio sim");
    }

    public void data() {
        System.out.println("browsing internet using jio sim");
    }
}

// 🔹 4. Vodaphone Class
package com.spring.ioc;

public class Vodaphone implements Sim {

    @Override
    public void calling() {
        System.out.println("calling using vodaphone mobile");
    }

    @Override
    public void data() {
        System.out.println("browsing internet using vodaphone sim");
    }
}

// 🔹 5. Spring Configuration (beans.xml)
// Defines which class object Spring should create.

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="sim" class="com.spring.ioc.Jio"/>
</beans>

// 👉 You can change implementation here without modifying Java code.

// 🔹 6. Main Class (Mobile)

package com.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("com/spring/ioc/beans.xml");

        System.out.println("config loaded successfully");

        Sim sim = context.getBean("sim", Sim.class);
        sim.calling();
        sim.data();
    }
}


// ⚙️ How It Works:

// Spring reads beans.xml
// Creates object of Jio class
// Stores it in IOC container
// getBean() returns that object
// Methods are executed

// 🧪 Output:

// config loaded successfully
// calling using jio sim
// browsing internet using jio sim
// 💡 Key Takeaways
// Spring manages object creation
// No need to use new keyword
// Easy to switch implementations
// Promotes loose coupling

// 🔄 Flexibility Example
// Change this:

// <bean id="sim" class="com.spring.ioc.Airtel"/>

// 👉 Now Airtel will be used without changing Java code.