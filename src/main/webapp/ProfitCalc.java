import java.text.NumberFormat;
import java.text.Format;

public class ProfitCalcServlet extends HttpServlet {
    // doPost() runs once per HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        try {
            double revenue = Double.parseDouble(request.getParameter("revenue") == null ? "0.00" : request.getParameter("revenue"));
            double expenses = Double.parseDouble(request.getParameter("expenses") == null ? "0.00" : request.getParameter("expenses"));
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
           request.setAttribute("total", formatter.format(revenue - expenses));
           request.setAttribute("error", null);
        }
        catch (Exception e) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            request.setAttribute("total", formatter.format(0.00));
            request.setAttribute("error", e.Message);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}