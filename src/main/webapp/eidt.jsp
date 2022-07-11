<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 7/11/2022
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/managerStaff?action=edit&id=${id}" method="post">
    <div class="modal-header">
        <h4 class="modal-title">Add Employee</h4>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    </div>
    <div class="modal-body">
        <div class="form-group">
            <label>ID</label>
            <input type="text"name="idStaff" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Tên nhân viên</label>
            <input type="text" name="nameStaff" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Ngày sinh</label>
            <input type="date" name="dateStaff" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Địa chỉ</label>
            <input type="text" name="addressStaff" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="emailStaff" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Số điện thoại</label>
            <input type="text" name="numberStaff" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Phòng</label>
            <input type="text" name="tenPhong" class="form-control" required>
        </div>
    </div>
    <div class="modal-footer">
        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
    </div>
    <button type="submit" class="btn btn-success" value="Add"></button>
</form>
</body>
</html>
