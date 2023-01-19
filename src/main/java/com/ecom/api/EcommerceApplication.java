package com.ecom.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;
import java.util.Map;


@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class EcommerceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // GitHub Copilot
        List<String> fiveNames = List.of("John", "Paul", "George", "Ringo", "Pete");

        List<Integer> ages = List.of(20, 21, 22, 23, 24);

        Map<String, Integer> mapNameToAge = Map.ofEntries(
                Map.entry(fiveNames.get(0), ages.get(0)),
                Map.entry(fiveNames.get(1), ages.get(1)),
                Map.entry(fiveNames.get(2), ages.get(2)),
                Map.entry(fiveNames.get(3), ages.get(3)),
                Map.entry(fiveNames.get(4), ages.get(4))
        );

        averageAge(ages);
        sum(ages);
        findOlderPerson(ages);
        findYoungerPerson(ages);

        fibonacci(10);

        getLastName(fiveNames);
        getFirstName(fiveNames);




    }

    private void findYoungerPerson(List<Integer> ages) {
        int youngerPerson = ages.stream().min(Integer::compareTo).get();
        log.info("The younger person is {}", youngerPerson);
    }

    private void sum(List<Integer> ages) {
        int sum = 0;
        for (Integer age : ages) {
            sum += age;
        }
        log.info("Sum of ages is {}", sum);
    }

    private void findOlderPerson(List<Integer> ages) {
        int olderPerson = ages.stream().max(Integer::compareTo).orElse(0);
        log.info("The older person is {}", olderPerson);
    }

    private void getFirstName(List<String> fiveNames) {
        log.info("First name: {}", fiveNames.get(0));
    }

    private void getLastName(List<String> fiveNames) {
        String lastName = fiveNames.get(fiveNames.size() - 1);
        log.info("Last name is {}", lastName);
    }

    private void fibonacci(int i) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int j = 0; j < i; j++) {
            c = a + b;
            a = b;
            b = c;
        }
    }

    private void averageAge(List<Integer> ages) {
        int sum = 0;
        for (int age : ages) {
            sum += age;
        }
        int average = sum / ages.size();
        log.info("Average age is {}", average);
    }

}
