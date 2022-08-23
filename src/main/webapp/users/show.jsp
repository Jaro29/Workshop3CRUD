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
                    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                    <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika </a>
                </div>
            </div>

            <table class="table table-sm table-dark">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nazwa użytkownika</th>
                    <th scope="col">email</th>
                    <th scope="col">Akcja</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row"><c:out value="${user.id}" default="empty attribute"/></th>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="<c:url value="/user/delete"/>">
                            Usuń
                        </a>
                        <a href="<c:url value="/user/edit"/>">
                            Edytuj
                        </a>
                        <a href="<c:url value="/user/show"/>">
                            Pokaż
                        </a>
                    </td>
                </tr>
<%--                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                </tr>--%>
                </tbody>
            </table>

        </div>
        <!-- /.container-fluid -->
    </div>
</div>
<jsp:include page="/fragments/footer.jsp"/>

