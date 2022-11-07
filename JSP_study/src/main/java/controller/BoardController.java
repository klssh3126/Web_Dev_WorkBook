package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.OracleDriver;


@WebServlet("/board/list")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db board테이블의 정보를 읽어와서
		String driver="oracle.jdbc.OracleDriver";
		//            "oracle.jdbc.driver.OracleDriver"
		
		try {
			Class<?> clazz=Class.forName(driver);
			clazz.getDeclaredConstructor().newInstance();
			System.out.println("Oracle Driver가 준비되었습니다.");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="nowon";
		String password="1234";
		Connection con=null;
		try {
			con=DriverManager.getConnection(url, user, password);
			System.out.println("OracleDB 접속완료!");
			
			String sql="select * from board order by 1 desc";

			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery(sql);
			request.setAttribute("list", rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//상대경로
		//request.getRequestDispatcher("list.jsp").forward(request, response);
		//        /board/list.jsp
		//절대경로
		request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
