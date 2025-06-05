package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@jakarta.servlet.annotation.WebServlet("/input-servlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String nameStr = "【名前】" + request.getParameter("name");
		String passwordStr = "【パスワード】" + request.getParameter("password");
		String genderStr = "【性別】" + request.getParameter("gender");
		String[] languageArray = request.getParameterValues("language");
		String languageStr = "【得意言語】";
		if (languageArray != null) {
			for (String language : languageArray) {
				languageStr += (language + "　");
			}
		} else {
			languageStr += "(未選択)";
		}
		String hobbyStr = "【趣味】" + request.getParameter("hobby");

		// リストに格納
		List<String> infoList = new ArrayList<String>();
		infoList.add(nameStr);
		infoList.add(passwordStr);
		infoList.add(genderStr);
		infoList.add(languageStr);
		infoList.add(hobbyStr);
		
		// リクエストスコープへのデータ格納（リストデータの格納）
		request.setAttribute("infoList", infoList);
		
		// 転送オブジェクトを取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");

		// 転送
		dispatcher.forward(request, response);
	}

}
