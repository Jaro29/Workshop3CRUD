<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<jsp:include page="/fragments/header.jsp"/>

<div class="container-fluid">
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                </nav>
                <!-- End of Topbar -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">User CRUD</h1>
                    <a href="<c:url value="/users/add.jsp"/>"
                       class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika </a>
                </div>
            </div>
            <table class="table table-bordered table-dark">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col"><c:out value="${user.id}" default="empty attribute"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Nazwa Użytkownika</th>
                    <td><c:out value="${user.username}" default="empty attribute"/></td>
                </tr>
                <tr>
                    <th scope="row">Email</th>
                    <td><c:out value="${user.email}" default="empty attribute"/></td>
                </tr>

                </tbody>
            </table>

        </div>
        <!-- /.container-fluid -->
    </div>
</div>
<jsp:include page="/fragments/footer.jsp"/>

