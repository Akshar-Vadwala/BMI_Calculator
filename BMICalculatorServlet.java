
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/BMICalculatorServlet")
public class BMICalculatorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		float height = Float.parseFloat(request.getParameter("height"));
		float weight = Float.parseFloat(request.getParameter("weight"));
        
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>BMI Calculator</title>");
        out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
        out.println("</head>");
        out.println("<body>");
		
        out.println("<div class=box>");
		out.println("<h2>Welcome "+name+",</h2>");
		
		height/=100;
		float bmi = (weight/(height*height));
		
		out.println("<p>Your BMI (Body Mass Index) is <b>"+String.format("%.1f", bmi)+" kg/m2</b> </p>");
		out.println("<p>Healthy BMI range: 18.5 - 25 kg/m2</p>");
		out.println("</div>");
	
		
			out.println("<p>According to the World Health Organization's (WHO) recommended body weight based on BMI values for adults:</p>");
			
			if(bmi<16) {
				out.println("<h3>You are Severly Thin.</h3>");
			}
			else if(bmi>=16 && bmi<17) {
				out.println("<h3>You are Moderately Thin.</h3>");
			}
			else if(bmi>=17 && bmi<18.5) {
				out.println("<h3>You are Mildly Thin.</h3>");
			}
			else if(bmi>=18.5 && bmi<25) {
				out.println("<h3>You have Normal Weight.</h3>");
			}
			else if(bmi>=25 && bmi<30) {
				out.println("<h3>You are Overweight.</h3>");
			}
			else if(bmi>=30 && bmi<35) {
				out.println("<h3>You are Class I Obese.</h3>");
			}
			else if(bmi>=35 && bmi<40) {
				out.println("<h3>You are Class II Obese.</h3>");
			}
			else{
				out.println("<h3>You are Class III Obese.</h3>");
			}
		
			out.println("</body>");
	    out.println("</html>");
		out.close();
	}   
}
