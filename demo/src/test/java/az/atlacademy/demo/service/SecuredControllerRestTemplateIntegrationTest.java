//package az.atlacademy.demo.service;
//
//import az.atlacademy.demo.dto.OrderDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class SecuredControllerRestTemplateIntegrationTest {
//
//    @Autowired
//    private TestRestTemplate template;
//
//
//
//    @Test
//    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
//        ResponseEntity<OrderDto[]> result = template.withBasicAuth("spring", "secret")
//                .getForEntity("/private/hello", OrderDto[].class);
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//    }
//}
//
