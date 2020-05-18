<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="helloworld">helloworld</a>
<br/>
<a href="/springmvc/helloworld2">helloworld2</a>
<br/>
<a href="/springmvc/testMethod">testMethod</a>
<br/>

<%--<form action="/springmvc/testMethod" method="post">--%>
<%--    <input type="text" name="username" value="用户名" />--%>
<%--    <input type="password" name="password" value="密码" />--%>
<%--    <input type="submit"/>--%>
<%--</form>--%>


<a href="/springmvc/testParam?username=atguigu&age=10">testParam</a>
<br/>

<a href="/springmvc/testPathVariable/1">testPathVariable</a>
<br/>

<a href="/springmvc/wobushuijiao">wobushuijiao</a>
<br/>

<a href="/springmvc/haha">haha</a>
<br/>


<a href="springmvc/testRest/1">testRest get</a>

<form action="/springmvc/testRest" method="post">
    <input type="submit" value="testrest post">
</form>

<form action="/springmvc/testRest/1" method="post">
    <input type="hidden" name="method" value="delete">
    <input type="submit" value="testrest delete">
</form>

<form action="/springmvc/testRest/1" method="post">
    <input type="hidden" name="method" value="put">
    <input type="submit" value="testrest put">
</form>



<br/>
<br/>
<br/>
<br/>
<a href="/springmvc/testRequestParam?username=atguigu&password=1234">点我提交请求参数</a>

<a href="/springmvc/testRequestHeader">请求头</a>

<a href="/springmvc/testCookieValue">testCookieValue</a>


<form action="springmvc/testPojo" method="post">
    username: <input type="text" name="username"/>
    <br>
    password: <input type="password" name="password"/>
    <br>
    emai: <input type="text" name="email"/>
    <br>
    age: <input type="text" name="age"/>
    <br>

    province: <input type="text" name="address.province"/>
    <br>
    city: <input type="text" name="address.city"/>
    <br>
    <input type="submit" value="提交"/>
</form>


<a href="springmvc/testServlet">testServlet</a>
<a href="springmvc/testServletWriter">testServletWriter</a>
<a href="springmvc/testModelAndView">testModelAndView</a>
<a href="springmvc/testSessionAttributes">testSessionAttributes</a>


<br>

<form action="/springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1"/>
    username: <input type="text" name="username" value="tom"/>
    <br>

    emai: <input type="text" name="email" value="tom@jd.com"/>
    <br>
    age: <input type="text" name="age" value="12"/>
    <br>

    <input type="submit" value="提交"/>
</form>



<a href="/springmvc/testRedirect">testRedirect</a>


<a href="/springmvc/testJson" id="testJson">testRedirect</a>

<br>
<br>

<script type="text/javascript" src="scripts/jquery-3.5.0.js"></script>
<script>
    $(function () {
        $("#testJson").click(function () {
            var url = this.href;
            var args = {};
            $.post(url, args, function (data) {
                data[]
            });

        });
    });
</script>



<br>
<br>
<form action="/springmvc/testMethodHaHa" method="post">
    <input type="submit" value="提交">
</form>


<a href="/springmvc/testAntPath/mvn/abc">testAntPath</a>



<a href="/springmvc/testRest/1"></a>


<a href="/yanghelin">返回json数据</a>
<a href="/getShopListJson">返回jsonList数据</a>






<form action="/springmvc/testHttpMessageConverter" method="post" enctype="multipart/form-data">

   文件: <input type="file" name="file"/>
   描述: <input type="text" name="desc"/>
    <input type="submit" name="提交"/>
</form>



<br>
<br>
<br>
<a href="/springmvc/testResponseEntity">文件下载</a>

<br>
<br>
<br>

<form action="/springmvc/testFileUpload" method="post" enctype="multipart/form-data">

    文件: <input type="file" name="file"/>
    描述: <input type="text" name="description"/>
    <input type="submit" name="提交"/>
</form>

<br>
<br>
<br>


</form>


<a href="/springmvc/testExceptionHandlerExceptionResolver?i=10">testExceptionHandlerExceptionResolver</a>

</body>
</html>
