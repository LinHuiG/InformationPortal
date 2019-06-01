
function logout() {

    $.ajax({
        type:"post",
        url:"/InformationPortal_war_exploded/LogoutServlet",
        success: function () {
            location.reload();
        }
    });
}

