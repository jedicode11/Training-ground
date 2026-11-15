package com.luv2code.springboot.thymeleafdemo;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:employees;MODE=MySQL",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
@Transactional
class ThymeleafdemoApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebApplicationContext context;

    @Test
    void rejectsBlankEmployeeFieldsAndRendersTheForm() throws Exception {
        MockMvcBuilders.webAppContextSetup(context).build()
                .perform(post("/employees/save")
                        .param("firstName", " ")
                        .param("lastName", "")
                        .param("email", ""))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("employee", "firstName", "lastName", "email"))
                .andExpect(content().string(containsString("is required")));

        assertThat(employeeRepository.count()).isZero();
    }

    @Test
    void updatesAnExistingEmployeeAndRendersTheList() throws Exception {
        Employee employee = employeeRepository.save(new Employee("Ada", "Byron", "ada@example.com"));
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();

        mvc.perform(post("/employees/save")
                        .param("id", Integer.toString(employee.getId()))
                        .param("firstName", "Ada")
                        .param("lastName", "Lovelace")
                        .param("email", "ada@example.com"))
                .andExpect(redirectedUrl("/employees/list"));

        mvc.perform(get("/employees/list"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Lovelace")));
        assertThat(employeeRepository.count()).isEqualTo(1);
    }
}
