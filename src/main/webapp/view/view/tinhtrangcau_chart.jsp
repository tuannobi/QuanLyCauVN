<%--
  Created by IntelliJ IDEA.
  User: Tuan
  Date: 6/12/2020
  Time: 3:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/view/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/layout/meta.jsp"/>
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/user_create.css">
    <jsp:include page="/view/layout/link.jsp" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

</head>
<body class="xxx">
<jsp:include page="/view/layout/menu.jsp"/>
<div id="content" style="transition: margin-left .5s;">
    <!-- add content -->
    <button id="thongke" class="btn btn-success mt-4 ml-5">Thống kê</button>
    <div class="cover-chart" style="width:600px;height: 600px;margin-left: 200px;">
        <canvas id="bar-chart" width="500" height="500"></canvas>
    </div>
</div>

<script>
    var dropdown = document.getElementsByClassName("dropdown-btn");
    var i;
    for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var dropdownContent = this.nextElementSibling;
            if (dropdownContent.style.display === "block") {
                dropdownContent.style.display = "none";
            } else {
                dropdownContent.style.display = "block";
            }
        });
    }
    $(document).ready(function(){
        let i =0;
        $(".openbtn").click(function(){
            if(i===1){
                $("#mySidebar").css('width','250px');
                $("#main,#content").css('margin-left',"250px");
                i=0;
            }
            else{
                $("#mySidebar").css('width','0');
                $("#main,#content").css('margin-left',"0");
                i=1;
            }
        });
    });
    $(document).ready(function () {
        $('#verticalScroll').DataTable({
            "scrollY": "380px",
            "scrollCollapse": true
        });
        $('.dataTables_length').addClass('bs-select');
    });

    $(document).on("click",".delete",(event)=>{
        let id = event.target.id;
        alert(id);
        $('.xxx').append("<div id='over' style='display:none;width:100%;height:300%;background:#342e2e;position:absolute;top:0;left:0;opacity:0.6;z-index:999999' onclick=clickCloseDialog()></div>");
        $("#content").append("<div class='dialog' style='width: 500px;display: none;position: fixed;overflow: hidden;top: 20%;left: 55%;margin-left: -300px;z-index: 99999999;background-color: #fff;padding-bottom: 15px;'>\
                <div style='padding: 10px;text-transform: uppercase;background-color: tomato;color: #FFF;'>\
                <span>Warning</span>\
                </div>\
                <p>Bạn xác nhận muốn xóa?</p>\
                <div style='display:flex;justify-content: space-evenly;'>\
                    <a href=''><button type='button' class='btn btn-secondary' onclick=clickCloseDialog()>Có</button></a>\
                    <a href=''><button type='button' class='btn btn-secondary' onclick=clickCloseDialog()>Không</button></a>\
                    </div>\
                    </div>");
        $('#over').fadeIn(300);
        $('.dialog').fadeIn(300,function(){
            $('.dialog').css('visibility','visible');
        });
    });

    function clickCloseDialog(){
        $('#over, .dialog').fadeOut(300 , function() {
            $('.dialog').css('visibility','hidden');
            $('body').css('overflow','visible');
        });
        $('#over, .dialog').remove();
    }

    //script biểu đồ
    $(document).ready(()=>{
        $("#thongke").click(()=>{
            $.ajax({
                type:"GET",
                url:"/QuanLyCauVN_war/getThongKeTheoTinhTrangAjax",
                success:function(data){
                    let dataArray=[];
                    let labelArray=[];
                    $.each(data,function(key,value){
                        labelArray.push(key);
                        dataArray.push(value);
                    });
                    new Chart(document.getElementById("bar-chart"), {
                        type: 'bar',
                        data: {
                            labels: labelArray,
                            datasets: [
                                {
                                    label: "Số lượng",
                                    backgroundColor: ["#e1bc10","#d36f24","#d32813"],
                                    data: dataArray
                                }
                            ]
                        },
                        options: {
                            legend: { display: false },
                            title: {
                                display: true,
                                text: 'Thống kê số lượng cầu của Sở GTVT'
                            },
                            responsive:true,
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });
                },
                error:function(err){
                    alert(err);
                }
            })
        });

    });

</script>
</body>
</html>
