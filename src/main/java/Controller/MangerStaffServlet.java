package Controller;

import Dao.StaffDao;
import Model.Staff;
import Service.PhongService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/managerStaff")
public class MangerStaffServlet extends HttpServlet {

    StaffDao staffDao = new StaffDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action="";
        } RequestDispatcher requestDispatcher;
        switch (action){
            case "edit":
                int id= Integer.getInteger(req.getParameter("id"));
                req.setAttribute("id",id);
                 requestDispatcher = req.getRequestDispatcher("edit.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            default:
                req.setAttribute("listStaff",staffDao.getAll());
                 requestDispatcher = req.getRequestDispatcher("/Manager.jsp");
                requestDispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                add(req,resp);
                break;
            case "edit":
                edit(req,resp);
                break;
        }

    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.getInteger(req.getParameter("idStaff"));
        String name = req.getParameter("nameStaff");
        Date date = Date.valueOf(req.getParameter("dateStaff"));
        String address = req.getParameter("addressStaff");
        String email = req.getParameter("emailStaff");
        String phone = req.getParameter("numberStaff");
        String tenPhong = req.getParameter("tenPhong");
        staffDao.create(new Staff(id,name,date,address,email,phone,PhongService.findPhongByName(tenPhong)));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Manager.jsp");
        requestDispatcher.forward(req,resp);
    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id= Integer.getInteger(req.getParameter("idStaff"));
        String name = req.getParameter("nameStaff");
        Date date = Date.valueOf(req.getParameter("dateStaff"));
        String address = req.getParameter("addressStaff");
        String email = req.getParameter("emailStaff");
        String phone = req.getParameter("numberStaff");
        String tenPhong = req.getParameter("tenPhong");
        staffDao.edit(id,new Staff(id,name,date,address,email,phone,PhongService.findPhongByName(tenPhong)));
       resp.sendRedirect("/managerStaff");
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id= Integer.getInteger(req.getParameter("id"));
        staffDao.delete(id);
    }
}
