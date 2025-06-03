package control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 出力サーブレット
 * @author M.Takahashi
 */
@jakarta.servlet.annotation.WebServlet("/output-servlet")
public class OutputServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストスコープからデータ取得
		String nameStr = (String) request.getAttribute("name");
		String passwordStr = (String) request.getAttribute("password");
		String genderStr = (String) request.getAttribute("gender");
		String languageStr = (String) request.getAttribute("language");
		String hobbyStr = (String) request.getAttribute("hobby");
		
		// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
		response.setContentType("text/html; charset=UTF-8");

		// レスポンス書き出し用オブジェクトの取得
		PrintWriter out = response.getWriter();

		//レスポンスの書き出し
		out.println("<!DOCTYPE html>                                 ");
		out.println("<html>                                          ");
		out.println("<head>                                          ");
		out.println("<meta charset=\"UTF-8\">                        ");
		out.println("<title>入力内容</title>                         ");
		out.println("<link rel=\"stylesheet\" href=\"style.css\">    ");
		out.println("</head>                                         ");
		out.println("<body>                                          ");
		out.println("    <h2>入力内容</h2>                           ");
		out.println("    " + nameStr + "<br><br>                     ");
		out.println("    " + passwordStr + "<br><br>                 ");
		out.println("    " + genderStr + "<br><br>                   ");
		out.println("    " + languageStr + "<br><br>                     ");
		out.println("    " + hobbyStr + "<br><br>                    ");
		out.println("<br><a href=\"input.html\">入力フォームへ</a>     ");
		out.println("<br><br><br>------これは、OutputServletで書き出しています。------");
		out.println("</body>                                         ");
		out.println("</html>                                         ");
	}

}
