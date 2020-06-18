<%--
  Created by IntelliJ IDEA.
  User: Tuan
  Date: 6/12/2020
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
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
    </script>

</body>
</html>
