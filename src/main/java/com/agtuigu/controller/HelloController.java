package com.agtuigu.controller;

import com.agtuigu.entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import sun.util.calendar.LocalGregorianCalendar;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

/**
 * @author sevenbooks
 * @date 2020/5/8 - 0:03
 */
@Controller
//@SessionAttributes(value = "user", types = {String.class})
@RequestMapping("springmvc")
public class HelloController {

    private static final String SUCCESS = "success";


    /**
     * @PathVariable可以映射url中的占位符到方法的参数中
     * @param id
     * @return
     */
    @RequestMapping("testPathVariable/{id}")
    // 注意:
    public String testPathVariable(@PathVariable(value = "id") Integer id){
        System.out.println("id:"+ id);
        return SUCCESS;
    }

    @RequestMapping("helloworld")
    public String hello(){
        System.out.println("hello!");
        return SUCCESS;
    }


    @RequestMapping("helloworld2")
    public String hello2(){
        System.out.println("hello2!");
        return SUCCESS;
    }

    @RequestMapping(value="testMethod",method = RequestMethod.POST)
    public String testMethod(){

        return SUCCESS;
    }


    @RequestMapping(value="testParam", params = {"username", "age!=10"})
    public String testParam(){

        return SUCCESS;
    }


    @RequestMapping("wobushuijiao")
    public String wobuhsuijiao(){
        System.out.println("=====");
        return SUCCESS;
    }


    @RequestMapping("haha")
    public String haha(){
        return SUCCESS;
    }


    /**
     * rest风格的url
     * 如何发送put请求和delete请求呢?
     * 1.需要配置hiddenhttpMethodFilter
     * 2.需要发送post请求
     * 3.在发送post请求的时候携带一个name="_method"的隐藏域,值为DELETE或PUT
     * @param id
     * @return
     */

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable(value = "id") Integer id){
        System.out.println("testRest put" + id);
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable(value = "id") Integer id){
        System.out.println("testRest delete" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRestPost(){
        System.out.println("testRest post");
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable(value = "id") Integer id){
        System.out.println("testRest GET" + id);
        return SUCCESS;
    }



    @RequestMapping(value = "testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password",required = false, defaultValue = "0") String password){
        System.out.println("testRequestParam方法");
        System.out.println("testRequestParam" + username + password);

        return SUCCESS;
    }


    @RequestMapping(value = "testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al){
        System.out.println(al);

        return SUCCESS;
    }


    @RequestMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println(cookie);

        return SUCCESS;
    }


    @RequestMapping(value = "testPojo")
    public String testPojo(User user){
        System.out.println("testPojo" + user);
        return SUCCESS;
    }


    @RequestMapping(value = "testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){

        System.out.println(request + "," +response);
        return SUCCESS;
    }


    @RequestMapping(value = "testServletWriter")
    public void testServletWriter(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {

        out.write("hello!");
//        return ;
    }


    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time", new Date());

        return modelAndView;

    }


    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map){
        User user = new User(1, "tmo", "22333", "66@jd.com", 19);
        map.put("user", user);
        map.put("school", "hahahahaha");

        return SUCCESS;

    }


    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user){
        System.out.println("修改以后的user:" + user);

        return SUCCESS;

    }


    @ModelAttribute
    public void getUser(Map<String, Object> map){
        System.out.println("modelAttribute method....");
        User user = new User(1,"tom", "123456", "tom@jd.com",12);

        map.put("abc", user);


    }



    @RequestMapping(value = "testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/pages/success.jsp";
    }



    @RequestMapping(value = "testMethodHaHa", method = RequestMethod.POST)
    public String testMethodHaHa(){

        return SUCCESS;
    }


    /**
     * 通配符,了解一下即可
     * @return
     */
    @RequestMapping(value = "testAntPath/*/abc" )
    public String testAntPath(){
        return SUCCESS;
    }


    @ResponseBody
    @RequestMapping(value = "testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "hello" + new Date();
    }




    @RequestMapping("testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession httpSession) throws IOException {
        byte[] body  =null;
//        InputStream in = httpSession.getServletContext().getResourceAsStream("/index.txt");
        body = "hellohhhhhhhhh".getBytes();
//        in.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");

        HttpStatus status = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, status);
        return response;
    }



    @RequestMapping("testFileUpload")
    public String testFileUpload( @RequestParam(value = "description") String desc, @RequestParam(value = "file") MultipartFile file) throws IOException {
//        System.out.println(desc);
        System.out.println("OriginalFilename" + file.getOriginalFilename());
        System.out.println("InputStream" + file.getInputStream()); // 可以拿到流
        return SUCCESS;
    }


    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex){
        System.out.println(ex + "出异常啦");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", ex);

        return modelAndView;
    }


    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam(value = "i") int i){
        System.out.println("result: " + (10 / i));
        return "success";
    }













}
