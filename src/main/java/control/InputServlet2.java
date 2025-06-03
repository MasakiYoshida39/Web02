package control;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 入力を受け付けるサーブレット
 * @author M.Takahashi
 */
@jakarta.servlet.annotation.WebServlet("/input-servlet2")
public class InputServlet2 extends HttpServlet {
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
		String[] languageArray = request.getParameterValues("food");
		String languageStr = "【好物】";
		if (languageArray != null) {
			for (String food : languageArray) {
				languageStr += (food + "　");
			}
		} else {
			languageStr += "(未選択)";
		}
		String hobbyStr = "【趣味】" + request.getParameter("hobby");

		// リクエストスコープへのデータ格納
		request.setAttribute("name", nameStr);
		request.setAttribute("password", passwordStr);
		request.setAttribute("gender", genderStr);
		request.setAttribute("food", languageStr);
		request.setAttribute("hobby", hobbyStr);
		
		// 転送オブジェクトを取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("output-servlet");

		// 転送
		dispatcher.forward(request, response);
	}

}
